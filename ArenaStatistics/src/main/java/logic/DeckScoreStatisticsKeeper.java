package logic;

import domain.Deck;
import domain.DeckClass;
import domain.DeckScoreStatistics;
import java.util.Map;
import util.Mapper;
import util.StatisticsHelper;

public class DeckScoreStatisticsKeeper extends DeckStatisticsKeeper {

    private DeckScoreStatistics statistics;

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

    
    public void updateDoubleMaps(DeckClass dc) {
        int totalDecksAsClass = getDecksAsClass(dc);
        Mapper.updateAverageInDcDoubleMap(statistics.getAvgWinsAsClass(),
                dc, getWinsAsClass(dc), totalDecksAsClass);
        updatePlayPerAsClass();
    }

    private void updatePlayPerAsClass() {
        for (DeckClass dc : DeckClass.values()) {
            int totalDecksAsClass = getDecksAsClass(dc);
            Mapper.updateAverageInDcDoubleMap(statistics.getPlayPerAsClass(),
                    dc, totalDecksAsClass, getTotalDeckAmount());
        }
    }
    
    public void setDecksAsClassWithXWins(DeckClass dc, int wins, int amount) {
        Map<Integer,Integer> map = statistics.getDecksWithXWinsAsClass().get(dc);
        map.put(wins, amount);
        statistics.getDecksWithXWinsAsClass().put(dc, map);
    }

    public DeckScoreStatistics getStatistics() {
        return statistics;
    }

    public void setAverageWinsAsClass(DeckClass dc, double avg) {
        statistics.getAvgWinsAsClass().put(dc, avg);
    }

    public void setPlayPercentageAsClass(DeckClass dc, double per) {
        statistics.getPlayPerAsClass().put(dc, per);
    }

    public int getDecksAsClass(DeckClass dc) {
        int decks = 0;
        for (int i = 0; i < 13; i++) {
            decks += statistics.getDecksWithXWinsAsClass().get(dc).get(i);
        }
        return decks;
    }

    public int getWinsAsClass(DeckClass dc) {
        int wins = 0;
        for (int i = 0; i < 13; i++) {
            wins += statistics.getDecksWithXWinsAsClass().get(dc).get(i) * i;
        }
        return wins;
    }
    
    public int getDecksAsClassWithXWins(DeckClass dc, int wins) {
        return statistics.getDecksWithXWinsAsClass().get(dc).get(wins);
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
    
    public double getAverageWins() {
        int wins = 0;
        for (DeckClass dc : DeckClass.values()) {
            wins += getWinsAsClass(dc);
        }
        return StatisticsHelper.getAverage(wins, getTotalDeckAmount());
    }

    @Override
    public void reset() {
        statistics = new DeckScoreStatistics();
    }
    
    @Override
    public int getDecksByWins(int wins) {
        int decks = 0;
        for (DeckClass dc: DeckClass.values()) {
            decks += getDecksAsClassWithXWins(dc, wins);
        }
        return decks;
    }
}
