package xml;

import domain.DeckClass;
import logic.MatchStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

/**
 * Class which parses Match statistics from a Xml file.
 */
public class MatchStatisticsParser extends StatisticsParser {

    private final MatchStatisticsKeeper keeper;

    /**
     * Creates a new MatchStatisticsParser Object.
     * 
     * @param filePath File path to the Xml file.
     */
    public MatchStatisticsParser(String filePath) {
        super(filePath, "Class", "Classes");
        keeper = new MatchStatisticsKeeper();
    }

    /**
     * Creates a new MatchStatisticsParser Object.
     * 
     * @param doc Document reprsentation of the Xml document.
     */
    public MatchStatisticsParser(Document doc) {
        super(doc, "Class");
        keeper = new MatchStatisticsKeeper();
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
        keeper.updateWinRatioIn1stMatchMaps(dc, dc);
        keeper.updateWinRatioIn2ndMatchMaps(dc, dc);
    }

    @Override
    public Object getParsedObject() {
        return keeper;
    }
}
