package domain;

import java.util.HashMap;
import java.util.Map;
import util.Mapper;

/**
 * Class that contains HashMaps which store matchup-specifc statistics.
 */
public class MatchupStatistics {

    private final Map<Matchup, Integer> matchesInMatchup1st;
    private final Map<Matchup, Integer> matchesInMatchup2nd;
    private final Map<Matchup, Integer> winsInMatchup1st;
    private final Map<Matchup, Integer> winsInMatchup2nd;
    private final Map<Matchup, Integer> lossesInMatchup1st;
    private final Map<Matchup, Integer> lossesInMatchup2nd;
    private final Map<Matchup, Double> MatchupWinRatio1st;
    private final Map<Matchup, Double> MatchupWinRatio2nd;

    /**
     * Creates a new MatchupStatistics
     */
    public MatchupStatistics() {
        matchesInMatchup1st = new HashMap();
        matchesInMatchup2nd = new HashMap();
        winsInMatchup1st = new HashMap();
        winsInMatchup2nd = new HashMap();
        lossesInMatchup1st = new HashMap();
        lossesInMatchup2nd = new HashMap();
        MatchupWinRatio1st = new HashMap();
        MatchupWinRatio2nd = new HashMap();
        mapZeroesToValues();
    }

    private void mapZeroesToValues() {
        mapZeroesToDeckClassPairIntegerMaps();
        mapZeroesToDeckClassPairDoubleMaps();
    }

    private void mapZeroesToDeckClassPairIntegerMaps() {
        Mapper.mapZeroesToDcpIntMap(lossesInMatchup1st);
        Mapper.mapZeroesToDcpIntMap(lossesInMatchup2nd);
        Mapper.mapZeroesToDcpIntMap(matchesInMatchup1st);
        Mapper.mapZeroesToDcpIntMap(matchesInMatchup2nd);
        Mapper.mapZeroesToDcpIntMap(winsInMatchup1st);
        Mapper.mapZeroesToDcpIntMap(winsInMatchup2nd);
    }

    private void mapZeroesToDeckClassPairDoubleMaps() {
        Mapper.mapZeroesToDcpDoubleMap(MatchupWinRatio1st);
        Mapper.mapZeroesToDcpDoubleMap(MatchupWinRatio2nd);
    }

    /**
     * Returns the HashMap which contains the amount of losses in a specific
     * matchup where the player went 1st.
     *
     * @return HashMap where the key is a Matchup and the value is an Integer of
     * the amount of losses in a specific matchup where the player went 1st.
     */
    public Map<Matchup, Integer> getLossesInMatchup1st() {
        return lossesInMatchup1st;
    }

    /**
     * Returns the HashMap which contains the amount of losses in a specific
     * matchup where the player went 2nd.
     *
     * @return HashMap where the key is a Matchup and the value is an Integer of
     * the amount of losses in a specific matchup where the player went 2nd.
     */
    public Map<Matchup, Integer> getLossesInMatchup2nd() {
        return lossesInMatchup2nd;
    }

    /**
     * Returns the HashMap which contains the amount of matches in a specific
     * matchup where the player went 1st.
     *
     * @return HashMap where the key is a Matchup and the value is an Integer of
     * the amount of matches in a specific matchup where the player went 1st.
     */
    public Map<Matchup, Integer> getMatchesInMatchup1st() {
        return matchesInMatchup1st;
    }

    /**
     * Returns the HashMap which contains the amount of matches in a specific
     * matchup where the player went 2nd.
     *
     * @return HashMap where the key is a Matchup and the value is an Integer of
     * the amount of matches in a specific matchup where the player went 2nd.
     */
    public Map<Matchup, Integer> getMatchesInMatchup2nd() {
        return matchesInMatchup2nd;
    }

    /**
     * Returns the HashMap which contains the win ratio of a specific matchup
     * where the player went 1st.
     *
     * @return HashMap where the key is a Matchup and the value is a Double
     * signifying the win ratio of a specific mathup where the player went 1st.
     */
    public Map<Matchup, Double> getMatchupWinRatio1st() {
        return MatchupWinRatio1st;
    }

    /**
     * Returns the HashMap which contains the win ratio of a specific matchup
     * where the player went 2nd.
     *
     * @return HashMap where the key is a Matchup and the value is a Double
     * signifying the win ratio of a specific mathup where the player went 2nd.
     */
    public Map<Matchup, Double> getMatchupWinRatio2nd() {
        return MatchupWinRatio2nd;
    }

    /**
     * Returns the HashMap which contains the amount of wins in a specific
     * matchup where the player went 1st.
     *
     * @return HashMap where the key is a Matchup and the value is an Integer of
     * the amount of wins in a specific matchup where the player went 1st.
     */
    public Map<Matchup, Integer> getWinsInMatchup1st() {
        return winsInMatchup1st;
    }

    /**
     * Returns the HashMap which contains the amount of wins in a specific
     * matchup where the player went 1st.
     *
     * @return HashMap where the key is a Matchup and the value is an Integer of
     * the amount of wins in a specific matchup where the player went 2nd.
     */
    public Map<Matchup, Integer> getWinsInMatchup2nd() {
        return winsInMatchup2nd;
    }
}
