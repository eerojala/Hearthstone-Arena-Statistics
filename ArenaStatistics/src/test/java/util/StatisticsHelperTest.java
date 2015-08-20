
package util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsHelperTest {
    
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
}
