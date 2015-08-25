package domain;

import java.util.HashMap;
import java.util.Map;
import util.Mapper;

public class DeckClassStatistics {

    private final Map<DeckClass, Integer> decksAsClass;
    private final Map<DeckClass, Integer> winsAsClass;
    private final Map<DeckClass, Double> avgWinsAsClass;
    private final Map<DeckClass, Double> playPerAsClass;

    public DeckClassStatistics() {
        decksAsClass = new HashMap();
        winsAsClass = new HashMap();
        avgWinsAsClass = new HashMap();
        playPerAsClass = new HashMap();
        mapZeroesToValues();
    }
    
    private void mapZeroesToValues() {
        Mapper.mapZeroesToADeckClassIntegerMap(decksAsClass);
        Mapper.mapZeroesToADeckClassIntegerMap(winsAsClass);
        Mapper.mapZeroesToADeckClassDoubleMap(avgWinsAsClass);
        Mapper.mapZeroesToADeckClassDoubleMap(playPerAsClass);
    }

    public Map<DeckClass, Double> getAvgWinsAsClass() {
        return avgWinsAsClass;
    }

    public Map<DeckClass, Integer> getDecksAsClass() {
        return decksAsClass;
    }

    public Map<DeckClass, Double> getPlayPerAsClass() {
        return playPerAsClass;
    }

    public Map<DeckClass, Integer> getWinsAsClass() {
        return winsAsClass;
    }
}
