package domain;

import java.util.ArrayList;
import java.util.List;

public class Deck implements Comparable<Deck>{

    private final DeckClass playerClass;
    private List<Match> matches;
    private List<Card> cards;
    private final int deckNumber;
    private int wins;
    private int losses;
    private int gold;
    private int dust;
    private int extraPacks;

    public Deck(DeckClass playerClass, int deckNumber) {
        this.playerClass = playerClass;
        this.deckNumber = deckNumber;
        matches = new ArrayList();
        cards = new ArrayList();
        wins = 0;
        losses = 0;
        gold = 0;
        dust = 0;
        extraPacks = 0;
    }

    public int getDeckNumber() {
        return deckNumber;
    }

    public int getLosses() {
        return losses;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public DeckClass getPlayerClass() {
        return playerClass;
    }

    public int getWins() {
        return wins;
    }

    public List<Card> getRewardCards() {
        return cards;
    }

    public int getDust() {
        return dust;
    }

    public int getExtraPacks() {
        return extraPacks;
    }

    public int getGold() {
        return gold;
    }

    public void setDust(int dust) {
        this.dust = dust;
    }

    public void setExtraPacks(int extraPacks) {
        this.extraPacks = extraPacks;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        
        Deck deck = (Deck) obj;
        
        return this.deckNumber == deck.getDeckNumber();
    }

    @Override
    public int compareTo(Deck o) {
        return this.deckNumber - o.getDeckNumber();
    }
    
    

}
