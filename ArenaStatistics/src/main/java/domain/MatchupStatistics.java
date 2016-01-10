package domain;

import java.util.HashMap;
import java.util.Map;
import util.Mapper;

public class MatchupStatistics {

    private final Map<Matchup, Integer> matchesInClassVSClass1st;
    private final Map<Matchup, Integer> matchesInClassVSClass2nd;
    private final Map<Matchup, Integer> winsInClassVSClass1st;
    private final Map<Matchup, Integer> winsInClassVSClass2nd;
    private final Map<Matchup, Integer> lossesInClassVSClass1st;
    private final Map<Matchup, Integer> lossesInClassVSClass2nd;
    private final Map<Matchup, Double> winPerClassVSClass1st;
    private final Map<Matchup, Double> winPerClassVSClass2nd;

    public MatchupStatistics() {
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
        Mapper.mapZeroesToDcpIntMap(lossesInClassVSClass1st);
        Mapper.mapZeroesToDcpIntMap(lossesInClassVSClass2nd);
        Mapper.mapZeroesToDcpIntMap(matchesInClassVSClass1st);
        Mapper.mapZeroesToDcpIntMap(matchesInClassVSClass2nd);
        Mapper.mapZeroesToDcpIntMap(winsInClassVSClass1st);
        Mapper.mapZeroesToDcpIntMap(winsInClassVSClass2nd);
    }
    
    private void mapZeroesToDeckClassPairDoubleMaps() {
        Mapper.mapZeroesToDcpDoubleMap(winPerClassVSClass1st);
        Mapper.mapZeroesToDcpDoubleMap(winPerClassVSClass2nd);
    }

    public Map<Matchup, Integer> getLossesInClassVSClass1st() {
        return lossesInClassVSClass1st;
    }

    public Map<Matchup, Integer> getLossesInClassVSClass2nd() {
        return lossesInClassVSClass2nd;
    }

    public Map<Matchup, Integer> getMatchesInClassVSClass1st() {
        return matchesInClassVSClass1st;
    }

    public Map<Matchup, Integer> getMatchesInClassVSClass2nd() {
        return matchesInClassVSClass2nd;
    }

    public Map<Matchup, Double> getWinPerClassVSClass1st() {
        return winPerClassVSClass1st;
    }

    public Map<Matchup, Double> getWinPerClassVSClass2nd() {
        return winPerClassVSClass2nd;
    }

    public Map<Matchup, Integer> getWinsInClassVSClass1st() {
        return winsInClassVSClass1st;
    }

    public Map<Matchup, Integer> getWinsInClassVSClass2nd() {
        return winsInClassVSClass2nd;
    }
}
