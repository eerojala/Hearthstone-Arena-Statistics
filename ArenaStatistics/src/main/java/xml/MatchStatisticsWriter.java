package xml;

import domain.DeckClass;
import logic.ClassStatisticsKeeper;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;

public class MatchStatisticsWriter extends StatisticsWriter {

    public MatchStatisticsWriter(String filepath) {
        super(filepath, "Classes", "Class");
    }

    @Override
    public void writeContent(Object obj) {
        try {
            ClassStatisticsKeeper keeper = (ClassStatisticsKeeper) obj;
            for (DeckClass dc : DeckClass.values()) {
                addClassToDocument(dc, keeper);
            }
        } catch (Exception e) {
            System.out.println("Writing Class statistics failed");
        }
    }

    private void addClassToDocument(DeckClass dc, ClassStatisticsKeeper keeper) {
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
        addToFile();
    }

    @Override
    public void updateSpecific(Object key, Object keeper) {
        try {
            DeckClass dc = (DeckClass) key;
            ClassStatisticsKeeper statKeeper = (ClassStatisticsKeeper) keeper;
            remove(dc.toString());
            addClassToDocument(dc, statKeeper);
        } catch (Exception e) {

        }
    }
}
