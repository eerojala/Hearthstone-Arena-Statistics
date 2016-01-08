package xml;

import domain.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatchParserTest {

    private final MatchParser parser;
    private final List<Match> matches;

    public MatchParserTest() {
        parser = new MatchParser("src/main/resources/xmltestfiles/MatchParseTest.xml");
        parser.addValues();
        matches = parser.getMatches();
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
    public void childlist_is_empty_if_invalid_filepath() {
        XmlParser tempParser = new MatchParser("sdasfafs");
        assertEquals(0, tempParser.getChildlist().size());
    }

    @Test
    public void parses_all_matches() {
        assertEquals(9, matches.size());
    }

    @Test
    public void match_has_correct_player_class1() {
        assertEquals(DeckClass.HUNTER, matches.get(0).getPlayerClass());
    }

    @Test
    public void match_has_correct_player_class2() {
        assertEquals(DeckClass.ROGUE, matches.get(1).getPlayerClass());
    }

    @Test
    public void match_has_correct_opponent_class1() {
        assertEquals(DeckClass.MAGE, matches.get(0).getOpponentClass());
    }

    @Test
    public void match_has_correct_opponent_class2() {
        assertEquals(DeckClass.HUNTER, matches.get(1).getOpponentClass());
    }

    @Test
    public void match_has_correct_opponent_class3() {
        assertEquals(DeckClass.SHAMAN, matches.get(2).getOpponentClass());
    }

    @Test
    public void match_has_correct_opponent_class4() {
        assertEquals(DeckClass.PRIEST, matches.get(3).getOpponentClass());
    }

    @Test
    public void match_has_correct_opponent_class5() {
        assertEquals(DeckClass.WARLOCK, matches.get(4).getOpponentClass());
    }

    @Test
    public void match_has_correct_opponent_class6() {
        assertEquals(DeckClass.PALADIN, matches.get(5).getOpponentClass());
    }

    @Test
    public void match_has_correct_opponent_class7() {
        assertEquals(DeckClass.WARRIOR, matches.get(6).getOpponentClass());
    }

    @Test
    public void match_has_correct_opponent_class8() {
        assertEquals(DeckClass.DRUID, matches.get(7).getOpponentClass());
    }

    @Test
    public void match_has_correct_opponent_class9() {
        assertEquals(DeckClass.ROGUE, matches.get(8).getOpponentClass());
    }

    @Test
    public void match_has_correct_opponent_name1() {
        assertEquals("Dennis", matches.get(0).getOpponentName());
    }

    @Test
    public void match_has_correct_opponent_name2() {
        assertEquals("", matches.get(5).getOpponentName());
    }

    @Test
    public void match_has_correct_outcome1() {
        assertEquals(Outcome.WIN, matches.get(0).getOutcome());
    }

    @Test
    public void match_has_correct_outcome2() {
        assertEquals(Outcome.LOSS, matches.get(1).getOutcome());
    }

    @Test
    public void match_has_correct_outcome3() {
        assertEquals(Outcome.DISCONNECT, matches.get(2).getOutcome());
    }

    @Test
    public void match_has_correct_outcome4() {
        assertEquals(Outcome.TIE, matches.get(5).getOutcome());
    }

    @Test
    public void match_has_correct_wentFirst_boolean1() {
        assertEquals(true, matches.get(0).wentFirst());
    }

    @Test
    public void match_has_correct_wentFirst_boolean2() {
        assertEquals(false, matches.get(1).wentFirst());
    }

    @Test
    public void match_has_correct_deck_number() {
        assertEquals(1, matches.get(0).getDeckNumber());
    }

    @Test
    public void match_has_correct_match_number() {
        assertEquals(2, matches.get(0).getMatchNumber());
    }
}
