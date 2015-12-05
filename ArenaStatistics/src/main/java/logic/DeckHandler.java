package logic;

import domain.*;
import java.util.List;

public class DeckHandler {

    private Deck deck;

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
            match.setMatchNumber(match.getMatchNumber() + 1);
        }
    }

    private void decreaseWinOrLossCount(Match match) {
        if (match.getOutcome() == Outcome.WIN) {
            deck.setWins(deck.getWins() - 1);
        } else if (match.getOutcome() != Outcome.TIE) {
            deck.setLosses(deck.getLosses() - 1);
        }
    }

    public void addCard(Card card) {
        deck.getRewardCards().add(card);
    }

    public Card removeCard(int i) {
        try {
            return deck.getRewardCards().remove(i);
        } catch (Exception e) {
            return null;
        }
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setGold(int x) {
        deck.setGold(x);
    }

    public void setDust(int x) {
        deck.setDust(x);
    }

    public void setExtraPacks(int x) {
        deck.setExtraPacks(x);
    }

    public Deck getDeck() {
        return deck;
    }

    public DeckClass getDeckClass() {
        return deck.getDeckClass();
    }

    public Match getLatestMatch() {
        try {
            return deck.getMatches().get(deck.getMatches().size() - 1);
        } catch (Exception e) {
            return null;
        }
    }

    public Match removeLatestMatch() {
        try {
            return removeMatch(getMatches().size() - 1);
        } catch (Exception e) {
            return null;
        }
    }

    public int getDeckNumber() {
        return deck.getDeckNumber();
    }

    public List<Match> getMatches() {
        return deck.getMatches();
    }
}
