
package util;


public class StatisticsHelper {
    public static double getWinPercentage(int matches, int wins, int losses, int disconnects) {
        double winPer = (double) wins / (matches - disconnects);
        if (winPer >= 0) {
            return winPer;
        }
        return 0;
    }
    
    public static double getAverage(int int1, int int2) {
        double avg = (double) int1 / int2;
        if (avg >= 0) {
            return avg;
        }
        return 0;
    }
}
