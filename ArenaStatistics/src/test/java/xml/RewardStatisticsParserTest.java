package xml;

import logic.RewardStatisticsKeeper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RewardStatisticsParserTest {

    private final RewardStatisticsParser parser;
    private final RewardStatisticsKeeper keeper;

    public RewardStatisticsParserTest() {
        parser = new RewardStatisticsParser("src/main/resources/xmltestfiles/RewardStatisticsParseTest.xml");
        parser.addValues();
        keeper = parser.getKeeper();
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
    public void decks_by_wins_is_correct1() {
        assertEquals(4, keeper.getDecksByWins(0));
    }

    @Test
    public void decks_by_wins_is_correct2() {
        assertEquals(3, keeper.getDecksByWins(12));
    }

    @Test
    public void dust_by_wins_is_correct1() {
        assertEquals(70, keeper.getDustByWins(0));
    }

    @Test
    public void dust_by_wins_is_correct2() {
        assertEquals(90, keeper.getDustByWins(12));
    }

    @Test
    public void gold_by_wins_is_correct1() {
        assertEquals(35, keeper.getGoldByWins(0));
    }

    @Test
    public void gold_by_wins_is_correct2() {
        assertEquals(640, keeper.getGoldByWins(12));
    }

    @Test
    public void extra_packs_by_wins_is_correct1() {
        assertEquals(0, keeper.getExtraPacksByWins(0));
    }

    @Test
    public void extra_packs_by_wins_is_correct2() {
        assertEquals(1, keeper.getExtraPacksByWins(12));
    }

    @Test
    public void regular_cards_by_wins_is_correct1() {
        assertEquals(2, keeper.getRegularCardsByWins(0));
    }

    @Test
    public void regular_cards_by_wins_is_correct2() {
        assertEquals(3, keeper.getRegularCardsByWins(12));
    }

    @Test
    public void gold_cards_by_wins_is_correct1() {
        assertEquals(1, keeper.getGoldCardsByWins(0));
    }

    @Test
    public void gold_cards_by_wins_is_correct2() {
        assertEquals(2, keeper.getGoldCardsByWins(12));
    }

    @Test
    public void average_dust_by_wins_is_correct1() {
        assertEquals(17.5, keeper.getAverageDustByWins(0), 0);
    }
    
    @Test
    public void average_dust_by_wins_is_correct2() {
        assertEquals(30, keeper.getAverageDustByWins(12), 0);
    }
    
    @Test
    public void average_gold_by_wins_is_correct1() {
        assertEquals(8.75, keeper.getAverageGoldByWins(0), 0);
    }
    
    @Test
    public void average_gold_by_wins_is_correct2() {
        assertEquals(213.333, keeper.getAverageGoldByWins(12), 0.001);
    }
    
    @Test
    public void average_extra_packs_by_wins_is_correct1() {
        assertEquals(0, keeper.getAverageExtraPacksByWins(0), 0);
    }
    
    @Test
    public void average_extra_packs_by_wins_is_correct2() {
        assertEquals(0.33, keeper.getAverageExtraPacksByWins(12), 0.01);
    }
    
    @Test
    public void average_regular_cards_by_wins_is_correct1() {
        assertEquals(0.5, keeper.getAverageRegularCardsByWins(0), 0);
    }
    
    @Test
    public void average_regular_cards_by_wins_is_correct2() {
        assertEquals(1, keeper.getAverageRegularCardsByWins(12), 0);
    }
    
    @Test
    public void average_gold_cards_by_wins_is_correct1() {
        assertEquals(0.25, keeper.getAverageGoldCardsByWins(0), 0);
    }
    
    @Test
    public void average_gold_cards_by_wins_is_correct2() {
        assertEquals(0.66, keeper.getAverageGoldCardsByWins(12), 0.01);
    }
    
}
