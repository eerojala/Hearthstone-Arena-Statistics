package domain;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.TestForLoop;

public class ClassVsClassStatisticsTest {

    ClassVsClassStatistics statistics;

    public ClassVsClassStatisticsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        statistics = new ClassVsClassStatistics();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void matches_in_class_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpIntMap(statistics.getMatchesInClassVSClass1st()));
    }

    @Test
    public void matches_in_class_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpIntMap(statistics.getMatchesInClassVSClass2nd()));
    }

    @Test
    public void wins_in_class_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpIntMap(statistics.getWinsInClassVSClass1st()));
    }

    @Test
    public void wins_in_class_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpIntMap(statistics.getWinsInClassVSClass2nd()));
    }

    @Test
    public void losses_in_class_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpIntMap(statistics.getLossesInClassVSClass1st()));
    }

    @Test
    public void losses_in_class_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpIntMap(statistics.getLossesInClassVSClass2nd()));
    }

    @Test
    public void winPer_in_class_vs_class_1st_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpDoubleMap(statistics.getWinPerClassVSClass1st()));
    }

    @Test
    public void winPer_in_class_vs_class_2nd_has_zeroes_at_start() {
        assertTrue(TestForLoop.zeroesInDcpDoubleMap(statistics.getWinPerClassVSClass2nd()));
    }

}
