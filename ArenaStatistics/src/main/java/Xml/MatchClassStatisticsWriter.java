package Xml;

import domain.DeckClass;
import logic.MatchClassStatisticsKeeper;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;

public class MatchClassStatisticsWriter extends StatisticsWriter {

    public MatchClassStatisticsWriter(String filepath) {
        super(filepath, "Classes", "Class");
    }

    @Override
    public void writeContent(Document doc, Object obj) {
        try {
            MatchClassStatisticsKeeper keeper = (MatchClassStatisticsKeeper) obj;
            for (DeckClass dc : DeckClass.values()) {
                addClassToDocument(doc, dc, keeper);
            }
        } catch (Exception e) {
            System.out.println("Writing Class statistics failed");
        }
    }

    private void addClassToDocument(Document doc, DeckClass dc, MatchClassStatisticsKeeper keeper) {
        Element element = new Element(childName);
        element.setAttribute(new Attribute("id", dc.toString()));
        element.addContent(new Element("MatchesAsClass1st").setText("" + keeper.getMatchesAsClass1st(dc)));
        element.addContent(new Element("MatchesAsClass2nd").setText("" + keeper.getMatchesAsClass2nd(dc)));
        element.addContent(new Element("MatchesVSClass1st").setText("" + keeper.getMatchesVSClass1st(dc)));
        element.addContent(new Element("MatchesVSClass2nd").setText("" + keeper.getMatchesVSClass2nd(dc)));
        element.addContent(new Element("WinsAsClass1st").setText("" + keeper.getWinsAsClass1st(dc)));
        element.addContent(new Element("WinsAsClass2nd").setText("" + keeper.getWinsAsClass2nd(dc)));
        element.addContent(new Element("WinsVSClass1st").setText("" + keeper.getWinsVSClass1st(dc)));
        element.addContent(new Element("WinsVSClass2nd").setText("" + keeper.getWinsVSClass2nd(dc)));
        element.addContent(new Element("LossesAsClass1st").setText("" + keeper.getLossesAsClass1st(dc)));
        element.addContent(new Element("LossesAsClass2nd").setText("" + keeper.getLossesAsClass2nd(dc)));
        element.addContent(new Element("LossesVSClass1st").setText("" + keeper.getLossesVSClass1st(dc)));
        element.addContent(new Element("LossesVSClass2nd").setText("" + keeper.getLossesVSClass2nd(dc)));
        doc.getRootElement().addContent(element);
        addToFile(doc);
    }

    @Override
    public void updateSpecific(Document doc, Object key, Object keeper) {
        try {
            DeckClass dc = (DeckClass) key;
            MatchClassStatisticsKeeper statKeeper = (MatchClassStatisticsKeeper) keeper;
            remove(doc, dc.toString());
            addClassToDocument(doc, dc, statKeeper);
        } catch (Exception e) {

        }
    }
}