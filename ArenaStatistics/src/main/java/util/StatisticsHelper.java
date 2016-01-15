package util;

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
     * Returns the given double converted into percents by shaving all the
     * decimals after the 3rd one and multiplying the double by 100. NOTE: the
     * method only shaves off the decimals and does NOT round double.
     *
     * @param d Double which is converted.
     * @return Given double converted into percents.
     */
    public static double convertToDecimal(Double d) {
        StringBuilder sb = new StringBuilder(d.toString());
        if (sb.length() > 6) {
            sb.replace(6, d.toString().length(), "");
        }
        return Double.parseDouble(sb.toString()) * 100;
    }
}
