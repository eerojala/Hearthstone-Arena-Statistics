package domain;

import java.util.HashMap;
import java.util.Map;
import util.Mapper;

/**
 * Class containing the HashMaps which store deck reward statistics.
 */
public class RewardStatistics {

    private final Map<Integer, Integer> decksByWins;
    private final Map<Integer, Integer> dustByWins;
    private final Map<Integer, Integer> goldByWins;
    private final Map<Integer, Integer> extraPacksByWins;
    private final Map<Integer, Integer> cardsByWins;
    private final Map<Integer, Integer> goldCardsByWins;
    private final Map<Integer, Double> avgDustByWins;
    private final Map<Integer, Double> avgGoldByWins;
    private final Map<Integer, Double> avgExtraPacksByWins;
    private final Map<Integer, Double> avgCardsByWins;
    private final Map<Integer, Double> avgGoldCardsByWins;

    /**
     * Creates a new RewardStatistics Object.
     */
    public RewardStatistics() {
        decksByWins = new HashMap();
        dustByWins = new HashMap();
        goldByWins = new HashMap();
        extraPacksByWins = new HashMap();
        cardsByWins = new HashMap();
        goldCardsByWins = new HashMap();
        avgDustByWins = new HashMap();
        avgGoldByWins = new HashMap();
        avgExtraPacksByWins = new HashMap();
        avgCardsByWins = new HashMap();
        avgGoldCardsByWins = new HashMap();
        mapZeroesToValues();
    }

    private void mapZeroesToValues() {
        mapZeroesToIntegerIntegerMaps();
        mapZeroesToIntegerDoubleMaps();
    }

    private void mapZeroesToIntegerIntegerMaps() {
        Mapper.mapZeroesToIntIntMap(decksByWins);
        Mapper.mapZeroesToIntIntMap(dustByWins);
        Mapper.mapZeroesToIntIntMap(goldByWins);
        Mapper.mapZeroesToIntIntMap(extraPacksByWins);
        Mapper.mapZeroesToIntIntMap(cardsByWins);
        Mapper.mapZeroesToIntIntMap(goldCardsByWins);
    }

    private void mapZeroesToIntegerDoubleMaps() {
        Mapper.mapZeroesToIntDoubleMap(avgDustByWins);
        Mapper.mapZeroesToIntDoubleMap(avgGoldByWins);
        Mapper.mapZeroesToIntDoubleMap(avgExtraPacksByWins);
        Mapper.mapZeroesToIntDoubleMap(avgCardsByWins);
        Mapper.mapZeroesToIntDoubleMap(avgGoldCardsByWins);
    }

    /**
     * Returns the HashMap which contains the average dust amount gotten from
     * decks with specific wins.
     *
     * @return HashMap where the key is an Integer signifying the amount of wins
     * a deck has, and the value is a Double signifying the average amount of
     * dust.
     */
    public Map<Integer, Double> getAvgDustByWins() {
        return avgDustByWins;
    }

    /**
     * Returns the HashMap which contains the average extra pack amount gotten
     * from decks with specific wins.
     *
     * @return HashMap where the key is an Integer signifying the amount of wins
     * a deck has, and the value is a Double signifying the average amount of
     * extra packs.
     */
    public Map<Integer, Double> getAvgExtraPacksByWins() {
        return avgExtraPacksByWins;
    }

    /**
     * Returns the HashMap which contains the average gold amount gotten from
     * decks with specific wins.
     *
     * @return HashMap where the key is an Integer signifying the amount of wins
     * a deck has, and the value is a Double signifying the average amount of
     * gold.
     */
    public Map<Integer, Double> getAvgGoldByWins() {
        return avgGoldByWins;
    }

    /**
     * Returns the HashMap which contains the amount of decks with specific
     * wins.
     *
     * @return HashMap where the key is an Integer signifying the amount wins a
     * deck has, and the value is an Integer signifying the amount of decks.
     */
    public Map<Integer, Integer> getDecksByWins() {
        return decksByWins;
    }

    /**
     * Returns the HashMap which contains the amount of dust gotten from decks
     * with specific wins.
     *
     * @return HashMap where the key is an Integer signifying the amount wins a
     * deck has, and the value is an Integer signifying the amount of dust.
     */
    public Map<Integer, Integer> getDustByWins() {
        return dustByWins;
    }

    /**
     * Returns the HashMap which contains the amount of extra packs gotten from
     * decks with specific wins.
     *
     * @return HashMap where the key is an Integer signifying the amount wins a
     * deck has, and the value is an Integer signifying the amount of extra
     * packs.
     */
    public Map<Integer, Integer> getExtraPacksByWins() {
        return extraPacksByWins;
    }

    /**
     * Returns the HashMap which contains the amount of gold gotten from decks
     * with specific wins.
     *
     * @return HashMap where the key is an Integer signifying the amount wins a
     * deck has, and the value is an Integer signifying the amount of gold.
     */
    public Map<Integer, Integer> getGoldByWins() {
        return goldByWins;
    }

    /**
     * Returns the HashMap which contains the average regular card amount gotten
     * from decks with specific wins.
     *
     * @return HashMap where the key is an Integer signifying the amount of wins
     * a deck has, and the value is a Double signifying the average amount of
     * regular cards.
     */
    public Map<Integer, Double> getAvgCardsByWins() {
        return avgCardsByWins;
    }

    /**
     * Returns the HashMap which contains the average golden card amount gotten
     * from decks with specific wins.
     *
     * @return HashMap where the key is an Integer signifying the amount of wins
     * a deck has, and the value is a Double signifying the average amount of
     * golden cards.
     */
    public Map<Integer, Double> getAvgGoldCardsByWins() {
        return avgGoldCardsByWins;
    }

    /**
     * Returns the HashMap which contains the amount of regular cards gotten
     * from decks with specific wins.
     *
     * @return HashMap where the key is an Integer signifying the amount wins a
     * deck has, and the value is an Integer signifying the amount of regular
     * cards.
     */
    public Map<Integer, Integer> getCardsByWins() {
        return cardsByWins;
    }

    /**
     * Returns the HashMap which contains the amount of golden cards gotten from
     * decks with specific wins.
     *
     * @return HashMap where the key is an Integer signifying the amount wins a
     * deck has, and the value is an Integer signifying the amount of golden
     * cards.
     */
    public Map<Integer, Integer> getGoldCardsByWins() {
        return goldCardsByWins;
    }
}
