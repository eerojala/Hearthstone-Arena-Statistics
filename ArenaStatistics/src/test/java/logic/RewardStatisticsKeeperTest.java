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
import util.TestForLoop;

public class RewardStatisticsKeeperTest {

    RewardStatisticsKeeper keeper;
    Deck deck1;
    Deck deck2;
    Deck deck3;
    Deck deck4;
    Deck deck5;
    int[] intExceptions;

    public RewardStatisticsKeeperTest() {
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
        intExceptions = new int[3];
        intExceptions[0] = 12;
        intExceptions[1] = 4;
        intExceptions[2] = 7;
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
        keeper = new RewardStatisticsKeeper();
        keeper.addDecks(dlist);
    }

    @After
    public void tearDown() {
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
        assertTrue(TestForLoop.zeroesInIntIntMap(keeper.getStatistics().getDecksByWins(), intExceptions));
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
        assertTrue(TestForLoop.zeroesInIntIntMap(keeper.getStatistics().getDustByWins(), intExceptions));
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
        assertTrue(TestForLoop.zeroesInIntIntMap(keeper.getStatistics().getGoldByWins(), intExceptions));
    }

    @Test
    public void extra_packs_by_wins_has_correct_values1() {
        assertEquals(1, keeper.getExtraPacksByWins(12));
    }

    @Test
    public void extra_packs_by_wins_has_correct_values2() {
        assertTrue(TestForLoop.zeroesInIntIntMap(keeper.getStatistics().getExtraPacksByWins(), 12));
    }

    @Test
    public void cards_by_wins_has_correct_values1() {
        assertEquals(2, keeper.getRegularCardsByWins(4));
    }

    @Test
    public void cards_by_wins_has_correct_values2() {
        assertTrue(TestForLoop.zeroesInIntIntMap(keeper.getStatistics().getCardsByWins(), 4));
    }

    @Test
    public void gold_cards_by_wins_has_correct_values1() {
        assertEquals(1, keeper.getGoldCardsByWins(4));
    }

    @Test
    public void gold_cards_by_wins_has_correct_values2() {
        assertTrue(TestForLoop.zeroesInIntIntMap(keeper.getStatistics().getGoldCardsByWins(), 4));
    }
    
    @Test
    public void getTotalDeckAmount_works_correctly() {
        assertEquals(5, keeper.getTotalDeckAmount());
    }

    @Test
    public void average_dust_by_wins_has_correct_values1() {
        assertEquals(160, keeper.getAverageDustByWins(12), 0.0);
    }

    @Test
    public void average_dust_by_wins_has_correct_values2() {
        assertEquals(30, keeper.getAverageDustByWins(4), 0.0);
    }

    @Test
    public void average_dust_by_wins_has_correct_values3() {
        assertEquals(50, keeper.getAverageDustByWins(7), 0.0);
    }

    @Test
    public void average_dust_by_wins_has_correct_values4() {
        assertTrue(TestForLoop.zeroesInIntDoubleMap(keeper.getStatistics().getAvgDustByWins(), intExceptions));
    }
    
    @Test
    public void average_gold_by_wins_has_correct_values1() {
        assertEquals(220, keeper.getAverageGoldByWins(12), 0.0);
    }
    
    @Test
    public void average_gold_by_wins_has_correct_values2() {
        assertEquals(40, keeper.getAverageGoldByWins(4), 0.0);
    }
    
    @Test
    public void average_gold_by_wins_has_correct_values3() {
        assertEquals(100, keeper.getAverageGoldByWins(7), 0.0);
    }
    
    @Test
    public void average_gold_by_wins_has_correct_values4() {
        assertTrue(TestForLoop.zeroesInIntDoubleMap(keeper.getStatistics().getAvgGoldByWins(), intExceptions));
    }
    
    @Test
    public void average_extra_packs_by_wins_has_correct_values1() {
        assertEquals(0.5, keeper.getAverageExtraPacksByWins(12), 0.0);
    }
    
    @Test
    public void average_extra_packs_by_wins_has_correct_values2() {
        assertTrue(TestForLoop.zeroesInIntDoubleMap(keeper.getStatistics().getAvgExtraPacksByWins(), 12));
    }
    
    @Test
    public void average_cards_by_wins_has_correct_values1() {
        assertEquals(1, keeper.getAverageRegularCardsByWins(4), 0);
    }
    
    @Test
    public void average_cards_by_wins_has_correct_values2() {
        assertTrue(TestForLoop.zeroesInIntDoubleMap(keeper.getStatistics().getAvgCardsByWins(), 4));
    }
    
    @Test
    public void average_gold_cards_by_wins_has_correct_values1() {
        assertEquals(0.5, keeper.getAverageGoldCardsByWins(4), 0);
    }
    
    @Test
    public void average_gold_cards_by_wins_has_correct_values2() {
        assertTrue(TestForLoop.zeroesInIntDoubleMap(keeper.getStatistics().getAvgGoldCardsByWins(), 4));
    }
    
    @Test
    public void get_total_deck_amount_works_correctly() {
        assertEquals(5, keeper.getTotalDeckAmount());
    }
    
    @Test
    public void percentageOutOfAllDecks_works_correctly1() {
        assertEquals(0.4, keeper.getPercentageOutOfAllDecks(12), 0);
    }
    
    @Test
    public void percentageOutOfAllDecks_works_correctly2() {
        assertEquals(0.4, keeper.getPercentageOutOfAllDecks(4), 0);
    }
    
    @Test
    public void percentageOutOfAllDecks_works_correctly3() {
        assertEquals(0.2, keeper.getPercentageOutOfAllDecks(7), 0);
    }
    
    @Test
    public void remove_deck_affects_decks_by_wins() {
        keeper.removeDeck(deck3);
        assertEquals(1, keeper.getDecksByWins(4));
    }
    
    @Test
    public void remove_deck_affects_dust_by_wins() {
        keeper.removeDeck(deck4);
        assertEquals(40, keeper.getDustByWins(4));
    }
    
    @Test
    public void remove_deck_affects_gold_by_wins() {
        keeper.removeDeck(deck1);
        assertEquals(240, keeper.getGoldByWins(12));
    }
    
    @Test
    public void remove_deck_affects_extra_packs_by_wins() {
        keeper.removeDeck(deck1);
        assertEquals(0, keeper.getExtraPacksByWins(12));
    }
    
    @Test
    public void remove_deck_affects_regular_cards_by_wins() {
        keeper.removeDeck(deck3);
        assertEquals(1, keeper.getRegularCardsByWins(4));
    }
    
    @Test
    public void remove_deck_affects_gold_cards_by_wins() {
        keeper.removeDeck(deck4);
        assertEquals(0, keeper.getGoldCardsByWins(4));
    }
    
    @Test
    public void remove_deck_affects_average_dust_by_wins() {
        keeper.removeDeck(deck2);
        assertEquals(200, keeper.getAverageDustByWins(12), 0);
    }
    
    @Test
    public void remove_deck_affects_average_gold_by_wins() {
        keeper.removeDeck(deck3);
        assertEquals(30, keeper.getAverageGoldByWins(4), 0);
    }
    
    @Test
    public void remove_deck_affects_average_extra_packs_by_wins() {
        keeper.removeDeck(deck1);
        assertEquals(0, keeper.getAverageExtraPacksByWins(12), 0);
    }
    
    @Test
    public void remove_deck_affects_average_regular_cards_by_wins() {
        keeper.removeDeck(deck3);
        keeper.removeDeck(deck4);
        assertEquals(0, keeper.getAverageRegularCardsByWins(4), 0);
    }
    
    @Test
    public void remove_deck_affects_average_gold_cards_by_wins() {
        keeper.removeDeck(deck4);
        assertEquals(0, keeper.getAverageGoldCardsByWins(4), 0);
    }
    
    @Test
    public void set_decks_by_wins_works_correctly() {
        keeper.setDecksByWins(0, 4444);
        assertEquals(4444, keeper.getDecksByWins(0));
    }
    
    @Test
    public void set_dust_by_wins_works_correctly() {
        keeper.setDustByWins(3, 333);
        assertEquals(333, keeper.getDustByWins(3));
    }
    
    @Test
    public void set_gold_by_wins_works_correctly() {
        keeper.setGoldByWins(5, 1);
        assertEquals(1, keeper.getGoldByWins(5));
    }
    
    @Test
    public void set_extra_packs_by_wins_works_correctly() {
        keeper.setExtraPacksByWins(8, 22);
        assertEquals(22, keeper.getExtraPacksByWins(8));
    }
    
    @Test
    public void set_regular_cards_by_wins_works_correctly() {
        keeper.setRegularCardsByWins(9, 3);
        assertEquals(3, keeper.getRegularCardsByWins(9));
    }
    
    @Test
    public void set_gold_cards_by_wins_works_correctly() {
        keeper.setGoldCardsByWins(1, 399);
        assertEquals(399, keeper.getGoldCardsByWins(1));
    }
    
    @Test
    public void set_average_dust_by_wins_works_correctly() {
        keeper.setAverageDustByWins(4, 0.2);
        assertEquals(0.2, keeper.getAverageDustByWins(4), 0);
    }
    
    @Test
    public void set_average_gold_by_wins_works_correctly() {
        keeper.setAverageGoldByWins(5, 37);
        assertEquals(37, keeper.getAverageGoldByWins(5), 0);
    }
    
    @Test
    public void set_average_extra_packs_by_wins_works_correctly() {
        keeper.setAverageExtraPacksByWins(10, 0.99);
        assertEquals(0.99, keeper.getAverageExtraPacksByWins(10), 0);
    }
    
    @Test
    public void set_average_regular_cards_by_wins_works_correctly() {
        keeper.setAverageRegularCardsByWins(11, 1);
        assertEquals(1, keeper.getAverageRegularCardsByWins(11), 0);
    }
    
    @Test
    public void set_average_gold_cards_by_wins_works_correctly() {
        keeper.setAverageGoldCardsByWins(0, 2.33);
        assertEquals(2.33, keeper.getAverageGoldCardsByWins(0), 0);
    }
    
    @Test
    public void reset_clears_decks() {
        keeper.reset();
        assertEquals(0, keeper.getTotalDeckAmount());
    }
    
    @Test
    public void getTotalDust_works_correctly() {
        assertEquals(430, keeper.getTotalDust());
    }
    
    @Test
    public void getTotalDustAverage_works_correctly() {
        assertEquals(86, keeper.getTotalDustAverage(), 0);
    }
    
    @Test
    public void getTotalGold_works_correctly() {
        assertEquals(620, keeper.getTotalGold());
    }
    
    @Test
    public void getTotalGoldAvergae_works_correctly() {
        assertEquals(124, keeper.getTotalGoldAverage(), 0);
    }
    
    @Test
    public void getTotalExtraPacks_works_correctly() {
        assertEquals(1, keeper.getTotalExtraPacks());
    }
    
    @Test
    public void getTotalExtraPacksAverage_works_correctly() {
        assertEquals(0.2, keeper.getTotalExtraPackAverage(), 0);
    }
    
    @Test
    public void getTotalRegularCards_works_correctly() {
        assertEquals(2, keeper.getTotalRegularCards());
    }
    
    @Test
    public void getTotalRegularCardAverage_works_correctly() {
        assertEquals(0.4, keeper.getTotalRegularCardAverage(), 0);
    }
    
    @Test
    public void getTotalGoldenCards_works_correctly() {
        assertEquals(1, keeper.getTotalGoldenCards());
    }
    
    @Test
    public void getTotalGoldenCardsAverage_works_correctly() {
        assertEquals(0.2, keeper.getTotalGoldenCardAverage(), 0);
    }
    
    @Test
    public void getPercentageOutOfAllDecksWorksCorrectly() {
        assertEquals(0.4, keeper.getPercentageOutOfAllDecks(12), 0);
    }
    
    @Test
    public void getTotalWins_works_correctly() {
        assertEquals(39, keeper.getTotalWins());
    }
    
    @Test
    public void getTotalWinAverage_works_correctly() {
        assertEquals(7.8, keeper.getTotalWinAverage(), 0);
    }
}
