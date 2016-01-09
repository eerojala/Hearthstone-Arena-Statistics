package xml;

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

public class MatchXmlTest {

    private final MatchWriter writer;
    private final Match match1;
    private final Match match2;
    private final Match match3;
    private final Match match4;
    private final Match match5;
    private final Match match6;
    private final Match match7;
    private final Match match8;
    private final Match match9;
    private static final String filePath = "src/main/resources/xmltestfiles/MatchXmlTest.xml";
    private MatchParser parser;
    private Match match;
    private List<Match> matches;
    

    public MatchXmlTest() {
        writer = new MatchWriter(filePath);
        match1 = new Match(DeckClass.DRUID, DeckClass.PALADIN, "Dennis", Outcome.DISCONNECT, true, 1, 1);
        match2 = new Match(DeckClass.HUNTER, DeckClass.ROGUE, "UNKNOWN", Outcome.WIN, false, 2, 1);
        match3 = new Match(DeckClass.MAGE, DeckClass.HUNTER, "öööö", Outcome.LOSS, true, 3, 1);
        match4 = new Match(DeckClass.SHAMAN, DeckClass.DRUID, "weweq", Outcome.TIE, false, 4, 1);
        match5 = new Match(DeckClass.WARLOCK, DeckClass.WARRIOR, "", Outcome.WIN, true, 5, 1);
        match6 = new Match(DeckClass.ROGUE, DeckClass.SHAMAN, "", Outcome.LOSS, false, 6, 1);
        match7 = new Match(DeckClass.WARRIOR, DeckClass.MAGE, "fafasdf", Outcome.DISCONNECT, true, 7, 1);
        match8 = new Match(DeckClass.PALADIN, DeckClass.WARLOCK, "fr3fseew3", Outcome.WIN, false, 8, 1);
        match9 = new Match(DeckClass.PALADIN, DeckClass.PRIEST, "332424", Outcome.LOSS, true, 9, 1);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        addAll();
    }

    @After
    public void tearDown() {
        writer.removeAll();
    }

    @Test
    public void addContent_adds_a_match() {
        parseDocument();
        match = matches.get(0);
        assertEquals(match, match1);
    }

    @Test
    public void addContent_adds_all_matches() {
        parseDocument();
        assertEquals(9, matches.size());
    }

    @Test
    public void removeLatest_removes_latest_match() {
        writer.removeLatest();
        parseDocument();
        assertFalse(matches.contains(match9));
    }

    @Test
    public void removeAll_removes_every_match() {
        writer.removeAll();
        parseDocument();
        assertTrue(matches.isEmpty());
    }

    @Test
    public void remove_removes_correct_match() {
        writer.remove("3.1");
        parseDocument();
        assertTrue(!matches.contains(match3));
    }

    @Test
    public void written_match_has_correct_player_class1() {
        parseDocument();
        match = matches.get(0);
        assertEquals(DeckClass.DRUID, match.getPlayerClass());
    }

    @Test
    public void written_match_has_correct_player_class2() {
        parseDocument();
        match = matches.get(8);
        assertEquals(DeckClass.PALADIN, match.getPlayerClass());
    }

    @Test
    public void written_match_has_correct_opponent_class1() {
        parseDocument();
        match = matches.get(0);
        assertEquals(DeckClass.PALADIN, match.getOpponentClass());
    }

    @Test
    public void written_match_has_correct_opponent_class2() {
        parseDocument();
        match = matches.get(1);
        assertEquals(DeckClass.ROGUE, match.getOpponentClass());
    }

    @Test
    public void written_match_has_correct_opponent_class3() {
        parseDocument();
        match = matches.get(2);
        assertEquals(DeckClass.HUNTER, match.getOpponentClass());
    }

    @Test
    public void written_match_has_correct_opponent_class4() {
        parseDocument();
        match = matches.get(3);
        assertEquals(DeckClass.DRUID, match.getOpponentClass());
    }

    @Test
    public void written_match_has_correct_opponent_class5() {
        parseDocument();
        match = matches.get(4);
        assertEquals(DeckClass.WARRIOR, match.getOpponentClass());
    }

    @Test
    public void written_match_has_correct_opponent_class6() {
        parseDocument();
        match = matches.get(5);
        assertEquals(DeckClass.SHAMAN, match.getOpponentClass());
    }

    @Test
    public void written_match_has_correct_opponent_class7() {
        parseDocument();
        match = matches.get(6);
        assertEquals(DeckClass.MAGE, match.getOpponentClass());
    }

    public void written_match_has_correct_opponent_class8() {
        parseDocument();
        match = matches.get(7);
        assertEquals(DeckClass.WARLOCK, match.getOpponentClass());
    }

    @Test
    public void written_match_has_correct_opponent_class9() {
        parseDocument();
        match = matches.get(8);
        assertEquals(DeckClass.PRIEST, match.getOpponentClass());
    }

    @Test
    public void written_match_has_correct_opponent_name1() {
        parseDocument();
        match = matches.get(2);
        assertEquals("öööö", match.getOpponentName());
    }

    @Test
    public void written_match_has_correct_opponent_name2() {
        parseDocument();
        match = matches.get(4);
        assertTrue(match.getOpponentName().isEmpty());
    }

    @Test
    public void written_match_has_correct_outcome1() {
        parseDocument();
        match = matches.get(0);
        assertEquals(Outcome.DISCONNECT, match.getOutcome());
    }

    @Test
    public void written_match_has_correct_outcome2() {
        parseDocument();
        match = matches.get(1);
        assertEquals(Outcome.WIN, match.getOutcome());
    }

    @Test
    public void written_match_has_correct_outcome3() {
        parseDocument();
        match = matches.get(2);
        assertEquals(Outcome.LOSS, match.getOutcome());
    }

    @Test
    public void written_match_has_correct_outcome4() {
        parseDocument();
        match = matches.get(3);
        assertEquals(Outcome.TIE, match.getOutcome());
    }

    @Test
    public void written_match_has_correct_wentFirst_boolean() {
        parseDocument();
        match = matches.get(1);
        assertFalse(match.wentFirst());
    }

    @Test
    public void written_match_has_correct_deck_number() {
        parseDocument();
        match = matches.get(2);
        assertEquals(3, match.getDeckNumber());
    }

    @Test
    public void written_match_has_correct_match_number() {
        parseDocument();
        match = matches.get(0);
        assertEquals(1, match.getMatchNumber());
    }

    private void addAll() {
        writer.writeContent(match1);
        writer.writeContent(match2);
        writer.writeContent(match3);
        writer.writeContent(match4);
        writer.writeContent(match5);
        writer.writeContent(match6);
        writer.writeContent(match7);
        writer.writeContent(match8);
        writer.writeContent(match9);
    }

    private void parseDocument() {
        parser = new MatchParser(writer.getDoc());
        parser.addValues();
        matches = parser.getMatches();
    }

}
