package Xml;

import domain.DeckClass;
import domain.Match;
import domain.Outcome;
import org.jdom.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatchWriterTest {

    XmlWriter writer;
    MatchParser parser;
    Document doc;
    Match match;
    Match match1;
    Match match2;
    Match match3;
    Match match4;
    Match match5;
    String filePath;

    public MatchWriterTest() {
        filePath = "src/main/resources/MatchWriteTest.xml";
        writer = new MatchWriter(filePath);
        match1 = new Match(DeckClass.WARLOCK, DeckClass.PALADIN, "Dennis",
                Outcome.DISCONNECT, true, 1, 1);
        match2 = new Match(DeckClass.PRIEST, DeckClass.ROGUE, "UNKNOWN",
                Outcome.WIN, false, 2, 1);
        match3 = new Match(DeckClass.WARRIOR, DeckClass.HUNTER, "öööö",
                Outcome.LOSS, true, 3, 1);
        match4 = new Match(DeckClass.SHAMAN, DeckClass.DRUID, "weweq",
                Outcome.DISCONNECT, false, 4, 1);
        match5 = new Match(DeckClass.MAGE, DeckClass.HUNTER, "",
                Outcome.WIN, true, 5, 1);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        doc = DocumentBuilder.buildDocument(filePath);
        addAll();
    }

    @After
    public void tearDown() {
        writer.removeAll(doc);
    }

    @Test
    public void addContent_adds_a_match1() {
        parseDocument();
        match = parser.getObjects().get(0);
        assertEquals(match, match1);
    }

    @Test
    public void addContent_adds_a_match2() {
        parseDocument();
        match = parser.getObjects().get(1);
        assertEquals(match, match2);
    }

    @Test
    public void addContent_adds_a_match3() {
        parseDocument();
        match = parser.getObjects().get(2);
        assertEquals(match, match3);
    }

    @Test
    public void addContent_adds_all_matches() {
        parseDocument();
        assertEquals(5, parser.getObjects().size());
    }

    @Test
    public void removeLatest_removes_latest_match() {
        writer.removeLatest(doc);
        parseDocument();
        assertFalse(parser.getObjects().contains(match5));
    }

    @Test
    public void removeAll_removes_every_match() {
        writer.removeAll(doc);
        parseDocument();
        assertTrue(parser.getObjects().isEmpty());
    }

    @Test
    public void remove_removes_correct_match() {
        writer.remove(doc, "3.1");
        parseDocument();
        assertTrue(!parser.getObjects().contains(match3));
    }

    @Test
    public void written_match_has_correct_player_class1() {
        parseDocument();
        match = parser.getObjects().get(0);
        assertEquals(DeckClass.WARLOCK, match.getPlayerClass());
    }

    @Test
    public void written_match_has_correct_player_class2() {
        parseDocument();
        match = parser.getObjects().get(1);
        assertEquals(DeckClass.PRIEST, match.getPlayerClass());
    }

    @Test
    public void written_match_has_correct_player_class3() {
        parseDocument();
        match = parser.getObjects().get(2);
        assertEquals(DeckClass.WARRIOR, match.getPlayerClass());
    }

    @Test
    public void written_match_has_correct_player_class4() {
        parseDocument();
        match = parser.getObjects().get(3);
        assertEquals(DeckClass.SHAMAN, match.getPlayerClass());
    }

    @Test
    public void written_match_has_correct_player_class5() {
        parseDocument();
        match = parser.getObjects().get(4);
        assertEquals(DeckClass.MAGE, match.getPlayerClass());
    }

    @Test
    public void written_match_has_correct_opponent_class1() {
        parseDocument();
        match = parser.getObjects().get(0);
        assertEquals(DeckClass.PALADIN, match.getOpponentClass());
    }

    @Test
    public void written_match_has_correct_opponent_class2() {
        parseDocument();
        match = parser.getObjects().get(1);
        assertEquals(DeckClass.ROGUE, match.getOpponentClass());
    }
    
    public void written_match_has_correct_opponent_class3() {
        parseDocument();
        match = parser.getObjects().get(2);
        assertEquals(DeckClass.HUNTER, match.getOpponentClass());
    }

    @Test
    public void written_match_has_correct_opponent_class4() {
        parseDocument();
        match = parser.getObjects().get(3);
        assertEquals(DeckClass.DRUID, match.getOpponentClass());
    }

    @Test
    public void written_match_has_correct_opponent_name1() {
        parseDocument();
        match = parser.getObjects().get(2);
        assertEquals("öööö", match.getOpponentName());
    }
    
    @Test
    public void written_match_has_correct_opponent_name2() {
        parseDocument();
        match = parser.getObjects().get(4);
        assertTrue(match.getOpponentName().isEmpty());
    }

    @Test
    public void written_match_has_correct_outcome1() {
        parseDocument();
        match = parser.getObjects().get(0);
        assertEquals(Outcome.DISCONNECT, match.getOutcome());
    }
    
    @Test
    public void written_match_has_correct_outcome2() {
        parseDocument();
        match = parser.getObjects().get(1);
        assertEquals(Outcome.WIN, match.getOutcome());
    }
    
    @Test
    public void written_match_has_correct_outcome3() {
        parseDocument();
        match = parser.getObjects().get(2);
        assertEquals(Outcome.LOSS, match.getOutcome());
    }
    
    @Test
    public void written_match_has_correct_wentFirst_boolean() {
        parseDocument();
        match = parser.getObjects().get(1);
        assertFalse(match.wentFirst());
    }

    @Test
    public void written_match_has_correct_deck_number() {
        parseDocument();
        match = parser.getObjects().get(2);
        assertEquals(3, match.getDeckNumber());
    }

    @Test
    public void written_match_has_correct_match_number() {
        parseDocument();
        match = parser.getObjects().get(0);
        assertEquals(1, match.getMatchNumber());
    }

    private void addAll() {
        writer.addContent(doc, match1);
        writer.addContent(doc, match2);
        writer.addContent(doc, match3);
        writer.addContent(doc, match4);
        writer.addContent(doc, match5);
    }

    private void parseDocument() {
        parser = new MatchParser(doc);
        parser.addValuesToList();
    }

}
