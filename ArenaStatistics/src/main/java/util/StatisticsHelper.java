package util;

import java.util.Map;

public class StatisticsHelper {

    public static double getWinPercentage(int matches, int wins) {
        double winPer = (double) wins / matches;
        if (winPer >= 0) {
            return winPer;
        }
        return 0;
    }

    public static double getAverage(int numerator, int divisor) {
        double avg = (double) numerator / divisor;
        if (avg >= 0) {
            return avg;
        }
        return 0;
    }

    public static int sumMapValueIntegers(Map<Integer, Integer> map) {
        int sum = 0;
        for (int i = 0; i < 13; i++) {
            if (map.get(i) != null) {
                sum += map.get(i);
            }
        }
        return sum;
    }
}
