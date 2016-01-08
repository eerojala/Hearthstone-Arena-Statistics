package xml;

import domain.Deck;
import domain.DeckClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.TestHelper;

public class DeckXmlTest {

    private static final String filepath = "src/main/resources/xmltestfiles/DeckXmlTest.xml";
    private final DeckWriter writer;
    private static final Deck druidDeck = new Deck(DeckClass.DRUID, 1);
    private static final Deck hunterDeck = new Deck(DeckClass.HUNTER, 2);
    private static final Deck mageDeck = new Deck(DeckClass.MAGE, 3);
    private static final Deck paladinDeck = new Deck(DeckClass.PALADIN, 4);
    private static final Deck priestDeck = new Deck(DeckClass.PRIEST, 5);
    private static final Deck rogueDeck = new Deck(DeckClass.ROGUE, 6);
    private static final Deck shamanDeck = new Deck(DeckClass.SHAMAN, 7);
    private static final Deck warlockDeck = new Deck(DeckClass.WARLOCK, 8);
    private static final Deck warriorDeck = new Deck(DeckClass.WARRIOR, 9);
    private Deck deck;

    public DeckXmlTest() {
        writer = new DeckWriter(filepath);
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
        writer.removeAll();
    }

    @Test
    public void deck_has_correct_deck_number1() {
        deck = TestHelper.writeAndParseDeck(writer, filepath, druidDeck);
        assertEquals(1, deck.getDeckNumber());
    }

    @Test
    public void deck_has_correct_deck_number2() {
        deck = TestHelper.writeAndParseDeck(writer, filepath, hunterDeck);
        assertEquals(2, deck.getDeckNumber());
    }

    @Test
    public void deck_has_correct_player_class1() {
        deck = TestHelper.writeAndParseDeck(writer, filepath, druidDeck);
        assertEquals(DeckClass.DRUID, deck.getDeckClass());
    }

    @Test
    public void deck_has_correct_player_class2() {
        deck = TestHelper.writeAndParseDeck(writer, filepath, hunterDeck);
        assertEquals(DeckClass.HUNTER, deck.getDeckClass());
    }

    @Test
    public void deck_has_correct_player_class3() {
        deck = TestHelper.writeAndParseDeck(writer, filepath, mageDeck);
        assertEquals(DeckClass.MAGE, deck.getDeckClass());
    }

    @Test
    public void deck_has_correct_player_class4() {
        deck = TestHelper.writeAndParseDeck(writer, filepath, paladinDeck);
        assertEquals(DeckClass.PALADIN, deck.getDeckClass());
    }

    @Test
    public void deck_has_correct_player_class5() {
        deck = TestHelper.writeAndParseDeck(writer, filepath, priestDeck);
        assertEquals(DeckClass.PRIEST, deck.getDeckClass());
    }

    @Test
    public void deck_has_correct_player_class6() {
        deck = TestHelper.writeAndParseDeck(writer, filepath, rogueDeck);
        assertEquals(DeckClass.ROGUE, deck.getDeckClass());
    }

    @Test
    public void deck_has_correct_player_class7() {
        deck = TestHelper.writeAndParseDeck(writer, filepath, shamanDeck);
        assertEquals(DeckClass.SHAMAN, deck.getDeckClass());
    }

    @Test
    public void deck_has_correct_player_class8() {
        deck = TestHelper.writeAndParseDeck(writer, filepath, warlockDeck);
        assertEquals(DeckClass.WARLOCK, deck.getDeckClass());
    }

    @Test
    public void deck_has_correct_player_class9() {
        deck = TestHelper.writeAndParseDeck(writer, filepath, warriorDeck);
        assertEquals(DeckClass.WARRIOR, deck.getDeckClass());
    }
}
