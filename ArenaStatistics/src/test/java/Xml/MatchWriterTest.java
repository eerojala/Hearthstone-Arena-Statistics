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

    MatchWriter writer;
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
    Match match10;
    String filePath;

    public MatchWriterTest() {
        filePath = "src/main/resources/MatchWriteTest.xml";
        writer = new MatchWriter(filePath);
        match1 = new Match(DeckClass.PALADIN, "Dennis", Outcome.DISCONNECT, true, 1, 1);
        match2 = new Match(DeckClass.ROGUE, "UNKNOWN", Outcome.WIN, false, 2, 1);
        match3 = new Match(DeckClass.HUNTER, "öööö", Outcome.LOSS, true, 3, 1);
        match4 = new Match(DeckClass.DRUID, "weweq", Outcome.TIE, false, 4, 1);
        match5 = new Match(DeckClass.WARRIOR, "", Outcome.WIN, true, 5, 1);
        match6 = new Match(DeckClass.SHAMAN, "", Outcome.LOSS, false, 6, 1);
        match7 = new Match(DeckClass.MAGE, "fafasdf", Outcome.DISCONNECT, true, 7, 1);
        match8 = new Match(DeckClass.WARLOCK, "fr3fseew3", Outcome.WIN, false, 8, 1);
        match9 = new Match(DeckClass.PRIEST, "332424", Outcome.LOSS, true, 9, 1);
        match10 = new Match(DeckClass.PALADIN, "", Outcome.WIN, true, 5, 2);
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
        match = parser.getMatches().get(0);
        assertEquals(match, match1);
    }

    @Test
    public void addContent_adds_all_matches() {
        parseDocument();
        assertEquals(10, parser.getMatches().size());
    }

    @Test
    public void removeLatest_removes_latest_match() {
        writer.removeLatest(doc);
        parseDocument();
        assertFalse(parser.getMatches().contains(match10));
    }

    @Test
    public void removeAll_removes_every_match() {
        writer.removeAll(doc);
        parseDocument();
        assertTrue(parser.getMatches().isEmpty());
    }

    @Test
    public void remove_removes_correct_match() {
        writer.remove(doc, "3.1");
        parseDocument();
        assertTrue(!parser.getMatches().contains(match3));
    }
    
    @Test
    public void removeMatchesFromASpecificDeck_removes_correct_matches() {
        writer.removeMatchesFromASpecificDeck(doc, 5);
        boolean bool = true;
        parseDocument();
        for (int i = 0; i < parser.getMatches().size(); i++) {
            if (parser.getMatches().get(i).getDeckNumber() == 5) {
                bool = false;
            }
        }
        assertTrue(bool);
    }

    @Test
    public void written_match_has_correct_opponent_class1() {
        parseDocument();
        match = parser.getMatches().get(0);
        assertEquals(DeckClass.PALADIN, match.getOpponentDeckClass());
    }

    @Test
    public void written_match_has_correct_opponent_class2() {
        parseDocument();
        match = parser.getMatches().get(1);
        assertEquals(DeckClass.ROGUE, match.getOpponentDeckClass());
    }

    @Test
    public void written_match_has_correct_opponent_class3() {
        parseDocument();
        match = parser.getMatches().get(2);
        assertEquals(DeckClass.HUNTER, match.getOpponentDeckClass());
    }

    @Test
    public void written_match_has_correct_opponent_class4() {
        parseDocument();
        match = parser.getMatches().get(3);
        assertEquals(DeckClass.DRUID, match.getOpponentDeckClass());
    }

    @Test
    public void written_match_has_correct_opponent_class5() {
        parseDocument();
        match = parser.getMatches().get(4);
        assertEquals(DeckClass.WARRIOR, match.getOpponentDeckClass());
    }

    @Test
    public void written_match_has_correct_opponent_class6() {
        parseDocument();
        match = parser.getMatches().get(5);
        assertEquals(DeckClass.SHAMAN, match.getOpponentDeckClass());
    }

    @Test
    public void written_match_has_correct_opponent_class7() {
        parseDocument();
        match = parser.getMatches().get(6);
        assertEquals(DeckClass.MAGE, match.getOpponentDeckClass());
    }
    
    public void written_match_has_correct_opponent_class8() {
        parseDocument();
        match = parser.getMatches().get(7);
        assertEquals(DeckClass.WARLOCK, match.getOpponentDeckClass());
    }

    @Test
    public void written_match_has_correct_opponent_class9() {
        parseDocument();
        match = parser.getMatches().get(8);
        assertEquals(DeckClass.PRIEST, match.getOpponentDeckClass());
    }

    @Test
    public void written_match_has_correct_opponent_name1() {
        parseDocument();
        match = parser.getMatches().get(2);
        assertEquals("öööö", match.getOpponentName());
    }
    
    @Test
    public void written_match_has_correct_opponent_name2() {
        parseDocument();
        match = parser.getMatches().get(4);
        assertTrue(match.getOpponentName().isEmpty());
    }

    @Test
    public void written_match_has_correct_outcome1() {
        parseDocument();
        match = parser.getMatches().get(0);
        assertEquals(Outcome.DISCONNECT, match.getOutcome());
    }
    
    @Test
    public void written_match_has_correct_outcome2() {
        parseDocument();
        match = parser.getMatches().get(1);
        assertEquals(Outcome.WIN, match.getOutcome());
    }
    
    @Test
    public void written_match_has_correct_outcome3() {
        parseDocument();
        match = parser.getMatches().get(2);
        assertEquals(Outcome.LOSS, match.getOutcome());
    }
    
    @Test
    public void written_match_has_correct_outcome4() {
        parseDocument();
        match = parser.getMatches().get(3);
        assertEquals(Outcome.TIE, match.getOutcome());
    }
    
    @Test
    public void written_match_has_correct_wentFirst_boolean() {
        parseDocument();
        match = parser.getMatches().get(1);
        assertFalse(match.wentFirst());
    }

    @Test
    public void written_match_has_correct_deck_number() {
        parseDocument();
        match = parser.getMatches().get(2);
        assertEquals(3, match.getDeckNumber());
    }

    @Test
    public void written_match_has_correct_match_number() {
        parseDocument();
        match = parser.getMatches().get(0);
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
        writer.addContent(doc, match10);
    }

    private void parseDocument() {
        parser = new MatchParser(doc);
        parser.addValues();
    }

}
