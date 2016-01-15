package domain;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.TestHelper;

public class MatchupStatisticsTest {

    MatchupStatistics statistics;

    public MatchupStatisticsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        statistics = new MatchupStatistics();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void matches_in_class_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInMatchupIntMap(statistics.getMatchesInMatchup1st()));
    }

    @Test
    public void matches_in_class_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInMatchupIntMap(statistics.getMatchesInMatchup2nd()));
    }

    @Test
    public void wins_in_class_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInMatchupIntMap(statistics.getWinsInMatchup1st()));
    }

    @Test
    public void wins_in_class_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInMatchupIntMap(statistics.getWinsInMatchup2nd()));
    }

    @Test
    public void losses_in_class_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInMatchupIntMap(statistics.getLossesInMatchup1st()));
    }

    @Test
    public void losses_in_class_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInMatchupIntMap(statistics.getLossesInMatchup2nd()));
    }

    @Test
    public void winPer_in_class_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInMatchupDoubleMap(statistics.getMatchupWinRatio1st()));
    }

    @Test
    public void winPer_in_class_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInMatchupDoubleMap(statistics.getMatchupWinRatio2nd()));
    }

}
