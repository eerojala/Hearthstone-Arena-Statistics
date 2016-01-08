package logic;

import domain.Card;
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
import util.TestHelper;

public class DeckClassStatisticsKeeperTest {

    DeckClassStatisticsKeeper keeper;
    Deck deck1;
    Deck deck2;
    Deck deck3;
    Deck deck4;
    Deck deck5;
    DeckClass[] dcExceptions;

    public DeckClassStatisticsKeeperTest() {
        deck1 = new Deck(DeckClass.DRUID, 1);
        deck1.setWins(12);
        deck2 = new Deck(DeckClass.MAGE, 2);
        deck2.setWins(12);
        deck3 = new Deck(DeckClass.DRUID, 3);
        deck3.setWins(4);
        deck4 = new Deck(DeckClass.SHAMAN, 4);
        deck4.setWins(4);
        deck5 = new Deck(DeckClass.MAGE, 5);
        deck5.setWins(7);
        dcExceptions = new DeckClass[3];
        dcExceptions[0] = DeckClass.DRUID;
        dcExceptions[1] = DeckClass.MAGE;
        dcExceptions[2] = DeckClass.SHAMAN;
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Deck> dlist = new ArrayList();
        dlist.add(deck1);
        dlist.add(deck2);
        dlist.add(deck3);
        dlist.add(deck4);
        dlist.add(deck5);
        keeper = new DeckClassStatisticsKeeper();
        keeper.addDecks(dlist);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void decks_by_class_has_correct_values1() {
        assertEquals(2, keeper.getDecksAsClass(DeckClass.DRUID));
    }

    @Test
    public void decks_by_class_has_correct_values2() {
        assertEquals(2, keeper.getDecksAsClass(DeckClass.MAGE));
    }

    @Test
    public void decks_by_class_has_correct_values3() {
        assertEquals(1, keeper.getDecksAsClass(DeckClass.SHAMAN));
    }

    @Test
    public void wins_as_class_has_correct_values1() {
        assertEquals(16, keeper.getWinsAsClass(DeckClass.DRUID));
    }

    @Test
    public void wins_as_class_has_correct_values2() {
        assertEquals(19, keeper.getWinsAsClass(DeckClass.MAGE));
    }

    @Test
    public void wins_as_class_has_correct_values3() {
        assertEquals(4, keeper.getWinsAsClass(DeckClass.SHAMAN));
    }
    
    @Test
    public void average_wins_by_class_has_correct_values1() {
        assertEquals(8.0, keeper.getAverageWinsAsClass(DeckClass.DRUID), 0.0);
    }

    @Test
    public void average_wins_by_class_has_correct_values2() {
        assertEquals(9.5, keeper.getAverageWinsAsClass(DeckClass.MAGE), 0.0);
    }

    @Test
    public void average_wins_by_class_has_correct_values3() {
        assertEquals(4, keeper.getAverageWinsAsClass(DeckClass.SHAMAN), 0.0);
    }

    @Test
    public void average_wins_by_class_has_correct_values4() {
        assertTrue(TestHelper.zeroesInDcDoubleMap(keeper.getStatistics().getAvgWinsAsClass(), dcExceptions));
    }

    @Test
    public void play_percentage_as_class_has_correct_values1() {
        assertEquals(0.4, keeper.getPlayPercentageAsClass(DeckClass.DRUID), 0.0);
    }

    @Test
    public void play_percentage_as_class_has_correct_values2() {
        assertEquals(0.4, keeper.getPlayPercentageAsClass(DeckClass.MAGE), 0.0);
    }

    @Test
    public void play_percentage_as_class_has_correct_values3() {
        assertEquals(0.2, keeper.getPlayPercentageAsClass(DeckClass.SHAMAN), 0.0);
    }

    @Test
    public void play_percentage_as_class_has_correct_values4() {
        assertTrue(TestHelper.zeroesInDcDoubleMap(keeper.getStatistics().getPlayPerAsClass(), dcExceptions));
    }
    
    @Test
    public void remove_deck_affects_decks_by_class() {
        keeper.removeDeck(deck1);
        assertEquals(1, keeper.getDecksAsClass(DeckClass.DRUID));
    }
    
    @Test
    public void remove_deck_affects_wins_by_class() {
        keeper.removeDeck(deck2);
        assertEquals(7, keeper.getWinsAsClass(DeckClass.MAGE));
    }
    
    @Test
    public void remove_deck_affects_average_wins_by_class() {
        keeper.removeDeck(deck5);
        assertEquals(12, keeper.getAverageWinsAsClass(DeckClass.MAGE), 0.0);
    }
    
    @Test
    public void remove_deck_affects_play_percentage_as_class() {
        keeper.removeDeck(deck1);
        assertEquals(0.25, keeper.getPlayPercentageAsClass(DeckClass.DRUID), 0.0);
    }
    
    @Test
    public void set_average_wins_as_class_works_correctly() {
        keeper.setAverageWinsAsClass(DeckClass.MAGE, 4);
        assertEquals(4, keeper.getAverageWinsAsClass(DeckClass.MAGE), 0);
    }
    
    @Test
    public void set_play_percentage_as_class_works_correctly() {
        keeper.setPlayPercentageAsClass(DeckClass.MAGE, 33.3);
        assertEquals(33.3, keeper.getPlayPercentageAsClass(DeckClass.MAGE), 0);
    }
    
    @Test
    public void average_wins_works_correctly() {
        assertEquals(7.8, keeper.getAverageWins(), 0);
    }
    
    @Test
    public void getTotalDeckAmount_works_correctly() {
        assertEquals(5, keeper.getTotalDeckAmount());
    }
    
    @Test
    public void getDecksAsClassWithXWins_works_correctly1() {
        assertEquals(1, keeper.getDecksAsClassWithXWins(DeckClass.MAGE, 12));
    }
    
    @Test
    public void getDecksAsClassWithXWins_works_correctly2() {
        assertEquals(1, keeper.getDecksAsClassWithXWins(DeckClass.MAGE, 7));
    }
    
    @Test
    public void getDecksAsClassWithXWins_works_correctly3() {
        assertEquals(0, keeper.getDecksAsClassWithXWins(DeckClass.MAGE, 0));
    }
    
    @Test
    public void setDecksAsClassWithXWins_works_correctly() {
        keeper.setDecksAsClassWithXWins(DeckClass.MAGE, 3, 1000);
        assertEquals(1000, keeper.getDecksAsClassWithXWins(DeckClass.MAGE, 3));
    }
    
    @Test
    public void getDecksByWins_works_correctly1() {
        assertEquals(2, keeper.getDecksByWins(12));
    }
    
    @Test
    public void getDecksByWins_works_correctly2() {
        assertEquals(2, keeper.getDecksByWins(4));
    }
    
    @Test
    public void getDecksByWins_works_correctly3() {
        assertEquals(1, keeper.getDecksByWins(7));
    }
}
