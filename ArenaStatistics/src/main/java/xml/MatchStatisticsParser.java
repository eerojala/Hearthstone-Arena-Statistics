package xml;

import domain.DeckClass;
import logic.ClassStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

public class MatchStatisticsParser extends StatisticsParser {

    private ClassStatisticsKeeper keeper;

    public MatchStatisticsParser(String filepath) {
        super(filepath, "Class", "Classes");
        keeper = new ClassStatisticsKeeper();
    }

    public MatchStatisticsParser(Document doc) {
        super(doc, "Class");
        keeper = new ClassStatisticsKeeper();
    }

    @Override
    protected void setStatistics(Element element) {
        DeckClass dc = DeckClass.parseDeckClass(getID(element));
        keeper.setMatchesAsClass1st(dc, getIntValue(element, "MatchesAsClass1st"));
        keeper.setMatchesAsClass2nd(dc, getIntValue(element, "MatchesAsClass2nd"));
        keeper.setMatchesVSClass1st(dc, getIntValue(element, "MatchesVSClass1st"));
        keeper.setMatchesVSClass2nd(dc, getIntValue(element, "MatchesVSClass2nd"));
        keeper.setWinsAsClass1st(dc, getIntValue(element, "WinsAsClass1st"));
        keeper.setWinsAsClass2nd(dc, getIntValue(element, "WinsAsClass2nd"));
        keeper.setWinsVSClass1st(dc, getIntValue(element, "WinsVSClass1st"));
        keeper.setWinsVSClass2nd(dc, getIntValue(element, "WinsVSClass2nd"));
        keeper.setLossesAsClass1st(dc, getIntValue(element, "LossesAsClass1st"));
        keeper.setLossesAsClass2nd(dc, getIntValue(element, "LossesAsClass2nd"));
        keeper.setLossesVSClass1st(dc, getIntValue(element, "LossesVSClass1st"));
        keeper.setLossesVSClass2nd(dc, getIntValue(element, "LossesVSClass2nd"));
        keeper.updateWinPercentageIn1stMatchMaps(dc, dc);
        keeper.updateWinPercentageIn2ndMatchMaps(dc, dc);
    }

    public ClassStatisticsKeeper getKeeper() {
        return keeper;
    }
}
