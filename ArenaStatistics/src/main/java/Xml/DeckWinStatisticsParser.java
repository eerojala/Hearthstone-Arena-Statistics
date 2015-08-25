package Xml;

import logic.DeckWinStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

public class DeckWinStatisticsParser extends StatisticsParser {

    private final DeckWinStatisticsKeeper keeper;

    public DeckWinStatisticsParser(String filepath) {
        super(filepath, "WinAmount", "WinAmounts");
        keeper = new DeckWinStatisticsKeeper();
    }

    public DeckWinStatisticsParser(Document doc) {
        super(doc, "WinAmount");
        keeper = new DeckWinStatisticsKeeper();
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

    public DeckWinStatisticsKeeper getKeeper() {
        return keeper;
    }
}
