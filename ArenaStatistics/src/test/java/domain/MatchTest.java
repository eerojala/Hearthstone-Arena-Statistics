package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatchTest {

    Deck deck;
    Match match1;
    Match match2;
    Match match3;
    Match match4;
    List<Match> matches;

    public MatchTest() {
        deck = new Deck(DeckClass.WARLOCK, 1);
        match1 = new Match(DeckClass.SHAMAN, "Test1", Outcome.WIN, true, 1, 1);
        match3 = new Match(DeckClass.DRUID, "teasdasd", Outcome.LOSS, false, 2, 1);
        match4 = new Match(DeckClass.PALADIN, "f3w3wr3", Outcome.DISCONNECT, true, 1, 6);
        matches = new ArrayList();
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
    public void equals_returns_false_if_wrong_class() {
        assertEquals(false, match1.equals(deck));
    }

    @Test
    public void equals_returns_false_if_deck_is_different() {
        match2 = new Match(DeckClass.SHAMAN, "Test1", Outcome.WIN,
                true, 2, 1);
        assertEquals(false, match1.equals(match2));
    }

    @Test
    public void equals_returns_false_if_different_match_number() {
        match2 = new Match(DeckClass.SHAMAN, "Test1", Outcome.WIN,
                true, 1, 2);
        assertEquals(false, match1.equals(match2));
    }

    @Test
    public void equals_returns_true_if_same() {
        match2 = new Match(DeckClass.SHAMAN, "Test1", Outcome.WIN,
                true, 1, 1);
        assertEquals(true, match1.equals(match2));
    }
    
    @Test
    public void compareTo_sorts_correctly_if_different_deck_number1() {
        matches.add(match3);
        matches.add(match1);
        Collections.sort(matches);
        assertEquals(match1, matches.get(0));
    }
    
    @Test
    public void compareTo_sorts_correctly_if_different_deck_number2() {
        matches.add(match3);
        matches.add(match4);
        Collections.sort(matches);
        assertEquals(match4, matches.get(0));
    }
    
    @Test
    public void compareTo_sorts_correctly_if_same_deck_number() {
        matches.add(match4);
        matches.add(match1);
        Collections.sort(matches);
        assertEquals(match1, matches.get(0));
        
    }
}
