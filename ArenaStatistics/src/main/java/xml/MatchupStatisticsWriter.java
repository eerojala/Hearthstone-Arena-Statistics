package xml;

import domain.DeckClass;
import domain.Matchup;
import logic.MatchupStatisticsKeeper;
import org.jdom.Attribute;
import org.jdom.Element;

/**
 * Class which writes Matchup statistics into a Xml file.
 */
public class MatchupStatisticsWriter extends StatisticsWriter {

    /**
     * Creates a new MatchUpStatisticsWriter Object.
     * 
     * @param filepath Filepath to the Xml file.
     */
    public MatchupStatisticsWriter(String filepath) {
        super(filepath, "ClassPairs", "ClassPair");
    }

    @Override
    public void writeContent(Object obj) {
        try {
            MatchupStatisticsKeeper keeper = (MatchupStatisticsKeeper) obj;
            for (DeckClass dc1 : DeckClass.values()) {
                for (DeckClass dc2 : DeckClass.values()) {
                    Matchup dcp = new Matchup(dc1, dc2);
                    addClassPairToDocument(dcp, keeper);
                }
            }
        } catch (Exception e) {
            System.out.println("Writing ClassVSClass statistics failed");
        }
    }

    private void addClassPairToDocument(Matchup dcp, MatchupStatisticsKeeper keeper) {
        Element element = new Element(childName);
        element.setAttribute(new Attribute("id", dcp.toString()));
        element.addContent(new Element("Matches1st").setText("" + keeper.getMatchesInMatchup1st(dcp)));
        element.addContent(new Element("Matches2nd").setText("" + keeper.getMatchesInMatchup2nd(dcp)));
        element.addContent(new Element("Wins1st").setText("" + keeper.getWinsInMatchup1st(dcp)));
        element.addContent(new Element("Wins2nd").setText("" + keeper.getWinsInMatchup2nd(dcp)));
        element.addContent(new Element("Losses1st").setText("" + keeper.getLossesInMatchup1st(dcp)));
        element.addContent(new Element("Losses2nd").setText("" + keeper.getLossesInMatchup2nd(dcp)));
        doc.getRootElement().addContent(element);
        addToFile();
    }

    @Override
    public void updateSpecific(Object key, Object keeper) {
        try {
            Matchup dcp = (Matchup) key;
            MatchupStatisticsKeeper statKeeper = (MatchupStatisticsKeeper) keeper;
            remove(dcp.toString());
            addClassPairToDocument(dcp, statKeeper);
        } catch (Exception e) {
        }
    }
}
