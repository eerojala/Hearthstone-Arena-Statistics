package util;

import domain.DeckClass;
import domain.DeckClassPair;
import domain.Match;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapper {

    private static DeckClass[] dcArray = DeckClass.values();

    public static void mapZeroesToDcIntMap(Map<DeckClass, Integer> map) {
        for (DeckClass deckClass : dcArray) {
            map.put(deckClass, 0);
        }
    }

    public static void mapZeroesToDcpIntMap(Map<DeckClassPair, Integer> map) {
        for (DeckClass deckClass1 : dcArray) {
            for (DeckClass deckClass2 : dcArray) {
                DeckClassPair dcp = new DeckClassPair(deckClass1, deckClass2);
                map.put(dcp, 0);
            }
        }
    }

    public static void mapZeroesToDcDoubleMap(Map<DeckClass, Double> map) {
        for (DeckClass deckClass : dcArray) {
            map.put(deckClass, 0.0);
        }
    }

    public static void mapZeroesToDcpDoubleMap(Map<DeckClassPair, Double> map) {
        for (DeckClass deckClass1 : dcArray) {
            for (DeckClass deckClass2 : dcArray) {
                DeckClassPair dcp = new DeckClassPair(deckClass1, deckClass2);
                map.put(dcp, 0.0);
            }
        }
    }

    public static void mapZeroesToIntIntMap(Map<Integer, Integer> map) {
        for (int i = 0; i < 13; i++) {
            map.put(i, 0);
        }
    }

    public static void mapZeroesToIntDoubleMap(Map<Integer, Double> map) {
        for (int i = 0; i < 13; i++) {
            map.put(i, 0.0);
        }
    }

    public static void mapZeroesToDcIntIntMapMap(Map<DeckClass, Map<Integer, Integer>> map) {
        for (DeckClass dc : DeckClass.values()) {
            Map<Integer, Integer> subMap = new HashMap();
            mapZeroesToIntIntMap(subMap);
            map.put(dc, subMap);
        }
    }

    public static void increaseIntegerInDcIntMap(Map<DeckClass, Integer> map, DeckClass dc) {
        increaseIntegerInDcIntMap(map, dc, 1);
    }

    public static void increaseIntegerInDcpIntMap(Map<DeckClassPair, Integer> map, DeckClassPair dcp) {
        map.put(dcp, map.get(dcp) + 1);
    }

    public static void updateWinPercentageInDcDoubleMap(Map<DeckClass, Double> doublemap,
            Map<DeckClass, Integer> matchmap, Map<DeckClass, Integer> winmap,
            Map<DeckClass, Integer> lossmap, DeckClass deckClass) {
        int wins = winmap.get(deckClass);
        int losses = lossmap.get(deckClass);
        int validMatches = wins + losses;
        Double winPer = StatisticsHelper.getWinPercentage(validMatches, wins);
        doublemap.put(deckClass, winPer);
    }

    public static void updateWinPercentageInDcpDoubleMap(Map<DeckClassPair, Double> doublemap,
            Map<DeckClassPair, Integer> matchmap, Map<DeckClassPair, Integer> winmap,
            Map<DeckClassPair, Integer> lossmap, DeckClassPair dcp) {
        int wins = winmap.get(dcp);
        int losses = lossmap.get(dcp);
        int validMatches = wins + losses;
        Double winPer = StatisticsHelper.getWinPercentage(validMatches, wins);
        doublemap.put(dcp, winPer);
    }

    public static void decreaseIntegerInDcIntMap(Map<DeckClass, Integer> map, DeckClass dc) {
        decreaseIntegerInDcIntMap(map, dc, 1);
    }

    private static int decreaseInteger(Integer integer) {
        if (integer == null || integer <= 0) {
            return 0;
        } else {
            return integer - 1;
        }
    }

    public static void decreaseIntegerInDcpIntMap(Map<DeckClassPair, Integer> map, DeckClassPair dcp) {
        map.put(dcp, decreaseInteger(map.get(dcp)));
    }

    public static void increaseIntegerInIntIntMap(Map<Integer, Integer> map, int key) {
        increaseIntegerInIntIntMap(map, key, 1);
    }

    public static void updateAverageInDcDoubleMap(Map<DeckClass, Double> map,
            DeckClass dc, int numerator, int divisor) {
        map.put(dc, StatisticsHelper.getAverage(numerator, divisor));
    }

    public static void updateAverageInIntDoubleMap(Map<Integer, Double> map,
            int key, int numerator, int divisor) {
        map.put(key, StatisticsHelper.getAverage(numerator, divisor));
    }

    public static void decreaseIntegerInIntIntMap(Map<Integer, Integer> map, int key) {
        decreaseIntegerInIntIntMap(map, key, 1);
    }

    public static void increaseIntegerInIntIntMap(Map<Integer, Integer> map, int key, int x) {
        map.put(key, map.get(key) + x);
    }

    public static void decreaseIntegerInIntIntMap(Map<Integer, Integer> map, int key, int x) {
        int value = decreaseInteger(map.get(key), x);
        map.put(key, value);
    }

    private static int decreaseInteger(int value, int x) {
        int newValue = value - x;
        if (newValue < 0) {
            return 0;
        }
        return newValue;
    }

    public static void increaseIntegerInDcIntMap(Map<DeckClass, Integer> map, DeckClass key, int x) {
        map.put(key, map.get(key) + x);
    }

    public static void decreaseIntegerInDcIntMap(Map<DeckClass, Integer> map, DeckClass key, int x) {
        int value = decreaseInteger(map.get(key), x);
        map.put(key, value);
    }

    public static void increaseIntegerInDcIntIntMapMap(Map<DeckClass, Map<Integer, Integer>> map,
            DeckClass dcKey, int intKey, int x) {
        Map<Integer, Integer> intIntMap = map.get(dcKey);
        increaseIntegerInIntIntMap(intIntMap, intKey, x);
        map.put(dcKey, intIntMap);
    }

    public static void increaseIntegerInDcIntIntMapMap(Map<DeckClass, Map<Integer, Integer>> map,
            DeckClass dcKey, int intKey) {
        increaseIntegerInDcIntIntMapMap(map, dcKey, intKey, 1);
    }

    public static void decreaseIntegerInDcIntIntMapMap(Map<DeckClass, Map<Integer, Integer>> map,
            DeckClass dcKey, int intKey, int x) {
        Map<Integer, Integer> intIntMap = map.get(dcKey);
        decreaseIntegerInIntIntMap(intIntMap, intKey, x);
        map.put(dcKey, intIntMap);
    }

    public static void decreaseIntegerInDcIntIntMapMap(Map<DeckClass, Map<Integer, Integer>> map,
            DeckClass dcKey, int intKey) {
        decreaseIntegerInDcIntIntMapMap(map, dcKey, intKey, 1);
    }
}
