package logic;

import domain.Card;
import domain.Deck;
import domain.DeckClass;
import domain.DeckWinStatistics;
import java.util.List;
import util.Mapper;
import util.StatisticsHelper;

public class DeckWinStatisticsKeeper extends DeckStatisticsKeeper{

    private DeckWinStatistics statistics;

    public DeckWinStatisticsKeeper() {
        statistics = new DeckWinStatistics();
    }
    
    @Override
    public void addDeck(Deck deck) {
        increaseIntegersInIntegerIntegerMaps(deck);
        updateDoubleMaps(deck.getWins());
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
    
   
    public void updateDoubleMaps(int wins) {
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

    public DeckWinStatistics getStatistics() {
        return statistics;
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

    @Override
    public void removeDeck(Deck deck) {        
        decreaseIntegersInIntegerIntegerMaps(deck);
        updateDoubleMaps(deck.getWins());
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

    @Override
    public int getTotalDeckAmount() {
        int total = 0;
        for (int i = 0; i < 13; i++) {
            total += getDecksByWins(i);
        }
        return total;
    }
    
    public double percentageOutOfAllDecks(int wins) {
        return StatisticsHelper.getAverage(getDecksByWins(wins), getTotalDeckAmount());
    }
    
    @Override
    public void reset() {
        statistics = new DeckWinStatistics();
    }
}
