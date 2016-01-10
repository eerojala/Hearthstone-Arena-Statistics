package domain;

import java.util.HashMap;
import java.util.Map;
import util.Mapper;

public class DeckScoreStatistics {

    private final Map<DeckClass, Double> avgWinsAsClass;
    private final Map<DeckClass, Double> playPerAsClass;
    private final Map<DeckClass, Map<Integer, Integer>> decksWithXWinsAsClass;

    public DeckScoreStatistics() {
        avgWinsAsClass = new HashMap();
        playPerAsClass = new HashMap();
        decksWithXWinsAsClass = new HashMap();
        mapZeroesToValues();
    }
    
    private void mapZeroesToValues() {
        Mapper.mapZeroesToDcDoubleMap(avgWinsAsClass);
        Mapper.mapZeroesToDcDoubleMap(playPerAsClass);
        Mapper.mapZeroesToDcIntIntMapMap(decksWithXWinsAsClass);
    }

    public Map<DeckClass, Double> getAvgWinsAsClass() {
        return avgWinsAsClass;
    }

    public Map<DeckClass, Double> getPlayPerAsClass() {
        return playPerAsClass;
    }

    public Map<DeckClass, Map<Integer, Integer>> getDecksWithXWinsAsClass() {
        return decksWithXWinsAsClass;
    }
}
