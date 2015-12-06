
package Xml;


import domain.DeckClass;
import domain.DeckClassPair;
import logic.ClassVSClassStatisticsKeeper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClassVSClassStatisticsParserTest {
    ClassVSClassStatisticsParser parser;
    ClassVSClassStatisticsKeeper keeper;
    DeckClassPair rVSpr;
    DeckClassPair paVSwarr;
    
    public ClassVSClassStatisticsParserTest() {
        parser = new ClassVSClassStatisticsParser("src/main/resources/ClassVSClassStatisticsParseTest.xml"); 
        parser.addValues();
        keeper = parser.getKeeper();
        rVSpr = new DeckClassPair(DeckClass.ROGUE, DeckClass.PRIEST);
        paVSwarr = new DeckClassPair(DeckClass.PALADIN, DeckClass.WARRIOR);
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
    public void matches_1st_is_correct1() {
        assertEquals(14, keeper.getMatchesInClassVSClass1st(rVSpr));
    }
    
    @Test
    public void matches_1st_is_correct2() {
        assertEquals(8, keeper.getMatchesInClassVSClass1st(paVSwarr));
    }
    
    @Test
    public void matches_2nd_is_correct1() {
        assertEquals(24, keeper.getMatchesInClassVSClass2nd(rVSpr));
    }
    
    @Test
    public void matches_2nd_is_correct2() {
        assertEquals(9, keeper.getMatchesInClassVSClass2nd(paVSwarr));
    }
    
    @Test
    public void wins_1st_is_correct1() {
        assertEquals(10, keeper.getWinsInClassVSClass1st(rVSpr));
    }
    
    @Test
    public void wins_1st_is_correct2() {
        assertEquals(2, keeper.getWinsInClassVSClass1st(paVSwarr));
    }
    
    @Test
    public void wins_2nd_is_correct1() {
        assertEquals(8, keeper.getWinsInClassVSClass2nd(rVSpr));
    }
    
    @Test
    public void wins_2nd_is_correct2() {
        assertEquals(6, keeper.getWinsInClassVSClass2nd(paVSwarr));
    }
    
    @Test
    public void losses_1st_is_correct1() {
        assertEquals(4, keeper.getLossesInClassVSClass1st(rVSpr));
    }
    
    @Test
    public void losses_1st_is_correct2() {
        assertEquals(3, keeper.getLossesInClassVSClass1st(paVSwarr));
    }
    
    @Test
    public void losses_2nd_is_correct1() {
        assertEquals(16, keeper.getLossesInClassVSClass2nd(rVSpr));
    }

    @Test
    public void losses_2nd_is_correct2() {
        assertEquals(1, keeper.getLossesInClassVSClass2nd(paVSwarr));
    }
    
    @Test
    public void win_percentage_1st_is_correct1() {
        assertEquals(0.714, keeper.getWinPerClassVSClass1st(rVSpr), 0.0005);
    }
    
    @Test
    public void win_percentage_1st_is_correct2() {
        assertEquals(0.4, keeper.getWinPerClassVSClass1st(paVSwarr), 0);
    }
    
    @Test
    public void win_percentage_2nd_is_correct1() {
        assertEquals(0.333, keeper.getWinPerClassVSClass2nd(rVSpr), 0.0005);
    }
    
    @Test
    public void win_percentage_2nd_is_correct2() {
        assertEquals(0.857, keeper.getWinPerClassVSClass2nd(paVSwarr), 0.0005);
    }
}
