package logic;

import domain.Deck;
import domain.DeckClass;
import domain.Match;
import domain.Outcome;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatchAssignerTest {

    private final Deck deck;
    private final List<Match> matches;
            
    public MatchAssignerTest() {
        deck = new Deck(DeckClass.DRUID, 1);
        matches = new ArrayList();
        matches.add(new Match(DeckClass.HUNTER, Outcome.WIN, true, 1, 1));
        matches.add(new Match(DeckClass.MAGE, Outcome.LOSS, false, 1, 2));
        MatchAssigner.assignMatchesToDeck(deck, matches);
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
    public void deck_has_matches() {
        assertEquals(matches, deck.getMatches());
    }
    
    @Test
    public void matches_have_player_class_assigned1() {
        assertEquals(DeckClass.DRUID, deck.getMatches().get(0).getPlayerClass());
    }
    
    @Test
    public void matches_have_player_class_assigned2() {
        assertEquals(DeckClass.DRUID, deck.getMatches().get(1).getPlayerClass());
    }
    
    @Test
    public void deck_has_correct_score() {
        assertEquals("1-1", deck.getScore());
    }
    
    @Test
    public void if_only_null_values_are_given_nothing_bad_happens() {
        MatchAssigner.assignMatchesToDeck(null, null);
        assertEquals(true, true);
    }
    
    @Test
    public void deck_is_not_affected_if_no_matches_are_given1() {
        MatchAssigner.assignMatchesToDeck(deck, null);
        assertEquals("1-1", deck.getScore());
    }
    
    @Test
    public void deck_is_not_affected_if_no_matches_are_given2() {
        MatchAssigner.assignMatchesToDeck(deck, new ArrayList<Match>());
        assertEquals("1-1", deck.getScore());
    }
    
    @Test
    public void match_list_size_is_same_if_no_deck_is_given() {
        MatchAssigner.assignMatchesToDeck(null, matches);
        assertEquals(2, matches.size());
    }
}
