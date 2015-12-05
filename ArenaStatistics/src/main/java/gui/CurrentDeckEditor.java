package gui;

import domain.Deck;
import domain.DeckClass;
import domain.Match;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import logic.DeckHandler;
import util.PortraitSetter;

public class CurrentDeckEditor implements GUIWithPortrait{

    private Deck currentDeck;
    private DeckHandler deckHandler;
    private JLabel currentScore;
    private JLabel playerClass;
    private JLabel opponentClass;
    private JLabel outcome;
    private JLabel went1stOr2nd;
    private JLabel portrait;
    private JRadioButton mainPortrait;
    private JRadioButton altPortrait;
    private JComboBox matchSelect;
    private JButton addMatch;
    private JButton removeMatch;
    private JButton newDeck;
    private JButton retireCurrentDeck;
    private JButton removeCurrentDeck;
    private JPanel matchInfoPanel;

    public CurrentDeckEditor(MainGUI gui) {
        currentDeck = gui.getCurrentDeck();
        deckHandler = new DeckHandler();
        deckHandler.setDeck(currentDeck);
        setGUIObjects(gui);
        setLabelValues();
    }

    private void setGUIObjects(MainGUI gui) {
        currentScore = gui.getCurrentScore();
        playerClass = gui.getCurrentDeckPlayerClass();
        opponentClass = gui.getCurrentDeckOpponentClass();
        outcome = gui.getCurrentDeckOutcome();
        went1stOr2nd = gui.getCurrentDeck1stOr2nd();
        portrait = gui.getCurrentDeckPortrait();
        mainPortrait = gui.getCurrentDeckMainPortraitChooser();
        altPortrait = gui.getCurrentDeckAltPortraitChooser();
        matchSelect = gui.getMatchSelect();
        addMatch = gui.getAddMatch();
        removeMatch = gui.getRemoveMatch();
        newDeck = gui.getNewDeck();
        retireCurrentDeck = gui.getRetireCurrentDeck();
        removeCurrentDeck = gui.getRemoveCurrentDeck();
        matchInfoPanel = gui.getMatchInfoPanel();
    }

    private void setLabelValues() {
        if (currentDeck != null) {
            setDefaultValues();
        } else {
            setCurrentRunValues();
        }
    }

    private void setCurrentRunValues() {
        currentScore.setText(currentDeck.getScore());
        enableElements(false, true);
        setMatchesToComboBox();
        setMatchInfo();
        updateVisuals();
    }

    // Use to enable/disable GUI elements depending if there is currently an ongoing arena run.
    // So if there is currently no arena run going on, you input (true, false) as the parameters, 
    // and vice versa if there is currently an ongoing arena run
    private void enableElements(boolean noDeck, boolean ongoingDeck) {
        matchSelect.setEnabled(ongoingDeck);
        matchInfoPanel.setVisible(ongoingDeck);
        addMatch.setEnabled(ongoingDeck);
        removeMatch.setEnabled(ongoingDeck);
        newDeck.setEnabled(noDeck);
        retireCurrentDeck.setEnabled(ongoingDeck);
        removeCurrentDeck.setEnabled(ongoingDeck);
        portrait.setVisible(ongoingDeck);
        mainPortrait.setEnabled(ongoingDeck);
        altPortrait.setEnabled(ongoingDeck);
    }

    private void setMatchInfo() {
        Match match = (Match) matchSelect.getSelectedItem();
        playerClass.setText(match.getPlayerClass().getName());
        opponentClass.setText(match.getOpponentClass().getName());
        setWent1stOr2nd(match.wentFirst());
        outcome.setText(match.getOutcome().getName());
    }

    private void setWent1stOr2nd(boolean wentFirst) {
        if (wentFirst) {
            went1stOr2nd.setText("Went first");
        } else {
            went1stOr2nd.setText("Went second");
        }
    }

    private void setDefaultValues() {
        currentScore.setText("0-0");
        enableElements(true, false);
        setMatchesToComboBox();
    }

    private void setMatchesToComboBox() {
        Match[] matches = new Match[]{};
        if (currentDeck != null) {
            matches = copyMatchListToArray();
        }
        matchSelect.setModel(new DefaultComboBoxModel(matches));
    }

    private Match[] copyMatchListToArray() {
        Match[] matches = new Match[]{};
        for (int i = 0; i < currentDeck.getMatches().size(); i++) {
            matches[i] = currentDeck.getMatches().get(i);
        }
        return matches;
    }

    public Match getMatch(int i) {
        return currentDeck.getMatches().get(i);
    }

    public boolean addMatch(Match match) {
        boolean deckFinished = deckHandler.addMatch(match);
        setLabelValues();
        return deckFinished;
    }

    public void removeMatch(int i) {
        deckHandler.removeMatch(i);
        setLabelValues();
    }

    @Override
    public void updatePortrait() {
        PortraitSetter.setPortrait(mainPortrait, altPortrait, portrait, currentDeck.getDeckClass());
    }

    @Override
    public void updatePortraitChoosers() {
        PortraitSetter.updatePortraitChoosers(mainPortrait, altPortrait, currentDeck.getDeckClass());
    }

    @Override
    public void updateVisuals() {
        updatePortrait();
        updatePortraitChoosers();
    }
    
    
}
