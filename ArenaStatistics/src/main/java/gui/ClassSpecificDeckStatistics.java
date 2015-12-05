package gui;

import domain.DeckClass;
import javax.swing.*;
import logic.DeckClassStatisticsKeeper;
import util.PortraitSetter;

public class ClassSpecificDeckStatistics  implements StatisticsGUI, GUIWithPortrait {

    private MainGUI gui;
    private DeckClassStatisticsKeeper keeper;
    private JComboBox classChooser;
    private JRadioButton mainPortraitChooser;
    private JRadioButton altPortraitChooser;
    private JLabel classPortrait;
    private JLabel decksAsClass;
    private JLabel winsAsClass;
    private JLabel playPerAsClass;
    private JLabel avgWinsAsClass;
    private JLabel zeroWinDecks;
    private JLabel oneWinDecks;
    private JLabel twoWinDecks;
    private JLabel threeWinDecks;
    private JLabel fourWinDecks;
    private JLabel fiveWinDecks;
    private JLabel sixWinDecks;
    private JLabel sevenWinDecks;
    private JLabel eightWinDecks;
    private JLabel nineWinDecks;
    private JLabel tenWinDecks;
    private JLabel elevenWinDecks;
    private JLabel twelveWinDecks;

    public ClassSpecificDeckStatistics(MainGUI gui) {
        this.gui = gui;
        setObjects();
    }

    private void setObjects() {
        keeper = gui.getDeckClassStatisticsKeeper();
        mainPortraitChooser = gui.getClassDeckStatisticsMainPortraitChooser();
        altPortraitChooser = gui.getClassDeckStatisticsAltPortraitChooser();
        classChooser = gui.getClassDeckStatisticsClassChooser();
        setJLabels();
    }

    private void setJLabels() {
        classPortrait = gui.getClassDeckStatisticsPortrait();
        decksAsClass = gui.getClassDeckStatisticsDecksAsClass();
        winsAsClass = gui.getClassDeckStatisticsWinsAsClass();
        playPerAsClass = gui.getClassDeckStatisticsPlayPerAsClass();
        avgWinsAsClass = gui.getClassDeckStatisticsAvgWinsAsClass();
        setWins();
    }

    private void setWins() {
        zeroWinDecks = gui.getClassDeckStatisticsZeroWinDecksAsClass();
        oneWinDecks = gui.getClassDeckStatisticsOneWinDecksAsClass();
        twoWinDecks = gui.getClassDeckStatisticsTwoWinDecksAsClass();
        threeWinDecks = gui.getClassDeckStatisticsThreeWinDecksAsClass();
        fourWinDecks = gui.getClassDeckStatisticsFourWinDecksAsClass();
        fiveWinDecks = gui.getClassDeckStatisticsFiveWinDecksAsClass();
        sixWinDecks = gui.getClassDeckStatisticsSixWinDecksAsClass();
        sevenWinDecks = gui.getClassDeckStatisticsSevenWinDecksAsClass();
        eightWinDecks = gui.getClassDeckStatisticsEightWinDecksAsClass();
        nineWinDecks = gui.getClassDeckStatisticsNineWinDecksAsClass();
        tenWinDecks = gui.getClassDeckStatisticsTenWinDecksAsClass();
        elevenWinDecks = gui.getClassDeckStatisticsElevenWinDecksAsClass();
        twelveWinDecks = gui.getClassDeckStatisticsTwelveWinDecksAsClass();
    }

    @Override
    public void updatePortraitChoosers() {
        PortraitSetter.updatePortraitChoosers(mainPortraitChooser, altPortraitChooser, (DeckClass) classChooser.getSelectedItem());
    }

    @Override
    public void updatePortrait() {
        PortraitSetter.setPortrait(mainPortraitChooser, altPortraitChooser, classPortrait, (DeckClass) classChooser.getSelectedItem());
    }

    @Override
    public void updateStats() {
        DeckClass dc = (DeckClass) classChooser.getSelectedItem();
        decksAsClass.setText("" + keeper.getDecksAsClass(dc));
        winsAsClass.setText("" + keeper.getWinsAsClass(dc));
        playPerAsClass.setText("" + keeper.getPlayPercentageAsClass(dc));
        avgWinsAsClass.setText("" + keeper.getAverageWinsAsClass(dc));
        zeroWinDecks.setText("" + keeper.getDecksAsClassWithXWins(dc, 0));
        oneWinDecks.setText("" + keeper.getDecksAsClassWithXWins(dc, 1));
        twoWinDecks.setText("" + keeper.getDecksAsClassWithXWins(dc, 2));
        threeWinDecks.setText("" + keeper.getDecksAsClassWithXWins(dc, 3));
        fourWinDecks.setText("" + keeper.getDecksAsClassWithXWins(dc, 4));
        fiveWinDecks.setText("" + keeper.getDecksAsClassWithXWins(dc, 5));
        sixWinDecks.setText("" + keeper.getDecksAsClassWithXWins(dc, 6));
        sevenWinDecks.setText("" + keeper.getDecksAsClassWithXWins(dc, 7));
        eightWinDecks.setText("" + keeper.getDecksAsClassWithXWins(dc, 8));
        nineWinDecks.setText("" + keeper.getDecksAsClassWithXWins(dc, 9));
        tenWinDecks.setText("" + keeper.getDecksAsClassWithXWins(dc, 10));
        elevenWinDecks.setText("" + keeper.getDecksAsClassWithXWins(dc, 11));
        twelveWinDecks.setText("" + keeper.getDecksAsClassWithXWins(dc, 12));
    }

    @Override
    public void updateVisuals() {
        updatePortrait();
        updatePortraitChoosers();
        updateStats();
    } 
}
