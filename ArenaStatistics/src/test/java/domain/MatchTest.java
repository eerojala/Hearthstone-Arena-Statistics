package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatchTest {

    ArenaDeck deck;
    Match match1;
    Match match2;

    public MatchTest() {
        deck = new ArenaDeck(DeckClass.WARLOCK, 1);
        match1 = new Match(deck.getPlayerClass(), DeckClass.SHAMAN, "Test1", Outcome.WIN,
                deck.getDeckNumber(), 1);
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
        match2 = new Match(DeckClass.WARLOCK, DeckClass.SHAMAN, "Test1", Outcome.WIN,
                2, 1);
        assertEquals(false, match1.equals(match2));
    }

    @Test
    public void equals_returns_false_if_different_match_number() {
        match2 = new Match(deck.getPlayerClass(), DeckClass.SHAMAN, "Test1", Outcome.WIN,
                1, 2);
        assertEquals(false, match1.equals(match2));
    }

    @Test
    public void equals_returns_true_if_same() {
        match2 = new Match(deck.getPlayerClass(), DeckClass.SHAMAN, "Test1", Outcome.WIN,
                1, 1);
        assertEquals(true, match1.equals(match2));
    }
}
