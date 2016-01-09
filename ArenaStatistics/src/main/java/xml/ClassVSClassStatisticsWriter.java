package xml;

import domain.DeckClass;
import domain.DeckClassPair;
import logic.ClassVSClassStatisticsKeeper;
import org.jdom.Attribute;
import org.jdom.Element;

public class ClassVSClassStatisticsWriter extends StatisticsWriter {

    public ClassVSClassStatisticsWriter(String filepath) {
        super(filepath, "ClassPairs", "ClassPair");
    }

    @Override
    public void writeContent(Object obj) {
        try {
            ClassVSClassStatisticsKeeper keeper = (ClassVSClassStatisticsKeeper) obj;
            for (DeckClass dc1 : DeckClass.values()) {
                for (DeckClass dc2 : DeckClass.values()) {
                    DeckClassPair dcp = new DeckClassPair(dc1, dc2);
                    addClassPairToDocument(dcp, keeper);
                }
            }
        } catch (Exception e) {
            System.out.println("Writing ClassVSClass statistics failed");
        }
    }

    private void addClassPairToDocument(DeckClassPair dcp, ClassVSClassStatisticsKeeper keeper) {
        Element element = new Element(childName);
        element.setAttribute(new Attribute("id", dcp.toString()));
        element.addContent(new Element("Matches1st").setText("" + keeper.getMatchesInClassVSClass1st(dcp)));
        element.addContent(new Element("Matches2nd").setText("" + keeper.getMatchesInClassVSClass2nd(dcp)));
        element.addContent(new Element("Wins1st").setText("" + keeper.getWinsInClassVSClass1st(dcp)));
        element.addContent(new Element("Wins2nd").setText("" + keeper.getWinsInClassVSClass2nd(dcp)));
        element.addContent(new Element("Losses1st").setText("" + keeper.getLossesInClassVSClass1st(dcp)));
        element.addContent(new Element("Losses2nd").setText("" + keeper.getLossesInClassVSClass2nd(dcp)));
        doc.getRootElement().addContent(element);
        addToFile();
    }

    @Override
    public void updateSpecific(Object key, Object keeper) {
        try {
            DeckClassPair dcp = (DeckClassPair) key;
            ClassVSClassStatisticsKeeper statKeeper = (ClassVSClassStatisticsKeeper) keeper;
            remove(dcp.toString());
            addClassPairToDocument(dcp, statKeeper);
        } catch (Exception e) {
        }
    }
}
