
package domain;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CardTest {
    
    public CardTest() {
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
    public void parseCard1() {
        assertEquals(Card.COMMON, Card.parseCard("Common"));
    }
    
    @Test
    public void parseCard2() {
        assertEquals(Card.COMMON_GOLD, Card.parseCard("Golden Common"));
    }
    
    @Test
    public void parseCard3() {
        assertEquals(Card.RARE, Card.parseCard("Rare"));
    }
    
    @Test
    public void parseCard4() {
        assertEquals(Card.RARE_GOLD, Card.parseCard("Golden Rare"));
    }
    
    @Test
    public void parseCard5() {
        assertEquals(Card.EPIC, Card.parseCard("Epic"));
    }
    
    @Test
    public void parseCard6() {
        assertEquals(Card.EPIC_GOLD, Card.parseCard("Golden Epic"));
    }
    
    @Test
    public void parseCard7() {
        assertEquals(Card.LEGENDARY, Card.parseCard("Legendary"));
    }
    
    @Test
    public void parseCard8() {
        assertEquals(Card.LEGENDARY_GOLD, Card.parseCard("Golden Legendary"));
    }
    
    @Test
    public void parseCard9() {
        assertEquals(null, Card.parseCard("common"));
    }
    
}
