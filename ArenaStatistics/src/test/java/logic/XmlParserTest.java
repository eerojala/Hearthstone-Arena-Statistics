package logic;

import domain.DeckClass;
import domain.Match;
import domain.Outcome;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class XmlParserTest {

    XmlParser parser;
    Match match1;
    Match match2;
    Match match3;
    
    public XmlParserTest() {
        parser = new XmlParser("src/main/resources/ParseTest.xml");
        match1 = parser.getMatches().get(0);
        match2 = parser.getMatches().get(1);
        match3 = parser.getMatches().get(2);
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
    public void getMatches() {
        assertEquals(3, parser.getMatches().size());
    }
    
    @Test
    public void match_has_correct_player_class() {
        assertEquals(DeckClass.DRUID, match1.getPlayerClass());
    }
    
    @Test
    public void match_has_correct_opponent_class() {
        assertEquals(DeckClass.MAGE, match1.getOpponentClass());
    }
    
    @Test
    public void match_has_correct_opponent_name() {
        assertEquals("Dennis", match1.getOpponentName());
    }
    
    @Test
    public void match_has_correct_outcome1() {
        assertEquals(Outcome.WIN, match1.getOutcome());
    }
    
    @Test
    public void match_has_correct_outcome2() {
        assertEquals(Outcome.LOSS, match2.getOutcome());
    }
    
    @Test
    public void match_has_correct_outcome3() {
        assertEquals(Outcome.DISCONNECT, match3.getOutcome());
    }
    
    @Test
    public void match_has_correct_wentFirst_boolean1() {
        assertEquals(true, match1.wentFirst());
    }
    
    @Test
    public void match_has_correct_wentFirst_boolean2() {
        assertEquals(false, match2.wentFirst());
    }
    
    @Test
    public void match_has_correct_deck_number() {
        assertEquals(1, match1.getDeckNumber());
    }
    
    @Test
    public void match_has_correct_match_number() {
        assertEquals(2, match1.getMatchNumber());
    }
}
