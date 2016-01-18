package util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/**
 * Class which provides useful methods for calculating or presenting statistics.
 */
public class StatisticsHelper {

    /**
     * Returns the calculated win ratio of the inputed match- and win amounts.
     *
     * @param matches Amount of matches.
     * @param wins Amount of wins.
     * @return Calculated win ratio if it's above 0, otherwise 0.
     */
    public static double getWinRatio(int matches, int wins) {
        double winPer = (double) wins / matches;
        if (winPer >= 0) {
            return winPer;
        }
        return 0;
    }

    /**
     * Returns the division value of the inputed numerator and divisor.
     *
     * @param numerator Numerator
     * @param divisor Divisor
     * @return Calculated division if it's above 0, otherwise 0.
     */
    public static double getDivision(int numerator, int divisor) {
        double avg = (double) numerator / divisor;
        if (avg >= 0) {
            return avg;
        }
        return 0;
    }

    /**
     * Sums the values of Integer keys 0-12 of a Map<Integer, Integer>.
     *
     * @param map Map.
     * @return Sum of the Map Values' Integers.
     */
    public static int sumMapValueIntegers(Map<Integer, Integer> map) {
        int sum = 0;
        for (int i = 0; i < 13; i++) {
            if (map.get(i) != null) {
                sum += map.get(i);
            }
        }
        return sum;
    }

    /**
     * Rounds a given double to 2 decimals.
     *
     * @param d Double which is rounded.
     * @return Given double rounded to 2 decimals.
     */
    public static double round(Double d) {
        if (d != Double.NaN && d > 0) {
            return round(d, 2);
        }
        return 0;
    }

    private static double round(Double d, int decimalPlaces) {
        BigDecimal bd = new BigDecimal(d);
        bd = bd.setScale(decimalPlaces, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Returns the given double converted into percents with 2 decimals.
     *
     * @param d Double which is converted.
     * @return Given double converted into percents.
     */
    public static double convertToPercentage(Double d) {
        return round(round(d, 4) * 100);
    }
}
