package logic;

import domain.*;
import java.util.List;

/**
 * Class which manipulates the values of a Deck Object.
 */
public class DeckHandler {

    private Deck deck;

    /**
     * Adds a match to the Deck.
     * 
     * @param match Match that is added to the deck.
     * @return true if the deck is finished, false if not finished.
     */
    public boolean addMatch(Match match) {
        match.setDeck(deck);
        match.setPlayerClass(deck.getDeckClass());
        deck.getMatches().add(match);
        increaseWinOrLossCount(match);
        return deck.isFinished();
    }

    private void increaseWinOrLossCount(Match match) {
        if (match.getOutcome() == Outcome.WIN) {
            deck.setWins(deck.getWins() + 1);
        } else if (match.getOutcome() != Outcome.TIE) {
            deck.setLosses(deck.getLosses() + 1);
        }
    }

    /**
     * Removes a specific match from the Deck's Match List.
     * 
     * @param i Index of the match.
     * @return The removed Match if successful, null otherwise.
     */
    public Match removeMatch(int i) {
        try {
            correctMatchNumbers(i);
            Match match = deck.getMatches().remove(i);
            decreaseWinOrLossCount(match);
            return match;
        } catch (Exception e) {
            return null;
        }
    }
    
    private void correctMatchNumbers(int j) { // j == index of the match which is going to be removed
        for (int i = j + 1; i < deck.getMatches().size(); i++) {
            Match match = deck.getMatches().get(i);
            match.setMatchNumber(match.getMatchNumber() - 1);
        }
    }

    private void decreaseWinOrLossCount(Match match) {
        if (match.getOutcome() == Outcome.WIN) {
            deck.setWins(deck.getWins() - 1);
        } else if (match.getOutcome() != Outcome.TIE) {
            deck.setLosses(deck.getLosses() - 1);
        }
    }

    /**
     * Adds a reward card to the Deck.
     * 
     * @param card Card which is added to the deck.
     */
    public void addCard(Card card) {
        deck.getRewardCards().add(card);
    }

    /**
     * Removes a specific reward card from the Deck.
     * 
     * @param i Index of the Card.
     * @return The removed Card if successful, null otherwise.
     */
    public Card removeCard(int i) {
        try {
            return deck.getRewardCards().remove(i);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Sets the Deck which values are manipulated.
     * 
     * @param deck Deck
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * Sets the amount of gold received at the end of the run.
     * 
     * @param x Amount of gold.
     */
    public void setGold(int x) {
        deck.setGold(x);
    }

    /**
     * Sets the amount of dust received at the end of the run.
     * 
     * @param x Amount of dust.
     */
    public void setDust(int x) {
        deck.setDust(x);
    }

    /**
     *
     * @param x
     */
    public void setExtraPacks(int x) {
        deck.setExtraPacks(x);
    }

    /**
     * Returns the deck currently in use by the DeckHandler.
     * 
     * @return Deck currently in use by DeckHandler.
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Returns the class of the Deck.
     * 
     * @return DeckClass of the Deck.
     */
    public DeckClass getDeckClass() {
        return deck.getDeckClass();
    }

    /**
     * Returns the latest match of the Deck.
     * 
     * @return Latest match of the Deck, null if deck has no matches.
     */
    public Match getLatestMatch() {
        try {
            return deck.getMatches().get(deck.getMatches().size() - 1);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Removes the latest match of the Deck.
     * 
     * @return The removed Match if successful, null otherwise.
     */
    public Match removeLatestMatch() {
        try {
            return removeMatch(getMatches().size() - 1);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Returns the identifying number of the Deck.
     * 
     * @return Identifying number of the Deck.
     */
    public int getDeckNumber() {
        return deck.getDeckNumber();
    }

    /**
     * Returns the Deck's List of Matches.
     * 
     * @return Deck's list of Matches.
     */
    public List<Match> getMatches() {
        return deck.getMatches();
    }
}
