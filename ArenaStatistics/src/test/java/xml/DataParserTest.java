package xml;

import domain.Deck;
import domain.DeckClass;
import domain.DeckClassPair;
import logic.ClassStatisticsKeeper;
import logic.ClassVSClassStatisticsKeeper;
import logic.DeckClassStatisticsKeeper;
import logic.RewardStatisticsKeeper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataParserTest {

    private DataParser parser;
    private final ClassStatisticsKeeper classStatisticsKeeper;
    private final ClassVSClassStatisticsKeeper classVSClassStatisticsKeeper;
    private final DeckClassStatisticsKeeper deckClassStatisticsKeeper;
    private final RewardStatisticsKeeper rewardStatisticsKeeper;
    private static final DeckClassPair dcp = new DeckClassPair(DeckClass.ROGUE, DeckClass.PRIEST);
    private static final String deckFilepath = "src/main/resources/xmltestfiles/DeckXmlTest.xml";

    public DataParserTest() {
        newParser();
        classStatisticsKeeper = parser.getClassStatisticsKeeper();
        classVSClassStatisticsKeeper = parser.getClassVSClassStatisticsKeeper();
        deckClassStatisticsKeeper = parser.getDeckClassStatisticsKeeper();
        rewardStatisticsKeeper = parser.getRewardStatisticsKeeper();
    }

    private void newParser() {
        parser = new DataParser();
        parser.setClassVSClassStatisticsFilepath("src/main/resources/xmltestfiles/ClassVSClassStatisticsParseTest.xml");
        parser.setDeckClassStatisticsFilepath("src/main/resources/xmltestfiles/DeckClassStatisticsParseTest.xml");
        parser.setDecksFilepath(deckFilepath);
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
        newParser();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void deck_is_null_if_file_empty() {
        assertNull(parser.getCurrentDeck());
    }
    
    @Test
    public void deck_is_parsed() {
        XmlWriter writer = new DeckWriter(deckFilepath);
        Deck deck = new Deck(DeckClass.MAGE, 1);
        writer.writeContent(deck);
        newParser();
        Deck parsedDeck = parser.getCurrentDeck();
        writer.removeAll();
        assertEquals(deck, parsedDeck);
    }

    @Test
    public void match_statistics_are_parsed() {
        assertEquals(48, classStatisticsKeeper.getMatchesAsClass1st(DeckClass.DRUID));
    }

    @Test
    public void class_vs_class_statistics_are_parsed() {
        assertEquals(38, classVSClassStatisticsKeeper.getMatchesInClassVSClassTotal(dcp));
    }

    @Test
    public void deck_class_statistics_are_parsed() {
        assertEquals(7, deckClassStatisticsKeeper.getTotalDeckAmount());
    }

    @Test
    public void reward_statistics_are_parsed() {
        assertEquals(7, rewardStatisticsKeeper.getTotalDeckAmount());
    }
}
