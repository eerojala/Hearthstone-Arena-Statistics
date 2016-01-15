package xml;

import domain.DeckClass;
import logic.DeckScoreStatisticsKeeper;
import org.jdom.Attribute;
import org.jdom.Element;

/**
 * Class which writes deck score statistics to a Xml file.
 */
public class DeckScoreStatisticsWriter extends StatisticsWriter {

    /**
     * Creates a new DeckScoreStatisticsWriter Object.
     * 
     * @param filePath File path to the Xml file.
     */
    public DeckScoreStatisticsWriter(String filePath) {
        super(filePath, "Classes", "Class");
    }

    @Override
    public void writeContent(Object obj) {
        try {
            DeckScoreStatisticsKeeper keeper = (DeckScoreStatisticsKeeper) obj;
            for (DeckClass dc : DeckClass.values()) {
                writeClassToDocument(dc, keeper);
            }
        } catch (Exception e) {
            System.out.println("Failed to write DeckClass statistics");
        }
    }

    private void writeClassToDocument(DeckClass dc, DeckScoreStatisticsKeeper keeper) {
        Element element = new Element(childName);
        element.setAttribute(new Attribute("id", dc.toString()));
        writeWinsToDocument(element, dc, keeper);
        doc.getRootElement().addContent(element);
        addToFile();
    }
    
    private void writeWinsToDocument(Element element, DeckClass dc, DeckScoreStatisticsKeeper keeper) {
        Element winsElement = new Element("Decks");
        for (int i = 0; i < 13; i++) {
            Element winElement = new Element("Wins"+i);
            winElement.setText("" + keeper.getDecksAsClassWithXWins(dc, i));
            winsElement.addContent(winElement);
        }
        element.addContent(winsElement);
    }

    @Override
    public void updateSpecific(Object key, Object keeper) {
        try {
            DeckClass dc = (DeckClass) key;
            DeckScoreStatisticsKeeper statKeeper = (DeckScoreStatisticsKeeper) keeper;
            remove(dc.toString());
            writeClassToDocument(dc, statKeeper);
        } catch (Exception e) {
        
        }
    }

}
