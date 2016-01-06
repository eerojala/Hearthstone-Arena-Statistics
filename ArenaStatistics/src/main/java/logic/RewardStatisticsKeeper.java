package logic;

import domain.Card;
import domain.Deck;
import domain.DeckClass;
import domain.RewardStatistics;
import java.util.List;
import util.Mapper;
import util.StatisticsHelper;

public class RewardStatisticsKeeper extends DeckStatisticsKeeper{

    private RewardStatistics statistics;

    public RewardStatisticsKeeper() {
        statistics = new RewardStatistics();
    }
    
    @Override
    public void addDeck(Deck deck) {
        increaseIntegersInIntegerIntegerMaps(deck);
        updateDoubleMaps(deck.getWins());
    }

    private void increaseIntegersInIntegerIntegerMaps(Deck deck) {
        int wins = deck.getWins();
        Mapper.increaseIntegerInIntIntMap(statistics.getDecksByWins(), wins);
        Mapper.increaseIntegerInIntIntMap(statistics.getDustByWins(), wins, deck.getDust());
        Mapper.increaseIntegerInIntIntMap(statistics.getGoldByWins(), wins, deck.getGold());
        Mapper.increaseIntegerInIntIntMap(statistics.getExtraPacksByWins(), wins, deck.getExtraPacks());
        increaseIntegerInCardMaps(deck, wins);
    }

    private void increaseIntegerInCardMaps(Deck deck, int wins) {
        for (Card card : deck.getRewardCards()) {
            if (card.isGolden()) {
                Mapper.increaseIntegerInIntIntMap(statistics.getGoldCardsByWins(), wins);
            } else {
                Mapper.increaseIntegerInIntIntMap(statistics.getCardsByWins(), wins);
            }
        }
    }
    
   
    public void updateDoubleMaps(int wins) {
        int decksByWins = getDecksByWins(wins);
        Mapper.updateAverageInIntDoubleMap(statistics.getAvgDustByWins(), wins,
                getDustByWins(wins), decksByWins);
        Mapper.updateAverageInIntDoubleMap(statistics.getAvgGoldByWins(), wins,
                getGoldByWins(wins), decksByWins);
        Mapper.updateAverageInIntDoubleMap(statistics.getAvgExtraPacksByWins(),
                wins, getExtraPacksByWins(wins), decksByWins);
        Mapper.updateAverageInIntDoubleMap(statistics.getAvgCardsByWins(), wins,
                getRegularCardsByWins(wins), decksByWins);
        Mapper.updateAverageInIntDoubleMap(statistics.getAvgGoldCardsByWins(),
                wins, getGoldCardsByWins(wins), decksByWins);
    }

    public RewardStatistics getStatistics() {
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

    @Override
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
        Mapper.decreaseIntegerInIntIntMap(statistics.getDecksByWins(), wins);
        Mapper.decreaseIntegerInIntIntMap(statistics.getDustByWins(), wins, deck.getDust());
        Mapper.decreaseIntegerInIntIntMap(statistics.getGoldByWins(), wins, deck.getGold());
        Mapper.decreaseIntegerInIntIntMap(statistics.getExtraPacksByWins(), wins, deck.getExtraPacks());
        decreaseIntegersInCardMaps(deck, wins);
    }

    private void decreaseIntegersInCardMaps(Deck deck, int wins) {
        for (Card card : deck.getRewardCards()) {
            if (card.isGolden()) {
                Mapper.decreaseIntegerInIntIntMap(statistics.getGoldCardsByWins(), wins);
            } else {
                Mapper.decreaseIntegerInIntIntMap(statistics.getCardsByWins(), wins);
            }
        }
    }

    @Override
    public int getTotalDeckAmount() {
        return StatisticsHelper.sumMapValueIntegers(statistics.getDecksByWins());
    }
    
    public double getPercentageOutOfAllDecks(int wins) {
        return StatisticsHelper.getAverage(getDecksByWins(wins), getTotalDeckAmount());
    }
    
    @Override
    public void reset() {
        statistics = new RewardStatistics();
    }
    
    public int getTotalDust() {
        return StatisticsHelper.sumMapValueIntegers(statistics.getDustByWins());
    }
    
    public double getTotalDustAverage() {
        return StatisticsHelper.getAverage(getTotalDust(), getTotalDeckAmount());
    }
    
    public int getTotalGold() {
        return StatisticsHelper.sumMapValueIntegers(statistics.getGoldByWins());
    }
    
    public double getTotalGoldAverage() {
        return StatisticsHelper.getAverage(getTotalGold(), getTotalDeckAmount());
    }
    
    public int getTotalExtraPacks() {
        return StatisticsHelper.sumMapValueIntegers(statistics.getExtraPacksByWins());
    }
    
    public double getTotalExtraPackAverage() {
        return StatisticsHelper.getAverage(getTotalExtraPacks(), getTotalDeckAmount());
    }
    
    public int getTotalRegularCards() {
        return StatisticsHelper.sumMapValueIntegers(statistics.getCardsByWins());
    }
    
    public double getTotalRegularCardAverage() {
        return StatisticsHelper.getAverage(getTotalRegularCards(), getTotalDeckAmount());
    }
    
    public int getTotalGoldenCards() {
        return StatisticsHelper.sumMapValueIntegers(statistics.getGoldCardsByWins());
    }
    
    public double getTotalGoldenCardAverage() {
        return StatisticsHelper.getAverage(getTotalGoldenCards(), getTotalDeckAmount());
    }
    
    public double getTotalWinAverage() {
        return (double) getTotalWins() / getTotalDeckAmount();
    }
    
    public int getTotalWins() {
        int sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += i * this.statistics.getDecksByWins().get(i);
        }
        return sum;
    }
    
}
