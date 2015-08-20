package util;

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
}
