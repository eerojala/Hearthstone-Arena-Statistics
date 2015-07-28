package logic;

import domain.Deck;
import domain.DeckClass;
import domain.Card;
import domain.Match;
import domain.Outcome;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckHandlerTest {

    DeckHandler handler;
    Match match1;
    Match match2;
    Match match3;
    Card card;
    int temp;

    public DeckHandlerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        handler = new DeckHandler();
        handler.setDeck(new Deck(DeckClass.DRUID, 1));
        match1 = new Match(DeckClass.MAGE, "test1", Outcome.WIN,
                true, handler.getDeckNumber(), 1);
        match2 = new Match(DeckClass.PALADIN, "test2", Outcome.LOSS,
                false, handler.getDeckNumber(), 2);
        match3 = new Match(DeckClass.HUNTER, "test3", Outcome.DISCONNECT,
                false, handler.getDeckNumber(), 3);
        card = Card.COMMON;
        handler.addMatch(match1);
        handler.addMatch(match2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addMatch_adds_to_list() {
        handler.addMatch(match3);
        assertEquals(match3, handler.getLatestMatch());
    }
    
    @Test
    public void addMatch_sets_deck_to_match() {
        handler.addMatch(match1);
        assertEquals(handler.getDeck(), match1.getDeck());
    }

    @Test
    public void addMatch_increases_win_count() {
        temp = handler.getDeck().getWins();
        handler.addMatch(match1);
        assertEquals(temp + 1, handler.getDeck().getWins());
    }

    @Test
    public void addMatch_doesnt_increase_loss_count_if_win() {
        temp = handler.getDeck().getLosses();
        handler.addMatch(match1);
        assertEquals(temp, handler.getDeck().getLosses());
    }

    @Test
    public void addMatch_increases_loss_count() {
        temp = handler.getDeck().getLosses();
        handler.addMatch(match2);
        assertEquals(temp + 1, handler.getDeck().getLosses());
    }

    @Test
    public void addMatch_doesnt_increase_win_count_if_loss() {
        temp = handler.getDeck().getWins();
        handler.addMatch(match2);
        assertEquals(temp, handler.getDeck().getWins());
    }

    @Test
    public void addMatch_counts_disconnect_as_loss() {
        temp = handler.getDeck().getLosses();
        handler.addMatch(match3);
        assertEquals(temp + 1, handler.getDeck().getLosses());
    }

    @Test
    public void addMatch_doesnt_count_disconnect_as_win() {
        temp = handler.getDeck().getWins();
        handler.addMatch(match3);
        assertEquals(temp, handler.getDeck().getWins());
    }

    @Test
    public void addMatch_returns_true_if_12_wins() {
        for (int i = 0; i < 10; i++) {
            handler.addMatch(match1);
        }
        assertEquals(true, handler.addMatch(match1));
    }

    @Test
    public void addMatch_returns_true_if_3_losses() {
        handler.addMatch(match2);
        assertEquals(true, handler.addMatch(match2));
    }

    @Test
    public void addMatch_returns_false_if_not_finished() {
        assertEquals(false, handler.addMatch(match2));
    }

    @Test
    public void removeMatch_returns_match_at_index() {
        assertEquals(match1, handler.removeMatch(0));
    }

    @Test
    public void removeMatch_removes_match_from_list() {
        handler.removeMatch(0);
        assertEquals(false, handler.getMatches().contains(match1));
    }

    @Test
    public void removeMatch_returns_null_if_no_match_at_index() {
        assertEquals(null, handler.removeMatch(2));
    }

    @Test
    public void removeMatch_decreases_win_count() {
        temp = handler.getDeck().getWins();
        handler.removeMatch(0);
        assertEquals(temp - 1, handler.getDeck().getWins());
    }

    @Test
    public void removeMatch_doesnt_decrease_win_count_if_not_win() {
        temp = handler.getDeck().getWins();
        handler.removeMatch(1);
        assertEquals(temp, handler.getDeck().getWins());
    }

    @Test
    public void removeMatch_decreases_loss_count() {
        temp = handler.getDeck().getLosses();
        handler.removeMatch(1);
        assertEquals(temp - 1, handler.getDeck().getLosses());
    }

    @Test
    public void removeMatch_doesnt_decrease_loss_count_if_not_loss() {
        temp = handler.getDeck().getLosses();
        handler.removeMatch(0);
        assertEquals(temp, handler.getDeck().getLosses());
    }

    @Test
    public void removeMatch_counts_disconnect_as_loss() {
        handler.addMatch(match3);
        temp = handler.getDeck().getLosses();
        handler.removeMatch(2);
        assertEquals(temp - 1, handler.getDeck().getLosses());
    }

    @Test
    public void removeMatch_doesnt_count_disconnect_as_win() {
        handler.addMatch(match3);
        temp = handler.getDeck().getWins();
        handler.removeMatch(2);
        assertEquals(temp, handler.getDeck().getWins());
    }

    @Test
    public void removeLatestMatch_removes_match_from_list() {
        handler.removeLatestMatch();
        assertEquals(false, handler.getMatches().contains(match2));
    }

    @Test
    public void removeLatestMatch_returns_latest_match() {
        assertEquals(handler.getLatestMatch(), handler.removeLatestMatch());
    }

    @Test
    public void removeLatestMatch_returns_null_if_no_matches() {
        handler.removeLatestMatch();
        handler.removeLatestMatch();
        assertEquals(null, handler.removeLatestMatch());
    }

    @Test
    public void getLatestMatch_returns_null_if_no_matches() {
        handler.removeLatestMatch();
        handler.removeLatestMatch();
        assertEquals(null, handler.getLatestMatch());
    }

    @Test
    public void getLatestMatch_returns_latest_added() {
        assertEquals(match2, handler.getLatestMatch());
    }

    @Test
    public void addCard_adds_card_to_list() {
        handler.addCard(card);
        assertEquals(true, handler.getDeck().getRewardCards().contains(card));
    }

    @Test
    public void removeCard_removes_card_from_list() {
        handler.addCard(card);
        handler.removeCard(0);
        assertEquals(false, handler.getDeck().getRewardCards().contains(card));
    }

    @Test
    public void removeCard_returns_card_at_index() {
        handler.addCard(card);
        assertEquals(card, handler.removeCard(0));
    }

    @Test
    public void removeCard_returns_null_if_no_card_at_index() {
        assertEquals(null, handler.removeCard(0));
    }

}
