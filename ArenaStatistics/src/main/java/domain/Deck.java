package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the deck that is used by the player in the arena run.
 */
public class Deck implements Comparable<Deck> {

    private final DeckClass deckClass;
    private final int deckNumber;
    private List<Match> matches;
    private List<Card> rewardCards;
    private int wins;
    private int losses;
    private int gold;
    private int dust;
    private int extraPacks;

    /**
     * Creates a new Deck object.
     *
     * @param playerClass The Class which the player chose for the deck.
     * @param deckNumber Number that identifies the deck.
     */
    public Deck(DeckClass playerClass, int deckNumber) {
        this.deckClass = playerClass;
        this.deckNumber = deckNumber;
        matches = new ArrayList();
        rewardCards = new ArrayList();
        wins = 0;
        losses = 0;
        gold = 0;
        dust = 0;
        extraPacks = 0;
    }

    /**
     * Returns the deck's number.
     *
     * @return Deck number as an int.
     */
    public int getDeckNumber() {
        return deckNumber;
    }

    /**
     * Returns the current loss amount of the deck.
     *
     * @return Number of losses as an int.
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Returns a list of the matches done with the deck.
     *
     * @return List of Matches.
     */
    public List<Match> getMatches() {
        return matches;
    }

    /**
     * Returns the class which the player is using for the deck.
     *
     * @return DeckClass of the deck's class.
     */
    public DeckClass getDeckClass() {
        return deckClass;
    }

    /**
     * Returns the current win amount of the deck.
     *
     * @return Number of wins as an int.
     */
    public int getWins() {
        return wins;
    }

    /**
     * Returns a list of the cards which the player received at the end of the
     * arena run.
     *
     * @return List of the Cards gotten at the end of the arena run.
     */
    public List<Card> getRewardCards() {
        return rewardCards;
    }

    /**
     * Returns the amount of dust which the player received at the end of the
     * arena run.
     *
     * @return Amount of dust received at the end of the arena run as an int.
     */
    public int getDust() {
        return dust;
    }

    /**
     * Returns the amount of extra card packs (besides the default card pack
     * received at the end of every arena run) which the player received at the
     * end of the arena run.
     *
     * @return Amount of extra packs received at the end of the arena run as an
     * int.
     */
    public int getExtraPacks() {
        return extraPacks;
    }

    /**
     * Returns the amount of gold which the player received at the end of the
     * arena run.
     *
     * @return Amount of gold received at the end of the run as an int.
     */
    public int getGold() {
        return gold;
    }

    /**
     * Set the amount of dust received at the end of the arena run.
     *
     * @param dust Amount of dust received at the end of the run.
     */
    public void setDust(int dust) {
        this.dust = dust;
    }

    /**
     * Set the amount of extra card packs (besides the default card pack
     * received at the end of every arena run) received at the end of the arena
     * run.
     *
     * @param extraPacks Amount of extra card packs received at the end of the
     * run.
     */
    public void setExtraPacks(int extraPacks) {
        this.extraPacks = extraPacks;
    }

    /**
     * Set the amount of gold received at the end of the arena run
     *
     * @param gold Amount of gold received at the end of the run.
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * Set the cards received at the end of the arena run.
     *
     * @param rewardCards List of the cards which the player received at the end
     * of the run
     */
    public void setRewardCards(List<Card> rewardCards) {
        this.rewardCards = rewardCards;
    }

    /**
     * Set the amount of losses which the deck currently has.
     *
     * @param losses Amount of losses which the deck currently has.
     */
    public void setLosses(int losses) {
        this.losses = losses;
    }

    /**
     * Set the matches where the player has participated in the current arena
     * run.
     *
     * @param matches List of matches where the player has participated in the
     * current arena run.
     */
    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    /**
     * Set the amount of wins which the deck currently has.
     *
     * @param wins Amount of wins which the deck currently has.
     */
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

    @Override
    public String toString() {
        return "Class: " + deckClass + ", Number: " + deckNumber;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Returns a boolean based on if the deck has finished (Amount of wins is 12
     * or amount of losses is 3)
     *
     * @return true if the deck is finished, false if the deck is still ongoing.
     */
    public boolean isFinished() {
        return wins > 11 || losses > 2;
    }

    /**
     * Returns the current score in a X-Y format where X is the amount wins and
     * Y is the amount of losses.
     *
     * @return The current score as a String.
     */
    public String getScore() {
        return wins + "-" + losses;
    }
}
