package domain;

import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.DeckClassList;
import util.TestForLoop;

public class MatchStatisticsTest {

    MatchStatistics statistics;
    List<DeckClass> dclist;
    boolean bool;

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
        dclist = DeckClassList.getDeckClassList();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void matches_as_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntegerMap(statistics.getMatchesAsClass1st()));
    }

    @Test
    public void matches_as_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntegerMap(statistics.getMatchesAsClass2nd()));
    }

    @Test
    public void matches_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntegerMap(statistics.getMatchesVSClass1st()));
    }

    @Test
    public void matches_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntegerMap(statistics.getMatchesVSClass2nd()));
    }
    
    @Test
    public void matches_in_class_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpIntegerMap(statistics.getMatchesInClassVSClass1st()));
    }
    
    @Test
    public void matches_in_class_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpIntegerMap(statistics.getMatchesInClassVSClass2nd()));
    }
    
    @Test
    public void wins_as_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntegerMap(statistics.getWinsAsClass1st()));
    }
    
    @Test
    public void wins_as_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntegerMap(statistics.getWinsAsClass2nd()));
    }
    
    @Test
    public void wins_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntegerMap(statistics.getWinsVSClass1st()));
    }
    
    @Test
    public void wins_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntegerMap(statistics.getWinsVSClass2nd()));
    }
    
    @Test
    public void wins_in_class_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpIntegerMap(statistics.getWinsInClassVSClass1st()));
    }
    
    @Test
    public void wins_in_class_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpIntegerMap(statistics.getWinsInClassVSClass2nd()));
    }
    
    @Test
    public void losses_as_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntegerMap(statistics.getLossesAsClass1st()));
    }
    
    @Test
    public void losses_as_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntegerMap(statistics.getLossesAsClass2nd()));
    }
    
    @Test
    public void losses_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntegerMap(statistics.getLossesVSClass1st()));
    }
    
    @Test
    public void losses_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcIntegerMap(statistics.getLossesVSClass2nd()));
    }
    
    @Test
    public void losses_in_class_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpIntegerMap(statistics.getLossesInClassVSClass1st()));
    }
    
    @Test
    public void losses_in_class_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpIntegerMap(statistics.getLossesInClassVSClass2nd()));
    }
    
    @Test
    public void winPer_as_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcDoubleMap(statistics.getWinPerAsClass1st()));
    }
    
    @Test
    public void winPer_as_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcDoubleMap(statistics.getWinPerAsClass2nd()));
    }
    
    @Test
    public void winPer_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcDoubleMap(statistics.getWinPerVSClass1st()));
    }
    
    @Test
    public void winPer_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcDoubleMap(statistics.getWinPerVSClass2nd()));
    }
    
    @Test
    public void winPer_in_class_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpDoubleMaps(statistics.getWinPerClassVSClass1st()));
    }
    
    @Test
    public void winPer_in_class_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpDoubleMaps(statistics.getWinPerClassVSClass2nd()));
    }
}
