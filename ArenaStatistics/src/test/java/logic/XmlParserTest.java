package logic;

import domain.ArenaDeck;
import domain.DeckClass;
import domain.Match;
import domain.Outcome;
import java.util.HashMap;
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
    HashMap<Integer, ArenaDeck> decks;
    ArenaDeck deck1;
    ArenaDeck deck2;
    
    public XmlParserTest() {
        parser = new XmlParser("src/main/resources/ParseTest.xml");
        decks = parser.getDecks();
        match1 = parser.getMatches().get(0);
        match2 = parser.getMatches().get(1);
        match3 = parser.getMatches().get(2);
        deck1 = decks.get(1);
        deck2 = decks.get(3);
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
    public void List_has_correct_size() {
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
    
    @Test
    public void HashMap_has_correct_size() {
        assertEquals(2, decks.keySet().size());
    }
    
    @Test
    public void deck_has_correct_deck_number1() {
        assertEquals(1, deck1.getDeckNumber());
    }
    
    @Test
    public void deck_has_correct_deck_number2() {
        assertEquals(3, deck2.getDeckNumber());
    }
    
    @Test
    public void deck_has_correct_player_class() {
        assertEquals(DeckClass.ROGUE, deck2.getPlayerClass());
    }
    
    @Test
    public void deck_has_correct_match1() {
        assertEquals(match1, deck1.getMatches().get(0));
    }
    
    @Test
    public void deck_has_correct_match2() {
        assertEquals(match2, deck2.getMatches().get(0));
    }
    
    @Test
    public void deck_has_correct_match3() {
        assertEquals(match3, deck2.getMatches().get(1));
    }
}
