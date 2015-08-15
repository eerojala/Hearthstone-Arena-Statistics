
package logic;

import domain.Card;
import domain.Deck;
import domain.DeckClass;
import domain.DeckStatistics;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.TestForLoop;

public class DeckStatisticsKeeperTest {
    DeckStatisticsKeeper keeper;
    Deck deck1;
    Deck deck2;
    Deck deck3;
    Deck deck4;
    Deck deck5;
    
    public DeckStatisticsKeeperTest() {
        deck1 = new Deck(DeckClass.DRUID, 1);
        deck1.setDust(200);
        deck1.setGold(200);
        deck1.setWins(12);
        deck1.setExtraPacks(1);
        deck2 = new Deck(DeckClass.MAGE, 2);
        deck2.setDust(120);
        deck2.setGold(240);
        deck2.setWins(12);
        deck3 = new Deck(DeckClass.DRUID, 3);
        deck3.setDust(40);
        deck3.setGold(50);
        deck3.setWins(4);
        deck4 = new Deck(DeckClass.SHAMAN, 4);
        deck4.setDust(20);
        deck4.setGold(30);
        deck4.setWins(4);
        deck5 = new Deck(DeckClass.MAGE, 5);
        deck5.setDust(50);
        deck5.setGold(100);
        deck5.setWins(7);
        deckCards();  
    }
    
    private void deckCards() {
        List<Card> clist = new ArrayList();
        clist.add(Card.RARE);
        deck3.setCards(clist);
        clist = new ArrayList();
        clist.add(Card.RARE);
        clist.add(Card.COMMON_GOLD);
        deck4.setCards(clist);
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
        keeper = new DeckStatisticsKeeper();
        keeper.addDecks(dlist);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void decks_by_class_has_correct_values1() {
        assertEquals(2, keeper.getDecksByClass(DeckClass.DRUID));
    }
    
    @Test
    public void decks_by_class_has_correct_values2() {
        assertEquals(2, keeper.getDecksByClass(DeckClass.MAGE));
    }
    
    @Test
    public void decks_by_class_has_correct_values3() {
        assertEquals(1, keeper.getDecksByClass(DeckClass.SHAMAN));
    }
    
    @Test
    public void decks_by_class_has_correct_values4() {
        assertTrue(TestForLoop.zeroesInDcIntegerMap(keeper.getStatistics().getDecksByClass(),
                DeckClass.DRUID, DeckClass.MAGE, DeckClass.SHAMAN));
    }
    
    @Test
    public void wins_by_class_has_correct_values1() {
        assertEquals(16, keeper.getWinsByClass(DeckClass.DRUID));
    }
    
    @Test
    public void wins_by_class_has_correct_values2() {
        assertEquals(19, keeper.getWinsByClass(DeckClass.MAGE));
    }
    
    @Test
    public void wins_by_class_has_correct_values3() {
        assertEquals(4, keeper.getWinsByClass(DeckClass.SHAMAN));
    }
    
    @Test
    public void wins_by_class_has_correct_values4() {
        assertTrue(TestForLoop.zeroesInDcIntegerMap(keeper.getStatistics().getWinsByClass(), 
                DeckClass.DRUID, DeckClass.MAGE, DeckClass.SHAMAN));
    }
    
    @Test
    public void decks_by_wins_has_correct_values1() {
        assertEquals(2, keeper.getDecksByWins(12));
    }
    
    @Test
    public void decks_by_wins_has_correct_values2() {
        assertEquals(2, keeper.getDecksByWins(4));
    }
    
    @Test
    public void decks_by_wins_has_correct_values3() {
        assertEquals(1, keeper.getDecksByWins(7));
    }
    
    @Test
    public void decks_by_wins_has_correct_values4() {
        assertTrue(TestForLoop.zeroesInIntegerIntegerMap(keeper.getStatistics().getDecksByWins(),
                12, 4, 7));
    }
    
    @Test
    public void dust_by_wins_has_correct_values1() {
        assertEquals(320, keeper.getDustByWins(12));
    }
    
    @Test
    public void dust_by_wins_has_correct_values2() {
        assertEquals(60, keeper.getDustByWins(4));
    }
    
    @Test
    public void dust_by_wins_has_correct_values3() {
        assertEquals(50, keeper.getDustByWins(7));
    }
    
    @Test
    public void dust_by_wins_has_correct_values4() {
        assertTrue(TestForLoop.zeroesInIntegerIntegerMap(keeper.getStatistics().getDustByWins(), 
                12, 4, 7));
    }
    
    @Test
    public void gold_by_wins_has_correct_values1() {
        assertEquals(440, keeper.getGoldByWins(12));
    }
    
    @Test
    public void gold_by_wins_has_correct_values2() {
        assertEquals(80, keeper.getGoldByWins(4));
    }
    
    @Test
    public void gold_by_wins_has_correct_values3() {
        assertEquals(100, keeper.getGoldByWins(7));
    }
    
    @Test
    public void gold_by_wins_has_correct_values4() {
        assertTrue(TestForLoop.zeroesInIntegerIntegerMap(keeper.getStatistics().getGoldByWins(),
                12, 4, 7));
    }
    
    @Test
    public void extra_packs_by_wins_has_correct_values1() {
        assertEquals(1, keeper.getExtraPacksByWins(12));
    }
    
    @Test
    public void extra_packs_by_wins_has_correct_values2() {
        assertTrue(TestForLoop.zeroesInIntegerIntegerMap(keeper.getStatistics().getExtraPacksByWins(), 12));
    }
    
    @Test
    public void cards_by_wins_has_correct_values1() {
        assertEquals(2, keeper.getRegularCardsByWins(4));
    }
    
    @Test
    public void cards_by_wins_has_correct_values2() {
        assertTrue(TestForLoop.zeroesInIntegerIntegerMap(keeper.getStatistics().getCardsByWins(), 4));
    }
    
    @Test
    public void gold_cards_by_wins_has_correct_values1() {
        assertEquals(1, keeper.getGoldCardsByWins(4));
    }
    
    @Test
    public void gold_cards_by_wins_has_correct_values2() {
        assertTrue(TestForLoop.zeroesInIntegerIntegerMap(keeper.getStatistics().getGoldCardsByWins(), 4));
    }
}
