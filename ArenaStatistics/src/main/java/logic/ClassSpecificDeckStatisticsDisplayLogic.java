package logic;

import domain.DeckClass;
import gui.MainGUI;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import util.PortraitSetter;
import util.StatisticsHelper;

/**
 * Class that inputs DeckScoreStatisticsKeeper manipulates GUI elements of the
 * 'Class Specific Deck Statistics' tab of MainGUI.
 */
public class ClassSpecificDeckStatisticsDisplayLogic implements StatisticsDisplay, DisplayWithPortrait {

    private final MainGUI gui;
    private final DeckScoreStatisticsKeeper keeper;
    private final JRadioButton mainPortraitChooser;
    private final JRadioButton altPortraitChooser;
    private final JComboBox classChooser;

    /**
     * Creates a new ClassSpecificDeckStatisticsDisplayLogic object.
     * 
     * @param gui The Main GUI of the program.
     */
    public ClassSpecificDeckStatisticsDisplayLogic(MainGUI gui) {
        this.gui = gui;
        keeper = gui.getDeckScoreStatisticsKeeper();
        mainPortraitChooser = gui.getClassDeckStatisticsMainPortraitChooser();
        altPortraitChooser = gui.getClassDeckStatisticsAltPortraitChooser();
        classChooser = gui.getClassDeckStatisticsClassChooser();
    }

    @Override
    public void updatePortraitChoosers() {
        PortraitSetter.updatePortraitChoosers(mainPortraitChooser, altPortraitChooser, (DeckClass) classChooser.getSelectedItem());
    }

    @Override
    public void updatePortrait() {
        PortraitSetter.setPortrait(mainPortraitChooser, altPortraitChooser, gui.getClassDeckStatisticsPortrait(), (DeckClass) classChooser.getSelectedItem());
    }

    @Override
    public void updateStats() {
        DeckClass dc = (DeckClass) classChooser.getSelectedItem();
        gui.getClassDeckStatisticsDecksAsClass().setText("" + keeper.getDecksAsClass(dc));
        gui.getClassDeckStatisticsWinsAsClass().setText("" + keeper.getWinsAsClass(dc));
        gui.getClassDeckStatisticsPlayPerAsClass().setText("" + StatisticsHelper.convertToPercentage(keeper.getPlayRatioAsClass(dc)));
        gui.getClassDeckStatisticsAvgWinsAsClass().setText("" + keeper.getAverageWinsAsClass(dc));
        putValuesToWinAmountLabels(dc);
    }

    private void putValuesToWinAmountLabels(DeckClass dc) {
        for (int i = 0; i < 13; i++) {
            gui.getWinAmountLabels().get(i).setText("" + keeper.getDecksAsClassWithXWins(dc, i));
        }
    }

    @Override
    public void updateVisuals() {
        updatePortrait();
        updatePortraitChoosers();
        updateStats();
    }
}
