package domain;

import java.util.HashMap;
import java.util.Map;
import util.Mapper;

public class ClassVsClassStatistics {

    private final Map<DeckClassPair, Integer> matchesInClassVSClass1st;
    private final Map<DeckClassPair, Integer> matchesInClassVSClass2nd;
    private final Map<DeckClassPair, Integer> winsInClassVSClass1st;
    private final Map<DeckClassPair, Integer> winsInClassVSClass2nd;
    private final Map<DeckClassPair, Integer> lossesInClassVSClass1st;
    private final Map<DeckClassPair, Integer> lossesInClassVSClass2nd;
    private final Map<DeckClassPair, Double> winPerClassVSClass1st;
    private final Map<DeckClassPair, Double> winPerClassVSClass2nd;

    public ClassVsClassStatistics() {
        matchesInClassVSClass1st = new HashMap();
        matchesInClassVSClass2nd = new HashMap();
        winsInClassVSClass1st = new HashMap();
        winsInClassVSClass2nd = new HashMap();
        lossesInClassVSClass1st = new HashMap();
        lossesInClassVSClass2nd = new HashMap();
        winPerClassVSClass1st = new HashMap();
        winPerClassVSClass2nd = new HashMap();
        mapZeroesToValues();
    }

    private void mapZeroesToValues() {
        mapZeroesToDeckClassPairIntegerMaps();
        mapZeroesToDeckClassPairDoubleMaps();
    }
    
    private void mapZeroesToDeckClassPairIntegerMaps() {
        Mapper.mapZeroesToADeckClassPairIntegerMap(lossesInClassVSClass1st);
        Mapper.mapZeroesToADeckClassPairIntegerMap(lossesInClassVSClass2nd);
        Mapper.mapZeroesToADeckClassPairIntegerMap(matchesInClassVSClass1st);
        Mapper.mapZeroesToADeckClassPairIntegerMap(matchesInClassVSClass2nd);
        Mapper.mapZeroesToADeckClassPairIntegerMap(winsInClassVSClass1st);
        Mapper.mapZeroesToADeckClassPairIntegerMap(winsInClassVSClass2nd);
    }
    
    private void mapZeroesToDeckClassPairDoubleMaps() {
        Mapper.mapZeroesToADeckClassPairDoubleMap(winPerClassVSClass1st);
        Mapper.mapZeroesToADeckClassPairDoubleMap(winPerClassVSClass2nd);
    }

    public Map<DeckClassPair, Integer> getLossesInClassVSClass1st() {
        return lossesInClassVSClass1st;
    }

    public Map<DeckClassPair, Integer> getLossesInClassVSClass2nd() {
        return lossesInClassVSClass2nd;
    }

    public Map<DeckClassPair, Integer> getMatchesInClassVSClass1st() {
        return matchesInClassVSClass1st;
    }

    public Map<DeckClassPair, Integer> getMatchesInClassVSClass2nd() {
        return matchesInClassVSClass2nd;
    }

    public Map<DeckClassPair, Double> getWinPerClassVSClass1st() {
        return winPerClassVSClass1st;
    }

    public Map<DeckClassPair, Double> getWinPerClassVSClass2nd() {
        return winPerClassVSClass2nd;
    }

    public Map<DeckClassPair, Integer> getWinsInClassVSClass1st() {
        return winsInClassVSClass1st;
    }

    public Map<DeckClassPair, Integer> getWinsInClassVSClass2nd() {
        return winsInClassVSClass2nd;
    }
}
