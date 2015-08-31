
package Xml;

import domain.DeckClass;
import logic.DeckClassStatisticsKeeper;
import org.jdom.Element;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckClassStatisticsParserTest {
    private final DeckClassStatisticsParser parser;
    private final DeckClassStatisticsKeeper keeper;
    private final DeckClass mage;
    private final DeckClass warrior;
    
    public DeckClassStatisticsParserTest() {
        parser = new DeckClassStatisticsParser("src/main/resources/DeckClassStatisticsParseTest.xml");
        parser.addValues();
        keeper = parser.getKeeper();
        mage = DeckClass.MAGE;
        warrior = DeckClass.WARRIOR;
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
    public void decks_as_class_is_correct1() {
        assertEquals(5, keeper.getDecksAsClass(mage));
    }
    
    @Test
    public void decks_as_class_is_correct2() {
        assertEquals(2, keeper.getDecksAsClass(warrior));
    }
    
    @Test
    public void wins_as_class_is_correct1() {
        assertEquals(33, keeper.getWinsAsClass(mage));
    }
    
    @Test
    public void wins_as_class_is_correct2() {
        assertEquals(19, keeper.getWinsAsClass(warrior));
    }
    
    @Test
    public void average_wins_as_class_is_correct1() {
        assertEquals(6.6, keeper.getAverageWinsAsClass(mage), 0);
    }
    
    @Test
    public void average_wins_as_class_is_correct2() {
        assertEquals(9.5, keeper.getAverageWinsAsClass(warrior), 0);
    }
    
    @Test
    public void play_percentage_as_class_is_correct1() {
        assertEquals(0.714, keeper.getPlayPercentageAsClass(mage), 0.001);
    }
    
    @Test
    public void play_percentage_as_class_is_correct2() {
        assertEquals(0.285, keeper.getPlayPercentageAsClass(warrior), 0.001);
    }    
    
    @Test
    public void decks_as_class_with_x_wins_is_correct1() {
        assertEquals(4, keeper.getDecksAsClassWithXWins(mage, 6));
    }
    
    @Test
    public void decks_as_class_with_x_wins_is_correct2() {
        assertEquals(1, keeper.getDecksAsClassWithXWins(mage, 9));
    }
    
    @Test
    public void decks_as_class_with_x_wins_is_correct3() {
        assertEquals(1, keeper.getDecksAsClassWithXWins(warrior, 9));
    }
    
    @Test
    public void decks_as_class_with_x_wins_is_correct4() {
        assertEquals(1, keeper.getDecksAsClassWithXWins(warrior, 10));
    }
}
