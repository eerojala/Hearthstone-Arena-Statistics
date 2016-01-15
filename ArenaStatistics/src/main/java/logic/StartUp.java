package logic;

import gui.MainGUI;
import javax.swing.SwingUtilities;
import xml.DataParser;
import xml.DataWriter;

/**
 * Class which starts up the MainGUI.
 */
public class StartUp {

    private final DataParser parser;
    private final MatchStatisticsKeeper classStatisticsKeeper;
    private final MatchupStatisticsKeeper classVSClassStatisticsKeeper;
    private final DeckScoreStatisticsKeeper deckClassStatisticsKeeper;
    private final RewardStatisticsKeeper rewardStatisticsKeeper;

    /**
     * Creates a new StartUp Object.
     */
    public StartUp() {
        parser = new DataParser();
        parser.parseData();
        classStatisticsKeeper = parser.getMatchStatisticsKeeper();
        classVSClassStatisticsKeeper = parser.getMatchupStatisticsKeeper();
        deckClassStatisticsKeeper = parser.getDeckScoreStatisticsKeeper();
        rewardStatisticsKeeper = parser.getRewardStatisticsKeeper();
    }

    /**
     * Starts up the MainGUI.
     */
    public void Start() {
        MainGUI gui = new MainGUI();
        setStatisticsKeepersToGUI(gui);
        gui.setDataWriter(new DataWriter(classStatisticsKeeper, classVSClassStatisticsKeeper,
                deckClassStatisticsKeeper, rewardStatisticsKeeper));
        if (classStatisticsKeeper.getTotalMatches() == 0) {
            gui.initXml();
        }
        gui.setCurrentDeck(parser.getCurrentDeck());
        SwingUtilities.invokeLater(gui);
        gui.setVisible(true);
    }

    private void setStatisticsKeepersToGUI(MainGUI gui) {
        gui.setMatchStatisticsKeeper(classStatisticsKeeper);
        gui.setMatchupStatisticsKeeper(classVSClassStatisticsKeeper);
        gui.setDeckScoreStatisticsKeeper(deckClassStatisticsKeeper);
        gui.setRewardStatisticsKeeper(rewardStatisticsKeeper);
    }
}
