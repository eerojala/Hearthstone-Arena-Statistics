package domain;

import java.util.HashMap;
import java.util.Map;
import util.Mapper;

public class MatchStatistics {

    private final Map<DeckClass, Integer> matchesVSClass1st;
    private final Map<DeckClass, Integer> matchesVSClass2nd;
    private final Map<DeckClass, Integer> matchesAsClass1st;
    private final Map<DeckClass, Integer> matchesAsClass2nd;
    private final Map<DeckClass, Integer> winsAsClass1st;
    private final Map<DeckClass, Integer> winsAsClass2nd;
    private final Map<DeckClass, Integer> lossesAsClass1st;
    private final Map<DeckClass, Integer> lossesAsClass2nd;
    private final Map<DeckClass, Integer> winsVSClass1st;
    private final Map<DeckClass, Integer> winsVSClass2nd;
    private final Map<DeckClass, Integer> lossesVSClass1st;
    private final Map<DeckClass, Integer> lossesVSClass2nd;
    private final Map<DeckClassPair, Integer> matchesInClassVSClass1st;
    private final Map<DeckClassPair, Integer> matchesInClassVSClass2nd;
    private final Map<DeckClassPair, Integer> winsInClassVSClass1st;
    private final Map<DeckClassPair, Integer> winsInClassVSClass2nd;
    private final Map<DeckClassPair, Integer> lossesInClassVSClass1st;
    private final Map<DeckClassPair, Integer> lossesInClassVSClass2nd;
    private final Map<DeckClass, Double> winPerVSClass1st;
    private final Map<DeckClass, Double> winPerVSClass2nd;
    private final Map<DeckClass, Double> winPerAsClass1st;
    private final Map<DeckClass, Double> winPerAsClass2nd;
    private final Map<DeckClassPair, Double> winPerClassVSClass1st;
    private final Map<DeckClassPair, Double> winPerClassVSClass2nd;

    public MatchStatistics() {
        matchesVSClass1st = new HashMap();
        matchesVSClass2nd = new HashMap();
        matchesAsClass1st = new HashMap();
        matchesAsClass2nd = new HashMap();
        winsAsClass1st = new HashMap();
        winsAsClass2nd = new HashMap();
        lossesAsClass1st = new HashMap();
        lossesAsClass2nd = new HashMap();
        winsVSClass1st = new HashMap();
        winsVSClass2nd = new HashMap();
        lossesVSClass1st = new HashMap();
        lossesVSClass2nd = new HashMap();
        matchesInClassVSClass1st = new HashMap();
        matchesInClassVSClass2nd = new HashMap();
        winsInClassVSClass1st = new HashMap();
        winsInClassVSClass2nd = new HashMap();
        lossesInClassVSClass1st = new HashMap();
        lossesInClassVSClass2nd = new HashMap();
        winPerVSClass1st = new HashMap();
        winPerVSClass2nd = new HashMap();
        winPerAsClass1st = new HashMap();
        winPerAsClass2nd = new HashMap();
        winPerClassVSClass1st = new HashMap();
        winPerClassVSClass2nd = new HashMap();
        mapZeroesToValues();
    }

    private void mapZeroesToValues() {
        mapZeroesToDeckClassIntegerMaps();
        mapZeroesToDeckClassPairIntegerMaps();
        mapZeroesToDeckClassDoubleMaps();
        mapZeroesToDeckClassPairDoubleMaps();
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

    private void mapZeroesToDeckClassPairIntegerMaps() {
        Mapper.mapZeroesToDcpIntMap(lossesInClassVSClass1st);
        Mapper.mapZeroesToDcpIntMap(lossesInClassVSClass2nd);
        Mapper.mapZeroesToDcpIntMap(matchesInClassVSClass1st);
        Mapper.mapZeroesToDcpIntMap(matchesInClassVSClass2nd);
        Mapper.mapZeroesToDcpIntMap(winsInClassVSClass1st);
        Mapper.mapZeroesToDcpIntMap(winsInClassVSClass2nd);
    }

    private void mapZeroesToDeckClassDoubleMaps() {
        Mapper.mapZeroesToDcDoubleMap(winPerAsClass1st);
        Mapper.mapZeroesToDcDoubleMap(winPerAsClass2nd);
        Mapper.mapZeroesToDcDoubleMap(winPerVSClass1st);
        Mapper.mapZeroesToDcDoubleMap(winPerVSClass2nd);
    }

    private void mapZeroesToDeckClassPairDoubleMaps() {
        Mapper.mapZeroesToDcpDoubleMap(winPerClassVSClass1st);
        Mapper.mapZeroesToDcpDoubleMap(winPerClassVSClass2nd);
    }

    public Map<DeckClass, Integer> getMatchesAsClass1st() {
        return matchesAsClass1st;
    }

    public Map<DeckClass, Integer> getMatchesAsClass2nd() {
        return matchesAsClass2nd;
    }

    public Map<DeckClassPair, Integer> getMatchesInClassVSClass1st() {
        return matchesInClassVSClass1st;
    }

    public Map<DeckClassPair, Integer> getMatchesInClassVSClass2nd() {
        return matchesInClassVSClass2nd;
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

    public Map<DeckClassPair, Double> getWinPerClassVSClass1st() {
        return winPerClassVSClass1st;
    }

    public Map<DeckClass, Double> getWinPerAsClass2nd() {
        return winPerAsClass2nd;
    }

    public Map<DeckClassPair, Double> getWinPerClassVSClass2nd() {
        return winPerClassVSClass2nd;
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

    public Map<DeckClassPair, Integer> getWinsInClassVSClass1st() {
        return winsInClassVSClass1st;
    }

    public Map<DeckClassPair, Integer> getWinsInClassVSClass2nd() {
        return winsInClassVSClass2nd;
    }

    public Map<DeckClass, Integer> getWinsVSClass1st() {
        return winsVSClass1st;
    }

    public Map<DeckClass, Integer> getWinsVSClass2nd() {
        return winsVSClass2nd;
    }

    public Map<DeckClass, Integer> getLossesAsClass1st() {
        return lossesAsClass1st;
    }

    public Map<DeckClass, Integer> getLossesAsClass2nd() {
        return lossesAsClass2nd;
    }

    public Map<DeckClassPair, Integer> getLossesInClassVSClass1st() {
        return lossesInClassVSClass1st;
    }

    public Map<DeckClassPair, Integer> getLossesInClassVSClass2nd() {
        return lossesInClassVSClass2nd;
    }

    public Map<DeckClass, Integer> getLossesVSClass1st() {
        return lossesVSClass1st;
    }

    public Map<DeckClass, Integer> getLossesVSClass2nd() {
        return lossesVSClass2nd;
    }

}
