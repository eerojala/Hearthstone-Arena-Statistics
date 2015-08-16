package logic;

import domain.Card;
import domain.Deck;
import domain.DeckClass;
import domain.DeckStatistics;
import java.util.List;
import util.Mapper;
import util.StatisticsHelper;

public class DeckStatisticsKeeper {

    private DeckStatistics statistics;

    public DeckStatisticsKeeper() {
        statistics = new DeckStatistics();
    }

    public void addDecks(List<Deck> list) {
        for (Deck deck : list) {
            addDeck(deck);
        }
    }

    public void addDeck(Deck deck) {
        DeckClass dc = deck.getDeckClass();
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getDecksAsClass(), dc);
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getWinsAsClass(), dc, deck.getWins());
        increaseIntegersInIntegerIntegerMaps(deck);
        updateDoubleMaps(deck);
    }

    private void increaseIntegersInIntegerIntegerMaps(Deck deck) {
        int wins = deck.getWins();
        Mapper.increaseIntegerInIntegerIntegerMap(statistics.getDecksByWins(), wins);
        Mapper.increaseIntegerInIntegerIntegerMap(statistics.getDustByWins(), wins, deck.getDust());
        Mapper.increaseIntegerInIntegerIntegerMap(statistics.getGoldByWins(), wins, deck.getGold());
        Mapper.increaseIntegerInIntegerIntegerMap(statistics.getExtraPacksByWins(), wins, deck.getExtraPacks());
        increaseIntegerInCardMaps(deck, wins);
    }

    private void increaseIntegerInCardMaps(Deck deck, int wins) {
        for (Card card : deck.getRewardCards()) {
            if (card.isGolden()) {
                Mapper.increaseIntegerInIntegerIntegerMap(statistics.getGoldCardsByWins(), wins);
            } else {
                Mapper.increaseIntegerInIntegerIntegerMap(statistics.getCardsByWins(), wins);
            }
        }
    }

    private void updateDoubleMaps(Deck deck) {
        updateDeckClassDoubleMaps(deck);
        updateIntegerDoubleMaps(deck);
    }

    private void updateDeckClassDoubleMaps(Deck deck) {
        DeckClass dc = deck.getDeckClass();
        int totalDecksAsClass = getDecksAsClass(dc);
        Mapper.updateAverageInDeckClassDoubleMap(statistics.getAvgWinsAsClass(),
                dc, getWinsAsClass(dc), totalDecksAsClass);
        updatePlayPerAsClass();
    }

    private void updatePlayPerAsClass() {
        for (DeckClass dc : DeckClass.getDeckClassList()) {
            int totalDecksAsClass = getDecksAsClass(dc);
            Mapper.updateAverageInDeckClassDoubleMap(statistics.getPlayPerAsClass(),
                    dc, totalDecksAsClass, totalDecks());
        }
    }

    private void updateIntegerDoubleMaps(Deck deck) {
        int wins = deck.getWins();
        int decksByWins = getDecksByWins(wins);
        Mapper.updateAverageInIntegerDoubleMap(statistics.getAvgDustByWins(), wins,
                getDustByWins(wins), decksByWins);
        Mapper.updateAverageInIntegerDoubleMap(statistics.getAvgGoldByWins(), wins,
                getGoldByWins(wins), decksByWins);
        Mapper.updateAverageInIntegerDoubleMap(statistics.getAvgExtraPacksByWins(),
                wins, getExtraPacksByWins(wins), decksByWins);
        Mapper.updateAverageInIntegerDoubleMap(statistics.getAvgCardsByWins(), wins,
                getRegularCardsByWins(wins), decksByWins);
        Mapper.updateAverageInIntegerDoubleMap(statistics.getAvgGoldCardsByWins(),
                wins, getGoldCardsByWins(wins), decksByWins);
    }

    private int totalDecks() {
        int total = 0;
        for (DeckClass dc : DeckClass.getDeckClassList()) {
            total += getDecksAsClass(dc);
        }
        return total;
    }

    public DeckStatistics getStatistics() {
        return statistics;
    }

    public void setDecksAsClass(DeckClass dc, int amount) {
        statistics.getDecksAsClass().put(dc, amount);
    }

    public void setWinsAsClass(DeckClass dc, int amount) {
        statistics.getWinsAsClass().put(dc, amount);
    }

    public void setDecksByWins(int wins, int amount) {
        statistics.getDecksByWins().put(wins, amount);
    }

    public void setDustByWins(int wins, int dust) {
        statistics.getDustByWins().put(wins, dust);
    }

    public void setGoldByWins(int wins, int gold) {
        statistics.getGoldByWins().put(wins, gold);
    }

    public void setExtraPacksByWins(int wins, int extraPacks) {
        statistics.getExtraPacksByWins().put(wins, extraPacks);
    }

    public void setRegularCardsByWins(int wins, int cards) {
        statistics.getCardsByWins().put(wins, cards);
    }

    public void setGoldCardsByWins(int wins, int cards) {
        statistics.getGoldCardsByWins().put(wins, cards);
    }

    public void setAverageWinsAsClass(DeckClass dc, double avg) {
        statistics.getAvgWinsAsClass().put(dc, avg);
    }

    public void setPlayPercentageAsClass(DeckClass dc, double per) {
        statistics.getPlayPerAsClass().put(dc, per);
    }

    public void setAverageDustByWins(int wins, double avg) {
        statistics.getAvgDustByWins().put(wins, avg);
    }

    public void setAverageGoldByWins(int wins, double avg) {
        statistics.getAvgGoldByWins().put(wins, avg);
    }

    public void setAverageExtraPacksByWins(int wins, double avg) {
        statistics.getAvgExtraPacksByWins().put(wins, avg);
    }

    public void setAverageRegularCardsByWins(int wins, double avg) {
        statistics.getAvgCardsByWins().put(wins, avg);
    }

    public void setAverageGoldCardsByWins(int wins, double avg) {
        statistics.getAvgGoldCardsByWins().put(wins, avg);
    }

    public int getDecksAsClass(DeckClass dc) {
        return statistics.getDecksAsClass().get(dc);
    }

    public int getWinsAsClass(DeckClass dc) {
        return statistics.getWinsAsClass().get(dc);
    }

    public int getDecksByWins(int wins) {
        return statistics.getDecksByWins().get(wins);
    }

    public int getDustByWins(int wins) {
        return statistics.getDustByWins().get(wins);
    }

    public int getGoldByWins(int wins) {
        return statistics.getGoldByWins().get(wins);
    }

    public int getExtraPacksByWins(int wins) {
        return statistics.getExtraPacksByWins().get(wins);
    }

    public int getRegularCardsByWins(int wins) {
        return statistics.getCardsByWins().get(wins);
    }

    public int getGoldCardsByWins(int wins) {
        return statistics.getGoldCardsByWins().get(wins);
    }

    public double getAverageWinsAsClass(DeckClass dc) {
        return statistics.getAvgWinsAsClass().get(dc);
    }

    public double getPlayPercentageAsClass(DeckClass dc) {
        return statistics.getPlayPerAsClass().get(dc);
    }

    public double getAverageDustByWins(int wins) {
        return statistics.getAvgDustByWins().get(wins);
    }

    public double getAverageGoldByWins(int wins) {
        return statistics.getAvgGoldByWins().get(wins);
    }

    public double getAverageExtraPacksByWins(int wins) {
        return statistics.getAvgExtraPacksByWins().get(wins);
    }

    public double getAverageRegularCardsByWins(int wins) {
        return statistics.getAvgCardsByWins().get(wins);
    }

    public double getAverageGoldCardsByWins(int wins) {
        return statistics.getAvgGoldCardsByWins().get(wins);
    }

    public void removeDeck(Deck deck) {
        DeckClass dc = deck.getDeckClass();
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getDecksAsClass(), dc);
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getWinsAsClass(), dc, deck.getWins());
        decreaseIntegersInIntegerIntegerMaps(deck);
        updateDoubleMaps(deck);
    }

    private void decreaseIntegersInIntegerIntegerMaps(Deck deck) {
        int wins = deck.getWins();
        Mapper.decreaseIntegerInIntegerIntegerMap(statistics.getDecksByWins(), wins);
        Mapper.decreaseIntegerInIntegerIntegerMap(statistics.getDustByWins(), wins, deck.getDust());
        Mapper.decreaseIntegerInIntegerIntegerMap(statistics.getGoldByWins(), wins, deck.getGold());
        Mapper.decreaseIntegerInIntegerIntegerMap(statistics.getExtraPacksByWins(), wins, deck.getExtraPacks());
        decreaseIntegersInCardMaps(deck, wins);
    }

    private void decreaseIntegersInCardMaps(Deck deck, int wins) {
        for (Card card : deck.getRewardCards()) {
            if (card.isGolden()) {
                Mapper.decreaseIntegerInIntegerIntegerMap(statistics.getGoldCardsByWins(), wins);
            } else {
                Mapper.decreaseIntegerInIntegerIntegerMap(statistics.getCardsByWins(), wins);
            }
        }
    }

    public int getTotalDeckAmount() {
        int total = 0;
        for (DeckClass dc : DeckClass.getDeckClassList()) {
            total += getDecksAsClass(dc);
        }
        return total;
    }

    public double getAverageWins() {
        int wins = 0;
        for (DeckClass dc : DeckClass.getDeckClassList()) {
            wins += getWinsAsClass(dc);
        }
        return StatisticsHelper.getAverage(wins, getTotalDeckAmount());
    }

    public void reset() {
        statistics = new DeckStatistics();
    }
}
