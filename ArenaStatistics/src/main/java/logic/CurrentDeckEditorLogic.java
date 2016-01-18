package logic;

import domain.Deck;
import domain.Match;
import gui.MainGUI;
import javax.swing.DefaultComboBoxModel;
import util.PortraitSetter;

/**
 * Class that manipulates the user's deck and GUI elements of the 'Current Deck'
 * tab of MainGUI.
 */
public class CurrentDeckEditorLogic implements DisplayWithPortrait {

    private Deck currentDeck;
    private final DeckHandler deckHandler;
    private final MainGUI gui;

    /**
     * Creates a new CurrentDeckEditorLogic Object.
     *
     * @param gui The Main GUI of the program.
     */
    public CurrentDeckEditorLogic(MainGUI gui) {
        this.gui = gui;
        currentDeck = gui.getCurrentDeck();
        deckHandler = new DeckHandler();
        deckHandler.setDeck(currentDeck);
        setLabelValues();
    }

    private void setLabelValues() {
        if (currentDeck == null) {
            setDefaultValues();
        } else {
            setCurrentRunValues();
        }
    }

    /**
     * Enables all the JButtons except the Deck Creation JButton, sets different
     * values from the current run into GUI elements.
     */
    public void setCurrentRunValues() {
        gui.getCurrentScore().setText(currentDeck.getScore());
        enableElements(false, true);
        setMatchesToComboBox();
        if (!currentDeck.getMatches().isEmpty()) {
            setMatchInfo();
        } else {
            gui.getMatchInfoPanel().setVisible(false);
        }
        updateVisuals();
    }

    // Use to enable/disable GUI elements depending if there is currently an ongoing arena run.
    // So if there is currently no arena run going on, you input (true, false) as the parameters, 
    // and vice versa if there is currently an ongoing arena run
    private void enableElements(boolean noDeck, boolean ongoingDeck) {
        gui.getMatchSelect().setEnabled(ongoingDeck);
        gui.getMatchInfoPanel().setVisible(ongoingDeck);
        gui.getAddMatch().setEnabled(ongoingDeck);
        gui.getRemoveMatch().setEnabled(ongoingDeck);
        gui.getNewDeck().setEnabled(noDeck);
        gui.getRetireCurrentDeck().setEnabled(ongoingDeck);
        gui.getRemoveCurrentDeck().setEnabled(ongoingDeck);
        gui.getCurrentDeckPortrait().setVisible(ongoingDeck);
        gui.getCurrentDeckMainPortraitChooser().setEnabled(ongoingDeck);
        gui.getCurrentDeckAltPortraitChooser().setEnabled(ongoingDeck);
    }

    /**
     * Sets info from the currently selected match into the match info display.
     */
    public void setMatchInfo() {
        int selectedIndex = gui.getMatchSelect().getSelectedIndex();
        if (selectedIndex > -1 && selectedIndex < currentDeck.getMatches().size()) {
            Match match = (Match) gui.getMatchSelect().getSelectedItem();
            gui.getCurrentDeckPlayerClass().setText(match.getPlayerClass().getName());
            gui.getCurrentDeckOpponentClass().setText(match.getOpponentClass().getName());
            setWent1stOr2nd(match.wentFirst());
            gui.getCurrentDeckOutcome().setText(match.getOutcome().getName());
        }
    }

    private void setWent1stOr2nd(boolean wentFirst) {
        if (wentFirst) {
            gui.getCurrentDeck1stOr2nd().setText("Went first");
        } else {
            gui.getCurrentDeck1stOr2nd().setText("Went second");
        }
    }

    private void setDefaultValues() {
        gui.getCurrentScore().setText("0-0");
        enableElements(true, false);
        setMatchesToComboBox();
    }

    private void setMatchesToComboBox() {
        Match[] matches = new Match[]{};
        if (currentDeck != null) {
            matches = copyMatchListToArray();
        }
        gui.getMatchSelect().setModel(new DefaultComboBoxModel(matches));
        gui.getMatchSelect().setEnabled(true);
    }

    private Match[] copyMatchListToArray() {
        Match[] matches = new Match[14];
        for (int i = 0; i < currentDeck.getMatches().size(); i++) {
            matches[i] = currentDeck.getMatches().get(i);
        }
        return matches;
    }

    /**
     * Returns the selected match from the deck#s list of matches.
     * 
     * @param i Index of the match.
     * @return Match if match found at the specified index, otherwise null.
     */
    public Match getMatch(int i) {
        return currentDeck.getMatches().get(i);
    }

    /**
     * Adds a match to the Deck.
     * 
     * @param match Match which is added to the deck.
     */
    public void addMatch(Match match) {
        boolean deckFinished = deckHandler.addMatch(match);
        setLabelValues();
        if (deckFinished) {
            finishDeck();
        } else {
            gui.saveProgress();
        }
    }

    /**
     * Opens the results GUI.
     */
    public void finishDeck() {
        gui.openResultsGUI();
    }

    /**
     * Removes the selected match from the deck's list of matches
     * 
     * @param i Index of the selected match.
     */
    public void removeMatch(int i) {
        deckHandler.removeMatch(i);
        setLabelValues();
    }

    @Override
    public void updatePortrait() {
        PortraitSetter.setPortrait(gui.getCurrentDeckMainPortraitChooser(),
                gui.getCurrentDeckAltPortraitChooser(), gui.getCurrentDeckPortrait(), currentDeck.getDeckClass());
    }

    @Override
    public void updatePortraitChoosers() {
        PortraitSetter.updatePortraitChoosers(gui.getCurrentDeckMainPortraitChooser(),
                gui.getCurrentDeckAltPortraitChooser(), currentDeck.getDeckClass());
    }

    @Override
    public void updateVisuals() {
        updatePortrait();
        updatePortraitChoosers();
    }

    /**
     * Sets the current deck used by the user.
     * 
     * @param currentDeck Deck currently in use by the user.
     */
    public void setCurrentDeck(Deck currentDeck) {
        this.currentDeck = currentDeck;
        deckHandler.setDeck(this.currentDeck);
        setLabelValues();
    }

}
