
package logic;

import gui.MainGUI;
import javax.swing.*;
import logic.RewardStatisticsKeeper;

public class GeneralDeckStatisticsLogic implements StatisticsGUI{
    private MainGUI gui;
    private JLabel wins;
    private JLabel decks;
    private JLabel perOutOfAllDecks;
    private JLabel dust;
    private JLabel avgDust;
    private JLabel gold;
    private JLabel avgGold;
    private JLabel extraPacks;
    private JLabel avgExtraPacks;
    private JLabel regularCards;
    private JLabel avgRegularCards;
    private JLabel goldenCards;
    private JLabel avgGoldenCards;
    private JSlider winSlider;
    private RewardStatisticsKeeper keeper;

    public GeneralDeckStatisticsLogic(MainGUI gui) {
        this.gui = gui;
        keeper = gui.getRewardStatisticsKeeper();
        winSlider = gui.getGeneralDeckStatisticsWinSlider();
        setLabels();
    }
    
    private void setLabels() {
        wins = gui.getGeneralDeckStatisticsWins();
        decks = gui.getGeneralDeckStatisticsDecks();
        perOutOfAllDecks = gui.getGeneralDeckStatisticsPerOutOfAllDecks();
        dust = gui.getGeneralDeckStatisticsDust();
        avgDust = gui.getGeneralDeckStatisticsAvgDust();
        gold = gui.getGeneralDeckStatisticsGold();
        avgGold = gui.getGeneralDeckStatisticsAvgGold();
        extraPacks = gui.getGeneralDeckStatisticsExtraPacks();
        avgExtraPacks = gui.getGeneralDeckStatisticsAvgExtraPacks();
        regularCards = gui.getGeneralDeckStatisticsRegularCards();
        avgRegularCards = gui.getGeneralDeckStatisticsAvgRegularCards();
        goldenCards = gui.getGeneralDeckStatisticsGoldenCards();
        avgGoldenCards = gui.getGeneralDeckStatisticsAvgGold();
    }

    @Override
    public void updateStats() {
        if (winSlider.getValue() == 13) {
            updateTotalStats();
        } else {
            updateXWinsStats(winSlider.getValue());
        }
    }
    
    private void updateTotalStats() {
        wins.setText("Total");
        decks.setText("" + keeper.getTotalDeckAmount());
        perOutOfAllDecks.setText("100");
        dust.setText("" + keeper.getTotalDust());
        avgDust.setText("" + keeper.getTotalDustAverage());
        gold.setText("" + keeper.getTotalGold());
        avgGold.setText("" + keeper.getTotalGoldAverage());
        extraPacks.setText("" + keeper.getTotalExtraPacks());
        avgExtraPacks.setText("" + keeper.getTotalExtraPackAverage());
        regularCards.setText("" + keeper.getTotalRegularCards());
        avgRegularCards.setText("" + keeper.getTotalRegularCardAverage());
        goldenCards.setText("" + keeper.getTotalGoldenCards());
        avgGoldenCards.setText("" + keeper.getTotalGoldenCardAverage());
    }
    
    private void updateXWinsStats(int x) {
        wins.setText("" + x);
        decks.setText("" + keeper.getDecksByWins(x));
        perOutOfAllDecks.setText("" + keeper.getPercentageOutOfAllDecks(x));
        dust.setText("" + keeper.getDustByWins(x));
        avgDust.setText("" + keeper.getAverageDustByWins(x));
        gold.setText("" + keeper.getGoldByWins(x));
        avgGold.setText("" + keeper.getAverageGoldByWins(x));
        extraPacks.setText("" + keeper.getExtraPacksByWins(x));
        avgExtraPacks.setText("" + keeper.getAverageExtraPacksByWins(x));
        regularCards.setText("" + keeper.getRegularCardsByWins(x));
        avgRegularCards.setText("" + keeper.getAverageRegularCardsByWins(x));
        goldenCards.setText("" + keeper.getGoldCardsByWins(x));
        avgGoldenCards.setText("" + keeper.getAverageGoldCardsByWins(x));
    }
}
