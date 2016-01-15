package domain;

import java.util.HashMap;
import java.util.Map;
import util.Mapper;

/**
 * Class which contains the HashMaps where the statistics about Deck scores,
 * average win amounts and play ratios are stored.
 */
public class DeckScoreStatistics {

    private final Map<DeckClass, Double> avgWinsAsClass;
    private final Map<DeckClass, Double> playRatioAsClass;
    private final Map<DeckClass, Map<Integer, Integer>> decksWithXWinsAsClass;

    /**
     * Creates a new DeckScoreStatistics object.
     */
    public DeckScoreStatistics() {
        avgWinsAsClass = new HashMap();
        playRatioAsClass = new HashMap();
        decksWithXWinsAsClass = new HashMap();
        mapZeroesToValues();
    }

    private void mapZeroesToValues() {
        Mapper.mapZeroesToDcDoubleMap(avgWinsAsClass);
        Mapper.mapZeroesToDcDoubleMap(playRatioAsClass);
        Mapper.mapZeroesToDcIntIntMapMap(decksWithXWinsAsClass);
    }

    /**
     * Returns the HashMap which stores each classes' average wins.
     *
     * @return HashMap where the key is a DeckClass and value is the average win
     * Double of that specific class.
     */
    public Map<DeckClass, Double> getAvgWinsAsClass() {
        return avgWinsAsClass;
    }

    /**
     * Returns the HashMap which stores each classes play ratio.
     *
     * @return HashMap where the key is a DeckClass and value is the play ratio
     * Double of that specific class.
     */
    public Map<DeckClass, Double> getPlayRatioAsClass() {
        return playRatioAsClass;
    }

    /**
     * Returns the HashMap which stores the amount of decks with specific class
     * and wins.
     *
     * @return HashMap where the key is a DeckClass and value is another HashMap
     * which contains the amount of decks with specific wins.
     */
    public Map<DeckClass, Map<Integer, Integer>> getDecksWithXWinsAsClass() {
        return decksWithXWinsAsClass;
    }
}
