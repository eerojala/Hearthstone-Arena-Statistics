package logic;

import domain.Deck;
import domain.DeckClass;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.DeckClassList;

public class DeckArchiverTest {

    DeckArchiver archiver;
    Deck deck1;
    Deck deck2;
    Deck deck3;
    Deck deck4;
    boolean bool;
    List<DeckClass> clist;

    public DeckArchiverTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        deck1 = new Deck(DeckClass.DRUID, 1);
        deck1.setWins(12);
        deck2 = new Deck(DeckClass.HUNTER, 2);
        deck2.setWins(6);
        deck3 = new Deck(DeckClass.WARLOCK, 3);
        deck3.setWins(12);
        List<Deck> list = new ArrayList();
        list.add(deck1);
        list.add(deck2);
        list.add(deck3);
        archiver = new DeckArchiver(list);
        deck4 = new Deck(DeckClass.SHAMAN, 4);
        clist = DeckClassList.getDeckClassList();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void decks_by_class_have_decks_correctly1() {
        assertTrue(archiver.getDecksByClass(DeckClass.DRUID).contains(deck1));
    }

    @Test
    public void decks_by_class_have_decks_correctly2() {
        assertTrue(archiver.getDecksByClass(DeckClass.HUNTER).contains(deck2));
    }

    @Test
    public void decks_by_class_have_decks_correctly3() {
        assertTrue(archiver.getDecksByClass(DeckClass.WARLOCK).contains(deck3));
    }

    @Test
    public void decks_by_class_have_decks_correctly4() {
        assertEquals(1, archiver.getDecksByClass(DeckClass.DRUID).size());
    }

    @Test
    public void decks_by_class_have_decks_correctly5() {
        assertEquals(1, archiver.getDecksByClass(DeckClass.HUNTER).size());
    }

    @Test
    public void decks_by_class_have_decks_correctly6() {
        assertEquals(1, archiver.getDecksByClass(DeckClass.WARLOCK).size());
    }

    @Test
    public void decks_by_class_have_decks_correctly7() {
        bool = true;
        for (DeckClass deckClass : clist) {
            if (archiver.getDecksByClass(deckClass) != null && (deckClass != DeckClass.DRUID
                    || deckClass != DeckClass.HUNTER || deckClass != DeckClass.WARLOCK)) {
                bool = false;
                break;
            }
            assertTrue(bool);
        }

    }

    @Test
    public void decks_by_class_returns_null_if_no_decks_found() {
        assertNull(archiver.getDecksByClass(DeckClass.MAGE));
    }

    @Test
    public void decks_by_win_count_have_decks_correctly1() {
        assertTrue(archiver.getDecksByWinCount(12).contains(deck1));
    }

    @Test
    public void decks_by_win_count_have_decks_correctly2() {
        assertTrue(archiver.getDecksByWinCount(6).contains(deck2));
    }

    @Test
    public void decks_by_win_count_have_decks_correctly3() {
        assertTrue(archiver.getDecksByWinCount(12).contains(deck3));
    }

    @Test
    public void decks_by_win_count_have_decks_correctly4() {
        assertEquals(2, archiver.getDecksByWinCount(12).size());
    }

    @Test
    public void decks_by_win_count_have_decks_correctly5() {
        assertEquals(1, archiver.getDecksByWinCount(6).size());
    }

    @Test
    public void decks_by_win_count_have_decks_correctly6() {
        bool = true;
        for (int i = 1; i <= 12; i++) {
            if (archiver.getDecksByWinCount(i) != null && !(i == 6 || i == 12)) {
                bool = false;
                break;
            }
        }
        assertTrue(bool);
    }

    @Test
    public void decks_by_win_count_returns_null_if_no_decks_found() {
        assertNull(archiver.getDecksByWinCount(7));
    }

    @Test
    public void deck_by_number_returns_correct_deck() {
        assertEquals(deck1, archiver.getDeckByNumber(1));
    }

    @Test
    public void deck_by_number_returns_null_if_no_deck_found() {
        assertNull(archiver.getDeckByNumber(4));
    }

    @Test
    public void added_deck_can_be_found_by_number() {
        archiver.addDeckToArchive(deck4);
        assertEquals(deck4, archiver.getDeckByNumber(4));
    }

    @Test
    public void added_deck_can_be_found_by_class() {
        archiver.addDeckToArchive(deck4);
        assertTrue(archiver.getDecksByClass(DeckClass.SHAMAN).contains(deck4));
    }

    @Test
    public void added_deck_can_be_found_by_win_count() {
        deck4.setWins(3);
        archiver.addDeckToArchive(deck4);
        assertTrue(archiver.getDecksByWinCount(3).contains(deck4));
    }
}
