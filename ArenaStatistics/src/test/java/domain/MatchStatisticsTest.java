package domain;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.TestHelper;

public class MatchStatisticsTest {

    MatchStatistics statistics;
  
    public MatchStatisticsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        statistics = new MatchStatistics();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void matches_as_class_1st_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcIntMap(statistics.getMatchesAsClass1st()));
    }

    @Test
    public void matches_as_class_2nd_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcIntMap(statistics.getMatchesAsClass2nd()));
    }

    @Test
    public void matches_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcIntMap(statistics.getMatchesVSClass1st()));
    }

    @Test
    public void matches_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcIntMap(statistics.getMatchesVSClass2nd()));
    }

    @Test
    public void wins_as_class_1st_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcIntMap(statistics.getWinsAsClass1st()));
    }

    @Test
    public void wins_as_class_2nd_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcIntMap(statistics.getWinsAsClass2nd()));
    }

    @Test
    public void wins_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcIntMap(statistics.getWinsVSClass1st()));
    }

    @Test
    public void wins_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcIntMap(statistics.getWinsVSClass2nd()));
    }

    @Test
    public void losses_as_class_1st_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcIntMap(statistics.getLossesAsClass1st()));
    }

    @Test
    public void losses_as_class_2nd_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcIntMap(statistics.getLossesAsClass2nd()));
    }

    @Test
    public void losses_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcIntMap(statistics.getLossesVSClass1st()));
    }

    @Test
    public void losses_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcIntMap(statistics.getLossesVSClass2nd()));
    }

    @Test
    public void winPer_as_class_1st_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcDoubleMap(statistics.getWinRatioAsClass1st()));
    }

    @Test
    public void winPer_as_class_2nd_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcDoubleMap(statistics.getWinRatioAsClass2nd()));
    }

    @Test
    public void winPer_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcDoubleMap(statistics.getWinRatioVSClass1st()));
    }

    @Test
    public void winPer_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestHelper.zeroesInDcDoubleMap(statistics.getWinRatioVSClass2nd()));
    }
}
