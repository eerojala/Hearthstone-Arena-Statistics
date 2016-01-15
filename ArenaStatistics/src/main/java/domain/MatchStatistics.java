package domain;

import java.util.HashMap;
import java.util.Map;
import util.Mapper;

/**
 * Class that contains the HashMaps which store class specific match statistics.
 */
public class MatchStatistics {

    private final Map<DeckClass, Integer> matchesAsClass1st;
    private final Map<DeckClass, Integer> matchesAsClass2nd;
    private final Map<DeckClass, Integer> matchesVSClass1st;
    private final Map<DeckClass, Integer> matchesVSClass2nd;
    private final Map<DeckClass, Integer> winsAsClass1st;
    private final Map<DeckClass, Integer> winsAsClass2nd;
    private final Map<DeckClass, Integer> lossesAsClass1st;
    private final Map<DeckClass, Integer> lossesAsClass2nd;
    private final Map<DeckClass, Integer> winsVSClass1st;
    private final Map<DeckClass, Integer> winsVSClass2nd;
    private final Map<DeckClass, Integer> lossesVSClass1st;
    private final Map<DeckClass, Integer> lossesVSClass2nd;
    private final Map<DeckClass, Double> winRatioVSClass1st;
    private final Map<DeckClass, Double> winRatioVSClass2nd;
    private final Map<DeckClass, Double> winRatioAsClass1st;
    private final Map<DeckClass, Double> winRatioAsClass2nd;

    /**
     * Creates a new MatchStatistics Object.
     */
    public MatchStatistics() {
        matchesAsClass1st = new HashMap();
        matchesAsClass2nd = new HashMap();
        matchesVSClass1st = new HashMap();
        matchesVSClass2nd = new HashMap();
        winsAsClass1st = new HashMap();
        winsAsClass2nd = new HashMap();
        lossesAsClass1st = new HashMap();
        lossesAsClass2nd = new HashMap();
        winsVSClass1st = new HashMap();
        winsVSClass2nd = new HashMap();
        lossesVSClass1st = new HashMap();
        lossesVSClass2nd = new HashMap();
        winRatioVSClass1st = new HashMap();
        winRatioVSClass2nd = new HashMap();
        winRatioAsClass1st = new HashMap();
        winRatioAsClass2nd = new HashMap();
        mapZeroesToValues();
    }

    private void mapZeroesToValues() {
        mapZeroesToDeckClassIntegerMaps();
        mapZeroesToDeckClassDoubleMaps();
    }

    private void mapZeroesToDeckClassIntegerMaps() {
        Mapper.mapZeroesToDcIntMap(lossesAsClass1st);
        Mapper.mapZeroesToDcIntMap(lossesAsClass2nd);
        Mapper.mapZeroesToDcIntMap(lossesVSClass1st);
        Mapper.mapZeroesToDcIntMap(lossesVSClass2nd);
        Mapper.mapZeroesToDcIntMap(matchesAsClass1st);
        Mapper.mapZeroesToDcIntMap(matchesAsClass2nd);
        Mapper.mapZeroesToDcIntMap(matchesVSClass1st);
        Mapper.mapZeroesToDcIntMap(matchesVSClass2nd);
        Mapper.mapZeroesToDcIntMap(winsAsClass1st);
        Mapper.mapZeroesToDcIntMap(winsAsClass2nd);
        Mapper.mapZeroesToDcIntMap(winsVSClass1st);
        Mapper.mapZeroesToDcIntMap(winsVSClass2nd);
    }

    private void mapZeroesToDeckClassDoubleMaps() {
        Mapper.mapZeroesToDcDoubleMap(winRatioAsClass1st);
        Mapper.mapZeroesToDcDoubleMap(winRatioAsClass2nd);
        Mapper.mapZeroesToDcDoubleMap(winRatioVSClass1st);
        Mapper.mapZeroesToDcDoubleMap(winRatioVSClass2nd);
    }

    /**
     * Returns the HashMap which contains amount of losses where the player went
     * 1st as a specific class
     *
     * @return HashMap where the key is a DeckClass and the value is an Integer
     * of the amount of losses where the player went 1st as a specific class.
     */
    public Map<DeckClass, Integer> getLossesAsClass1st() {
        return lossesAsClass1st;
    }

    /**
     * Returns the HashMap which contains amount of losses where the player went
     * 2nd as a specific class.
     *
     * @return HashMap where the key is a DeckClass and the value is an Integer
     * of the amount of losses where the player went 2nd as a specific class
     */
    public Map<DeckClass, Integer> getLossesAsClass2nd() {
        return lossesAsClass2nd;
    }

    /**
     * Returns the HashMap which contains the amount of losses where the player
     * went 1st against a specific class.
     *
     * @return HashMap where the key is a DeckClass and the value is an Integer
     * of the amount of losses where the player went 1st against a specific
     * class.
     */
    public Map<DeckClass, Integer> getLossesVSClass1st() {
        return lossesVSClass1st;
    }

    /**
     * Returns the HashMap which contains the amount of losses where the player
     * went 2nd against a specific class.
     *
     * @return HashMap where the key is a DeckClass and the value is an Integer
     * of the amount of losses where the player went 2nd against a specific
     * class.
     */
    public Map<DeckClass, Integer> getLossesVSClass2nd() {
        return lossesVSClass2nd;
    }

    /**
     * Returns the HashMap which contains the amount of matches where the player
     * went 1st as a specific class.
     *
     * @return HashMap where the key is a DeckClass and the value is an Integer
     * of the amount of matches where the player went 1st as a specific class.
     */
    public Map<DeckClass, Integer> getMatchesAsClass1st() {
        return matchesAsClass1st;
    }

    /**
     * Returns the HashMap which contains the amount of matches where the player
     * went 2nd as a specific class.
     *
     * @return HashMap where the key is a DeckClass and the value is an Integer
     * of the amount of matches where the player went 2nd as a specific class.
     */
    public Map<DeckClass, Integer> getMatchesAsClass2nd() {
        return matchesAsClass2nd;
    }

    /**
     * Returns the HashMap which contains the amount of matches where the player
     * went 1st against a specific class.
     *
     * @return HashMap where the key is a DeckClass and the value is an Integer
     * of the amount of matches where the player went 1st against a specific
     * class.
     */
    public Map<DeckClass, Integer> getMatchesVSClass1st() {
        return matchesVSClass1st;
    }

    /**
     * Returns the HashMap which contains the amount of matches where the player
     * went 2nd against a specific class.
     *
     * @return HashMap where the key is a DeckClass and the value is an Integer
     * of the amount of matches where the player went 2nd against a specific
     * class.
     */
    public Map<DeckClass, Integer> getMatchesVSClass2nd() {
        return matchesVSClass2nd;
    }

    /**
     * Returns the HashMap which contains the win ratio of playing as a specific
     * class while going 1st.
     *
     * @return HashMap where the key is a DeckClass and the value is an Double
     * signifying the win ratio of playing as a specific class while going 1st.
     */
    public Map<DeckClass, Double> getWinRatioAsClass1st() {
        return winRatioAsClass1st;
    }

    /**
     * Returns the HashMap which contains the win ratio of playing as a specific
     * class while going 2nd.
     *
     * @return HashMap where the key is a DeckClass and the value is an Double
     * signifying the win ratio of playing as a specific class while going 2nd.
     */
    public Map<DeckClass, Double> getWinRatioAsClass2nd() {
        return winRatioAsClass2nd;
    }

    /**
     * Returns the HashMap which contains the win ratio of playing against a
     * specific class while going 1st.
     *
     * @return HashMap where the key is a DeckClass and the value is an Double
     * signifying the win ratio of playing against a specific class while going
     * 1st.
     */
    public Map<DeckClass, Double> getWinRatioVSClass1st() {
        return winRatioVSClass1st;
    }

    /**
     * Returns the HashMap which contains the win ratio of playing against a
     * specific class while going 2nd.
     *
     * @return HashMap where the key is a DeckClass and the value is an Double
     * signifying the win ratio of playing against a specific class while going
     * 2nd.
     */
    public Map<DeckClass, Double> getWinRatioVSClass2nd() {
        return winRatioVSClass2nd;
    }

    /**
     * Returns the HashMap which contains the amount of wins where the player
     * went 1st as a specific class.
     *
     * @return HashMap where the key is a DeckClass and the value is an Integer
     * of the amount of wins where the player went 1st as a specific class.
     */
    public Map<DeckClass, Integer> getWinsAsClass1st() {
        return winsAsClass1st;
    }

    /**
     * Returns the HashMap which contains the amount of wins where the player
     * went 2nd as a specific class.
     *
     * @return HashMap where the key is a DeckClass and the value is an Integer
     * of the amount of wins where the player went 2nd as a specific class.
     */
    public Map<DeckClass, Integer> getWinsAsClass2nd() {
        return winsAsClass2nd;
    }

    /**
     * Returns the HashMap which contains the amount of wins where the player
     * went 1st against a specific class.
     *
     * @return HashMap where the key is a DeckClass and the value is an Integer
     * of the amount of wins where the player went 1st against a specific class.
     */
    public Map<DeckClass, Integer> getWinsVSClass1st() {
        return winsVSClass1st;
    }

    /**
     * Returns the HashMap which contains the amount of wins where the player
     * went 2nd against a specific class.
     *
     * @return HashMap where the key is a DeckClass and the value is an Integer
     * of the amount of wins where the player went 2nd against a specific class.
     */
    public Map<DeckClass, Integer> getWinsVSClass2nd() {
        return winsVSClass2nd;
    }
}
