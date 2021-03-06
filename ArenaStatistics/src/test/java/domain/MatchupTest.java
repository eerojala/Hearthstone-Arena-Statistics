package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatchupTest {

    Matchup dcp1;
    Matchup dcp2;

    public MatchupTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dcp1 = new Matchup(DeckClass.SHAMAN, DeckClass.DRUID);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void equals_returns_false_if_compared_to_null() {
        assertFalse(dcp1.equals(null));
    }

    @Test
    public void equals_returns_false_if_compared_to_different_class() {
        assertFalse(dcp1.equals(new Deck(DeckClass.DRUID, 1)));
    }

    @Test
    public void equals_returns_false_if_different_player_deck_class() {
        dcp2 = new Matchup(DeckClass.MAGE, DeckClass.DRUID);
        assertFalse(dcp1.equals(dcp2));
    }

    @Test
    public void equals_returns_false_if_different_opponent_deck_class() {
        dcp2 = new Matchup(DeckClass.SHAMAN, DeckClass.ROGUE);
        assertFalse(dcp1.equals(dcp2));
    }

    @Test
    public void equals_returns_true_if_same_player_and_opponent_deck_class() {
        dcp2 = new Matchup(DeckClass.SHAMAN, DeckClass.DRUID);
        assertTrue(dcp1.equals(dcp2));
    }

    @Test
    public void deckClassPairList_is_correct_size() {
        assertEquals(81, Matchup.getMatchupList().size());
    }

    @Test
    public void deckClassPairList_has_all_DeckClassPairs() {
        boolean bool = true;
        for (DeckClass dc1 : DeckClass.values()) {
            for (DeckClass dc2 : DeckClass.values()) {
                Matchup dcp = new Matchup(dc1, dc2);
                if (!Matchup.getMatchupList().contains(dcp)) {
                    bool = false;
                    break;
                }
            }
        }
        assertTrue(bool);
    }

    @Test
    public void parseDeckClassPair_works_correctly() {
        boolean bool = true;
        for (DeckClass dc1 : DeckClass.values()) {
            for (DeckClass dc2 : DeckClass.values()) {
                Matchup dcp1 = new Matchup(dc1, dc2);
                Matchup dcp2 = Matchup.parseMatchup(dcp1.toString());
                if (!dcp1.equals(dcp2)) {
                    bool = false;
                    break;
                }
            }
        }
        assertTrue(bool);
    }
    
    @Test
    public void parseDeckClassPair_returns_null_if_not_valid_DeckClassPair() {
        assertNull(Matchup.parseMatchup("ShamanVSTest"));
    }
}
