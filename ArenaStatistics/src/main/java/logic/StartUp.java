package logic;

import gui.MainGUI;
import javax.swing.SwingUtilities;
import xml.DataParser;
import xml.DataWriter;

public class StartUp {

    private final DataParser parser;
    private final ClassStatisticsKeeper classStatisticsKeeper;
    private final ClassVSClassStatisticsKeeper classVSClassStatisticsKeeper;
    private final DeckClassStatisticsKeeper deckClassStatisticsKeeper;
    private final RewardStatisticsKeeper rewardStatisticsKeeper;

    public StartUp() {
        parser = new DataParser();
        parser.parseData();
        classStatisticsKeeper = parser.getClassStatisticsKeeper();
        classVSClassStatisticsKeeper = parser.getClassVSClassStatisticsKeeper();
        deckClassStatisticsKeeper = parser.getDeckClassStatisticsKeeper();
        rewardStatisticsKeeper = parser.getRewardStatisticsKeeper();
    }

    public void Start() {
        MainGUI gui = new MainGUI();
        setStatisticsKeepersToGUI(gui);
        if (classStatisticsKeeper.getTotalMatches() == 0) {
            gui.initXml();
        }
        gui.setCurrentDeck(parser.getCurrentDeck());
        SwingUtilities.invokeLater(gui);
        gui.setVisible(true);
    }

    private void setStatisticsKeepersToGUI(MainGUI gui) {
        gui.setClassStatisticsKeeper(classStatisticsKeeper);
        gui.setClassVSClassStatisticsKeeper(classVSClassStatisticsKeeper);
        gui.setDeckClassStatisticsKeeper(deckClassStatisticsKeeper);
        gui.setRewardStatisticsKeeper(rewardStatisticsKeeper);
        gui.setDataWriter(new DataWriter(classStatisticsKeeper, classVSClassStatisticsKeeper,
                deckClassStatisticsKeeper, rewardStatisticsKeeper));
    }
}
