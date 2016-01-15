package gui;

import logic.*;
import domain.Deck;
import domain.DeckClass;
import domain.Match;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import xml.DataWriter;

/**
 * Class for the main GUI of the program.
 */
public class MainGUI extends javax.swing.JFrame implements Runnable {

    @Override
    public void run() {
        initComponents();
        putWinAmountLabelsToList();
        classSpecificDeckStatistics = new ClassSpecificDeckStatisticsDisplayLogic(this);
        classSpecificDeckStatistics.updateVisuals();
        matchStatistics = new MatchStatisticsDisplayLogic(this);
        matchStatistics.updateVisuals();
        generalDeckStatistics = new GeneralDeckStatisticsDisplayLogic(this);
        generalDeckStatistics.updateStats();
        currentDeckEditor = new CurrentDeckEditorLogic(this);
    }

    private void putWinAmountLabelsToList() {
        winAmountLabels = new ArrayList();
        winAmountLabels.add(classDeckStatisticsZeroWinDecksAsClass);
        winAmountLabels.add(classDeckStatisticsOneWinDecksAsClass);
        winAmountLabels.add(classDeckStatisticsTwoWinDecksAsClass);
        winAmountLabels.add(classDeckStatisticsThreeWinDecksAsClass);
        winAmountLabels.add(classDeckStatisticsFourWinDecksAsClass);
        winAmountLabels.add(classDeckStatisticsFiveWinDecksAsClass);
        winAmountLabels.add(classDeckStatisticsSixWinDecksAsClass);
        winAmountLabels.add(classDeckStatisticsSevenWinDecksAsClass);
        winAmountLabels.add(classDeckStatisticsEightWinDecksAsClass);
        winAmountLabels.add(classDeckStatisticsNineWinDecksAsClass);
        winAmountLabels.add(classDeckStatisticsTenWinDecksAsClass);
        winAmountLabels.add(classDeckStatisticsElevenWinDecksAsClass);
        winAmountLabels.add(classDeckStatisticsTwelveWinDecksAsClass);
    }

    /**
     * Sets the deck currently used by the player.
     *
     * @param currentDeck Deck currently used by the player.
     */
    public void setCurrentDeck(Deck currentDeck) {
        this.currentDeck = currentDeck;
        if (currentDeck == null) {
            currentDeckNumber = deckScoreStatisticsKeeper.getTotalDeckAmount() + 1;
        } else {
            currentDeckNumber = this.currentDeck.getDeckNumber();
        }
        setCurrentMatchNumber();
    }

    private void setCurrentMatchNumber() {
        if (currentDeck == null || currentDeck.getMatches().isEmpty()) {
            nextMatchNumber = 1;
        } else {
            nextMatchNumber = this.currentDeck.getMatches().get(this.currentDeck.getMatches().size() - 1).getMatchNumber() + 1;
        }
    }

    /**
     * @param matchStatisticsKeeper
     */
    public void setMatchStatisticsKeeper(MatchStatisticsKeeper matchStatisticsKeeper) {
        this.matchStatisticsKeeper = matchStatisticsKeeper;
    }

    /**
     *
     * @param matchupStatisticsKeeper
     */
    public void setMatchupStatisticsKeeper(MatchupStatisticsKeeper matchupStatisticsKeeper) {
        this.matchupStatisticsKeeper = matchupStatisticsKeeper;
    }

    /**
     *
     * @param deckScoreStatisticsKeeper
     */
    public void setDeckScoreStatisticsKeeper(DeckScoreStatisticsKeeper deckScoreStatisticsKeeper) {
        this.deckScoreStatisticsKeeper = deckScoreStatisticsKeeper;
    }

    /**
     *
     * @param rewardStatisticsKeeper
     */
    public void setRewardStatisticsKeeper(RewardStatisticsKeeper rewardStatisticsKeeper) {
        this.rewardStatisticsKeeper = rewardStatisticsKeeper;
    }

    /**
     *
     * @param dataWriter
     */
    public void setDataWriter(DataWriter dataWriter) {
        this.dataWriter = dataWriter;
    }

    /**
     * Returns the JLabel used for class portraits in the 'Class Specific Deck
     * Statistics' tab.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsPortrait() {
        return classDeckStatisticsPortrait;
    }

    /**
     * Returns the JLabel used for class portraits in the 'Match Statistics'
     * tab.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsPortrait() {
        return matchStatisticsPortrait;
    }

    /**
     *
     * @return MatchStatisticsKeeper
     */
    public MatchStatisticsKeeper getMatchStatisticsKeeper() {
        return matchStatisticsKeeper;
    }

    /**
     *
     * @return MatchupStatisticsKeeper
     */
    public MatchupStatisticsKeeper getMatchupStatisticsKeeper() {
        return matchupStatisticsKeeper;
    }

    /**
     * Returns the JLabel used for the average wins as class value in the 'Class
     * Specific Deck Statistics' tab.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsAvgWinsAsClass() {
        return classDeckStatisticsAvgWinsAsClass;
    }

    /**
     * Returns the JRadioButton used for selecting the alternate class portrait
     * in the 'Class Specific Deck Statistics' tab.
     *
     * @return JRadioButton
     */
    public JRadioButton getClassDeckStatisticsAltPortraitChooser() {
        return classDeckStatisticsAltPortraitChooser;
    }

    /**
     *
     * @return DeckScoreStatisticsKeeper
     */
    public DeckScoreStatisticsKeeper getDeckScoreStatisticsKeeper() {
        return deckScoreStatisticsKeeper;
    }

    /**
     * Returns the JRadioButton used for selecting the main class portrait in
     * the 'Class Specific Deck Statistics' tab.
     *
     * @return JRadioButton
     */
    public JRadioButton getClassDeckStatisticsMainPortraitChooser() {
        return classDeckStatisticsMainPortraitChooser;
    }

    /**
     * Returns the JComboBox used for selecting the viewed class in the 'Class
     * Specific Deck Statistics' tab.
     *
     * @return JComboBox
     */
    public JComboBox getClassDeckStatisticsClassChooser() {
        return ClassDeckStatisticsClassChooser;
    }

    /**
     *
     * @return RewardStatisticsKeeper
     */
    public RewardStatisticsKeeper getRewardStatisticsKeeper() {
        return rewardStatisticsKeeper;
    }

    /**
     * Returns the JLabel used for the 'wins as class' value in 'Class Specific
     * Deck Statistics' tab.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsWinsAsClass() {
        return classDeckStatisticsWinsAsClass;
    }

    /**
     * Returns the JLabel used for the 'decks as class' value in the 'Class
     * Specific Deck Statistics' tab.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsDecksAsClass() {
        return classDeckStatisticsDecksAsClass;
    }

    /**
     * Returns the JLabel used for the '8 win decks' value in the 'Class
     * Specific Deck Statistics' tab.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsEightWinDecksAsClass() {
        return classDeckStatisticsEightWinDecksAsClass;
    }

    /**
     * Returns the JLabel used for the '11 win decks' value in the 'Class
     * Specific Deck Statistics' tab.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsElevenWinDecksAsClass() {
        return classDeckStatisticsElevenWinDecksAsClass;
    }

    /**
     * Returns the JLabel used for the '5 win decks' value in the 'Class
     * Specific Deck Statistics' tab.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsFiveWinDecksAsClass() {
        return classDeckStatisticsFiveWinDecksAsClass;
    }

    /**
     * Returns the JLabel used for the '4 win decks' value in the 'Class
     * Specific Deck Statistics' tab.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsFourWinDecksAsClass() {
        return classDeckStatisticsFourWinDecksAsClass;
    }

    /**
     * Returns the JLabel used for the '9 win decks' value in the 'Class
     * Specific Deck Statistics' tab.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsNineWinDecksAsClass() {
        return classDeckStatisticsNineWinDecksAsClass;
    }

    /**
     * Returns the JRadioButton used for choosing the alternate class portrait
     * in the 'Match Statistics' tab.
     *
     * @return JRadioButton
     */
    public JRadioButton getMatchStatisticsAltPortraitChooser() {
        return matchStatisticsAltPortraitChooser;
    }

    /**
     * Returns the JRadioButton used for choosing the main class portrait in the
     * 'Match Statistics' tab.
     *
     * @return JRadioButton
     */
    public JRadioButton getMatchStatisticsMainPortraitChooser() {
        return matchStatisticsMainPortraitChooser;
    }

    /**
     * Returns the JRadioButton used in the 'Match Statistics' tab for choosing
     * to display statistics about matches where the player went 1st.
     *
     * @return JRadioButton
     */
    public JRadioButton getMatchStatistics1stRadioButton() {
        return matchStatistics1stRadioButton;
    }

    /**
     * Returns the JRadioButton used in the 'Match Statistics' tab for choosing
     * to display statistics about matches where the player went 2nd.
     *
     * @return JRadioButton
     */
    public JRadioButton getMatchStatistics2ndRadioButton() {
        return matchStatistics2ndRadioButton;
    }

    /**
     * Returns the JComboBox used in the 'Match Statistics' tab for choosing the
     * main class which statistics are viewed.
     *
     * @return JComboBox
     */
    public JComboBox getMatchStatisticsClass1Chooser() {
        return matchStatisticsClass1Chooser;
    }

    /**
     * Returns the JComboBox used in the 'Match Statistics' tab for choosing the
     * second class which is used in the matchup statistics section along with
     * the main class.
     *
     * @return JComboBox
     */
    public JComboBox getMatchStatisticsClass2Chooser() {
        return matchStatisticsClass2Chooser;
    }

    /**
     * Returns the JRadioButton used in the 'Match Statistics' tab for choosing
     * to display statistics about all of the matches regardless of the turn
     * order.
     *
     * @return
     */
    public JRadioButton getMatchStatisticsTotalRadioButton() {
        return matchStatisticsTotalRadioButton;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * chosen class in the 'Wins as [class]' label.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsWinsAsClassLabel() {
        return matchStatisticsWinsAsClassLabel;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * amount of wins for the chosen class.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsWinsAsClassValue() {
        return matchStatisticsWinsAsClassValue;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * chosen class in the 'Wins vs [class]' label.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsWinsVSClassLabel() {
        return matchStatisticsWinsVSClassLabel;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * amount of wins against the chosen class.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsWinsVSClassValue() {
        return matchStatisticsWinsVSClassValue;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * chosen class in the 'Matches as [class]' label
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsMatchesAsClassLabel() {
        return matchStatisticsMatchesAsClassLabel;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * amount matches where the player used the chosen class.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsMatchesAsClassValue() {
        return matchStatisticsMatchesAsClassValue;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * chosen alternate class in the 'Matches vs [altclass]' label.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsMatchesVSClass2Label() {
        return matchStatisticsMatchesVSClass2Label;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * amount of matches in a specific matchup.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsMatchesVSClass2Value() {
        return matchStatisticsMatchesVSClass2Value;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * chosen class in the 'Matches vs [class]' label.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsMatchesVSClassLabel() {
        return matchStatisticsMatchesVSClassLabel;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * amount of matches against the chosen class.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsMatchesVSClassValue() {
        return matchStatisticsMatchesVSClassValue;
    }

    /**
     * Returns the JLabel used in the 'Class Specific Deck Statistics' tab for
     * displaying the amount of 1-win decks played with the chosen class.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsOneWinDecksAsClass() {
        return classDeckStatisticsOneWinDecksAsClass;
    }

    /**
     * Returns the JLabel used in the 'Class Specific Deck Statistics' tab for
     * displaying the playing percentage of the chosen class.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsPlayPerAsClass() {
        return classDeckStatisticsPlayPerAsClass;
    }

    /**
     * Returns the JLabel used in the 'Class Specific Deck Statistics' tab for
     * displaying the amount of 7-win decks played with the class.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsSevenWinDecksAsClass() {
        return classDeckStatisticsSevenWinDecksAsClass;
    }

    /**
     * Returns the JLabel used in the 'Class Specific Deck Statistics' tab for
     * displaying the amount of 6-win decks played with the chosen class.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsSixWinDecksAsClass() {
        return classDeckStatisticsSixWinDecksAsClass;
    }

    /**
     * Returns the JLabel used in the 'Class Specific Deck Statistics' tab for
     * displaying the amount of 10-win decks played with the chosen class.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsTenWinDecksAsClass() {
        return classDeckStatisticsTenWinDecksAsClass;
    }

    /**
     * Returns the JLabel used in the 'Class Specific Deck Statistics' tab for
     * displaying the amount of 3-win decks played with the chosen class.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsThreeWinDecksAsClass() {
        return classDeckStatisticsThreeWinDecksAsClass;
    }

    /**
     * Returns the JLabel used in the 'Class Specific Deck Statistics' tab for
     * displaying the amount of 12-win decks played with the chosen class.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsTwelveWinDecksAsClass() {
        return classDeckStatisticsTwelveWinDecksAsClass;
    }

    /**
     * Returns the JLabel used in the 'Class Specific Deck Statistics' tab for
     * displaying the amount of 2-win decks played with the chosen class.
     *
     * @return JLabel
     */
    public JLabel getClassDeckStatisticsTwoWinDecksAsClass() {
        return classDeckStatisticsTwoWinDecksAsClass;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * chosen class in the 'Win% as [class]' label.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsWinPerAsClassLabel() {
        return matchStatisticsWinPerAsClassLabel;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * win percentage of the chosen class.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsWinPerAsClassValue() {
        return matchStatisticsWinPerAsClassValue;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * chosen alternate class in the 'Win% vs [altclass]' label.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsWinPerVSClass2Label() {
        return matchStatisticsWinPerVSClass2Label;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * win percentage in a specific matchup.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsWinPerVSClass2Value() {
        return matchStatisticsWinPerVSClass2Value;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * chosen class in the 'Win% vs [class]' label.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsWinPerVSClassLabel() {
        return matchStatisticsWinPerVSClassLabel;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * win percentage against the chosen class.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsWinPerVSClassValue() {
        return matchStatisticsWinPerVSClassValue;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * chosen alternate class in the 'wins vs [altclass]' label.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsWinsVSClass2Label() {
        return matchStatisticsWinsVSClass2Label;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * amount of wins in a specific matchup.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsWinsVSClass2Value() {
        return matchStatisticsWinsVSClass2Value;
    }

    /**
     * Returns the JLabel used in the 'Class Specific Deck Statistics' tab for
     * displaying the amount of 0-win decks played with the chosen class.
     *
     * @return
     */
    public JLabel getClassDeckStatisticsZeroWinDecksAsClass() {
        return classDeckStatisticsZeroWinDecksAsClass;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * total amount of matches.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsTotalMatches() {
        return matchStatisticsTotalMatches;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * users total win percentage.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsTotalWinPer() {
        return matchStatisticsTotalWinPer;
    }

    /**
     * Returns the JLabel used in the 'Match Statistics' tab for displaying the
     * total amount of wins.
     *
     * @return JLabel
     */
    public JLabel getMatchStatisticsTotalWins() {
        return matchStatisticsTotalWins;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the average amount of dust received in X-win decks.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsAvgDust() {
        return generalDeckStatisticsAvgDust;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the average amount of extra card packs received in X-win
     * decks.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsAvgExtraPacks() {
        return generalDeckStatisticsAvgExtraPacks;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the average amount of gold received in X-win decks.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsAvgGold() {
        return generalDeckStatisticsAvgGold;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the average amount of golden cards received in X-win decks.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsAvgGoldenCards() {
        return generalDeckStatisticsAvgGoldenCards;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the average amount of regular cards received in X-win decks.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsAvgRegularCards() {
        return generalDeckStatisticsAvgRegularCards;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the total amount of decks with X-wins.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsDecks() {
        return generalDeckStatisticsDecks;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the total amount of dust received from decks with X-wins.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsDust() {
        return generalDeckStatisticsDust;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the total amount of extra card packs received from decks with
     * X-wins.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsExtraPacks() {
        return generalDeckStatisticsExtraPacks;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the total amount of golden cards received from decks with
     * X-wins.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsGoldenCards() {
        return generalDeckStatisticsGoldenCards;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the total amount of regular cards received from decks with
     * X-wins.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsRegularCards() {
        return generalDeckStatisticsRegularCards;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the total amount of gold received from decks with X-winsö.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsGold() {
        return generalDeckStatisticsGold;
    }

    /**
     * Returns the JSlider used in the 'General Deck Statistics' tab for
     * choosing the amount of wins which statistics are shown.
     *
     * @return JSlider
     */
    public JSlider getGeneralDeckStatisticsWinSlider() {
        return generalDeckStatisticsWinSlider;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the amount of wins which statistics are displayed.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsWins() {
        return generalDeckStatisticsWins;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the percentage of X-win decks out of all the decks.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsPerOutOfAllDecks() {
        return generalDeckStatisticsPerOutOfAllDecks;
    }

    /**
     * Returns the current deck in use by the user.
     *
     * @return Deck
     */
    public Deck getCurrentDeck() {
        return currentDeck;
    }

    /**
     * Returns the JLabel which displays the deck's current score in the
     * 'Current Deck' tab.
     *
     * @return JLabel
     */
    public JLabel getCurrentScore() {
        return currentScore;
    }

    /**
     * Returns the JLabel used in the 'Current Deck' tab for displaying the
     * score of the current deck.
     *
     * @return JLabel
     */
    public JLabel getCurrentDeckPlayerClass() {
        return currentDeckPlayerClass;
    }

    /**
     * Returns the JLabel used in the 'Current Deck' tab for displaying the
     * opponent's class in the viewed match.
     *
     * @return JLabel
     */
    public JLabel getCurrentDeckOpponentClass() {
        return currentDeckOpponentClass;
    }

    /**
     * Returns the JLabel used in the 'Current Deck' tab for displaying the
     * outcome of the viewed match.
     *
     * @return JLabel
     */
    public JLabel getCurrentDeckOutcome() {
        return currentDeckOutcome;
    }

    /**
     * Returns the JLabel used in the 'Current Deck' tab for displaying if the
     * player went first or second in the viewed match.
     *
     * @return JLabel
     */
    public JLabel getCurrentDeck1stOr2nd() {
        return currentDeck1stOr2nd;
    }

    /**
     * Returns the JLabel used in the 'Current Deck' tab for displaying the
     * chosen class portrait.
     *
     * @return JLabel
     */
    public JLabel getCurrentDeckPortrait() {
        return currentDeckPortrait;
    }

    /**
     * Returns the JRadioButton used in the 'Current Deck' tab for choosing the
     * main class portrait.
     *
     * @return JRadioButton
     */
    public JRadioButton getCurrentDeckMainPortraitChooser() {
        return currentDeckMainPortraitChooser;
    }

    /**
     * Returns the JRadioButton used in the 'Current Deck' tab for choosing the
     * alternate class portrait.
     *
     * @return JRadioButton
     */
    public JRadioButton getCurrentDeckAltPortraitChooser() {
        return currentDeckAltPortraitChooser;
    }

    /**
     * Returns the JCombobox used in the 'Current Deck' tab for choosing the
     * displayed match.
     *
     * @return JComboBox
     */
    public JComboBox getMatchSelect() {
        return matchSelect;
    }

    /**
     * Returns the JButton used in the 'Current Deck' tab for opening the match
     * creation GUI.
     *
     * @return JButton
     */
    public JButton getAddMatch() {
        return addMatch;
    }

    /**
     * Returns the JButton used in the 'Current Deck' tab for removing the
     * currently selected match.
     *
     * @return JButton
     */
    public JButton getRemoveMatch() {
        return removeMatch;
    }

    /**
     * Returns the JButton used in the 'Current Deck' tab for opening the deck
     * creation GUI.
     *
     * @return JButton
     */
    public JButton getNewDeck() {
        return newDeck;
    }

    /**
     * Returns the JButton used in the 'Current Deck' tab for retiring the
     * current deck.
     *
     * @return JButton
     */
    public JButton getRetireCurrentDeck() {
        return retireCurrentDeck;
    }

    /**
     * Returns the JButton used in the 'Current Deck' tab for removing the
     * current deck.
     *
     * @return JButton
     */
    public JButton getRemoveCurrentDeck() {
        return removeCurrentDeck;
    }

    /**
     * Returns the JPanel used in the 'Current Deck' tab for displaying info
     * about the currently selected match.
     *
     * @return JPanel
     */
    public JPanel getMatchInfoPanel() {
        return matchInfoPanel;
    }

    /**
     *
     * @return CurrentDeckEditorLogic
     */
    public CurrentDeckEditorLogic getCurrentDeckEditor() {
        return currentDeckEditor;
    }

    /**
     * Returns a list of JLabels used in the 'Class Specific Deck Statistics'
     * tab for displaying the amount of decks with X-wins.
     *
     * @return
     */
    public List<JLabel> getWinAmountLabels() {
        return winAmountLabels;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the 'Average Wins' label.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsAvgWins() {
        return generalDeckStatisticsAvgWins;
    }

    /**
     * Returns the JLabel used in the 'General Deck Statistics' tab for
     * displaying the total average amount of wins.
     *
     * @return JLabel
     */
    public JLabel getGeneralDeckStatisticsAvgWinsValue() {
        return generalDeckStatisticsAvgWins;
    }

    private void updateDeckStatsPortrait() {
        classSpecificDeckStatistics.updatePortrait();
    }

    private void updateMatchStatsPortrait() {
        matchStatistics.updatePortrait();
    }

    /**
     * Adds the current deck and it's matches to the statistics keepers.
     */
    public void addDeckAndMatchesToStatisticsKeepers() {
        deckScoreStatisticsKeeper.addDeck(currentDeck);
        rewardStatisticsKeeper.addDeck(currentDeck);
        addMatchesToStatisticsKeepers();
    }

    private void addMatchesToStatisticsKeepers() {
        for (Match match : currentDeck.getMatches()) {
            matchStatisticsKeeper.addMatch(match);
            matchupStatisticsKeeper.addMatch(match);
        }
    }

    /**
     * Saves the current deck and the newest match in the Xml files.
     *
     * @see xml.DataWriter#saveProgress(domain.Deck)
     */
    public void saveProgress() {
        dataWriter.saveProgress(currentDeck);
    }

    /**
     * Saves the statistics into the Xml files and nullifies the current deck.
     *
     * @see xml.DataWriter#saveStatistics(domain.Deck)
     */
    public void saveStatistics() {
        dataWriter.saveStatistics(currentDeck);
        currentDeck = null;
        currentDeckEditor.setCurrentDeck(currentDeck);
    }

    /**
     * Clears the statistics Xml files, and saves the current statistics on
     * them.
     *
     * @see xml.DataWriter#initXml()
     */
    public void initXml() {
        dataWriter.initXml();
    }

    /**
     * Disables the main GUI and runs a new ResultsGUI
     */
    public void openResultsGUI() {
        ResultsGUI gui = new ResultsGUI(this, currentDeck);
        this.setEnabled(false);
        SwingUtilities.invokeLater(gui);
        gui.setVisible(true);
    }

    /**
     * Increases the number used for identifying the next created match by 1.
     */
    public void increaseNextMatchNumber() {
        nextMatchNumber++;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deckStatisticsPortraitSelect = new javax.swing.ButtonGroup();
        matchStatisticsPortraitSelect = new javax.swing.ButtonGroup();
        matchStatisticsStatsSelect = new javax.swing.ButtonGroup();
        currentDeckPortraitSelect = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        classDeckStatisticsDecksAsClass = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        classDeckStatisticsWinsAsClass = new javax.swing.JLabel();
        classDeckStatisticsPlayPerAsClass = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        classDeckStatisticsAvgWinsAsClass = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        classDeckStatisticsEightWinDecksAsClass = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        classDeckStatisticsNineWinDecksAsClass = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        classDeckStatisticsTenWinDecksAsClass = new javax.swing.JLabel();
        classDeckStatisticsElevenWinDecksAsClass = new javax.swing.JLabel();
        classDeckStatisticsTwelveWinDecksAsClass = new javax.swing.JLabel();
        classDeckStatisticsSevenWinDecksAsClass = new javax.swing.JLabel();
        classDeckStatisticsSixWinDecksAsClass = new javax.swing.JLabel();
        classDeckStatisticsFiveWinDecksAsClass = new javax.swing.JLabel();
        classDeckStatisticsFourWinDecksAsClass = new javax.swing.JLabel();
        classDeckStatisticsThreeWinDecksAsClass = new javax.swing.JLabel();
        classDeckStatisticsTwoWinDecksAsClass = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        classDeckStatisticsOneWinDecksAsClass = new javax.swing.JLabel();
        classDeckStatisticsZeroWinDecksAsClass = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ClassDeckStatisticsClassChooser = new javax.swing.JComboBox();
        jPanel10 = new javax.swing.JPanel();
        classDeckStatisticsPortrait = new javax.swing.JLabel();
        classDeckStatisticsMainPortraitChooser = new javax.swing.JRadioButton();
        classDeckStatisticsAltPortraitChooser = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        newDeck = new javax.swing.JButton();
        addMatch = new javax.swing.JButton();
        removeMatch = new javax.swing.JButton();
        retireCurrentDeck = new javax.swing.JButton();
        removeCurrentDeck = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        currentScore = new javax.swing.JLabel();
        matchInfoPanel = new javax.swing.JPanel();
        currentDeckPlayerClass = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        currentDeckOpponentClass = new javax.swing.JLabel();
        currentDeck1stOr2nd = new javax.swing.JLabel();
        currentDeckOutcome = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        matchSelect = new javax.swing.JComboBox();
        currentDeckPortrait = new javax.swing.JLabel();
        currentDeckMainPortraitChooser = new javax.swing.JRadioButton();
        currentDeckAltPortraitChooser = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        generalDeckStatisticsWins = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        generalDeckStatisticsDecks = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        generalDeckStatisticsAvgDust = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        generalDeckStatisticsDust = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        generalDeckStatisticsGold = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        generalDeckStatisticsAvgGold = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        generalDeckStatisticsExtraPacks = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        generalDeckStatisticsAvgExtraPacks = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        generalDeckStatisticsRegularCards = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        generalDeckStatisticsAvgRegularCards = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        generalDeckStatisticsGoldenCards = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        generalDeckStatisticsAvgGoldenCards = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        generalDeckStatisticsPerOutOfAllDecks = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        generalDeckStatisticsAvgWins = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        generalDeckStatisticsWinSlider = new javax.swing.JSlider();
        generalDeckStatisticsSliderIndicator = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        matchStatisticsClass1Chooser = new javax.swing.JComboBox();
        jPanel14 = new javax.swing.JPanel();
        matchStatisticsPortrait = new javax.swing.JLabel();
        matchStatisticsMainPortraitChooser = new javax.swing.JRadioButton();
        matchStatisticsAltPortraitChooser = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        matchStatisticsMatchesAsClassLabel = new javax.swing.JLabel();
        matchStatisticsMatchesAsClassValue = new javax.swing.JLabel();
        matchStatisticsMatchesVSClassLabel = new javax.swing.JLabel();
        matchStatisticsMatchesVSClassValue = new javax.swing.JLabel();
        matchStatisticsWinsAsClassLabel = new javax.swing.JLabel();
        matchStatisticsWinsAsClassValue = new javax.swing.JLabel();
        matchStatisticsWinsVSClassLabel = new javax.swing.JLabel();
        matchStatisticsWinsVSClassValue = new javax.swing.JLabel();
        matchStatisticsWinPerAsClassLabel = new javax.swing.JLabel();
        matchStatisticsWinPerAsClassValue = new javax.swing.JLabel();
        matchStatisticsWinPerVSClassLabel = new javax.swing.JLabel();
        matchStatisticsWinPerVSClassValue = new javax.swing.JLabel();
        matchStatisticsMatchesVSClass2Label = new javax.swing.JLabel();
        matchStatisticsMatchesVSClass2Value = new javax.swing.JLabel();
        matchStatisticsWinsVSClass2Label = new javax.swing.JLabel();
        matchStatisticsWinsVSClass2Value = new javax.swing.JLabel();
        matchStatisticsWinPerVSClass2Label = new javax.swing.JLabel();
        matchStatisticsWinPerVSClass2Value = new javax.swing.JLabel();
        matchStatisticsTotalRadioButton = new javax.swing.JRadioButton();
        matchStatistics1stRadioButton = new javax.swing.JRadioButton();
        matchStatistics2ndRadioButton = new javax.swing.JRadioButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        matchStatisticsClass2Chooser = new javax.swing.JComboBox();
        jPanel20 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        matchStatisticsTotalMatches = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        matchStatisticsTotalWins = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        matchStatisticsTotalWinPer = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Decks:");

        classDeckStatisticsDecksAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsDecksAsClass.setText("jLabel2");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Play Percentage:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Wins:");

        classDeckStatisticsWinsAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsWinsAsClass.setText("jLabel4");

        classDeckStatisticsPlayPerAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsPlayPerAsClass.setText("jLabel6");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Average Wins:");

        classDeckStatisticsAvgWinsAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsAvgWinsAsClass.setText("jLabel5");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("3 Win Decks:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("4 Win Decks:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("5 Win Decks:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("6 Win Decks:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("7 Win Decks:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("8 Win Decks:");

        classDeckStatisticsEightWinDecksAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsEightWinDecksAsClass.setText("jLabel14");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("9 Win Decks:");

        classDeckStatisticsNineWinDecksAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsNineWinDecksAsClass.setText("jLabel16");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("10 Win Decks:");

        classDeckStatisticsTenWinDecksAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsTenWinDecksAsClass.setText("jLabel17");

        classDeckStatisticsElevenWinDecksAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsElevenWinDecksAsClass.setText("jLabel18");

        classDeckStatisticsTwelveWinDecksAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsTwelveWinDecksAsClass.setText("jLabel19");

        classDeckStatisticsSevenWinDecksAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsSevenWinDecksAsClass.setText("jLabel14");

        classDeckStatisticsSixWinDecksAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsSixWinDecksAsClass.setText("jLabel13");

        classDeckStatisticsFiveWinDecksAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsFiveWinDecksAsClass.setText("jLabel12");

        classDeckStatisticsFourWinDecksAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsFourWinDecksAsClass.setText("jLabel11");

        classDeckStatisticsThreeWinDecksAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsThreeWinDecksAsClass.setText("jLabel10");

        classDeckStatisticsTwoWinDecksAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsTwoWinDecksAsClass.setText("jLabel9");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("2 Win Decks:");

        classDeckStatisticsOneWinDecksAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsOneWinDecksAsClass.setText("jLabel8");

        classDeckStatisticsZeroWinDecksAsClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        classDeckStatisticsZeroWinDecksAsClass.setText("jLabel7");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("1 Win Decks:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("0 Win Decks:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("11 Win Decks:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("12 Win Decks:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(classDeckStatisticsWinsAsClass))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(classDeckStatisticsDecksAsClass)))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(classDeckStatisticsAvgWinsAsClass))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(classDeckStatisticsPlayPerAsClass)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classDeckStatisticsThreeWinDecksAsClass)
                            .addComponent(classDeckStatisticsFourWinDecksAsClass)
                            .addComponent(classDeckStatisticsFiveWinDecksAsClass)
                            .addComponent(classDeckStatisticsSixWinDecksAsClass)
                            .addComponent(classDeckStatisticsSevenWinDecksAsClass)
                            .addComponent(classDeckStatisticsEightWinDecksAsClass)
                            .addComponent(classDeckStatisticsNineWinDecksAsClass)
                            .addComponent(classDeckStatisticsTenWinDecksAsClass)
                            .addComponent(classDeckStatisticsTwoWinDecksAsClass)
                            .addComponent(classDeckStatisticsOneWinDecksAsClass)
                            .addComponent(classDeckStatisticsZeroWinDecksAsClass)
                            .addComponent(classDeckStatisticsElevenWinDecksAsClass)
                            .addComponent(classDeckStatisticsTwelveWinDecksAsClass))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(classDeckStatisticsDecksAsClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(classDeckStatisticsWinsAsClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(classDeckStatisticsPlayPerAsClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(classDeckStatisticsAvgWinsAsClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classDeckStatisticsZeroWinDecksAsClass)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classDeckStatisticsOneWinDecksAsClass)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classDeckStatisticsTwoWinDecksAsClass)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(classDeckStatisticsThreeWinDecksAsClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(classDeckStatisticsFourWinDecksAsClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(classDeckStatisticsFiveWinDecksAsClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(classDeckStatisticsSixWinDecksAsClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(classDeckStatisticsSevenWinDecksAsClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classDeckStatisticsEightWinDecksAsClass)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classDeckStatisticsNineWinDecksAsClass)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(classDeckStatisticsTenWinDecksAsClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classDeckStatisticsElevenWinDecksAsClass)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classDeckStatisticsTwelveWinDecksAsClass)
                    .addComponent(jLabel18)))
        );

        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Class:");

        ClassDeckStatisticsClassChooser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ClassDeckStatisticsClassChooser.setModel(new javax.swing.DefaultComboBoxModel(DeckClass.values()));
        ClassDeckStatisticsClassChooser.setSelectedIndex(0);
        ClassDeckStatisticsClassChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassDeckStatisticsClassChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ClassDeckStatisticsClassChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ClassDeckStatisticsClassChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        classDeckStatisticsPortrait.setIcon(new javax.swing.ImageIcon(getClass().getResource("/portraits/Druid1.png"))); // NOI18N

        deckStatisticsPortraitSelect.add(classDeckStatisticsMainPortraitChooser);
        classDeckStatisticsMainPortraitChooser.setSelected(true);
        classDeckStatisticsMainPortraitChooser.setText("Main Portrait");
        classDeckStatisticsMainPortraitChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classDeckStatisticsMainPortraitChooserActionPerformed(evt);
            }
        });

        deckStatisticsPortraitSelect.add(classDeckStatisticsAltPortraitChooser);
        classDeckStatisticsAltPortraitChooser.setText("Alternate Portrait");
        classDeckStatisticsAltPortraitChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classDeckStatisticsAltPortraitChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(classDeckStatisticsPortrait)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(classDeckStatisticsMainPortraitChooser)
                        .addGap(28, 28, 28)
                        .addComponent(classDeckStatisticsAltPortraitChooser)
                        .addGap(41, 41, 41))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(classDeckStatisticsPortrait)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classDeckStatisticsMainPortraitChooser)
                    .addComponent(classDeckStatisticsAltPortraitChooser))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane6.addTab("Class Specific Deck Statistics", jPanel6);

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        newDeck.setText("Start a New Run");
        newDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newDeckActionPerformed(evt);
            }
        });

        addMatch.setText("Add Match");
        addMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMatchActionPerformed(evt);
            }
        });

        removeMatch.setText("Remove Match");
        removeMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMatchActionPerformed(evt);
            }
        });

        retireCurrentDeck.setText("Retire");
        retireCurrentDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retireCurrentDeckActionPerformed(evt);
            }
        });

        removeCurrentDeck.setText("Remove Current Deck");
        removeCurrentDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCurrentDeckActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel37.setText("Current Score:");

        currentScore.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        currentScore.setText("jLabel38");

        matchInfoPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        currentDeckPlayerClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        currentDeckPlayerClass.setText("Player");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setText("VS");

        currentDeckOpponentClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        currentDeckOpponentClass.setText("Opponent");

        currentDeck1stOr2nd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        currentDeck1stOr2nd.setText("jLabel39");

        currentDeckOutcome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        currentDeckOutcome.setText("jLabel39");

        javax.swing.GroupLayout matchInfoPanelLayout = new javax.swing.GroupLayout(matchInfoPanel);
        matchInfoPanel.setLayout(matchInfoPanelLayout);
        matchInfoPanelLayout.setHorizontalGroup(
            matchInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matchInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(matchInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(matchInfoPanelLayout.createSequentialGroup()
                        .addComponent(currentDeckPlayerClass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentDeckOpponentClass))
                    .addComponent(currentDeck1stOr2nd)
                    .addComponent(currentDeckOutcome))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        matchInfoPanelLayout.setVerticalGroup(
            matchInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matchInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(matchInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentDeckPlayerClass)
                    .addComponent(jLabel38)
                    .addComponent(currentDeckOpponentClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentDeck1stOr2nd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentDeckOutcome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setText("Match Select:");

        matchSelect.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        matchSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchSelectActionPerformed(evt);
            }
        });

        currentDeckPortrait.setIcon(new javax.swing.ImageIcon("C:\\Users\\Eero\\Hearthstone-Arena-Tracker\\ArenaStatistics\\src\\main\\resources\\portraits\\Druid1.png")); // NOI18N

        currentDeckPortraitSelect.add(currentDeckMainPortraitChooser);
        currentDeckMainPortraitChooser.setSelected(true);
        currentDeckMainPortraitChooser.setText("Main Portrait");
        currentDeckMainPortraitChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentDeckMainPortraitChooserActionPerformed(evt);
            }
        });

        currentDeckPortraitSelect.add(currentDeckAltPortraitChooser);
        currentDeckAltPortraitChooser.setText("Alternate Portrait");
        currentDeckAltPortraitChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentDeckAltPortraitChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(newDeck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(currentDeckMainPortraitChooser)
                        .addGap(18, 18, 18)
                        .addComponent(currentDeckAltPortraitChooser)
                        .addGap(49, 49, 49))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(removeCurrentDeck)
                                    .addComponent(addMatch)
                                    .addComponent(removeMatch)
                                    .addComponent(retireCurrentDeck))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(matchInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(122, 122, 122)))
                        .addComponent(currentDeckPortrait)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentScore))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(matchSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentScore)
                    .addComponent(jLabel37))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 49, Short.MAX_VALUE)
                        .addComponent(currentDeckPortrait, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(matchSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91)
                        .addComponent(matchInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addMatch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeMatch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(retireCurrentDeck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeCurrentDeck)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentDeckMainPortraitChooser)
                    .addComponent(currentDeckAltPortraitChooser)
                    .addComponent(newDeck))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Current Deck", jPanel4);

        jPanel17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        generalDeckStatisticsWins.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalDeckStatisticsWins.setText("Wins");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Decks:");

        generalDeckStatisticsDecks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalDeckStatisticsDecks.setText("jLabel24");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Average Dust:");

        generalDeckStatisticsAvgDust.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalDeckStatisticsAvgDust.setText("jLabel25");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Wins:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Dust:");

        generalDeckStatisticsDust.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalDeckStatisticsDust.setText("jLabel28");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Gold:");

        generalDeckStatisticsGold.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalDeckStatisticsGold.setText("jLabel28");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Average Gold:");

        generalDeckStatisticsAvgGold.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalDeckStatisticsAvgGold.setText("jLabel29");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setText("Extra Packs:");

        generalDeckStatisticsExtraPacks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalDeckStatisticsExtraPacks.setText("jLabel20");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Average Extra Packs:");

        generalDeckStatisticsAvgExtraPacks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalDeckStatisticsAvgExtraPacks.setText("jLabel21");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Regular Cards:");

        generalDeckStatisticsRegularCards.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalDeckStatisticsRegularCards.setText("jLabel30");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setText("Average Regular Cards:");

        generalDeckStatisticsAvgRegularCards.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalDeckStatisticsAvgRegularCards.setText("jLabel31");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("Golden Cards:");

        generalDeckStatisticsGoldenCards.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalDeckStatisticsGoldenCards.setText("jLabel32");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("Average Golden Cards:");

        generalDeckStatisticsAvgGoldenCards.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalDeckStatisticsAvgGoldenCards.setText("jLabel33");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setText("%out of All Decks:");

        generalDeckStatisticsPerOutOfAllDecks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalDeckStatisticsPerOutOfAllDecks.setText("jLabel37");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel40.setText("Average Wins:");

        generalDeckStatisticsAvgWins.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalDeckStatisticsAvgWins.setText("jLabel41");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalDeckStatisticsWins))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalDeckStatisticsAvgGoldenCards))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalDeckStatisticsGoldenCards))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalDeckStatisticsAvgRegularCards))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalDeckStatisticsRegularCards))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalDeckStatisticsAvgExtraPacks))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalDeckStatisticsExtraPacks))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalDeckStatisticsAvgGold))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalDeckStatisticsGold))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalDeckStatisticsAvgDust))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalDeckStatisticsDust))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalDeckStatisticsPerOutOfAllDecks))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalDeckStatisticsAvgWins))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalDeckStatisticsDecks)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(generalDeckStatisticsWins))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(generalDeckStatisticsDecks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(generalDeckStatisticsAvgWins))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(generalDeckStatisticsPerOutOfAllDecks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(generalDeckStatisticsDust))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(generalDeckStatisticsAvgDust))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(generalDeckStatisticsGold))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(generalDeckStatisticsAvgGold))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(generalDeckStatisticsExtraPacks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(generalDeckStatisticsAvgExtraPacks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(generalDeckStatisticsRegularCards))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(generalDeckStatisticsAvgRegularCards))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(generalDeckStatisticsGoldenCards))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(generalDeckStatisticsAvgGoldenCards))
                .addContainerGap())
        );

        jPanel19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        generalDeckStatisticsWinSlider.setMajorTickSpacing(2);
        generalDeckStatisticsWinSlider.setMaximum(13);
        generalDeckStatisticsWinSlider.setMinorTickSpacing(1);
        generalDeckStatisticsWinSlider.setPaintLabels(true);
        generalDeckStatisticsWinSlider.setPaintTicks(true);
        generalDeckStatisticsWinSlider.setSnapToTicks(true);
        generalDeckStatisticsWinSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                generalDeckStatisticsWinSliderStateChanged(evt);
            }
        });

        generalDeckStatisticsSliderIndicator.setText("Statistics by Wins");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generalDeckStatisticsWinSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(generalDeckStatisticsSliderIndicator)
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generalDeckStatisticsSliderIndicator)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generalDeckStatisticsWinSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane6.addTab("General Deck Statistics", jPanel1);

        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Class 1:");

        matchStatisticsClass1Chooser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsClass1Chooser.setModel(new javax.swing.DefaultComboBoxModel(DeckClass.values()));
        matchStatisticsClass1Chooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchStatisticsClass1ChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matchStatisticsClass1Chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(matchStatisticsClass1Chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        matchStatisticsPortrait.setIcon(new javax.swing.ImageIcon(getClass().getResource("/portraits/Druid1.png"))); // NOI18N

        matchStatisticsPortraitSelect.add(matchStatisticsMainPortraitChooser);
        matchStatisticsMainPortraitChooser.setSelected(true);
        matchStatisticsMainPortraitChooser.setText("Main Portrait");
        matchStatisticsMainPortraitChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchStatisticsMainPortraitChooserActionPerformed(evt);
            }
        });

        matchStatisticsPortraitSelect.add(matchStatisticsAltPortraitChooser);
        matchStatisticsAltPortraitChooser.setText("Alternate Portrait");
        matchStatisticsAltPortraitChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchStatisticsAltPortraitChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(matchStatisticsPortrait, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(matchStatisticsMainPortraitChooser)
                        .addGap(28, 28, 28)
                        .addComponent(matchStatisticsAltPortraitChooser)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(matchStatisticsPortrait, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matchStatisticsMainPortraitChooser)
                    .addComponent(matchStatisticsAltPortraitChooser))
                .addContainerGap())
        );

        jPanel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        matchStatisticsMatchesAsClassLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsMatchesAsClassLabel.setText("Matches as Class:");

        matchStatisticsMatchesAsClassValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsMatchesAsClassValue.setText("jLabel21");

        matchStatisticsMatchesVSClassLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsMatchesVSClassLabel.setText("Matches vs Class:");

        matchStatisticsMatchesVSClassValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsMatchesVSClassValue.setText("jLabel22");

        matchStatisticsWinsAsClassLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsWinsAsClassLabel.setText("Wins as Class:");

        matchStatisticsWinsAsClassValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsWinsAsClassValue.setText("jLabel23");

        matchStatisticsWinsVSClassLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsWinsVSClassLabel.setText("Wins vs Class:");

        matchStatisticsWinsVSClassValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsWinsVSClassValue.setText("jLabel24");

        matchStatisticsWinPerAsClassLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsWinPerAsClassLabel.setText("Win% as Class:");

        matchStatisticsWinPerAsClassValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsWinPerAsClassValue.setText("jLabel25");

        matchStatisticsWinPerVSClassLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsWinPerVSClassLabel.setText("Win% vs Class:");

        matchStatisticsWinPerVSClassValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsWinPerVSClassValue.setText("jLabel26");

        matchStatisticsMatchesVSClass2Label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsMatchesVSClass2Label.setText("Matches vs Paladin:");

        matchStatisticsMatchesVSClass2Value.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsMatchesVSClass2Value.setText("jLabel26");

        matchStatisticsWinsVSClass2Label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsWinsVSClass2Label.setText("Wins vs Paladin:");

        matchStatisticsWinsVSClass2Value.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsWinsVSClass2Value.setText("jLabel26");

        matchStatisticsWinPerVSClass2Label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsWinPerVSClass2Label.setText("Win% vs Paladin:");

        matchStatisticsWinPerVSClass2Value.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsWinPerVSClass2Value.setText("jLabel26");

        matchStatisticsStatsSelect.add(matchStatisticsTotalRadioButton);
        matchStatisticsTotalRadioButton.setSelected(true);
        matchStatisticsTotalRadioButton.setText("Total");
        matchStatisticsTotalRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchStatisticsTotalRadioButtonActionPerformed(evt);
            }
        });

        matchStatisticsStatsSelect.add(matchStatistics1stRadioButton);
        matchStatistics1stRadioButton.setText("Going 1st");
        matchStatistics1stRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchStatistics1stRadioButtonActionPerformed(evt);
            }
        });

        matchStatisticsStatsSelect.add(matchStatistics2ndRadioButton);
        matchStatistics2ndRadioButton.setText("Going 2nd");
        matchStatistics2ndRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchStatistics2ndRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(matchStatisticsTotalRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchStatistics1stRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchStatistics2ndRadioButton))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(matchStatisticsMatchesAsClassLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchStatisticsMatchesAsClassValue))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(matchStatisticsMatchesVSClassLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchStatisticsMatchesVSClassValue))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(matchStatisticsWinsAsClassLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchStatisticsWinsAsClassValue))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(matchStatisticsWinsVSClassLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchStatisticsWinsVSClassValue))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(matchStatisticsWinPerAsClassLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchStatisticsWinPerAsClassValue))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(matchStatisticsWinPerVSClassLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchStatisticsWinPerVSClassValue))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(matchStatisticsMatchesVSClass2Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchStatisticsMatchesVSClass2Value))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(matchStatisticsWinsVSClass2Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchStatisticsWinsVSClass2Value))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(matchStatisticsWinPerVSClass2Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchStatisticsWinPerVSClass2Value)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matchStatisticsMatchesAsClassLabel)
                    .addComponent(matchStatisticsMatchesAsClassValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matchStatisticsMatchesVSClassLabel)
                    .addComponent(matchStatisticsMatchesVSClassValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matchStatisticsWinsAsClassLabel)
                    .addComponent(matchStatisticsWinsAsClassValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matchStatisticsWinsVSClassLabel)
                    .addComponent(matchStatisticsWinsVSClassValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matchStatisticsWinPerAsClassLabel)
                    .addComponent(matchStatisticsWinPerAsClassValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matchStatisticsWinPerVSClassLabel)
                    .addComponent(matchStatisticsWinPerVSClassValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matchStatisticsMatchesVSClass2Label)
                    .addComponent(matchStatisticsMatchesVSClass2Value))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matchStatisticsWinsVSClass2Label)
                    .addComponent(matchStatisticsWinsVSClass2Value))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matchStatisticsWinPerVSClass2Label)
                    .addComponent(matchStatisticsWinPerVSClass2Value))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matchStatisticsTotalRadioButton)
                    .addComponent(matchStatistics1stRadioButton)
                    .addComponent(matchStatistics2ndRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Class 2:");

        matchStatisticsClass2Chooser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsClass2Chooser.setModel(new javax.swing.DefaultComboBoxModel(DeckClass.values()));
        matchStatisticsClass2Chooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchStatisticsClass2ChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matchStatisticsClass2Chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(matchStatisticsClass2Chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setText("Total Matches:");

        matchStatisticsTotalMatches.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsTotalMatches.setText("jLabel34");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel34.setText("Total Wins:");

        matchStatisticsTotalWins.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsTotalWins.setText("jLabel35");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setText("Total Win%:");

        matchStatisticsTotalWinPer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        matchStatisticsTotalWinPer.setText("jLabel36");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchStatisticsTotalMatches))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchStatisticsTotalWins))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matchStatisticsTotalWinPer)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(matchStatisticsTotalMatches))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(matchStatisticsTotalWins))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(matchStatisticsTotalWinPer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Match Statistics", jPanel8);

        jButton1.setText("RESET");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jButton1)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jButton1)
                .addContainerGap(319, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Options", jPanel7);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void classDeckStatisticsAltPortraitChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classDeckStatisticsAltPortraitChooserActionPerformed
        updateDeckStatsPortrait();
    }//GEN-LAST:event_classDeckStatisticsAltPortraitChooserActionPerformed

    private void classDeckStatisticsMainPortraitChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classDeckStatisticsMainPortraitChooserActionPerformed
        updateDeckStatsPortrait();
    }//GEN-LAST:event_classDeckStatisticsMainPortraitChooserActionPerformed

    private void ClassDeckStatisticsClassChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassDeckStatisticsClassChooserActionPerformed
        classSpecificDeckStatistics.updateVisuals();
    }//GEN-LAST:event_ClassDeckStatisticsClassChooserActionPerformed

    private void generalDeckStatisticsWinSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_generalDeckStatisticsWinSliderStateChanged
        generalDeckStatistics.updateStats();
    }//GEN-LAST:event_generalDeckStatisticsWinSliderStateChanged

    private void matchStatisticsClass2ChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchStatisticsClass2ChooserActionPerformed
        matchStatistics.updateStats();
    }//GEN-LAST:event_matchStatisticsClass2ChooserActionPerformed

    private void matchStatistics2ndRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchStatistics2ndRadioButtonActionPerformed
        matchStatistics.updateStats();
    }//GEN-LAST:event_matchStatistics2ndRadioButtonActionPerformed

    private void matchStatistics1stRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchStatistics1stRadioButtonActionPerformed
        matchStatistics.updateStats();
    }//GEN-LAST:event_matchStatistics1stRadioButtonActionPerformed

    private void matchStatisticsTotalRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchStatisticsTotalRadioButtonActionPerformed
        matchStatistics.updateStats();
    }//GEN-LAST:event_matchStatisticsTotalRadioButtonActionPerformed

    private void matchStatisticsAltPortraitChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchStatisticsAltPortraitChooserActionPerformed
        updateMatchStatsPortrait();
    }//GEN-LAST:event_matchStatisticsAltPortraitChooserActionPerformed

    private void matchStatisticsMainPortraitChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchStatisticsMainPortraitChooserActionPerformed
        updateMatchStatsPortrait();
    }//GEN-LAST:event_matchStatisticsMainPortraitChooserActionPerformed

    private void matchStatisticsClass1ChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchStatisticsClass1ChooserActionPerformed
        matchStatistics.updateVisuals();
    }//GEN-LAST:event_matchStatisticsClass1ChooserActionPerformed

    private void newDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDeckActionPerformed
        DeckCreationGUI deckCreationGUI = new DeckCreationGUI(this, currentDeckNumber);
        SwingUtilities.invokeLater(deckCreationGUI);
        deckCreationGUI.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_newDeckActionPerformed

    private void addMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMatchActionPerformed
        MatchCreationGUI matchCreationGUI = new MatchCreationGUI(this, currentDeckNumber, nextMatchNumber);
        SwingUtilities.invokeLater(matchCreationGUI);
        matchCreationGUI.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_addMatchActionPerformed

    private void removeMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMatchActionPerformed
        this.setEnabled(false);
        int answer = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to remove this match: "
                + currentDeckEditor.getMatch(matchSelect.getSelectedIndex()));
        if (answer == JOptionPane.YES_OPTION) {
            currentDeckEditor.removeMatch(matchSelect.getSelectedIndex());
        }
        this.setEnabled(true);
    }//GEN-LAST:event_removeMatchActionPerformed

    private void retireCurrentDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retireCurrentDeckActionPerformed
        this.setEnabled(false);
        int answer = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to retire this deck? "
                + "This option WILL affect statistics.");
        if (answer == JOptionPane.YES_OPTION) {
            currentDeckEditor.finishDeck();
        }
        this.setEnabled(true);
    }//GEN-LAST:event_retireCurrentDeckActionPerformed

    private void removeCurrentDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCurrentDeckActionPerformed
        this.setEnabled(false);
        int answer = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to remove this deck? "
                + "This option WILL NOT affect statistics.");
        if (answer == JOptionPane.YES_OPTION) {
            currentDeck = null;
            currentDeckEditor.setCurrentDeck(currentDeck);
            dataWriter.clearDeckAndMatchesXml();
        }
        this.setEnabled(true);
    }//GEN-LAST:event_removeCurrentDeckActionPerformed

    private void matchSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchSelectActionPerformed
        currentDeckEditor.setMatchInfo();
    }//GEN-LAST:event_matchSelectActionPerformed

    private void currentDeckMainPortraitChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentDeckMainPortraitChooserActionPerformed
        currentDeckEditor.updateVisuals();
    }//GEN-LAST:event_currentDeckMainPortraitChooserActionPerformed

    private void currentDeckAltPortraitChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentDeckAltPortraitChooserActionPerformed
        currentDeckEditor.updateVisuals();
    }//GEN-LAST:event_currentDeckAltPortraitChooserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setEnabled(false);
        int answer = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to reset data? "
                + "This will nullify your statistics and completely remove your current deck");
        if (answer == JOptionPane.YES_OPTION) {
            dataWriter.resetData();
            currentDeck = null;
            currentDeckEditor.setCurrentDeck(null);
        }
        this.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ClassDeckStatisticsClassChooser;
    private javax.swing.JButton addMatch;
    private javax.swing.JRadioButton classDeckStatisticsAltPortraitChooser;
    private javax.swing.JLabel classDeckStatisticsAvgWinsAsClass;
    private javax.swing.JLabel classDeckStatisticsDecksAsClass;
    private javax.swing.JLabel classDeckStatisticsEightWinDecksAsClass;
    private javax.swing.JLabel classDeckStatisticsElevenWinDecksAsClass;
    private javax.swing.JLabel classDeckStatisticsFiveWinDecksAsClass;
    private javax.swing.JLabel classDeckStatisticsFourWinDecksAsClass;
    private javax.swing.JRadioButton classDeckStatisticsMainPortraitChooser;
    private javax.swing.JLabel classDeckStatisticsNineWinDecksAsClass;
    private javax.swing.JLabel classDeckStatisticsOneWinDecksAsClass;
    private javax.swing.JLabel classDeckStatisticsPlayPerAsClass;
    private javax.swing.JLabel classDeckStatisticsPortrait;
    private javax.swing.JLabel classDeckStatisticsSevenWinDecksAsClass;
    private javax.swing.JLabel classDeckStatisticsSixWinDecksAsClass;
    private javax.swing.JLabel classDeckStatisticsTenWinDecksAsClass;
    private javax.swing.JLabel classDeckStatisticsThreeWinDecksAsClass;
    private javax.swing.JLabel classDeckStatisticsTwelveWinDecksAsClass;
    private javax.swing.JLabel classDeckStatisticsTwoWinDecksAsClass;
    private javax.swing.JLabel classDeckStatisticsWinsAsClass;
    private javax.swing.JLabel classDeckStatisticsZeroWinDecksAsClass;
    private javax.swing.JLabel currentDeck1stOr2nd;
    private javax.swing.JRadioButton currentDeckAltPortraitChooser;
    private javax.swing.JRadioButton currentDeckMainPortraitChooser;
    private javax.swing.JLabel currentDeckOpponentClass;
    private javax.swing.JLabel currentDeckOutcome;
    private javax.swing.JLabel currentDeckPlayerClass;
    private javax.swing.JLabel currentDeckPortrait;
    private javax.swing.ButtonGroup currentDeckPortraitSelect;
    private javax.swing.JLabel currentScore;
    private javax.swing.ButtonGroup deckStatisticsPortraitSelect;
    private javax.swing.JLabel generalDeckStatisticsAvgDust;
    private javax.swing.JLabel generalDeckStatisticsAvgExtraPacks;
    private javax.swing.JLabel generalDeckStatisticsAvgGold;
    private javax.swing.JLabel generalDeckStatisticsAvgGoldenCards;
    private javax.swing.JLabel generalDeckStatisticsAvgRegularCards;
    private javax.swing.JLabel generalDeckStatisticsAvgWins;
    private javax.swing.JLabel generalDeckStatisticsDecks;
    private javax.swing.JLabel generalDeckStatisticsDust;
    private javax.swing.JLabel generalDeckStatisticsExtraPacks;
    private javax.swing.JLabel generalDeckStatisticsGold;
    private javax.swing.JLabel generalDeckStatisticsGoldenCards;
    private javax.swing.JLabel generalDeckStatisticsPerOutOfAllDecks;
    private javax.swing.JLabel generalDeckStatisticsRegularCards;
    private javax.swing.JLabel generalDeckStatisticsSliderIndicator;
    private javax.swing.JSlider generalDeckStatisticsWinSlider;
    private javax.swing.JLabel generalDeckStatisticsWins;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JPanel matchInfoPanel;
    private javax.swing.JComboBox matchSelect;
    private javax.swing.JRadioButton matchStatistics1stRadioButton;
    private javax.swing.JRadioButton matchStatistics2ndRadioButton;
    private javax.swing.JRadioButton matchStatisticsAltPortraitChooser;
    private javax.swing.JComboBox matchStatisticsClass1Chooser;
    private javax.swing.JComboBox matchStatisticsClass2Chooser;
    private javax.swing.JRadioButton matchStatisticsMainPortraitChooser;
    private javax.swing.JLabel matchStatisticsMatchesAsClassLabel;
    private javax.swing.JLabel matchStatisticsMatchesAsClassValue;
    private javax.swing.JLabel matchStatisticsMatchesVSClass2Label;
    private javax.swing.JLabel matchStatisticsMatchesVSClass2Value;
    private javax.swing.JLabel matchStatisticsMatchesVSClassLabel;
    private javax.swing.JLabel matchStatisticsMatchesVSClassValue;
    private javax.swing.JLabel matchStatisticsPortrait;
    private javax.swing.ButtonGroup matchStatisticsPortraitSelect;
    private javax.swing.ButtonGroup matchStatisticsStatsSelect;
    private javax.swing.JLabel matchStatisticsTotalMatches;
    private javax.swing.JRadioButton matchStatisticsTotalRadioButton;
    private javax.swing.JLabel matchStatisticsTotalWinPer;
    private javax.swing.JLabel matchStatisticsTotalWins;
    private javax.swing.JLabel matchStatisticsWinPerAsClassLabel;
    private javax.swing.JLabel matchStatisticsWinPerAsClassValue;
    private javax.swing.JLabel matchStatisticsWinPerVSClass2Label;
    private javax.swing.JLabel matchStatisticsWinPerVSClass2Value;
    private javax.swing.JLabel matchStatisticsWinPerVSClassLabel;
    private javax.swing.JLabel matchStatisticsWinPerVSClassValue;
    private javax.swing.JLabel matchStatisticsWinsAsClassLabel;
    private javax.swing.JLabel matchStatisticsWinsAsClassValue;
    private javax.swing.JLabel matchStatisticsWinsVSClass2Label;
    private javax.swing.JLabel matchStatisticsWinsVSClass2Value;
    private javax.swing.JLabel matchStatisticsWinsVSClassLabel;
    private javax.swing.JLabel matchStatisticsWinsVSClassValue;
    private javax.swing.JButton newDeck;
    private javax.swing.JButton removeCurrentDeck;
    private javax.swing.JButton removeMatch;
    private javax.swing.JButton retireCurrentDeck;
    // End of variables declaration//GEN-END:variables
    private Deck currentDeck;
    private MatchStatisticsKeeper matchStatisticsKeeper;
    private MatchupStatisticsKeeper matchupStatisticsKeeper;
    private DeckScoreStatisticsKeeper deckScoreStatisticsKeeper;
    private RewardStatisticsKeeper rewardStatisticsKeeper;
    private ClassSpecificDeckStatisticsDisplayLogic classSpecificDeckStatistics;
    private MatchStatisticsDisplayLogic matchStatistics;
    private StatisticsDisplay generalDeckStatistics;
    private CurrentDeckEditorLogic currentDeckEditor;
    private DataWriter dataWriter;
    private List<JLabel> winAmountLabels;
    private int currentDeckNumber;
    private int nextMatchNumber;
}
