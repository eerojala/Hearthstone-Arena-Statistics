//package logic;
//
//import domain.Deck;
//import domain.DeckClass;
//import domain.Match;
//import domain.Outcome;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class MatchAssignerTest {
//
//    MatchAssigner assigner;
//    List<Match> matches;
//    List<Deck> decks;
//    Deck deck;
//    Match match;
//    boolean bool;
//
//    public MatchAssignerTest() {
//        assigner = new MatchAssigner();
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        matches = new ArrayList();
//        decks = new ArrayList();
//        addDecks();
//        addMatches();
//        assigner.assignMatches(decks, matches);
//        bool = true;
//    }
//
//    private void addDecks() {
//        deck = new Deck(DeckClass.DRUID, 1);
//        decks.add(new Deck(DeckClass.PRIEST, 2));
//        decks.add(new Deck(DeckClass.HUNTER, 3));
//        decks.add(deck);
//    }
//    
//    private void addMatches() {
//        match = new Match(DeckClass.ROGUE, "", Outcome.DISCONNECT, true, 1, 1);
//        matches.add(new Match(DeckClass.WARLOCK, "", Outcome.WIN, true, 2, 2));
//        matches.add(new Match(DeckClass.MAGE, "", Outcome.LOSS, false, 1, 3));
//        matches.add(match);
//        matches.add(new Match(DeckClass.SHAMAN, "", Outcome.LOSS, false, 1, 2));
//        matches.add(new Match(DeckClass.DRUID, "", Outcome.WIN, true, 2, 1));
//        matches.add(new Match(DeckClass.HUNTER, "", Outcome.WIN, false, 2, 4));
//        matches.add(new Match(DeckClass.WARRIOR, "", Outcome.WIN, true, 2, 6));
//        matches.add(new Match(DeckClass.WARLOCK, "", Outcome.WIN, false, 2, 5));
//        matches.add(new Match(DeckClass.MAGE, "", Outcome.WIN, true, 2, 3));
//        matches.add(new Match(DeckClass.SHAMAN, "", Outcome.WIN, true, 2, 7));
//        matches.add(new Match(DeckClass.PRIEST, "", Outcome.WIN, false, 2, 8));
//        matches.add(new Match(DeckClass.PALADIN, "", Outcome.WIN, true, 2, 9));
//        matches.add(new Match(DeckClass.WARLOCK, "", Outcome.WIN, false, 2, 10));
//        matches.add(new Match(DeckClass.HUNTER, "", Outcome.WIN, true, 2, 11));
//        matches.add(new Match(DeckClass.MAGE, "", Outcome.WIN, false, 2, 12));
//        matches.add(new Match(DeckClass.PALADIN, "", Outcome.DISCONNECT, true, 3, 1));
//        matches.add(new Match(DeckClass.SHAMAN, "", Outcome.WIN, false, 3, 2));
//    }
//
//    @Test
//    public void assignMatches_sorts_decklist() {
//        assertEquals(deck, decks.get(0));
//    }
//    
//    @Test
//    public void assignMatches_sorts_matchlist() {
//        assertEquals(match, matches.get(0));
//    }
//    
//    @Test
//    public void deck_has_correct_win_count1() {
//        assertEquals(0, decks.get(0).getWins());
//    }
//    
//    @Test
//    public void deck_has_correct_win_count2() {
//        assertEquals(12, decks.get(1).getWins());
//    }
//    
//    @Test
//    public void deck_has_correct_win_count3() {
//        assertEquals(1, decks.get(2).getWins());
//    }
//    
//    @Test
//    public void deck_has_correct_loss_count1() {
//        assertEquals(3, decks.get(0).getLosses());
//    }
//    
//    @Test
//    public void deck_has_correct_loss_count2() {
//        assertEquals(0, decks.get(1).getLosses());
//    }
//    
//    @Test
//    public void deck_has_correct_loss_count3() {
//        assertEquals(1, decks.get(2).getLosses());
//    }
//    
//    @Test
//    public void matches_are_connected_to_correct_decks1() {
//        for (int i = 0; i < 3; i++) {
//            if (!matches.get(i).getDeck().equals(decks.get(0))) {
//                bool = false;
//            }
//        }
//        assertTrue(bool);
//    }
//    
//    @Test
//    public void matches_are_connected_to_correct_decks2() {
//        for (int i = 3; i < 15; i++) {
//            if (!matches.get(i).getDeck().equals(decks.get(1))) {
//                bool = false;
//            }
//        }
//        assertTrue(bool);
//    }
//    
//    @Test
//    public void matches_are_connected_to_correct_decks3() {
//        for (int i = 15; i < 17; i++) {
//            if (!matches.get(i).getDeck().equals(decks.get(2))) {
//                bool = false;
//            }
//        }
//        assertTrue(bool);
//    }
//    
//    @Test
//    public void decks_have_correct_match_amount1() {
//        assertEquals(3, decks.get(0).getMatches().size());
//    }
//    
//    @Test
//    public void decks_have_correct_match_amount2() {
//        assertEquals(12, decks.get(1).getMatches().size());
//    }
//    
//    @Test
//    public void decks_have_correct_match_amount3() {
//        assertEquals(2, decks.get(2).getMatches().size());
//    }
//    
//    @Test
//    public void decks_have_correct_matches1() {
//        deck = decks.get(0);
//        for (int i = 0; i < 3; i++) {
//            if (!deck.getMatches().get(i).equals(matches.get(i))) {
//                bool = false;
//            }
//        }
//        assertTrue(bool);
//    }
//    
//    @Test
//    public void decks_have_correct_matches2() {
//        deck = decks.get(1);
//        int j = 0;
//        for (int i = 3; i < 15; i++) {
//            if (!deck.getMatches().get(j).equals(matches.get(i))) {
//                bool = false;
//            }
//            j++;
//        }
//        assertTrue(bool);
//    }
//    
//    @Test
//    public void decks_have_correct_matches3() {
//        deck = decks.get(2);
//        int j = 0;
//        for (int i = 15; i < 17; i++) {
//            if (!deck.getMatches().get(j).equals(matches.get(i))) {
//                bool = false;
//            }
//            j++;
//        }
//        assertTrue(bool);
//    }
//
//}
