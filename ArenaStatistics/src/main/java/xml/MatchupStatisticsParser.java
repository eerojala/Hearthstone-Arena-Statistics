package xml;

import domain.Matchup;
import logic.MatchupStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

/**
 * Class which parses Matchup statistics from a Xml file.
 */
public class MatchupStatisticsParser extends StatisticsParser {

    private final MatchupStatisticsKeeper keeper;

    /**
     * Creates a new MatchupStatisticsParser Object.
     *
     * @param filePath File path to the Xml file.
     */
    public MatchupStatisticsParser(String filePath) {
        super(filePath, "ClassPair", "ClassPairs");
        keeper = new MatchupStatisticsKeeper();
    }

    /**
     * Creates a new MatchupStatisticsParser Object.
     *
     * @param doc Document representation of the Xml document.
     */
    public MatchupStatisticsParser(Document doc) {
        super(doc, "ClassPair");
        keeper = new MatchupStatisticsKeeper();
    }

    @Override
    protected void setStatistics(Element element) {
        Matchup dcp = Matchup.parseMatchup(getID(element));
        keeper.setMatchesInMatchup1st(dcp, getIntValue(element, "Matches1st"));
        keeper.setMatchesInMatchup2nd(dcp, getIntValue(element, "Matches2nd"));
        keeper.setWinsInMatchup1st(dcp, getIntValue(element, "Wins1st"));
        keeper.setWinsInMatchup2nd(dcp, getIntValue(element, "Wins2nd"));
        keeper.setLossesInMatchup1st(dcp, getIntValue(element, "Losses1st"));
        keeper.setLossesInMatchup2nd(dcp, getIntValue(element, "Losses2nd"));
        keeper.updateWinRatio1st(dcp);
        keeper.updateWinRatio2nd(dcp);
    }

    @Override
    public Object getParsedObject() {
        return keeper;
    }
}
