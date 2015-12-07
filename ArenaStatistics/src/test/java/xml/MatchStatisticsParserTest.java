package xml;

import xml.MatchStatisticsParser;
import domain.DeckClass;
import logic.ClassStatisticsKeeper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatchStatisticsParserTest {
    MatchStatisticsParser parser;
    ClassStatisticsKeeper keeper;
    
    public MatchStatisticsParserTest() {
        parser = new MatchStatisticsParser("src/main/resources/xmltestfiles/MatchStatisticsParseTest.xml");
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
    public void matches_as_class_1st_is_correct1() {
        assertEquals(48, keeper.getMatchesAsClass1st(DeckClass.DRUID));
    }
    
    @Test
    public void matches_as_class_1st_is_correct2() {
        assertEquals(10, keeper.getMatchesAsClass1st(DeckClass.WARLOCK));
    }
    
    @Test
    public void matches_as_class_2nd_is_correct1() {
        assertEquals(60, keeper.getMatchesAsClass2nd(DeckClass.DRUID));
    }
    
    @Test
    public void matches_as_class_2nd_is_correct2() {
        assertEquals(12, keeper.getMatchesAsClass2nd(DeckClass.WARLOCK));
    }
    
    @Test
    public void matches_vs_class_1st_is_correct1() {
        assertEquals(8, keeper.getMatchesVSClass1st(DeckClass.DRUID));
    }
    
    @Test
    public void matches_vs_class_1st_is_correct2() {
        assertEquals(30, keeper.getMatchesVSClass1st(DeckClass.WARLOCK));
    }
    
    @Test
    public void matches_vs_class_2nd_is_correct1() {
        assertEquals(10, keeper.getMatchesVSClass2nd(DeckClass.DRUID));
    }
    
    @Test
    public void matches_vs_class_2nd_is_correct2() {
        assertEquals(14, keeper.getMatchesVSClass2nd(DeckClass.WARLOCK));
    }
    
    @Test
    public void wins_as_class_1st_is_correct1() {
        assertEquals(12, keeper.getWinsAsClass1st(DeckClass.DRUID));
    }
    
    @Test
    public void wins_as_class_1st_is_correct2() {
        assertEquals(2, keeper.getWinsAsClass1st(DeckClass.WARLOCK));
    }
    
    @Test
    public void wins_as_class_2nd_is_correct1() {
        assertEquals(36, keeper.getWinsAsClass2nd(DeckClass.DRUID));
    }
    
    @Test
    public void wins_as_class_2nd_is_correct2() {
        assertEquals(5, keeper.getWinsAsClass2nd(DeckClass.WARLOCK));
    }
    
    @Test
    public void wins_vs_class_1st_is_correct1() {
        assertEquals(6, keeper.getWinsVSClass1st(DeckClass.DRUID));
    }
    
    @Test
    public void wins_vs_class_1st_is_correct2() {
        assertEquals(20, keeper.getWinsVSClass1st(DeckClass.WARLOCK));
    }
    
    @Test
    public void wins_vs_class_2nd_is_correct1() {
        assertEquals(1, keeper.getWinsVSClass2nd(DeckClass.DRUID));
    }
    
    @Test
    public void wins_vs_class_2nd_is_correct2() {
        assertEquals(9, keeper.getWinsVSClass2nd(DeckClass.WARLOCK));
    }
    
    @Test
    public void losses_as_class_1st_is_correct1() {
        assertEquals(36, keeper.getLossesAsClass1st(DeckClass.DRUID));
    }
    
    @Test
    public void losses_as_class_1st_is_correct2() {
        assertEquals(6, keeper.getLossesAsClass1st(DeckClass.WARLOCK));
    }
    
    @Test
    public void losses_as_class_2nd_is_correct1() {
        assertEquals(24, keeper.getLossesAsClass2nd(DeckClass.DRUID));
    }
    
    @Test
    public void losses_as_class_2nd_is_correct2() {
        assertEquals(3, keeper.getLossesAsClass2nd(DeckClass.WARLOCK));
    }
    
    @Test
    public void losses_vs_class_1st_is_correct1() {
        assertEquals(2, keeper.getLossesVSClass1st(DeckClass.DRUID));
    }
    
    @Test
    public void losses_vs_class_1st_is_correct2() {
        assertEquals(8, keeper.getLossesVSClass1st(DeckClass.WARLOCK));
    }
    
    @Test
    public void losses_vs_class_2nd_is_correct1() {
        assertEquals(9, keeper.getLossesVSClass2nd(DeckClass.DRUID));
    }
    
    @Test
    public void losses_vs_class_2nd_is_correct2() {
        assertEquals(0, keeper.getLossesVSClass2nd(DeckClass.WARLOCK));
    }
    
    @Test
    public void win_percentage_as_class_1st_is_correct1() {
        assertEquals(0.25, keeper.getWinPerAsClass1st(DeckClass.DRUID), 0);
    }
    
    @Test
    public void win_percentage_as_class_1st_is_correct2() {
        assertEquals(0.25, keeper.getWinPerAsClass1st(DeckClass.WARLOCK), 0);
    }
    
    @Test
    public void win_percentage_as_class_2nd_is_correct1() {
        assertEquals(0.6, keeper.getWinPerAsClass2nd(DeckClass.DRUID), 0);
    }
    
    @Test
    public void win_percentage_as_class_2nd_is_correct2() {
        assertEquals(0.625, keeper.getWinPerAsClass2nd(DeckClass.WARLOCK), 0);
    }
    
    @Test
    public void win_percentage_vs_class_1st_is_correct1() {
        assertEquals(0.75, keeper.getWinPerVSClass1st(DeckClass.DRUID), 0);
    }
    
    @Test
    public void win_percentage_vs_class_1st_is_correct2() {
        assertEquals(0.714, keeper.getWinPerVSClass1st(DeckClass.WARLOCK), 0.0005);
    }
    
    @Test
    public void win_percentage_vs_class_2nd_is_correct1() {
        assertEquals(0.1, keeper.getWinPerVSClass2nd(DeckClass.DRUID), 0);
    }
    
    @Test
    public void win_percentage_vs_class_2nd_is_correct2() {
        assertEquals(1, keeper.getWinPerVSClass2nd(DeckClass.WARLOCK), 0);
    }
}
