package logic;

import domain.Card;
import domain.Deck;
import domain.RewardStatistics;
import util.Mapper;
import util.StatisticsHelper;

/**
 * Class which handles reward-specific statistics.
 */
public class RewardStatisticsKeeper extends DeckStatisticsKeeper {

    private RewardStatistics statistics;

    /**
     * Creates a new RewardStatisticsKeeper Object.
     */
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

    /**
     * Updates HashMaps which store average reward amounts for decks with
     * specific win amounts.
     *
     * @param wins Amount of wins.
     */
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

    /**
     * Returns the RewardStatistics used by RewardStatisticsKeeper.
     *
     * @return RewardStatistics
     */
    public RewardStatistics getStatistics() {
        return statistics;
    }

    /**
     * Sets the amount of decks with a specific win amount.
     *
     * @param wins Amount of wins.
     * @param decks Amount of decks.
     */
    public void setDecksByWins(int wins, int decks) {
        statistics.getDecksByWins().put(wins, decks);
    }

    /**
     * Sets the amount of dust gained by decks with a specific win amount.
     *
     * @param wins Amount of wins.
     * @param dust Amount of dust.
     */
    public void setDustByWins(int wins, int dust) {
        statistics.getDustByWins().put(wins, dust);
    }

    /**
     * Sets the amount of gold gained by decks with a specific win amount.
     *
     * @param wins Amount of wins.
     * @param gold Amount of gold.
     */
    public void setGoldByWins(int wins, int gold) {
        statistics.getGoldByWins().put(wins, gold);
    }

    /**
     * Sets the amount of extra card packs gained by decks with a specific win
     * amount.
     *
     * @param wins Amount of wins.
     * @param extraPacks Amount of extra card packs.
     */
    public void setExtraPacksByWins(int wins, int extraPacks) {
        statistics.getExtraPacksByWins().put(wins, extraPacks);
    }

    /**
     * Sets the amount of regular cards gained by decks with a specific win
     * amount.
     *
     * @param wins Amount of wins.
     * @param cards Amount of regular cards.
     */
    public void setRegularCardsByWins(int wins, int cards) {
        statistics.getCardsByWins().put(wins, cards);
    }

    /**
     * Sets the amount of golden cards gained by decks with a specific win
     * amount.
     *
     * @param wins Amount of wins.
     * @param cards Amount of golden cards.
     */
    public void setGoldCardsByWins(int wins, int cards) {
        statistics.getGoldCardsByWins().put(wins, cards);
    }

    /**
     * Sets the average amount of dust received from decks with a specific win
     * amount.
     *
     * @param wins Win amount.
     * @param avg Average dust amount.
     */
    public void setAverageDustByWins(int wins, double avg) {
        statistics.getAvgDustByWins().put(wins, avg);
    }

    /**
     * Sets the average amount of gold received from decks with a specific win
     * amount.
     *
     * @param wins Win amount.
     * @param avg Average gold amount.
     */
    public void setAverageGoldByWins(int wins, double avg) {
        statistics.getAvgGoldByWins().put(wins, avg);
    }

    /**
     * Sets the average amount of extra card packs received from decks with a
     * specific win amount.
     *
     * @param wins Win amount.
     * @param avg Average extra card pack amount.
     */
    public void setAverageExtraPacksByWins(int wins, double avg) {
        statistics.getAvgExtraPacksByWins().put(wins, avg);
    }

    /**
     * Sets the average amount of regular cards received from decks with a
     * specific win amount.
     *
     * @param wins Win amount.
     * @param avg Average regular card amount.
     */
    public void setAverageRegularCardsByWins(int wins, double avg) {
        statistics.getAvgCardsByWins().put(wins, avg);
    }

    /**
     * Sets the average amount of golden cards received from decks with a
     * specific win amount.
     *
     * @param wins Win amount.
     * @param avg Average golden card amount.
     */
    public void setAverageGoldCardsByWins(int wins, double avg) {
        statistics.getAvgGoldCardsByWins().put(wins, avg);
    }

    @Override
    public int getDecksByWins(int wins) {
        return statistics.getDecksByWins().get(wins);
    }

    /**
     * Returns the total amount of dust received from decks with a specific win
     * amount.
     *
     * @param wins Amount of wins.
     * @return Amount of dust.
     */
    public int getDustByWins(int wins) {
        return statistics.getDustByWins().get(wins);
    }

    /**
     * Returns the total amount of gold received from decks with a specific win
     * amount.
     *
     * @param wins Amount of wins.
     * @return Amount of gold.
     */
    public int getGoldByWins(int wins) {
        return statistics.getGoldByWins().get(wins);
    }

    /**
     * Returns the total amount of extra card packs received from decks with a
     * specific win amount.
     *
     * @param wins Amount of wins.
     * @return Amount of extra packs.
     */
    public int getExtraPacksByWins(int wins) {
        return statistics.getExtraPacksByWins().get(wins);
    }

    /**
     * Returns the total amount of regular cards received from decks with a
     * specific win amount.
     *
     * @param wins Amount of wins.
     * @return Amount of regular cards.
     */
    public int getRegularCardsByWins(int wins) {
        return statistics.getCardsByWins().get(wins);
    }

    /**
     * Returns the total amount of golden cards received from decks with a
     * specific win amount.
     *
     * @param wins Amount of wins.
     * @return Amount of golden cards.
     */
    public int getGoldCardsByWins(int wins) {
        return statistics.getGoldCardsByWins().get(wins);
    }

    /**
     * Returns the average amount of dust received from decks with a specific
     * win amount.
     *
     * @param wins Amount of wins.
     * @return Average amount of dust.
     */
    public double getAverageDustByWins(int wins) {
        return statistics.getAvgDustByWins().get(wins);
    }

    /**
     * Returns the average amount of gold received from decks with a specific
     * win amount.
     *
     * @param wins Amount of wins.
     * @return Average amount of gold.
     */
    public double getAverageGoldByWins(int wins) {
        return statistics.getAvgGoldByWins().get(wins);
    }

    /**
     * Returns the average amount of extra card packs received from decks with a
     * specific win amount.
     *
     * @param wins Amount of wins.
     * @return Average amount of extra card packs.
     */
    public double getAverageExtraPacksByWins(int wins) {
        return statistics.getAvgExtraPacksByWins().get(wins);
    }

    /**
     * Returns the average amount of regular cards received from decks with a
     * specific win amount.
     *
     * @param wins Amount of wins.
     * @return Average amount of regular cards.
     */
    public double getAverageRegularCardsByWins(int wins) {
        return statistics.getAvgCardsByWins().get(wins);
    }

    /**
     * Returns the average amount of golden cards received from decks with a
     * specific win amount.
     *
     * @param wins Amount of wins.
     * @return Average amount of golden cards.
     */
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

    /**
     * Returns the ratio of decks with a specific win amount.
     *
     * @param wins Amount of wins.
     * @see util.StatisticsHelper#getDivision(int, int) 
     * @return Ratio of decks with a specific win amount.
     */
    public double getPlayRatio(int wins) {
        return StatisticsHelper.getDivision(getDecksByWins(wins), getTotalDeckAmount());
    }

    @Override
    public void reset() {
        statistics = new RewardStatistics();
    }

    /**
     * Returns the total amount of dust received from decks.
     *
     * @see util.StatisticsHelper#sumMapValueIntegers(java.util.Map) 
     * @return Amount of dust.
     */
    public int getTotalDust() {
        return StatisticsHelper.sumMapValueIntegers(statistics.getDustByWins());
    }

    /**
     * Returns the average amount of dust received from decks.
     *
     * @see util.StatisticsHelper#getDivision(int, int) 
     * @return Average amount of dust.
     */
    public double getTotalDustAverage() {
        return StatisticsHelper.getDivision(getTotalDust(), getTotalDeckAmount());
    }

    /**
     * Returns the total amount of gold received from decks.
     *
     * @see util.StatisticsHelper#sumMapValueIntegers(java.util.Map) 
     * @return Amount of gold.
     */
    public int getTotalGold() {
        return StatisticsHelper.sumMapValueIntegers(statistics.getGoldByWins());
    }

    /**
     * Returns the average amount of gold received from decks.
     *
     * @see util.StatisticsHelper#getDivision(int, int) 
     * @return Average amount of gold.
     */
    public double getTotalGoldAverage() {
        return StatisticsHelper.getDivision(getTotalGold(), getTotalDeckAmount());
    }

    /**
     * Returns the total amount of extra card packs received from decks.
     *
     * @see util.StatisticsHelper#sumMapValueIntegers(java.util.Map) 
     * @return Amount of extra card packs.
     */
    public int getTotalExtraPacks() {
        return StatisticsHelper.sumMapValueIntegers(statistics.getExtraPacksByWins());
    }

    /**
     * Returns the average amount of extra card packs received from decks.
     *
     * @see util.StatisticsHelper#getDivision(int, int) 
     * @return Average amount of extra card packs.
     */
    public double getTotalExtraPackAverage() {
        return StatisticsHelper.getDivision(getTotalExtraPacks(), getTotalDeckAmount());
    }

    /**
     * Returns the total amount of regular cards received from decks.
     *
     * @see util.StatisticsHelper#sumMapValueIntegers(java.util.Map) 
     * @return Amount of regular cards.
     */
    public int getTotalRegularCards() {
        return StatisticsHelper.sumMapValueIntegers(statistics.getCardsByWins());
    }

    /**
     * Returns the average amount of regular cards received from decks.
     *
     * @see util.StatisticsHelper#getDivision(int, int) 
     * @return Average amount of regular cards.
     */
    public double getTotalRegularCardAverage() {
        return StatisticsHelper.getDivision(getTotalRegularCards(), getTotalDeckAmount());
    }

    /**
     * Returns the total amount of golden cards received from decks.
     * 
     * @see util.StatisticsHelper#sumMapValueIntegers(java.util.Map) 
     * @return Total amount of golden cards.
     */
    public int getTotalGoldenCards() {
        return StatisticsHelper.sumMapValueIntegers(statistics.getGoldCardsByWins());
    }

    /**
     * Returns the average amount of golden cards received from decks.
     * 
     * @see util.StatisticsHelper#getDivision(int, int) 
     * @return Average amount of golden cards.
     */
    public double getTotalGoldenCardAverage() {
        return StatisticsHelper.getDivision(getTotalGoldenCards(), getTotalDeckAmount());
    }

    /**
     * Returns the average amount of wins the user's decks have.
     * 
     * @return Average amount of wins.
     */
    public double getTotalWinAverage() {
        return (double) getTotalWins() / getTotalDeckAmount();
    }

    /**
     * Returns the total amount of wins the user's decks have.
     * 
     * @return Total amount of wins.
     */
    public int getTotalWins() {
        int sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += i * this.statistics.getDecksByWins().get(i);
        }
        return sum;
    }

}
