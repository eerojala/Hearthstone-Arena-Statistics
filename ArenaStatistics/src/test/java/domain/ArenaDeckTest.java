
package domain;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArenaDeckTest {
    ArenaDeck deck1;
    ArenaDeck deck2;
    
    public ArenaDeckTest() {
        deck1 = new ArenaDeck(DeckClass.WARRIOR, 1);
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
        deck2 = new ArenaDeck(DeckClass.WARRIOR, 2);
        assertEquals(false, deck1.equals(deck2));
    }
    
    @Test
    public void equals_returns_true_if_same() {
        deck2 = new ArenaDeck(DeckClass.PRIEST, 1);
        assertEquals(true, deck1.equals(deck2));
    }
    
}
