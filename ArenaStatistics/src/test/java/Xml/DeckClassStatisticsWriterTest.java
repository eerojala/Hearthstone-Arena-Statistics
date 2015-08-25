package Xml;

import domain.DeckClass;
import logic.DeckClassStatisticsKeeper;
import org.jdom.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckClassStatisticsWriterTest {

    private final StatisticsWriter writer;
    private DeckClassStatisticsKeeper keeper1;
    private DeckClassStatisticsKeeper keeper2;
    private DeckClassStatisticsParser parser;
    private final String filepath;
    private final Document doc;
    private final DeckClass priest;
    private final DeckClass hunter;

    public DeckClassStatisticsWriterTest() {
        priest = DeckClass.PRIEST;
        hunter = DeckClass.HUNTER;
        filepath = "src/main/resources/DeckClassStatisticsWriteTest.xml";
        writer = new DeckClassStatisticsWriter(filepath);
        doc = DocumentBuilder.buildDocument(filepath);
        keeper1 = new DeckClassStatisticsKeeper();
        setClass1(priest);
        setClass2(hunter);
        writer.writeContent(doc, keeper1);
        parseToKeeper1();
    }

    private void parseToKeeper1() {
        parse();
        keeper1 = parser.getKeeper();
    }

    private void parse() {
        parser = new DeckClassStatisticsParser(doc);
        parser.addValues();
    }
    
    private void parseToKeeper2() {
        parse();
        keeper2 = parser.getKeeper();
    }

    private void setClass1(DeckClass dc) {
        keeper1.setDecksAsClass(dc, 5);
        keeper1.setWinsAsClass(dc, 27);
    }

    private void setClass2(DeckClass dc) {
        keeper1.setDecksAsClass(dc, 6);
        keeper1.setWinsAsClass(dc, 31);
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
        writer.removeAll(doc);
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
        assertEquals(6, keeper1.getDecksAsClass(hunter));
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
        assertEquals(5.166, keeper1.getAverageWinsAsClass(hunter), 0.001);
    }

    @Test
    public void play_percentage_as_class_is_correct1() {
        assertEquals(0.454, keeper1.getPlayPercentageAsClass(priest), 0.001);
    }

    @Test
    public void play_percentage_as_class_is_correct2() {
        assertEquals(0.545, keeper1.getPlayPercentageAsClass(hunter), 0.001);
    }

    @Test
    public void update_specific_works_correctly() {
        keeper1.setDecksAsClass(priest, 1);
        writer.updateSpecific(doc, priest, keeper1);
        parseToKeeper2();
        assertEquals(1, keeper2.getDecksAsClass(priest));
    }
    
    @Test
    public void update_specific_doesnt_affect_others() {
        writer.updateSpecific(doc, priest, keeper1);
        parseToKeeper2();
        assertEquals(6, keeper2.getDecksAsClass(hunter));
    }
    
    @Test
    public void update_specific_doesnt_duplicate_specific() {
        writer.updateSpecific(doc, priest, keeper1);
        parseToKeeper2();
        assertEquals(9, parser.getChildlist().size());
    }
    
    @Test
    public void update_specific_does_nothing_if_wrong_classes_are_given() {
        keeper1.setDecksAsClass(priest, 1);
        writer.updateSpecific(doc, doc, keeper1);
        parseToKeeper2();
        assertEquals(5, keeper2.getDecksAsClass(priest));
    }
}
