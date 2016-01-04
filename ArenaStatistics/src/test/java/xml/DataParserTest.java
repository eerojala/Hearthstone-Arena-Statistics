
package xml;

import domain.DeckClass;
import domain.DeckClassPair;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DataParserTest {
    private final DataParser parser;
    private static final DeckClassPair dcp = new DeckClassPair(DeckClass.ROGUE, DeckClass.PRIEST);
    
    public DataParserTest() {
        parser = new DataParser();
        parser.setClassVSClassStatisticsFilepath("src/main/resources/xmltestfiles/ClassVSClassStatisticsParseTest.xml");
        parser.setDeckClassStatisticsFilepath("src/main/resources/xmltestfiles/DeckClassStatisticsParseTest.xml");
        parser.setDecksFilepath("src/main/resources/xmltestfiles/DeckParseTest.xml");
        parser.setMatchStatisticsFilepath("src/main/resources/xmltestfiles/MatchStatisticsParseTest.xml");
        parser.setMatchesFilepath("src/main/resources/xmltestfiles/MatchParseTest.xml");
        parser.setRewardStatisticsFilepath("src/main/resources/xmltestfiles/RewardStatisticsParseTest.xml");
        parser.parseData();
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
    public void deck_is_parsed() {
        assertEquals(DeckClass.MAGE, parser.getCurrentDeck().getDeckClass());
    }
    
    @Test
    public void match_statistics_are_parsed() {
        assertEquals(48, parser.getClassStatisticsKeeper().getMatchesAsClass1st(DeckClass.DRUID));
    }
    
    @Test
    public void class_vs_class_statistics_are_parsed() {
        assertEquals(38, parser.getClassVSClassStatisticsKeeper().getMatchesInClassVSClassTotal(dcp));
    }
    
    @Test
    public void deck_class_statistics_are_parsed() {
        assertEquals(7, parser.getDeckClassStatisticsKeeper().getTotalDeckAmount());
    }
    
    @Test
    public void reward_statistics_are_parsed() {
        assertEquals(7, parser.getRewardStatisticsKeeper().getTotalDeckAmount());
    }
}
