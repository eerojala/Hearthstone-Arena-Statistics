
package util;

import domain.DeckClass;
import domain.DeckClassPair;
import domain.Match;
import java.util.List;
import java.util.Map;


public class Mapper {
    private static DeckClass[] dcArray = DeckClass.values();
    
    public static void mapZeroesToADeckClassIntegerMap(Map<DeckClass, Integer> map) {
        for (DeckClass deckClass : dcArray) {
            map.put(deckClass, 0);
        }
    }
    
    public static void mapZeroesToADeckClassPairIntegerMap(Map<DeckClassPair, Integer> map) {
        for (DeckClass deckClass1 : dcArray) {
            for (DeckClass deckClass2 : dcArray) {
                DeckClassPair dcp = new DeckClassPair(deckClass1, deckClass2);
                map.put(dcp, 0);
            }
        }
    }
    
    public static  void mapZeroesToADeckClassDoubleMap(Map<DeckClass, Double> map) {
        for (DeckClass deckClass : dcArray) {
            map.put(deckClass, 0.0);
        }
    }
    
    public static void mapZeroesToADeckClassPairDoubleMap(Map<DeckClassPair, Double> map) {
        for (DeckClass deckClass1 : dcArray) {
            for (DeckClass deckClass2 : dcArray) {
                DeckClassPair dcp = new DeckClassPair(deckClass1, deckClass2);
                map.put(dcp, 0.0);
            }
        }
    }
    
    public static void mapZeroesToIntegerIntegerMap(Map<Integer, Integer> map) {
        for (int i = 0; i <= 12; i++) {
            map.put(i, 0);
        }
    }
    
    public static void mapZeroesToIntegerDoubleMap(Map<Integer,Double> map) {
        for (int i = 0; i <= 12; i++) {
            map.put(i, 0.0);
        }
    }
    
    public static void increaseIntegerInDeckClassIntegerMap(Map<DeckClass, Integer> map, DeckClass dc) {
        increaseIntegerInDeckClassIntegerMap(map, dc, 1);
    }
    
    public static void increaseIntegerInDeckClassPairIntegerMap(Map<DeckClassPair, Integer> map, DeckClassPair dcp) {
        map.put(dcp, map.get(dcp) + 1);
    }
    
    public static void updateWinPercentageInDeckClassDoubleMap(Map<DeckClass, Double> doublemap,
            Map<DeckClass, Integer> matchmap, Map<DeckClass, Integer> winmap,
            Map<DeckClass, Integer> lossmap, DeckClass deckClass) {
        int wins = winmap.get(deckClass);
        int losses = lossmap.get(deckClass);
        int validMatches = wins + losses;
        Double winPer = StatisticsHelper.getWinPercentage(validMatches, wins);
        doublemap.put(deckClass, winPer);
    }
    
    public static void updateWinPercentageInDeckClassPairDoubleMap(Map<DeckClassPair, Double> doublemap,
            Map<DeckClassPair, Integer> matchmap, Map<DeckClassPair, Integer> winmap, 
            Map<DeckClassPair, Integer> lossmap, DeckClassPair dcp) {
        int wins = winmap.get(dcp);
        int losses = lossmap.get(dcp);
        int validMatches = wins + losses;
        Double winPer = StatisticsHelper.getWinPercentage(validMatches, wins);
        doublemap.put(dcp, winPer);
    }
    
    public static void decreaseIntegerInDeckClassIntegerMap(Map<DeckClass, Integer> map, DeckClass dc) {
        decreaseIntegerInDeckClassIntegerMap(map, dc, 1);
    }
    
    private static int decreaseInteger(Integer integer) {
        if (integer == null || integer <= 0) {
            return 0;
        } else {
            return integer - 1;
        }
    }
    
    public static void decreaseIntegerInDeckClassPairIntegerMap(Map<DeckClassPair, Integer> map, DeckClassPair dcp) {
        map.put(dcp, decreaseInteger(map.get(dcp)));
    }
    
    public static void increaseIntegerInIntegerIntegerMap(Map<Integer, Integer> map, int key) {
        increaseIntegerInIntegerIntegerMap(map, key, 1);
    }
    
    public static void updateAverageInDeckClassDoubleMap(Map<DeckClass, Double> map, 
            DeckClass dc, int numerator, int divisor) {
        map.put(dc, StatisticsHelper.getAverage(numerator, divisor));
    }
    
    public static void updateAverageInIntegerDoubleMap(Map<Integer, Double> map,
            int key, int numerator, int divisor) {
        map.put(key, StatisticsHelper.getAverage(numerator, divisor));
        }
    
    public static void decreaseIntegerInIntegerIntegerMap(Map<Integer, Integer> map, int key) {
        decreaseIntegerInIntegerIntegerMap(map, key, 1);
    }
    
    public static void increaseIntegerInIntegerIntegerMap(Map<Integer, Integer> map, int key, int x) {
        map.put(key, map.get(key) + x);
    }
    
    public static void decreaseIntegerInIntegerIntegerMap(Map<Integer, Integer> map, int key, int x) {
        int value = map.get(key) - x;
        if (value < 0) {
            value = 0;
        }
        map.put(key, value);
    }
    
    public static void increaseIntegerInDeckClassIntegerMap(Map<DeckClass, Integer> map, DeckClass key, int x) {
        map.put(key, map.get(key) + x);
    }
    
    public static void decreaseIntegerInDeckClassIntegerMap(Map<DeckClass, Integer> map , DeckClass key, int x) {
        int value = map.get(key) - x;
        if (value < 0) {
            value = 0;
        }
        map.put(key, value);
    }
    
    
    
}
