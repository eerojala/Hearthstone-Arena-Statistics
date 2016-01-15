package util;

import domain.DeckClass;
import domain.Matchup;
import java.util.HashMap;
import java.util.Map;

/**
 * Class which handles Map values.
 */
public class Mapper {

    private static final DeckClass[] dcArray = DeckClass.values();

    /**
     * Inputs 0s as values to every DeckClass key in a Map which has a DeckClass
     * as key and Integer as value.
     *
     * @param map Map
     */
    public static void mapZeroesToDcIntMap(Map<DeckClass, Integer> map) {
        for (DeckClass deckClass : dcArray) {
            map.put(deckClass, 0);
        }
    }

    /**
     * Inputs 0s as values to every Matchup key in a Map which has a Matchup as
     * key and Integer as value.
     *
     * @param map Map
     */
    public static void mapZeroesToMatchupIntMap(Map<Matchup, Integer> map) {
        for (DeckClass deckClass1 : dcArray) {
            for (DeckClass deckClass2 : dcArray) {
                Matchup dcp = new Matchup(deckClass1, deckClass2);
                map.put(dcp, 0);
            }
        }
    }

    /**
     * Inputs 0s as values to every DeckClass key in a Map which has a DeckClass
     * as key and Double as value.
     *
     * @param map Map
     */
    public static void mapZeroesToDcDoubleMap(Map<DeckClass, Double> map) {
        for (DeckClass deckClass : dcArray) {
            map.put(deckClass, 0.0);
        }
    }

    /**
     * Inputs 0s as values to every Matchup key in a Map which has a Matchup as
     * key and Double as value.
     *
     * @param map Map DeckClass
     */
    public static void mapZeroesToMatchupDoubleMap(Map<Matchup, Double> map) {
        for (DeckClass deckClass1 : dcArray) {
            for (DeckClass deckClass2 : dcArray) {
                Matchup dcp = new Matchup(deckClass1, deckClass2);
                map.put(dcp, 0.0);
            }
        }
    }

    /**
     * Inputs 0s as values to Integer keys 0-12 in a Map which has an Integer as
     * key and Integer as value.
     *
     * @param map Map
     */
    public static void mapZeroesToIntIntMap(Map<Integer, Integer> map) {
        for (int i = 0; i < 13; i++) {
            map.put(i, 0);
        }
    }

    /**
     * Inputs 0s as values to Integer keys 0-12 in a Map which has an Integer as
     * key and Double as value.
     *
     * @param map Map
     */
    public static void mapZeroesToIntDoubleMap(Map<Integer, Double> map) {
        for (int i = 0; i < 13; i++) {
            map.put(i, 0.0);
        }
    }

    /**
     * Inputs 0s to nested Map<Integer, Integer> values which have an Integer
     * Key between 0-12 for every DeckClass Key of the Outer Map.
     *
     * @param map Map
     */
    public static void mapZeroesToDcIntIntMapMap(Map<DeckClass, Map<Integer, Integer>> map) {
        for (DeckClass dc : DeckClass.values()) {
            Map<Integer, Integer> subMap = new HashMap();
            mapZeroesToIntIntMap(subMap);
            map.put(dc, subMap);
        }
    }

    /**
     * Increases the Integer value of a specific DeckClass key by 1.
     *
     * @param map Map
     * @param dc DeckClass key.
     */
    public static void increaseIntegerInDcIntMap(Map<DeckClass, Integer> map, DeckClass dc) {
        increaseIntegerInDcIntMap(map, dc, 1);
    }

    /**
     * Increases the Integer value of a specific Matchup key by 1.
     *
     * @param map Map
     * @param matchup Matchup key.
     */
    public static void increaseIntegerInMatchupIntMap(Map<Matchup, Integer> map, Matchup matchup) {
        map.put(matchup, map.get(matchup) + 1);
    }

    /**
     * Updates a specific DeckClass' win ratio stored in a
     * Map<DeckClass, Double>.
     *
     * @param doublemap Map where win ratios are stored.
     * @param matchmap Map where match amounts are stored.
     * @param winmap Map where win amounts are stored.
     * @param lossmap Map where loss amounts are stored.
     * @param deckClass DeckClass key.
     */
    public static void updateWinRatioInDcDoubleMap(Map<DeckClass, Double> doublemap,
            Map<DeckClass, Integer> matchmap, Map<DeckClass, Integer> winmap,
            Map<DeckClass, Integer> lossmap, DeckClass deckClass) {
        int wins = winmap.get(deckClass);
        int losses = lossmap.get(deckClass);
        int validMatches = wins + losses;
        Double winPer = StatisticsHelper.getWinRatio(validMatches, wins);
        doublemap.put(deckClass, winPer);
    }

    /**
     * Updates a specific Matchup's win ratio stored in a Map<Matchup, Double>.
     *
     * @param doublemap Map where win ratios are stored.
     * @param matchmap Map where match amounts are stored.
     * @param winmap Map where win amounts are stored.
     * @param lossmap Map where loss amounts are stored.
     * @param matchup Matchup key.
     */
    public static void updateWinRatioInMatchupDoubleMap(Map<Matchup, Double> doublemap,
            Map<Matchup, Integer> matchmap, Map<Matchup, Integer> winmap,
            Map<Matchup, Integer> lossmap, Matchup matchup) {
        int wins = winmap.get(matchup);
        int losses = lossmap.get(matchup);
        int validMatches = wins + losses;
        Double winPer = StatisticsHelper.getWinRatio(validMatches, wins);
        doublemap.put(matchup, winPer);
    }

    /**
     * Decreases the Integer value of a specific DeckClass key by 1.
     *
     * @param map Map
     * @param dc DeckClass key.
     */
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

    /**
     * Decreases the Integer value of a specific Matchup key by 1.
     *
     * @param map Map
     * @param matchup Matchup key.
     */
    public static void decreaseIntegerInMatchupIntMap(Map<Matchup, Integer> map, Matchup matchup) {
        map.put(matchup, decreaseInteger(map.get(matchup)));
    }

    /**
     * Increases the Integer value of a specific Integer key by 1.
     *
     * @param map Map
     * @param key Integer key.
     */
    public static void increaseIntegerInIntIntMap(Map<Integer, Integer> map, int key) {
        increaseIntegerInIntIntMap(map, key, 1);
    }

    /**
     * Updates an average stored in a Map<DeckClass, Double>.
     *
     * @param map Map
     * @param dc DeckClass key.
     * @param numerator Numerator.
     * @param divisor Divisor.
     */
    public static void updateAverageInDcDoubleMap(Map<DeckClass, Double> map,
            DeckClass dc, int numerator, int divisor) {
        map.put(dc, StatisticsHelper.getDivision(numerator, divisor));
    }

    /**
     * Updates an average stored in a Map<Integer, Double>.
     *
     * @param map Map
     * @param key Integer key.
     * @param numerator Numerator
     * @param divisor Divisor
     */
    public static void updateAverageInIntDoubleMap(Map<Integer, Double> map,
            int key, int numerator, int divisor) {
        map.put(key, StatisticsHelper.getDivision(numerator, divisor));
    }

    /**
     * Decreases the Integer value of a specific Integer Key by 1.
     *
     * @param map Map
     * @param key Integer key.
     */
    public static void decreaseIntegerInIntIntMap(Map<Integer, Integer> map, int key) {
        decreaseIntegerInIntIntMap(map, key, 1);
    }

    /**
     * Increases the Integer value of a specific Integer Key by 1.
     *
     * @param map Map
     * @param key Integer key.
     */
    public static void increaseIntegerInIntIntMap(Map<Integer, Integer> map, int key, int x) {
        map.put(key, map.get(key) + x);
    }

    /**
     * Decreases the Integer value of a specific Integer key by X amount.
     *
     * @param map Map
     * @param key Integer key.
     * @param x Amount which the value is increased by.
     */
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

    /**
     * Increases the Integer value of a specific DeckClass key by X amount
     *
     * @param map Map
     * @param key DeckClass key.
     * @param x Amount which the value is increased by.
     */
    public static void increaseIntegerInDcIntMap(Map<DeckClass, Integer> map, DeckClass key, int x) {
        map.put(key, map.get(key) + x);
    }

    /**
     * Decreases the Integer value of a specific DeckClass key by X amount
     *
     * @param map Map
     * @param key DeckClass key.
     * @param x Amount which is decreased from the value.
     */
    public static void decreaseIntegerInDcIntMap(Map<DeckClass, Integer> map, DeckClass key, int x) {
        int value = decreaseInteger(map.get(key), x);
        map.put(key, value);
    }

    /**
     * Increase the Integer value of a nested Map<Integer, Integer> by X amount.
     *
     * @param map Map
     * @param dcKey DeckClass key of the outer Map.
     * @param intKey Integer key of the nested Map.
     * @param x Amount which the value is increased by.
     */
    public static void increaseIntegerInDcIntIntMapMap(Map<DeckClass, Map<Integer, Integer>> map,
            DeckClass dcKey, int intKey, int x) {
        Map<Integer, Integer> intIntMap = map.get(dcKey);
        increaseIntegerInIntIntMap(intIntMap, intKey, x);
        map.put(dcKey, intIntMap);
    }

    /**
     * Increase the Integer value of a nested Map<Integer, Integer> by 1.
     *
     * @param map Map
     * @param dcKey DeckClass key of the outer Map.
     * @param intKey Integer key of the nested Map..
     */
    public static void increaseIntegerInDcIntIntMapMap(Map<DeckClass, Map<Integer, Integer>> map,
            DeckClass dcKey, int intKey) {
        increaseIntegerInDcIntIntMapMap(map, dcKey, intKey, 1);
    }

    /**
     * Decrease the Integer value of a nested Map<Integer, Integer> by X amount.
     * 
     * @param map Map
     * @param dcKey DeckClass key of the outer Map.
     * @param intKey Integer key of the nested Map.
     * @param x Amount which is decreased from the value.
     */
    public static void decreaseIntegerInDcIntIntMapMap(Map<DeckClass, Map<Integer, Integer>> map,
            DeckClass dcKey, int intKey, int x) {
        Map<Integer, Integer> intIntMap = map.get(dcKey);
        decreaseIntegerInIntIntMap(intIntMap, intKey, x);
        map.put(dcKey, intIntMap);
    }

    /**
     * Decrease the Integer value of a nested Map<Integer, Integer> by 1.
     * 
     * @param map Map
     * @param dcKey DeckClass key of the outer Map.
     * @param intKey Integer key of the nested Map.
     */
    public static void decreaseIntegerInDcIntIntMapMap(Map<DeckClass, Map<Integer, Integer>> map,
            DeckClass dcKey, int intKey) {
        decreaseIntegerInDcIntIntMapMap(map, dcKey, intKey, 1);
    }
}
