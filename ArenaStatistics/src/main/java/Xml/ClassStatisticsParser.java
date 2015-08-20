package Xml;

import domain.DeckClass;
import logic.ClassStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

public class ClassStatisticsParser extends MatchStatisticsParser {

    private ClassStatisticsKeeper keeper;

    public ClassStatisticsParser(String filepath) {
        super(filepath, "Class", "Classes");
        keeper = new ClassStatisticsKeeper();
    }

    public ClassStatisticsParser(Document doc) {
        super(doc, "Class");
    }

    @Override
    protected void setStatistics(Element element) {
        DeckClass dc = DeckClass.parseDeckClass(getID(element));
        keeper.setMatchesAsClass1st(dc, getIntegerValue(element, "MatchesAsClass1st"));
        keeper.setMatchesAsClass2nd(dc, getIntegerValue(element, "MatchesAsClass2nd"));
        keeper.setMatchesVSClass1st(dc, getIntegerValue(element, "MatchesVSClass1st"));
        keeper.setMatchesVSClass2nd(dc, getIntegerValue(element, "MatchesVSClass2nd"));
        keeper.setWinsAsClass1st(dc, getIntegerValue(element, "WinsAsClass1st"));
        keeper.setWinsAsClass2nd(dc, getIntegerValue(element, "WinsAsClass2nd"));
        keeper.setWinsVSClass1st(dc, getIntegerValue(element, "WinsVSClass1st"));
        keeper.setWinsVSClass2nd(dc, getIntegerValue(element, "WinsVSClass2nd"));
        keeper.setLossesAsClass1st(dc, getIntegerValue(element, "LossesAsClass1st"));
        keeper.setLossesAsClass2nd(dc, getIntegerValue(element, "LossesAsClass2nd"));
        keeper.setLossesVSClass1st(dc, getIntegerValue(element, "LossesVSClass1st"));
        keeper.setLossesVSClass2nd(dc, getIntegerValue(element, "LossesVSClass2nd"));
        keeper.updateWinPercentageIn1stMatchMaps(dc, dc);
        keeper.updateWinPercentageIn2ndMatchMaps(dc, dc);
    }

    public ClassStatisticsKeeper getKeeper() {
        return keeper;
    }
}
