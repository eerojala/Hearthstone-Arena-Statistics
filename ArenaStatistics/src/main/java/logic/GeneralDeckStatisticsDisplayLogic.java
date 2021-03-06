package logic;

import gui.MainGUI;
import util.StatisticsHelper;

/**
 * Class which manipulates GUI elements of the 'General Deck Statistics' tab of MainGUI.
 */
public class GeneralDeckStatisticsDisplayLogic implements StatisticsDisplay {

    private final MainGUI gui;
    private final RewardStatisticsKeeper keeper;

    /**
     * Creates a new GeneralDeckStatisticsDisplayLogic Object.
     * 
     * @param gui The Main GUI of the program.
     */
    public GeneralDeckStatisticsDisplayLogic(MainGUI gui) {
        this.gui = gui;
        keeper = gui.getRewardStatisticsKeeper();
    }

    @Override
    public void updateStats() {
        if (gui.getGeneralDeckStatisticsWinSlider().getValue() == 13) {
            updateToTotalStats();
            enableAvgWinsDisplay(true);
        } else {
            updateToXWinsStats(gui.getGeneralDeckStatisticsWinSlider().getValue());
            enableAvgWinsDisplay(false);
        }
    }

    private void updateToTotalStats() {
        gui.getGeneralDeckStatisticsWins().setText("Total");
        gui.getGeneralDeckStatisticsDecks().setText("" + keeper.getTotalDeckAmount());
        gui.getGeneralDeckStatisticsPerOutOfAllDecks().setText("100.0");
        gui.getGeneralDeckStatisticsDust().setText("" + keeper.getTotalDust());
        gui.getGeneralDeckStatisticsAvgDust().setText("" + StatisticsHelper.round(keeper.getTotalDustAverage()));
        gui.getGeneralDeckStatisticsGold().setText("" + keeper.getTotalGold());
        gui.getGeneralDeckStatisticsAvgGold().setText("" + StatisticsHelper.round(keeper.getTotalGoldAverage()));
        gui.getGeneralDeckStatisticsExtraPacks().setText("" + keeper.getTotalExtraPacks());
        gui.getGeneralDeckStatisticsAvgExtraPacks().setText("" + StatisticsHelper.round(keeper.getTotalExtraPackAverage()));
        gui.getGeneralDeckStatisticsRegularCards().setText("" + keeper.getTotalRegularCards());
        gui.getGeneralDeckStatisticsAvgRegularCards().setText("" + StatisticsHelper.round(keeper.getTotalRegularCardAverage()));
        gui.getGeneralDeckStatisticsGoldenCards().setText("" + keeper.getTotalGoldenCards());
        gui.getGeneralDeckStatisticsAvgGoldenCards().setText("" + StatisticsHelper.round(keeper.getTotalGoldenCardAverage()));
    }
    
    private void enableAvgWinsDisplay(boolean enable) {
            gui.getGeneralDeckStatisticsAvgWins().setVisible(enable);
            gui.getGeneralDeckStatisticsAvgWinsValue().setVisible(enable);
            gui.getGeneralDeckStatisticsAvgWinsValue().setText("" + StatisticsHelper.round(keeper.getTotalWinAverage()));
    }

    private void updateToXWinsStats(int x) {
        gui.getGeneralDeckStatisticsWins().setText("" + x);
        gui.getGeneralDeckStatisticsDecks().setText("" + keeper.getDecksByWins(x));
        gui.getGeneralDeckStatisticsPerOutOfAllDecks().setText("" + StatisticsHelper.convertToPercentage(keeper.getPlayRatio(x)));
        gui.getGeneralDeckStatisticsDust().setText("" + keeper.getDustByWins(x));
        gui.getGeneralDeckStatisticsAvgDust().setText("" + StatisticsHelper.round(keeper.getAverageDustByWins(x)));
        gui.getGeneralDeckStatisticsGold().setText("" + keeper.getGoldByWins(x));
        gui.getGeneralDeckStatisticsAvgGold().setText("" + StatisticsHelper.round(keeper.getAverageGoldByWins(x)));
        gui.getGeneralDeckStatisticsExtraPacks().setText("" + keeper.getExtraPacksByWins(x));
        gui.getGeneralDeckStatisticsAvgExtraPacks().setText("" + StatisticsHelper.round(keeper.getAverageExtraPacksByWins(x)));
        gui.getGeneralDeckStatisticsRegularCards().setText("" + keeper.getRegularCardsByWins(x));
        gui.getGeneralDeckStatisticsAvgRegularCards().setText("" + StatisticsHelper.round(keeper.getAverageRegularCardsByWins(x)));
        gui.getGeneralDeckStatisticsGoldenCards().setText("" + keeper.getGoldCardsByWins(x));
        gui.getGeneralDeckStatisticsAvgGoldenCards().setText("" + StatisticsHelper.round(keeper.getAverageGoldCardsByWins(x)));
    }
}
