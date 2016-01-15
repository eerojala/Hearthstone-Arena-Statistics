package xml;

import domain.DeckClass;
import logic.DeckScoreStatisticsKeeper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckScoreStatisticsXmlTest {

    private DeckScoreStatisticsKeeper keeper1;
    private DeckScoreStatisticsKeeper keeper2;
    private DeckScoreStatisticsParser parser;
    private final StatisticsWriter writer;
    private static final String filepath = "src/main/resources/xmltestfiles/DeckClassStatisticsXmlTest.xml";
    private static final DeckClass priest = DeckClass.PRIEST;
    private static final DeckClass hunter = DeckClass.HUNTER;

    public DeckScoreStatisticsXmlTest() {
        writer = new DeckScoreStatisticsWriter(filepath);
        keeper1 = new DeckScoreStatisticsKeeper();
        setClass1(priest);
        setClass2(hunter);
        writer.writeContent(keeper1);
        parseToKeeper1();
    }

    private void parseToKeeper1() {
        parse();
        keeper1 = (DeckScoreStatisticsKeeper) parser.getParsedObject();
    }

    private void parse() {
        parser = new DeckScoreStatisticsParser(writer.getDoc());
        parser.addValues();
    }

    private void parseToKeeper2() {
        parse();
        keeper2 = (DeckScoreStatisticsKeeper) parser.getParsedObject();
    }

    private void setClass1(DeckClass dc) {
        keeper1.setDecksAsClassWithXWins(dc, 5, 3);
        keeper1.setDecksAsClassWithXWins(dc, 6, 2);
    }

    private void setClass2(DeckClass dc) {
        keeper1.setDecksAsClassWithXWins(dc, 2, 3);
        keeper1.setDecksAsClassWithXWins(dc, 5, 2);
        keeper1.setDecksAsClassWithXWins(dc, 1, 4);
        keeper1.setDecksAsClassWithXWins(dc, 11, 1);
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
    public void amount_of_classes_is_correct() {
        assertEquals(9, parser.getChildlist().size());
    }

    @Test
    public void decks_as_class_is_correct1() {
        assertEquals(5, keeper1.getDecksAsClass(priest));
    }

    @Test
    public void decks_as_class_is_correct2() {
        assertEquals(10, keeper1.getDecksAsClass(hunter));
    }

    @Test
    public void wins_as_class_is_correct1() {
        assertEquals(27, keeper1.getWinsAsClass(priest));
    }

    @Test
    public void wins_as_class_is_correct2() {
        assertEquals(31, keeper1.getWinsAsClass(hunter));
    }

    @Test
    public void average_wins_as_class_is_correct1() {
        assertEquals(5.4, keeper1.getAverageWinsAsClass(priest), 0);
    }

    @Test
    public void average_wins_as_class_is_correct2() {
        assertEquals(3.1, keeper1.getAverageWinsAsClass(hunter), 0);
    }

    @Test
    public void play_percentage_as_class_is_correct1() {
        assertEquals(0.33, keeper1.getPlayRatioAsClass(priest), 0.01);
    }

    @Test
    public void play_percentage_as_class_is_correct2() {
        assertEquals(0.66, keeper1.getPlayRatioAsClass(hunter), 0.01);
    }

    @Test
    public void decks_as_class_with_x_wins_is_correct1() {
        assertEquals(3, keeper1.getDecksAsClassWithXWins(priest, 5));
    }

    @Test
    public void decks_as_class_with_x_wins_is_correct2() {
        assertEquals(2, keeper1.getDecksAsClassWithXWins(priest, 6));
    }

    @Test
    public void decks_as_class_with_x_wins_is_correct3() {
        assertEquals(3, keeper1.getDecksAsClassWithXWins(hunter, 2));
    }

    @Test
    public void decks_as_class_with_x_wins_is_correct4() {
        assertEquals(2, keeper1.getDecksAsClassWithXWins(hunter, 5));
    }

    @Test
    public void decks_as_class_with_x_wins_is_correct5() {
        assertEquals(4, keeper1.getDecksAsClassWithXWins(hunter, 1));
    }

    @Test
    public void decks_as_class_with_x_wins_is_correct6() {
        assertEquals(1, keeper1.getDecksAsClassWithXWins(hunter, 11));
    }

    @Test
    public void update_specific_works_correctly() {
        keeper1.setDecksAsClassWithXWins(priest, 1, 100);
        writer.updateSpecific(priest, keeper1);
        parseToKeeper2();
        assertEquals(100, keeper2.getDecksAsClassWithXWins(priest, 1));
    }

    @Test
    public void update_specific_doesnt_affect_others() {
        writer.updateSpecific(priest, keeper1);
        parseToKeeper2();
        assertEquals(10, keeper2.getDecksAsClass(hunter));
    }

    @Test
    public void update_specific_doesnt_duplicate_specific() {
        writer.updateSpecific(priest, keeper1);
        parseToKeeper2();
        assertEquals(9, parser.getChildlist().size());
    }

    @Test
    public void update_specific_does_nothing_if_wrong_objects_are_given() {
        keeper1.setDecksAsClassWithXWins(priest, 5, 1111);
        writer.updateSpecific("asdf", keeper1);
        parseToKeeper2();
        assertEquals(3, keeper2.getDecksAsClassWithXWins(priest, 5));
    }
}
