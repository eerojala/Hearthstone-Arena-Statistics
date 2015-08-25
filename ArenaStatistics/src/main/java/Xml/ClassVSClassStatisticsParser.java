package Xml;

import domain.DeckClassPair;
import logic.ClassVSClassStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

public class ClassVSClassStatisticsParser extends StatisticsParser {

    private ClassVSClassStatisticsKeeper keeper;

    public ClassVSClassStatisticsParser(String filePath) {
        super(filePath, "ClassPair", "ClassPairs");
        keeper = new ClassVSClassStatisticsKeeper();
    }

    public ClassVSClassStatisticsParser(Document doc) {
        super(doc, "ClassPair");
        keeper = new ClassVSClassStatisticsKeeper();
    }

    @Override
    protected void setStatistics(Element element) {
        DeckClassPair dcp = DeckClassPair.parseDeckClassPair(getID(element));
        keeper.setMatchesInClassVSClass1st(dcp, getIntValue(element, "Matches1st"));
        keeper.setMatchesInClassVSClass2nd(dcp, getIntValue(element, "Matches2nd"));
        keeper.setWinsInClassVSClass1st(dcp, getIntValue(element, "Wins1st"));
        keeper.setWinsInClassVSClass2nd(dcp, getIntValue(element, "Wins2nd"));
        keeper.setLossesInClassVSClass1st(dcp, getIntValue(element, "Losses1st"));
        keeper.setLossesInClassVSClass2nd(dcp, getIntValue(element, "Losses2nd"));
        keeper.updateWinPercentage1st(dcp);
        keeper.updateWinPercentage2nd(dcp);
    }

    public ClassVSClassStatisticsKeeper getKeeper() {
        return keeper;
    }

}
