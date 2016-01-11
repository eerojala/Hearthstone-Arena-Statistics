package xml;

import domain.Matchup;
import logic.MatchupStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

public class ClassVSClassStatisticsParser extends StatisticsParser {

    private MatchupStatisticsKeeper keeper;

    public ClassVSClassStatisticsParser(String filePath) {
        super(filePath, "ClassPair", "ClassPairs");
        keeper = new MatchupStatisticsKeeper();
    }

    public ClassVSClassStatisticsParser(Document doc) {
        super(doc, "ClassPair");
        keeper = new MatchupStatisticsKeeper();
    }

    @Override
    protected void setStatistics(Element element) {
        Matchup dcp = Matchup.parseMatchup(getID(element));
        keeper.setMatchesInClassVSClass1st(dcp, getIntValue(element, "Matches1st"));
        keeper.setMatchesInClassVSClass2nd(dcp, getIntValue(element, "Matches2nd"));
        keeper.setWinsInClassVSClass1st(dcp, getIntValue(element, "Wins1st"));
        keeper.setWinsInClassVSClass2nd(dcp, getIntValue(element, "Wins2nd"));
        keeper.setLossesInClassVSClass1st(dcp, getIntValue(element, "Losses1st"));
        keeper.setLossesInClassVSClass2nd(dcp, getIntValue(element, "Losses2nd"));
        keeper.updateWinPercentage1st(dcp);
        keeper.updateWinPercentage2nd(dcp);
    }

    public MatchupStatisticsKeeper getKeeper() {
        return keeper;
    }

}
