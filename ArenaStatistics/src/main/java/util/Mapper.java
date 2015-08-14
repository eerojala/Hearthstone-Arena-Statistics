
package util;

import domain.DeckClass;
import domain.DeckClassPair;
import domain.Match;
import java.util.Map;


public class Mapper {
    public static void mapZeroesToADeckClassIntegerMap(Map<DeckClass, Integer> map) {
        for (DeckClass deckClass : DeckClassList.getDeckClassList()) {
            map.put(deckClass, 0);
        }
    }
    
    public static void mapZeroesToADeckClassPairIntegerMap(Map<DeckClassPair, Integer> map) {
        for (DeckClass deckClass1 : DeckClassList.getDeckClassList()) {
            for (DeckClass deckClass2 : DeckClassList.getDeckClassList()) {
                DeckClassPair dcp = new DeckClassPair(deckClass1, deckClass2);
                map.put(dcp, 0);
            }
        }
    }
    
    public static  void mapZeroesToADeckClassDoubleMap(Map<DeckClass, Double> map) {
        for (DeckClass deckClass : DeckClassList.getDeckClassList()) {
            map.put(deckClass, 0.0);
        }
    }
    
    public static void mapZeroesToADeckClassPairDoubleMap(Map<DeckClassPair, Double> map) {
        for (DeckClass deckClass1 : DeckClassList.getDeckClassList()) {
            for (DeckClass deckClass2 : DeckClassList.getDeckClassList()) {
                DeckClassPair dcp = new DeckClassPair(deckClass1, deckClass2);
                map.put(dcp, 0.0);
            }
        }
    }
    
    public static void mapZeroesToIntegerIntegerMap(Map<Integer, Integer> map) {
        for (int i = 1; i <= 12; i++) {
            map.put(i, 0);
        }
    }
    
    public static void mapZeroesToIntegerDoubleMap(Map<Integer,Double> map) {
        for (int i = 1; i <= 12; i++) {
            map.put(i, 0.0);
        }
    }
    
    public static void increaseIntegerInDeckClassIntegerMap(Map<DeckClass, Integer> map, DeckClass deckClass) {
        map.put(deckClass, map.get(deckClass) + 1);
    }
    
    public static void increaseIntegerInDeckClassPairIntegerMap(Match match, Map<DeckClassPair, Integer> map) {
        DeckClassPair dcp = new DeckClassPair(match.getPlayerDeckClass(), match.getOpponentDeckClass());
        map.put(dcp, map.get(dcp) + 1);
    }
    
    public static void updateWinPercentageInDeckClassDoubleMap(Map<DeckClass, Double> doublemap,
            Map<DeckClass, Integer> matchmap, Map<DeckClass, Integer> winmap,
            Map<DeckClass, Integer> lossmap, DeckClass deckClass) {
        int matches = matchmap.get(deckClass);
        int wins = winmap.get(deckClass);
        int losses = lossmap.get(deckClass);
        int disconnects = matches - wins - losses;
        Double winPer = StatisticsHelper.getWinPercentage(matches, wins, losses, disconnects);
        doublemap.put(deckClass, winPer);
    }
    
    public static void updateWinPercentageInDeckClassPairDoubleMap(Match match,
            Map<DeckClassPair, Double> doublemap, Map<DeckClassPair, Integer> matchmap,
            Map<DeckClassPair, Integer> winmap, Map<DeckClassPair, Integer> lossmap) {
        DeckClassPair dcp = new DeckClassPair(match.getPlayerDeckClass(), match.getOpponentDeckClass());
        int matches = matchmap.get(dcp);
        int wins = winmap.get(dcp);
        int losses = lossmap.get(dcp);
        int disconnects = matches - wins - losses;
        Double winPer = StatisticsHelper.getWinPercentage(matches, wins, losses, disconnects);
        doublemap.put(dcp, winPer);
    }
    
    public static void decreaseIntegerInDeckClassIntegerMap(Map<DeckClass, Integer> map, DeckClass deckClass) {
        Integer integer = decreaseInteger(map.get(deckClass));
        map.put(deckClass, integer);
    }
    
    private static int decreaseInteger(Integer integer) {
        if (integer == null || integer <= 0) {
            return 0;
        } else {
            return integer - 1;
        }
    }
    
    public static void decreaseIntegerInDeckClassPairIntegerMap(Match match, Map<DeckClassPair, Integer> map) {
        DeckClassPair dcp = new DeckClassPair(match.getPlayerDeckClass(), match.getOpponentDeckClass());
        Integer integer = decreaseInteger(map.get(dcp));
        map.put(dcp, integer);
    }
    
    public static void increaseIntegerInIntegerIntegerMap(Map<Integer, Integer> map, int key) {
        map.put(key, map.get(key) + 1);
    }
    
    public static void updateAverageInDeckClassDoubleMap(Map<DeckClass, Double> map, 
            DeckClass dc, int int1, int int2) {
        map.put(dc, StatisticsHelper.getAverage(int1, int2));
    }
    
    public static void updateAverageInIntegerDoubleMap(Map<Integer, Double> map,
            int key, int int1, int int2) {
        map.put(key, StatisticsHelper.getAverage(int1, int2));
    }
    
    public static void decreaseIntegerInIntegerIntegerMaps(Map<Integer, Integer> map, int key) {
        map.put(key, map.get(key) - 1);
    }
}
