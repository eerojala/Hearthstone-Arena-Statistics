package domain;

import java.util.ArrayList;
import java.util.List;

public class ArenaDeck {

    private final DeckClass playerClass;
    private List<Match> matches;
    private List<RewardCard> cards;
    private final int deckNumber;
    private int wins;
    private int losses;
    private int gold;
    private int dust;
    private int extra_packs;

    public ArenaDeck(DeckClass playerClass, int deckNumber) {
        this.playerClass = playerClass;
        this.deckNumber = deckNumber;
        matches = new ArrayList();
        cards = new ArrayList();
        wins = 0;
        losses = 0;
        gold = 0;
        dust = 0;
        extra_packs = 0;
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

    public List<RewardCard> getRewardCards() {
        return cards;
    }

    public int getDust() {
        return dust;
    }

    public int getExtraPacks() {
        return extra_packs;
    }

    public int getGold() {
        return gold;
    }

    public void setDust(int dust) {
        this.dust = dust;
    }

    public void setExtraPacks(int extra_packs) {
        this.extra_packs = extra_packs;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setCards(List<RewardCard> cards) {
        this.cards = cards;
    }

    public void setExtra_packs(int extra_packs) {
        this.extra_packs = extra_packs;
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
        
        ArenaDeck deck = (ArenaDeck) obj;
        
        return this.deckNumber == deck.getDeckNumber();
    }
    
    

}
