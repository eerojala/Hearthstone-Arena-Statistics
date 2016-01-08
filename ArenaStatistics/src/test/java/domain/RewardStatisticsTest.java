
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.TestHelper;


public class RewardStatisticsTest {
    RewardStatistics statistics;
    
    public RewardStatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        statistics = new RewardStatistics();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void decks_by_wins_have_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInIntIntMap(statistics.getDecksByWins()));
    }
    
    @Test
    public void dust_by_wins_have_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInIntIntMap(statistics.getDustByWins()));
    }
    
    @Test
    public void gold_by_wins_have_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInIntIntMap(statistics.getGoldByWins()));
    }
    
    @Test
    public void extra_packs_by_wins_have_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInIntIntMap(statistics.getExtraPacksByWins()));
    }
    
    @Test
    public void cards_by_wins_have_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInIntIntMap(statistics.getCardsByWins()));
    }
    
    @Test
    public void gold_cards_by_wins_have_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInIntIntMap(statistics.getGoldCardsByWins()));
    }
    
    @Test
    public void average_dust_by_wins_have_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInIntDoubleMap(statistics.getAvgDustByWins()));
    }
    
    @Test
    public void average_gold_by_wins_have_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInIntDoubleMap(statistics.getAvgGoldByWins()));
    }
    
    @Test
    public void average_extra_packs_by_wins_have_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInIntDoubleMap(statistics.getAvgExtraPacksByWins()));
    }
    
    @Test
    public void average_cards_by_wins_have_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInIntDoubleMap(statistics.getAvgCardsByWins()));
    }
    
    @Test
    public void average_gold_cards_by_wins_have_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInIntDoubleMap(statistics.getAvgGoldCardsByWins()));
    }
}
