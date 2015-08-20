package Xml;

import domain.DeckClassPair;
import logic.ClassVSClassStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

public class ClassVSClassStatisticsParser extends MatchStatisticsParser {

    private ClassVSClassStatisticsKeeper keeper;

    public ClassVSClassStatisticsParser(String filePath) {
        super(filePath, "ClassPair", "ClassPairs");
        keeper = new ClassVSClassStatisticsKeeper();
    }

    public ClassVSClassStatisticsParser(Document doc) {
        super(doc, "ClassPair");
    }

    @Override
    protected void setStatistics(Element element) {
        DeckClassPair dcp = DeckClassPair.parseDeckClassPair(getID(element));
        keeper.setMatchesInClassVSClass1st(dcp, getIntegerValue(element, "Matches1st"));
        keeper.setMatchesInClassVSClass2nd(dcp, getIntegerValue(element, "Matches2nd"));
        keeper.setWinsInClassVSClass1st(dcp, getIntegerValue(element, "Wins1st"));
        keeper.setWinsInClassVSClass2nd(dcp, getIntegerValue(element, "Wins2nd"));
        keeper.setLossesInClassVSClass1st(dcp, getIntegerValue(element, "Losses1st"));
        keeper.setLossesInClassVSClass2nd(dcp, getIntegerValue(element, "Losses2nd"));
        keeper.updateWinPercentage1st(dcp);
        keeper.updateWinPercentage2nd(dcp);
    }

    public ClassVSClassStatisticsKeeper getKeeper() {
        return keeper;
    }

}
