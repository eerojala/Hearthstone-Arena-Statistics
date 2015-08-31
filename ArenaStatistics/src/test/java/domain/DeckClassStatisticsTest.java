package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.TestForLoop;

public class DeckClassStatisticsTest {
    DeckClassStatistics statistics;
    
    public DeckClassStatisticsTest() {
        statistics = new DeckClassStatistics();
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
    public void average_wins_by_class_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcDoubleMap(statistics.getAvgWinsAsClass()));
    }
    
    @Test
    public void percentage_played_as_class_out_of_all_decks_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcDoubleMap(statistics.getPlayPerAsClass()));
    }
    
    @Test
    public void decks_with_x_wins_as_class_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntIntMapMap(statistics.getDecksWithXWinsAsClass()));
    }
}
