package Xml;

import domain.DeckClass;
import logic.DeckClassStatisticsKeeper;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;

public class DeckClassStatisticsWriter extends StatisticsWriter {

    public DeckClassStatisticsWriter(String filepath) {
        super(filepath, "Classes", "Class");
    }

    @Override
    public void writeContent(Document doc, Object obj) {
        try {
            DeckClassStatisticsKeeper keeper = (DeckClassStatisticsKeeper) obj;
            for (DeckClass dc : DeckClass.values()) {
                writeClassToDocument(doc, dc, keeper);
            }
        } catch (Exception e) {
            System.out.println("Failed to write DeckClass statistics");
        }
    }

    private void writeClassToDocument(Document doc, DeckClass dc, DeckClassStatisticsKeeper keeper) {
        Element element = new Element(childName);
        element.setAttribute(new Attribute("id", dc.toString()));
        writeWinsToDocument(element, dc, keeper);
        doc.getRootElement().addContent(element);
        addToFile(doc);
    }
    
    private void writeWinsToDocument(Element element, DeckClass dc, DeckClassStatisticsKeeper keeper) {
        Element winsElement = new Element("Decks");
        for (int i = 0; i < 13; i++) {
            Element winElement = new Element("Wins"+i);
            winElement.setText("" + keeper.getDecksAsClassWithXWins(dc, i));
            winsElement.addContent(winElement);
        }
        element.addContent(winsElement);
    }

    @Override
    public void updateSpecific(Document doc, Object key, Object keeper) {
        try {
            DeckClass dc = (DeckClass) key;
            DeckClassStatisticsKeeper statKeeper = (DeckClassStatisticsKeeper) keeper;
            remove(doc, dc.toString());
            writeClassToDocument(doc, dc, statKeeper);
        } catch (Exception e) {
        
        }
    }

}
