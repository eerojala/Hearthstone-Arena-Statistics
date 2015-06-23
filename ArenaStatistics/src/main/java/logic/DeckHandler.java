package logic;

import domain.*;
import java.util.List;

public class DeckHandler {

    private ArenaDeck deck;

    public DeckHandler() {

    }

    public boolean addMatch(Match match) {
        deck.getMatches().add(match);
        increaseWinOrLossCount(match);
        return isFinished();
    }

    private void increaseWinOrLossCount(Match match) {
        if (match.getOutcome() == Outcome.WIN) {
            deck.setWins(deck.getWins() + 1);
        } else {
            deck.setLosses(deck.getLosses() + 1);
        }
    }

    private boolean isFinished() {
        return deck.getWins() >= 12 || deck.getLosses() >= 3;
    }

    public Match removeMatch(int i) {
        try {
            Match match = deck.getMatches().remove(i);
            decreaseWinOrLossCount(match);
            return match;
        } catch (Exception e) {
            return null;
        }
    }

    private void decreaseWinOrLossCount(Match match) {
        if (match.getOutcome() == Outcome.WIN) {
            deck.setWins(deck.getWins() - 1);
        } else {
            deck.setLosses(deck.getLosses() - 1);
        }
    }

    public void addCard(RewardCard card) {
        deck.getRewardCards().add(card);
    }

    public RewardCard removeCard(int i) {
        try {
            return deck.getRewardCards().remove(i);
        } catch (Exception e) {
            return null;
        }
    }

    public void setDeck(ArenaDeck deck) {
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

    public ArenaDeck getDeck() {
        return deck;
    }

    public DeckClass getDeckClass() {
        return deck.getPlayerClass();
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
