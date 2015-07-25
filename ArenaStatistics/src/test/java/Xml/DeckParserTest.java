
package Xml;

import Xml.DeckParser;
import domain.Deck;
import domain.DeckClass;
import domain.Card;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DeckParserTest {
    DeckParser parser;
    Deck deck1;
    Deck deck2;
    Deck deck3;
    List<Card> cards1;
    List<Card> cards2;
    
    public DeckParserTest() {
        parser = new DeckParser("src/main/resources/DeckParseTest.xml");
        parser.addValuesToList();
        deck1 = parser.getObjects().get(0);
        deck2 = parser.getObjects().get(1);
        deck3 = parser.getObjects().get(2);
        cards1 = deck1.getRewardCards();
        cards2 = deck3.getRewardCards();
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
    public void parses_all_decks() {
        assertEquals(3, parser.getObjects().size());
    }
    
    @Test
    public void deck_has_correct_deck_number() {
        assertEquals(1, deck1.getDeckNumber());
    }
    
    @Test
    public void deck_has_correct_player_class() {
        assertEquals(DeckClass.WARLOCK, deck1.getPlayerClass());
    }
    
    @Test
    public void deck_has_correct_gold_amount() {
        assertEquals(300, deck3.getGold());
    }
    
    @Test
    public void deck_has_correct_dust_amount() {
        assertEquals(30, deck1.getDust());
    }
    
    @Test
    public void deck_has_correct_extra_pack_amount() {
        assertEquals(1, deck1.getExtraPacks());
    }
    
    @Test
    public void deck_has_correct_amount_of_cards1() {
        assertEquals(4, deck1.getRewardCards().size());
    }
    
    @Test
    public void deck_has_correct_amount_of_cards2() {
        assertEquals(0, deck2.getRewardCards().size());
    }
    
    @Test
    public void deck_has_correct_cards1() {
        assertEquals(Card.EPIC, cards1.get(0));
    }
    
    @Test
    public void deck_has_correct_cards2() {
        assertEquals(Card.COMMON_GOLD, cards1.get(1));
    }
    
    @Test
    public void deck_has_correct_cards3() {
        assertEquals(Card.RARE, cards1.get(2));
    }
    
    @Test
    public void deck_has_correct_cards4() {
        assertEquals(Card.LEGENDARY_GOLD, cards1.get(3));
    }
    
    @Test
    public void deck_has_correct_cards5() {
        assertEquals(Card.LEGENDARY, cards2.get(0));
    }
    
    @Test
    public void deck_has_correct_cards6() {
        assertEquals(Card.COMMON, cards2.get(1));
    }
    
    @Test
    public void deck_has_correct_cards7() {
        assertEquals(Card.EPIC_GOLD, cards2.get(2));
    }
    
    @Test
    public void deck_has_correct_cards8() {
        assertEquals(Card.RARE_GOLD, cards2.get(3));
    }
}
