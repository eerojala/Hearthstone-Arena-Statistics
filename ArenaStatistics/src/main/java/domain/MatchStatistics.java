package domain;

import java.util.HashMap;
import java.util.Map;
import util.DeckClassList;

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
        mapZeroesToADeckClassIntegerMap(lossesAsClass1st);
        mapZeroesToADeckClassIntegerMap(lossesAsClass2nd);
        mapZeroesToADeckClassIntegerMap(lossesVSClass1st);
        mapZeroesToADeckClassIntegerMap(lossesVSClass2nd);
        mapZeroesToADeckClassIntegerMap(matchesAsClass1st);
        mapZeroesToADeckClassIntegerMap(matchesAsClass2nd);
        mapZeroesToADeckClassIntegerMap(matchesVSClass1st);
        mapZeroesToADeckClassIntegerMap(matchesVSClass2nd);
        mapZeroesToADeckClassIntegerMap(winsAsClass1st);
        mapZeroesToADeckClassIntegerMap(winsAsClass2nd);
        mapZeroesToADeckClassIntegerMap(winsVSClass1st);
        mapZeroesToADeckClassIntegerMap(winsVSClass2nd);
    }

    private void mapZeroesToADeckClassIntegerMap(Map<DeckClass, Integer> map) {
        for (DeckClass deckClass : DeckClassList.getDeckClassList()) {
            map.put(deckClass, 0);
        }
    }

    private void mapZeroesToDeckClassPairIntegerMaps() {
        mapZeroesToADeckClassPairIntegerMap(lossesInClassVSClass1st);
        mapZeroesToADeckClassPairIntegerMap(lossesInClassVSClass2nd);
        mapZeroesToADeckClassPairIntegerMap(matchesInClassVSClass1st);
        mapZeroesToADeckClassPairIntegerMap(matchesInClassVSClass2nd);
        mapZeroesToADeckClassPairIntegerMap(winsInClassVSClass1st);
        mapZeroesToADeckClassPairIntegerMap(winsInClassVSClass2nd);
    }

    private void mapZeroesToADeckClassPairIntegerMap(Map<DeckClassPair, Integer> map) {
        for (DeckClass deckClass1 : DeckClassList.getDeckClassList()) {
            for (DeckClass deckClass2 : DeckClassList.getDeckClassList()) {
                DeckClassPair dcp = new DeckClassPair(deckClass1, deckClass2);
                map.put(dcp, 0);
            }
        }
    }
    
    private void mapZeroesToDeckClassDoubleMaps() {
        mapZeroesToADeckClassDoubleMap(winPerAsClass1st);
        mapZeroesToADeckClassDoubleMap(winPerAsClass2nd);
        mapZeroesToADeckClassDoubleMap(winPerVSClass1st);
        mapZeroesToADeckClassDoubleMap(winPerVSClass2nd);
    }
    
    private void mapZeroesToADeckClassDoubleMap(Map<DeckClass, Double> map) {
        for (DeckClass deckClass : DeckClassList.getDeckClassList()) {
            map.put(deckClass, 0.0);
        }
    }
    
    private void mapZeroesToDeckClassPairDoubleMaps() {
        mapZeroesToADeckClassPairDoubleMap(winPerClassVSClass1st);
        mapZeroesToADeckClassPairDoubleMap(winPerClassVSClass2nd);
    }
    
    private void mapZeroesToADeckClassPairDoubleMap(Map<DeckClassPair, Double> map) {
        for (DeckClass deckClass1 : DeckClassList.getDeckClassList()) {
            for (DeckClass deckClass2 : DeckClassList.getDeckClassList()) {
                DeckClassPair dcp = new DeckClassPair(deckClass1, deckClass2);
                map.put(dcp, 0.0);
            }
        }
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
