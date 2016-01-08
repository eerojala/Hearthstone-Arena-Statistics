package domain;

import java.util.List;
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
    DeckClass[] dcArray;

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
        dcArray = DeckClass.values();
    }

    @After
    public void tearDown() {
    }
}
