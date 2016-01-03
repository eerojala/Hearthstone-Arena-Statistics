package util;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsHelperTest {

    Map<Integer, Integer> intMap;

    public StatisticsHelperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        intMap = new HashMap();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getWinPercentage_is_correct() {
        assertEquals(0.75, StatisticsHelper.getWinPercentage(4, 3), 0);
    }

    @Test
    public void getWinPercentage_returns_zero_if_win_percentage_is_negative() {
        assertEquals(0, StatisticsHelper.getWinPercentage(4, -3), 0);
    }

    @Test
    public void getAverage_is_correct() {
        assertEquals(0.9, StatisticsHelper.getAverage(9, 10), 0);
    }

    @Test
    public void getAverage_returns_zero_if_average_is_negative() {
        assertEquals(0, StatisticsHelper.getAverage(9, -10), 0);
    }

    @Test
    public void sumMapValueIntegers_works_correctly() {
        intMap.put(0, 1);
        intMap.put(12, 33);
        assertEquals(34, StatisticsHelper.sumMapValueIntegers(intMap));
    }

    @Test
    public void sumMapValueIntegers_doesnt_count_integers_out_of_range() {
        intMap.put(-1, 3);
        intMap.put(11, 2);
        intMap.put(13, 5);
        assertEquals(2, StatisticsHelper.sumMapValueIntegers(intMap));
    }
    
    @Test
    public void convertToPercentage_returns_correct_value1() {
        assertEquals(12.34, StatisticsHelper.convertToPercentage(0.12345), 0.0);
    }
    
    @Test
    public void convertToPercentageReturns_correct_value2() {
        assertEquals(12.34, StatisticsHelper.convertToPercentage(0.1234), 0.0);
    }
    
    @Test
    public void convertToPercentageReturns_correct_value3() {
        assertEquals(12.3, StatisticsHelper.convertToPercentage(0.123), 0.0);
    }
    
    @Test
    public void convertToPercentageReturns_correct_value4() {
        assertEquals(12.0, StatisticsHelper.convertToPercentage(0.12), 0.0);
    }
}
