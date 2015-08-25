package logic;

import domain.Deck;
import domain.DeckClass;
import domain.DeckClassStatistics;
import util.Mapper;
import util.StatisticsHelper;

public class DeckClassStatisticsKeeper extends DeckStatisticsKeeper {

    private DeckClassStatistics statistics;

    public DeckClassStatisticsKeeper() {
        statistics = new DeckClassStatistics();
    }

    @Override
    public void addDeck(Deck deck) {
        DeckClass dc = deck.getDeckClass();
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getDecksAsClass(), dc);
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getWinsAsClass(), dc, deck.getWins());
        updateDoubleMaps(deck.getDeckClass());
    }

    
    public void updateDoubleMaps(DeckClass dc) {
        int totalDecksAsClass = getDecksAsClass(dc);
        Mapper.updateAverageInDeckClassDoubleMap(statistics.getAvgWinsAsClass(),
                dc, getWinsAsClass(dc), totalDecksAsClass);
        updatePlayPerAsClass();
    }

    private void updatePlayPerAsClass() {
        for (DeckClass dc : DeckClass.values()) {
            int totalDecksAsClass = getDecksAsClass(dc);
            Mapper.updateAverageInDeckClassDoubleMap(statistics.getPlayPerAsClass(),
                    dc, totalDecksAsClass, totalDecks());
        }
    }

    private int totalDecks() {
        int total = 0;
        for (DeckClass dc : DeckClass.values()) {
            total += getDecksAsClass(dc);
        }
        return total;
    }

    public void setDecksAsClass(DeckClass dc, int amount) {
        statistics.getDecksAsClass().put(dc, amount);
    }

    public void setWinsAsClass(DeckClass dc, int amount) {
        statistics.getWinsAsClass().put(dc, amount);
    }

    public DeckClassStatistics getStatistics() {
        return statistics;
    }

    public void setAverageWinsAsClass(DeckClass dc, double avg) {
        statistics.getAvgWinsAsClass().put(dc, avg);
    }

    public void setPlayPercentageAsClass(DeckClass dc, double per) {
        statistics.getPlayPerAsClass().put(dc, per);
    }

    public int getDecksAsClass(DeckClass dc) {
        return statistics.getDecksAsClass().get(dc);
    }

    public int getWinsAsClass(DeckClass dc) {
        return statistics.getWinsAsClass().get(dc);
    }

    public double getAverageWinsAsClass(DeckClass dc) {
        return statistics.getAvgWinsAsClass().get(dc);
    }

    public double getPlayPercentageAsClass(DeckClass dc) {
        return statistics.getPlayPerAsClass().get(dc);
    }

    @Override
    public void removeDeck(Deck deck) {
        DeckClass dc = deck.getDeckClass();
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getDecksAsClass(), dc);
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getWinsAsClass(), dc, deck.getWins());
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
    
    public double getAverageWins() {
        int wins = 0;
        for (DeckClass dc : DeckClass.values()) {
            wins += getWinsAsClass(dc);
        }
        return StatisticsHelper.getAverage(wins, getTotalDeckAmount());
    }

    @Override
    public void reset() {
        statistics = new DeckClassStatistics();
    }
}
