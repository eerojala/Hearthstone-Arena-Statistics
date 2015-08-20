package domain;

import java.util.HashMap;
import java.util.Map;
import util.Mapper;

public class ClassStatistics {

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
    private final Map<DeckClass, Double> winPerVSClass1st;
    private final Map<DeckClass, Double> winPerVSClass2nd;
    private final Map<DeckClass, Double> winPerAsClass1st;
    private final Map<DeckClass, Double> winPerAsClass2nd;

    public ClassStatistics() {
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
        winPerVSClass1st = new HashMap();
        winPerVSClass2nd = new HashMap();
        winPerAsClass1st = new HashMap();
        winPerAsClass2nd = new HashMap();
        mapZeroesToValues();
    }

    private void mapZeroesToValues() {
        mapZeroesToDeckClassIntegerMaps();
        mapZeroesToDeckClassDoubleMaps();
    }

    private void mapZeroesToDeckClassIntegerMaps() {
        Mapper.mapZeroesToADeckClassIntegerMap(lossesAsClass1st);
        Mapper.mapZeroesToADeckClassIntegerMap(lossesAsClass2nd);
        Mapper.mapZeroesToADeckClassIntegerMap(lossesVSClass1st);
        Mapper.mapZeroesToADeckClassIntegerMap(lossesVSClass2nd);
        Mapper.mapZeroesToADeckClassIntegerMap(matchesAsClass1st);
        Mapper.mapZeroesToADeckClassIntegerMap(matchesAsClass2nd);
        Mapper.mapZeroesToADeckClassIntegerMap(matchesVSClass1st);
        Mapper.mapZeroesToADeckClassIntegerMap(matchesVSClass2nd);
        Mapper.mapZeroesToADeckClassIntegerMap(winsAsClass1st);
        Mapper.mapZeroesToADeckClassIntegerMap(winsAsClass2nd);
        Mapper.mapZeroesToADeckClassIntegerMap(winsVSClass1st);
        Mapper.mapZeroesToADeckClassIntegerMap(winsVSClass2nd);
    }

    private void mapZeroesToDeckClassDoubleMaps() {
        Mapper.mapZeroesToADeckClassDoubleMap(winPerAsClass1st);
        Mapper.mapZeroesToADeckClassDoubleMap(winPerAsClass2nd);
        Mapper.mapZeroesToADeckClassDoubleMap(winPerVSClass1st);
        Mapper.mapZeroesToADeckClassDoubleMap(winPerVSClass2nd);
    }

    public Map<DeckClass, Integer> getLossesAsClass1st() {
        return lossesAsClass1st;
    }

    public Map<DeckClass, Integer> getLossesAsClass2nd() {
        return lossesAsClass2nd;
    }

    public Map<DeckClass, Integer> getLossesVSClass1st() {
        return lossesVSClass1st;
    }

    public Map<DeckClass, Integer> getLossesVSClass2nd() {
        return lossesVSClass2nd;
    }

    public Map<DeckClass, Integer> getMatchesAsClass1st() {
        return matchesAsClass1st;
    }

    public Map<DeckClass, Integer> getMatchesAsClass2nd() {
        return matchesAsClass2nd;
    }

    public Map<DeckClass, Integer> getMatchesVSClass1st() {
        return matchesVSClass1st;
    }

    public Map<DeckClass, Integer> getMatchesVSClass2nd() {
        return matchesVSClass2nd;
    }

    public Map<DeckClass, Double> getWinPerAsClass1st() {
        return winPerAsClass1st;
    }

    public Map<DeckClass, Double> getWinPerAsClass2nd() {
        return winPerAsClass2nd;
    }

    public Map<DeckClass, Double> getWinPerVSClass1st() {
        return winPerVSClass1st;
    }

    public Map<DeckClass, Double> getWinPerVSClass2nd() {
        return winPerVSClass2nd;
    }

    public Map<DeckClass, Integer> getWinsAsClass1st() {
        return winsAsClass1st;
    }

    public Map<DeckClass, Integer> getWinsAsClass2nd() {
        return winsAsClass2nd;
    }

    public Map<DeckClass, Integer> getWinsVSClass1st() {
        return winsVSClass1st;
    }

    public Map<DeckClass, Integer> getWinsVSClass2nd() {
        return winsVSClass2nd;
    }  
}
