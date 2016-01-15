package xml;

import logic.RewardStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

/**
 * Class which parses reward statistics from a Xml file.
 */
public class RewardStatisticsParser extends StatisticsParser {

    private final RewardStatisticsKeeper keeper;

    /**
     * Creates a new RewardStatisticsParser Object.
     *
     * @param filePath File path to the Xml file.
     */
    public RewardStatisticsParser(String filePath) {
        super(filePath, "WinAmount", "WinAmounts");
        keeper = new RewardStatisticsKeeper();
    }

    /**
     * Creates a new RewardStatisticsParser Object.
     *
     * @param doc Document representation of the Xml file.
     */
    public RewardStatisticsParser(Document doc) {
        super(doc, "WinAmount");
        keeper = new RewardStatisticsKeeper();
    }

    @Override
    protected void setStatistics(Element element) {
        int wins = Integer.parseInt(getID(element));
        keeper.setDecksByWins(wins, getIntValue(element, "AmountOfDecks"));
        keeper.setDustByWins(wins, getIntValue(element, "Dust"));
        keeper.setGoldByWins(wins, getIntValue(element, "Gold"));
        keeper.setExtraPacksByWins(wins, getIntValue(element, "ExtraPacks"));
        keeper.setRegularCardsByWins(wins, getIntValue(element, "RegularCards"));
        keeper.setGoldCardsByWins(wins, getIntValue(element, "GoldCards"));
        keeper.updateDoubleMaps(wins);
    }

    @Override
    public Object getParsedObject() {
        return keeper;
    }

}
