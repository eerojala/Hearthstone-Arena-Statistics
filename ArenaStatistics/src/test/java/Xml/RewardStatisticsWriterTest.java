package Xml;

import util.DocumentBuilder;
import logic.RewardStatisticsKeeper;
import org.jdom.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RewardStatisticsWriterTest {

    private final StatisticsWriter writer;
    private RewardStatisticsKeeper keeper1;
    private RewardStatisticsKeeper keeper2;
    private RewardStatisticsParser parser;
    private final String filepath;
    private final Document doc;

    public RewardStatisticsWriterTest() {
        filepath = "src/main/resources/DeckWinStatisticsWriteTest.xml";
        writer = new RewardStatisticsWriter(filepath);
        doc = DocumentBuilder.buildDocument(filepath);
        keeper1 = new RewardStatisticsKeeper();
    }


    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        setWinAmount1();
        setWinAmount2();
        writer.writeContent(doc, keeper1);
        keeper1 = parseToKeeper();
    }
    
    private void setWinAmount1() {
        keeper1.setDecksByWins(1, 7);
        keeper1.setDustByWins(1, 60);
        keeper1.setGoldByWins(1, 100);
        keeper1.setExtraPacksByWins(1, 3);
        keeper1.setRegularCardsByWins(1, 2);
        keeper1.setGoldCardsByWins(1, 1);
    }

    private void setWinAmount2() {
        keeper1.setDecksByWins(11, 3);
        keeper1.setDustByWins(11, 30);
        keeper1.setGoldByWins(11, 410);
        keeper1.setExtraPacksByWins(11, 1);
        keeper1.setRegularCardsByWins(11, 2);
        keeper1.setGoldCardsByWins(11, 3);
    }

    private RewardStatisticsKeeper parseToKeeper() {
        parse();
        return parser.getKeeper();
    }
    
    private void parse() {
        parser = new RewardStatisticsParser(filepath);
        parser.addValues();
    }

    @After
    public void tearDown() {
        writer.removeAll(doc);
    }

    @Test
    public void correct_amount_of_win_amounts() {
        assertEquals(13, parser.getChildlist().size());
    }

    @Test
    public void decks_by_wins_is_correct1() {
        assertEquals(7, keeper1.getDecksByWins(1));
    }

    @Test
    public void decks_by_wins_is_correct2() {
        assertEquals(3, keeper1.getDecksByWins(11));
    }

    @Test
    public void dust_by_wins_is_correct1() {
        assertEquals(60, keeper1.getDustByWins(1));
    }

    @Test
    public void dust_by_wins_is_correct2() {
        assertEquals(30, keeper1.getDustByWins(11));
    }

    @Test
    public void gold_by_wins_is_correct1() {
        assertEquals(100, keeper1.getGoldByWins(1));
    }

    @Test
    public void gold_by_wins_is_correct2() {
        assertEquals(410, keeper1.getGoldByWins(11));
    }

    @Test
    public void extra_packs_by_wins_is_correct1() {
        assertEquals(3, keeper1.getExtraPacksByWins(1));
    }

    @Test
    public void extra_packs_by_wins_is_correct2() {
        assertEquals(1, keeper1.getExtraPacksByWins(11));
    }

    @Test
    public void regular_cards_by_wins_is_correct1() {
        assertEquals(2, keeper1.getRegularCardsByWins(1));
    }

    @Test
    public void regular_cards_by_wins_is_correct2() {
        assertEquals(2, keeper1.getRegularCardsByWins(11));
    }

    @Test
    public void gold_cards_by_wins_is_correct1() {
        assertEquals(1, keeper1.getGoldCardsByWins(1));
    }

    @Test
    public void gold_cards_by_wins_is_correct2() {
        assertEquals(3, keeper1.getGoldCardsByWins(11));
    }

    @Test
    public void average_dust_by_wins_is_correct1() {
        assertEquals(8.571, keeper1.getAverageDustByWins(1), 0.001);
    }

    @Test
    public void average_dust_by_wins_is_correct2() {
        assertEquals(10, keeper1.getAverageDustByWins(11), 0);
    }

    @Test
    public void average_gold_by_wins_is_correct1() {
        assertEquals(14.285, keeper1.getAverageGoldByWins(1), 0.001);
    }

    @Test
    public void average_gold_by_wins_is_correct2() {
        assertEquals(136.666, keeper1.getAverageGoldByWins(11), 0.001);
    }

    @Test
    public void average_extra_packs_by_wins_is_correct1() {
        assertEquals(0.428, keeper1.getAverageExtraPacksByWins(1), 0.001);
    }

    @Test
    public void average_extra_packs_by_wins_is_correct2() {
        assertEquals(0.33, keeper1.getAverageExtraPacksByWins(11), 0.01);
    }

    @Test
    public void average_regular_cards_by_wins_is_correct1() {
        assertEquals(0.285, keeper1.getAverageRegularCardsByWins(1), 0.001);
    }

    @Test
    public void average_regular_cards_by_wins_is_correct2() {
        assertEquals(0.66, keeper1.getAverageRegularCardsByWins(11), 0.01);
    }

    @Test
    public void average_gold_cards_by_wins_is_correct1() {
        assertEquals(0.142, keeper1.getAverageGoldCardsByWins(1), 0.001);
    }

    @Test
    public void average_gold_cards_by_wins_is_correct2() {
        assertEquals(1, keeper1.getAverageGoldCardsByWins(11), 0);
    }
    
    @Test
    public void update_specific_works_correctly() {
        keeper1.setDecksByWins(11, 99);
        writer.updateSpecific(doc, 11, keeper1);
        keeper2 = parseToKeeper();
        assertEquals(99, keeper2.getDecksByWins(11));
    }
    
    @Test
    public void update_specific_does_not_affect_others() {
        writer.updateSpecific(doc, 11, keeper1);
        keeper2 = parseToKeeper();
        assertEquals(7, keeper2.getDecksByWins(1));
    }
    
    @Test
    public void update_specific_does_not_duplicate_specific() {
        writer.updateSpecific(doc, 11, keeper1);
        parse();
        assertEquals(13, parser.getChildlist().size());
    }
    
    @Test
    public void update_specific_does_nothing_if_wrong_classes_are_given() {
        keeper1.setDecksByWins(11, 13);
        writer.updateSpecific(doc, doc, keeper1);
        keeper2 = parseToKeeper();
        assertEquals(3, keeper2.getDecksByWins(11));
    }

}
