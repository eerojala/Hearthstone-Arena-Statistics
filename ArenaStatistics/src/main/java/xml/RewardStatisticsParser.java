package xml;

import logic.RewardStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

public class RewardStatisticsParser extends StatisticsParser {

    private final RewardStatisticsKeeper keeper;

    public RewardStatisticsParser(String filepath) {
        super(filepath, "WinAmount", "WinAmounts");
        keeper = new RewardStatisticsKeeper();
    }

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

    public RewardStatisticsKeeper getKeeper() {
        return keeper;
    }
}
