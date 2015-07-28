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
    Match match6;
    Match match7;
    Match match8;
    Match match9;
    String filePath;

    public MatchWriterTest() {
        filePath = "src/main/resources/MatchWriteTest.xml";
        writer = new MatchWriter(filePath);
        match1 = new Match(DeckClass.PALADIN, "Dennis", Outcome.DISCONNECT, true, 1, 1);
        match2 = new Match(DeckClass.ROGUE, "UNKNOWN", Outcome.WIN, false, 2, 1);
        match3 = new Match(DeckClass.HUNTER, "öööö", Outcome.LOSS, true, 3, 1);
        match4 = new Match(DeckClass.DRUID, "weweq", Outcome.DISCONNECT, false, 4, 1);
        match5 = new Match(DeckClass.WARRIOR, "", Outcome.WIN, true, 5, 1);
        match6 = new Match(DeckClass.SHAMAN, "", Outcome.LOSS, false, 6, 1);
        match7 = new Match(DeckClass.MAGE, "fafasdf", Outcome.DISCONNECT, true, 7, 1);
        match8 = new Match(DeckClass.WARLOCK, "fr3fseew3", Outcome.WIN, false, 8, 1);
        match9 = new Match(DeckClass.PRIEST, "332424", Outcome.LOSS, true, 9, 1);
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
    public void addContent_adds_a_match() {
        parseDocument();
        match = parser.getObjects().get(0);
        assertEquals(match, match1);
    }

    @Test
    public void addContent_adds_all_matches() {
        parseDocument();
        assertEquals(9, parser.getObjects().size());
    }

    @Test
    public void removeLatest_removes_latest_match() {
        writer.removeLatest(doc);
        parseDocument();
        assertFalse(parser.getObjects().contains(match9));
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

    @Test
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
    public void written_match_has_correct_opponent_class5() {
        parseDocument();
        match = parser.getObjects().get(4);
        assertEquals(DeckClass.WARRIOR, match.getOpponentClass());
    }

    @Test
    public void written_match_has_correct_opponent_class6() {
        parseDocument();
        match = parser.getObjects().get(5);
        assertEquals(DeckClass.SHAMAN, match.getOpponentClass());
    }

    @Test
    public void written_match_has_correct_opponent_class7() {
        parseDocument();
        match = parser.getObjects().get(6);
        assertEquals(DeckClass.MAGE, match.getOpponentClass());
    }
    
    public void written_match_has_correct_opponent_class8() {
        parseDocument();
        match = parser.getObjects().get(7);
        assertEquals(DeckClass.WARLOCK, match.getOpponentClass());
    }

    @Test
    public void written_match_has_correct_opponent_class9() {
        parseDocument();
        match = parser.getObjects().get(8);
        assertEquals(DeckClass.PRIEST, match.getOpponentClass());
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
        writer.addContent(doc, match6);
        writer.addContent(doc, match7);
        writer.addContent(doc, match8);
        writer.addContent(doc, match9);
    }

    private void parseDocument() {
        parser = new MatchParser(doc);
        parser.addValuesToList();
    }

}
