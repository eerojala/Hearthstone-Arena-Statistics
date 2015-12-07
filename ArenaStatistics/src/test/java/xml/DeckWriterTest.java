package xml;

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

public class DeckWriterTest {

    XmlWriter writer;
    DeckParser parser;
    Deck deck;
    Deck deck1;
    Deck deck2;
    Deck deck3;
    Deck deck4;
    Deck deck5;
    Deck deck6;
    Deck deck7;
    Deck deck8;
    Deck deck9;
    String filepath;
    List<Deck> decks;

    public DeckWriterTest() {
        filepath = "src/main/resources/xmltestfiles/DeckWriteTest.xml";
        writer = new DeckWriter(filepath);
        deck1 = new Deck(DeckClass.DRUID, 1);
        deck2 = new Deck(DeckClass.PALADIN, 2);
        deck3 = new Deck(DeckClass.WARRIOR, 3);
        deck4 = new Deck(DeckClass.WARLOCK, 4);
        deck5 = new Deck(DeckClass.HUNTER, 5);
        deck6 = new Deck(DeckClass.MAGE, 6);
        deck7 = new Deck(DeckClass.ROGUE, 7);
        deck8 = new Deck(DeckClass.PRIEST, 8);
        deck9 = new Deck(DeckClass.SHAMAN, 9);
        setDeck1();
        setDeck2();
    }

    private void setDeck1() {
        deck1.setDust(30);
        deck1.setGold(280);
        deck1.setExtraPacks(1);
        deck1.setWins(12);
        deck1.setLosses(2);
        setDeck1Cards();
    }

    private void setDeck1Cards() {
        List<Card> cards = new ArrayList();
        cards.add(Card.COMMON);
        cards.add(Card.RARE);
        cards.add(Card.EPIC);
        cards.add(Card.LEGENDARY);
        deck1.setCards(cards);
    }

    private void setDeck2() {
        deck2.setDust(0);
        deck2.setGold(60);
        deck2.setExtraPacks(0);
        deck2.setWins(4);
        deck2.setLosses(3);
        setDeck2Cards();
    }

    private void setDeck2Cards() {
        List<Card> cards = new ArrayList();
        cards.add(Card.COMMON_GOLD);
        cards.add(Card.RARE_GOLD);
        cards.add(Card.EPIC_GOLD);
        cards.add(Card.LEGENDARY_GOLD);
        deck2.setCards(cards);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        addAll();
        parse();
        decks = parser.getDecks();
    }

    private void addAll() {
        writer.writeContent(deck1);
        writer.writeContent(deck2);
        writer.writeContent(deck3);
        writer.writeContent(deck4);
        writer.writeContent(deck5);
        writer.writeContent(deck6);
        writer.writeContent(deck7);
        writer.writeContent(deck8);
        writer.writeContent(deck9);
    }

    private void parse() {
        parser = new DeckParser(writer.getDoc());
        parser.addValues();
    }

    @After
    public void tearDown() {
        writer.removeAll();
    }

    @Test
    public void addContent_adds_a_deck1() {
        deck = decks.get(0);
        assertEquals(deck1, deck);
    }

    @Test
    public void addContent_adds_a_deck2() {
        deck = decks.get(1);
        assertEquals(deck2, deck);
    }

    @Test
    public void addContent_adds_all_decks() {
        assertEquals(9, decks.size());
    }

    @Test
    public void written_deck_has_correct_player_class1() {
        deck = decks.get(0);
        assertEquals(DeckClass.DRUID, deck.getDeckClass());
    }

    @Test
    public void written_deck_has_correct_player_class2() {
        deck = decks.get(1);
        assertEquals(DeckClass.PALADIN, deck.getDeckClass());
    }

    @Test
    public void written_deck_has_correct_player_class3() {
        deck = decks.get(2);
        assertEquals(DeckClass.WARRIOR, deck.getDeckClass());
    }

    @Test
    public void written_deck_has_correct_player_class4() {
        deck = decks.get(3);
        assertEquals(DeckClass.WARLOCK, deck.getDeckClass());
    }

    @Test
    public void written_deck_has_correct_player_class5() {
        deck = decks.get(4);
        assertEquals(DeckClass.HUNTER, deck.getDeckClass());
    }

    @Test
    public void written_deck_has_correct_player_class6() {
        deck = decks.get(5);
        assertEquals(DeckClass.MAGE, deck.getDeckClass());
    }

    @Test
    public void written_deck_has_correct_player_class7() {
        deck = decks.get(6);
        assertEquals(DeckClass.ROGUE, deck.getDeckClass());
    }

    @Test
    public void written_deck_has_correct_player_class8() {
        deck = decks.get(7);
        assertEquals(DeckClass.PRIEST, deck.getDeckClass());
    }
    
    @Test
    public void written_deck_has_correct_player_class9() {
        deck = decks.get(8);
        assertEquals(DeckClass.SHAMAN, deck.getDeckClass());
    }

    @Test
    public void written_deck_has_correct_deck_number() {
        deck = decks.get(1);
        assertEquals(2, deck.getDeckNumber());
    }

    @Test
    public void written_deck_has_correct_dust_amount() {
        deck = decks.get(0);
        assertEquals(30, deck.getDust());
    }

    @Test
    public void written_deck_has_correct_gold_amount() {
        deck = decks.get(1);
        assertEquals(60, deck.getGold());
    }

    @Test
    public void written_deck_has_correct_extra_pack_amount() {
        deck = decks.get(0);
        assertEquals(1, deck.getExtraPacks());
    }

    @Test
    public void written_deck_has_correct_amount_of_cards() {
        deck = decks.get(1);
        assertEquals(4, deck.getRewardCards().size());
    }

    @Test
    public void written_deck_has_correct_cards_1() {
        deck = decks.get(0);
        assertEquals(Card.COMMON, deck.getRewardCards().get(0));
    }

    @Test
    public void written_deck_has_correct_cards_2() {
        deck = decks.get(0);
        assertEquals(Card.RARE, deck.getRewardCards().get(1));
    }

    @Test
    public void written_deck_has_correct_cards_3() {
        deck = decks.get(0);
        assertEquals(Card.EPIC, deck.getRewardCards().get(2));
    }

    @Test
    public void written_deck_has_correct_cards_4() {
        deck = decks.get(0);
        assertEquals(Card.LEGENDARY, deck.getRewardCards().get(3));
    }

    @Test
    public void written_deck_has_correct_cards_5() {
        deck = decks.get(1);
        assertEquals(Card.COMMON_GOLD, deck.getRewardCards().get(0));
    }

    @Test
    public void written_deck_has_correct_cards_6() {
        deck = decks.get(1);
        assertEquals(Card.RARE_GOLD, deck.getRewardCards().get(1));
    }

    @Test
    public void written_deck_has_correct_cards_7() {
        deck = decks.get(1);
        assertEquals(Card.EPIC_GOLD, deck.getRewardCards().get(2));
    }

    @Test
    public void written_deck_has_correct_cards_8() {
        deck = decks.get(1);
        assertEquals(Card.LEGENDARY_GOLD, deck.getRewardCards().get(3));
    }


}
