
package domain;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DeckTest {
    Deck deck1;
    Deck deck2;
    
    public DeckTest() {
        deck1 = new Deck(DeckClass.WARRIOR, 1);
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
    public void equals_returns_false_if_wrong_class() {
        assertEquals(false, deck1.equals("test"));
    }
    
    @Test
    public void equals_returns_false_if_wrong_deck_number() {
        deck2 = new Deck(DeckClass.WARRIOR, 2);
        assertEquals(false, deck1.equals(deck2));
    }
    
    @Test
    public void equals_returns_true_if_same() {
        deck2 = new Deck(DeckClass.PRIEST, 1);
        assertEquals(true, deck1.equals(deck2));
    }
    
}
