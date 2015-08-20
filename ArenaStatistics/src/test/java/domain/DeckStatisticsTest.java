
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.TestForLoop;


public class DeckStatisticsTest {
    DeckStatistics statistics;
    
    public DeckStatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        statistics = new DeckStatistics();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void decks_by_class_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntMap(statistics.getDecksAsClass()));
    }
    
    @Test
    public void wins_by_class_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntMap(statistics.getWinsAsClass()));
    }
    
    @Test
    public void decks_by_wins_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInIntIntMap(statistics.getDecksByWins()));
    }
    
    @Test
    public void dust_by_wins_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInIntIntMap(statistics.getDustByWins()));
    }
    
    @Test
    public void gold_by_wins_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInIntIntMap(statistics.getGoldByWins()));
    }
    
    @Test
    public void extra_packs_by_wins_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInIntIntMap(statistics.getExtraPacksByWins()));
    }
    
    @Test
    public void cards_by_wins_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInIntIntMap(statistics.getCardsByWins()));
    }
    
    @Test
    public void gold_cards_by_wins_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInIntIntMap(statistics.getGoldCardsByWins()));
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
    public void average_dust_by_wins_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInIntDoubleMap(statistics.getAvgDustByWins()));
    }
    
    @Test
    public void average_gold_by_wins_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInIntDoubleMap(statistics.getAvgGoldByWins()));
    }
    
    @Test
    public void average_extra_packs_by_wins_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInIntDoubleMap(statistics.getAvgExtraPacksByWins()));
    }
    
    @Test
    public void average_cards_by_wins_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInIntDoubleMap(statistics.getAvgCardsByWins()));
    }
    
    @Test
    public void average_gold_card_by_wins_have_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInIntDoubleMap(statistics.getAvgGoldCardsByWins()));
    }
}
