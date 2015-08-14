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

public class MatchArchiverTest {

    MatchArchiver archiver;
    Deck deck1;
    Deck deck2;
    Match match1;
    Match match2;
    Match match3;
    Match match4;
    Match match5;
    boolean bool;
    List<DeckClass> classList;

    public MatchArchiverTest() {

    }

    private void prepareDeck1() {
        DeckHandler handler = new DeckHandler();
        deck1 = new Deck(DeckClass.MAGE, 1);
        handler.setDeck(deck1);
        match1 = new Match(DeckClass.DRUID, "Dennis", Outcome.WIN, true, 1, 1);
        match2 = new Match(DeckClass.DRUID, "Dennis", Outcome.LOSS, false, 1, 2);
        handler.addMatch(match1);
        handler.addMatch(match2);
    }

    private void prepareDeck2() {
        DeckHandler handler = new DeckHandler();
        deck2 = new Deck(DeckClass.SHAMAN, 2);
        handler.setDeck(deck2);
        match3 = new Match(DeckClass.WARRIOR, "", Outcome.DISCONNECT, true, 2, 1);
        match4 = new Match(DeckClass.WARLOCK, "", Outcome.TIE, false, 2, 2);
        handler.addMatch(match3);
        handler.addMatch(match4);
    }

    private void initClassList() {
        classList = new ArrayList();
        classList.add(DeckClass.DRUID);
        classList.add(DeckClass.HUNTER);
        classList.add(DeckClass.MAGE);
        classList.add(DeckClass.PALADIN);
        classList.add(DeckClass.PRIEST);
        classList.add(DeckClass.ROGUE);
        classList.add(DeckClass.SHAMAN);
        classList.add(DeckClass.WARLOCK);
        classList.add(DeckClass.WARRIOR);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        prepareDeck1();
        prepareDeck2();
        List<Deck> list = new ArrayList();
        list.add(deck1);
        list.add(deck2);
        archiver = new MatchArchiver(list);
        initClassList();
        bool = true;
        match5 = new Match(DeckClass.PALADIN, "test", Outcome.DISCONNECT, false,
        3, 1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void matches_by_opponent_class_have_matches_correctly1() {
        assertTrue(archiver.getMatchesByOpponentDeckClass(DeckClass.DRUID).contains(match1));
    }

    @Test
    public void matches_by_opponent_class_have_matches_correctly2() {
        assertTrue(archiver.getMatchesByOpponentDeckClass(DeckClass.DRUID).contains(match2));
    }

    @Test
    public void matches_by_opponent_class_have_matches_correctly3() {
        assertTrue(archiver.getMatchesByOpponentDeckClass(DeckClass.WARRIOR).contains(match3));
    }

    @Test
    public void matches_by_opponent_class_have_matches_correctly4() {
        assertTrue(archiver.getMatchesByOpponentDeckClass(DeckClass.WARLOCK).contains(match4));
    }

    @Test
    public void matches_by_opponent_class_have_matches_correctly5() {
        assertEquals(2, archiver.getMatchesByOpponentDeckClass(DeckClass.DRUID).size());
    }

    @Test
    public void matches_by_opponent_class_have_matches_correctly6() {
        assertEquals(1, archiver.getMatchesByOpponentDeckClass(DeckClass.WARRIOR).size());
    }

    @Test
    public void matches_by_opponent_class_have_matches_correctly7() {
        assertEquals(1, archiver.getMatchesByOpponentDeckClass(DeckClass.WARLOCK).size());
    }

    @Test
    public void matches_by_opponent_class_have_matches_correctly8() {
        for (DeckClass deckClass : classList) {
            if (archiver.getMatchesByOpponentDeckClass(deckClass) != null && !(
                    deckClass == DeckClass.DRUID || deckClass == DeckClass.WARRIOR ||
                    deckClass == DeckClass.WARLOCK)) {
                bool = false;
                break;
            }
        }
        assertTrue(bool);
    }
    
    @Test
    public void matches_by_opponent_class_returns_null_if_no_matches_found() {
        assertNull(archiver.getMatchesByOpponentDeckClass(DeckClass.MAGE));
    }
    
    @Test
    public void matches_by_opponent_have_matches_correctly1() {
        assertTrue(archiver.getMatchesByOpponent("Dennis").contains(match1));
    }
    
    @Test
    public void matches_by_opponent_have_matches_correctly2() {
        assertTrue(archiver.getMatchesByOpponent("Dennis").contains(match2));
    }
    
    @Test
    public void matches_by_opponent_have_matches_correctly3() {
        assertTrue(archiver.getMatchesByOpponent("").contains(match3));
    }
    
    @Test
    public void matches_by_opponent_have_matches_correctly4() {
        assertTrue(archiver.getMatchesByOpponent("").contains(match4));
    }
    
    @Test
    public void matches_by_opponent_have_matches_correctly5() {
        assertEquals(2, archiver.getMatchesByOpponent("Dennis").size());
    }
    
    @Test
    public void matches_by_opponent_have_matches_correctly6() {
        assertEquals(2, archiver.getMatchesByOpponent("").size());
    }
    
    @Test
    public void matches_by_opponent_returns_null_if_no_matches_found() {
        assertNull(archiver.getMatchesByOpponent("UNKNOWN"));
    }
    
    @Test
    public void matches_by_player_class_have_matches_correctly1() {
        assertTrue(archiver.getMatchesByPlayerDeckClass(DeckClass.MAGE).contains(match1));
    }
    
    @Test
    public void matches_by_player_class_have_matches_correctly2() {
        assertTrue(archiver.getMatchesByPlayerDeckClass(DeckClass.MAGE).contains(match2));
    }
    
    @Test
    public void matches_by_player_class_have_matches_correctly3() {
        assertTrue(archiver.getMatchesByPlayerDeckClass(DeckClass.SHAMAN).contains(match3));
    }
    
    @Test
    public void matches_by_player_class_have_matches_correctly4() {
        assertTrue(archiver.getMatchesByPlayerDeckClass(DeckClass.SHAMAN).contains(match4));
    }
    
    @Test
    public void matches_by_player_class_have_matches_correctly5() {
        assertEquals(2, archiver.getMatchesByPlayerDeckClass(DeckClass.MAGE).size());
    }
    
    @Test
    public void matches_by_player_class_have_matches_correctly6() {
        assertEquals(2, archiver.getMatchesByPlayerDeckClass(DeckClass.SHAMAN).size());
    }
    
    @Test
    public void matches_by_player_class_have_matches_correctly7() {
        for (DeckClass deckClass : classList) {
            if (archiver.getMatchesByPlayerDeckClass(deckClass) != null && !(
                    deckClass == DeckClass.MAGE || deckClass == DeckClass.SHAMAN)) {
                bool = false;
                break;
            }
        }
        assertTrue(bool);
    }
    
    @Test
    public void matches_by_player_class_returns_null_if_no_matches_found() {
        assertNull(archiver.getMatchesByPlayerDeckClass(DeckClass.DRUID));
    }
    
    @Test
    public void matches_by_outcome_have_matches_correctly1() {
        assertTrue(archiver.getMatchesByOutcome(Outcome.WIN).contains(match1));
    }
    
    @Test
    public void matches_by_outcome_have_matches_correctly2() {
        assertTrue(archiver.getMatchesByOutcome(Outcome.LOSS).contains(match2));
    }
    
    @Test
    public void matches_by_outcome_have_matches_correctly3() {
        assertTrue(archiver.getMatchesByOutcome(Outcome.DISCONNECT).contains(match3));
    }
    
    @Test
    public void matches_by_outcome_have_matches_correctly4() {
        assertTrue(archiver.getMatchesByOutcome(Outcome.WIN).contains(match1));
    }
    
    @Test
    public void matches_by_outcome_have_matches_correctly5() {
        assertEquals(1, archiver.getMatchesByOutcome(Outcome.WIN).size());
    }
    
    @Test
    public void matches_by_outcome_have_matches_correctly6() {
        assertEquals(1, archiver.getMatchesByOutcome(Outcome.LOSS).size());
    }
    
    @Test
    public void matches_by_outcome_have_matches_correctly7() {
        archiver.addMatchToArchive(match5);
        assertEquals(2, archiver.getMatchesByOutcome(Outcome.DISCONNECT).size());
    }
    
    @Test
    public void matches_by_outcome_have_matches_correctly8() {
        assertEquals(1, archiver.getMatchesByOutcome(Outcome.TIE).size());
    }
    
    @Test
    public void matches_by_outcome_returns_null_if_no_matches_found() {
       Deck deck = new Deck(DeckClass.DRUID, 4);
       Match match = new Match(DeckClass.MAGE, "fsads", Outcome.WIN, true, 4, 1);
       List<Match> list = new ArrayList();
       list.add(match);
       deck.setMatches(list);
       List<Deck> decklist = new ArrayList();
       decklist.add(deck);
       MatchArchiver arc = new MatchArchiver(decklist);
       assertNull(arc.getMatchesByOutcome(Outcome.LOSS));
    }
    
    @Test
    public void matches_by_ID_have_matches_correctly1() {
        assertEquals(match1, archiver.getMatchByID("1.1"));
    }
    
    @Test
    public void matches_by_ID_have_matches_correctly2() {
        assertEquals(match2, archiver.getMatchByID("1.2"));
    }
    
    @Test
    public void matches_by_ID_have_matches_correctly3() {
        assertEquals(match3, archiver.getMatchByID("2.1"));
    }
    
    @Test
    public void matches_by_ID_have_matches_correctly4() {
        assertEquals(match4, archiver.getMatchByID("2.2"));
    }
    
    @Test
    public void matches_by_ID_returns_null_if_no_matches_found() {
        assertNull(archiver.getMatchByID("1.3"));
    }
    
    @Test
    public void added_match_can_be_found_by_ID() {
        archiver.addMatchToArchive(match5);
        assertEquals(match5, archiver.getMatchByID("3.1"));
    }
    
    @Test
    public void added_match_can_be_found_by_opponent() {
        archiver.addMatchToArchive(match5);
        assertTrue(archiver.getMatchesByOpponent("test").contains(match5));
    }
    
    @Test
    public void added_match_can_be_found_by_player_class() {
        match5.setPlayerDeckClass(DeckClass.ROGUE);
        archiver.addMatchToArchive(match5);
        assertTrue(archiver.getMatchesByPlayerDeckClass(DeckClass.ROGUE).contains(match5));
    }
    
    @Test
    public void added_match_can_be_found_by_opponent_class() {
        archiver.addMatchToArchive(match5);
        assertTrue(archiver.getMatchesByOpponentDeckClass(DeckClass.PALADIN).contains(match5));
    }
    
    @Test
    public void added_match_can_be_found_by_outcome() {
        archiver.addMatchToArchive(match5);
        assertTrue(archiver.getMatchesByOutcome(Outcome.DISCONNECT).contains(match5));
    }
    
}
