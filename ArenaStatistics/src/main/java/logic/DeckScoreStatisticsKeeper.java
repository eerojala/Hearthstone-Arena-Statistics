package logic;

import domain.Deck;
import domain.DeckClass;
import domain.DeckScoreStatistics;
import java.util.Map;
import util.Mapper;
import util.StatisticsHelper;

/**
 * Class which handles deck score related statistics.
 */
public class DeckScoreStatisticsKeeper extends DeckStatisticsKeeper {

    private DeckScoreStatistics statistics;

    /**
     * Creates a new DeckScoreStatisticsKeeper Object.
     */
    public DeckScoreStatisticsKeeper() {
        statistics = new DeckScoreStatistics();
    }

    @Override
    public void addDeck(Deck deck) {
        DeckClass dc = deck.getDeckClass();
        int wins = deck.getWins();
        Mapper.increaseIntegerInDcIntIntMapMap(statistics.getDecksWithXWinsAsClass(), dc, wins);
        updateDoubleMaps(deck.getDeckClass());
    }

    /**
     * Updates values in HashMaps which store average wins and play ratios.
     *
     * @param dc DeckClass which values are updated.
     */
    public void updateDoubleMaps(DeckClass dc) {
        int totalDecksAsClass = getDecksAsClass(dc);
        Mapper.updateAverageInDcDoubleMap(statistics.getAvgWinsAsClass(),
                dc, getWinsAsClass(dc), totalDecksAsClass);
        updatePlayRatioAsClass();
    }

    private void updatePlayRatioAsClass() {
        for (DeckClass dc : DeckClass.values()) {
            int totalDecksAsClass = getDecksAsClass(dc);
            Mapper.updateAverageInDcDoubleMap(statistics.getPlayRatioAsClass(),
                    dc, totalDecksAsClass, getTotalDeckAmount());
        }
    }

    /**
     * Sets the amount of decks with a specific class and win amount
     *
     * @param dc DeckClass
     * @param wins Win amount
     * @param amount Amount of decks with a specific DeckClass and win amount.
     */
    public void setDecksAsClassWithXWins(DeckClass dc, int wins, int amount) {
        Map<Integer, Integer> map = statistics.getDecksWithXWinsAsClass().get(dc);
        map.put(wins, amount);
        statistics.getDecksWithXWinsAsClass().put(dc, map);
    }

    /**
     * Returns the DeckScoreStatistics used by DeckScoreStatistics
     *
     * @return DeckScoreStatistics.
     */
    public DeckScoreStatistics getStatistics() {
        return statistics;
    }

    /**
     * Sets the average win amount as a specific class.
     *
     * @param dc DeckClass
     * @param avg Average win amount.
     */
    public void setAverageWinsAsClass(DeckClass dc, double avg) {
        statistics.getAvgWinsAsClass().put(dc, avg);
    }

    /**
     * Sets the play ratio of a specific class.
     *
     * @param dc DeckClass
     * @param per Play percentage
     */
    public void setPlayRatioAsClass(DeckClass dc, double per) {
        statistics.getPlayRatioAsClass().put(dc, per);
    }

    /**
     * Returns the amount of decks with a specific class.
     * 
     * @param dc DeckClass
     * @return Amount of decks with a specific class.
     */
    public int getDecksAsClass(DeckClass dc) {
        int decks = 0;
        for (int i = 0; i < 13; i++) {
            decks += statistics.getDecksWithXWinsAsClass().get(dc).get(i);
        }
        return decks;
    }

    /**
     * Returns the amount of wins gotten from decks with a specific class.
     * 
     * @param dc DeckClass
     * @return Wins gotten from decks with a specific class.
     */
    public int getWinsAsClass(DeckClass dc) {
        int wins = 0;
        for (int i = 0; i < 13; i++) {
            wins += statistics.getDecksWithXWinsAsClass().get(dc).get(i) * i;
        }
        return wins;
    }

    /**
     * Returns the amount of decks with a specific class and amount of wins.
     * 
     * @param dc DeckClass
     * @param wins Amount of wins
     * @return Amount of decks with a specific DeckClass and amount of wins.
     */
    public int getDecksAsClassWithXWins(DeckClass dc, int wins) {
        return statistics.getDecksWithXWinsAsClass().get(dc).get(wins);
    }

    /**
     * Returns the average amount of wins gotten with a specific class.
     * 
     * @param dc DeckClass
     * @return Average amount wins gotten with a specific class.
     */
    public double getAverageWinsAsClass(DeckClass dc) {
        return statistics.getAvgWinsAsClass().get(dc);
    }

    /**
     * Returns the play ratio of a specific class.
     * 
     * @param dc DeckClass
     * @return Play percentage of a specific class.
     */
    public double getPlayRatioAsClass(DeckClass dc) {
        return statistics.getPlayRatioAsClass().get(dc);
    }

    @Override
    public void removeDeck(Deck deck) {
        DeckClass dc = deck.getDeckClass();
        int wins = deck.getWins();
        Mapper.decreaseIntegerInDcIntIntMapMap(statistics.getDecksWithXWinsAsClass(), dc, wins);
        updateDoubleMaps(deck.getDeckClass());
    }

    @Override
    public int getTotalDeckAmount() {
        int total = 0;
        for (DeckClass dc : DeckClass.values()) {
            total += getDecksAsClass(dc);
        }
        return total;
    }

    /**
     * Returns the amount of wins the user achieves with a deck on average.
     * @return
     */
    public double getAverageWins() {
        int wins = 0;
        for (DeckClass dc : DeckClass.values()) {
            wins += getWinsAsClass(dc);
        }
        return StatisticsHelper.getDivision(wins, getTotalDeckAmount());
    }

    @Override
    public void reset() {
        statistics = new DeckScoreStatistics();
    }

    @Override
    public int getDecksByWins(int wins) {
        int decks = 0;
        for (DeckClass dc : DeckClass.values()) {
            decks += getDecksAsClassWithXWins(dc, wins);
        }
        return decks;
    }
}
