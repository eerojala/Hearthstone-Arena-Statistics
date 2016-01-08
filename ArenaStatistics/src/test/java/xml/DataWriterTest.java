package xml;

import domain.Deck;
import domain.DeckClass;
import domain.DeckClassPair;
import domain.Match;
import domain.Outcome;
import java.util.ArrayList;
import java.util.List;
import logic.ClassStatisticsKeeper;
import logic.ClassVSClassStatisticsKeeper;
import logic.DeckClassStatisticsKeeper;
import logic.DeckHandler;
import logic.RewardStatisticsKeeper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataWriterTest {

    private DataWriter writer;
    private ClassStatisticsKeeper classStatisticsKeeper;
    private ClassVSClassStatisticsKeeper classVSClassStatisticsKeeper;
    private DeckClassStatisticsKeeper deckClassStatisticsKeeper;
    private RewardStatisticsKeeper rewardStatisticsKeeper;
    private Deck deck;
    private Match match1;
    private Match match2;
    private final String classVSClassUrl = "src/main/resources/xmltestfiles/ClassVSClassStatisticsWriteTest.xml";
    private final String deckClassUrl = "src/main/resources/xmltestfiles/DeckClassStatisticsWriteTest.xml";
    private final String deckUrl = "src/main/resources/xmltestfiles/DeckXmlTest.xml";
    private final String matchStatisticsUrl = "src/main/resources/xmltestfiles/MatchStatisticsWriteTest.xml";
    private final String matchUrl = "src/main/resources/xmltestfiles/MatchWriteTest.xml";
    private final String rewardUrl = "src/main/resources/xmltestfiles/RewardStatisticsWriteTest.xml";
    private final DeckClassPair dVSh = new DeckClassPair(DeckClass.DRUID, DeckClass.HUNTER);

    public DataWriterTest() {
        initStatisticsKeepers();
        setUpDataWriterAndFilepaths();
        setUpDeckAndMatches();
        addDeckAndMatchesToStatisticsKeepers();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        writer.initXml();
    }

    private void initStatisticsKeepers() {
        classStatisticsKeeper = new ClassStatisticsKeeper();
        classVSClassStatisticsKeeper = new ClassVSClassStatisticsKeeper();
        deckClassStatisticsKeeper = new DeckClassStatisticsKeeper();
        rewardStatisticsKeeper = new RewardStatisticsKeeper();
    }

    private void setUpDataWriterAndFilepaths() {
        writer = new DataWriter(classStatisticsKeeper, classVSClassStatisticsKeeper,
                deckClassStatisticsKeeper, rewardStatisticsKeeper);
        writer.setClassVSClassStatisticsWriterFilepath(classVSClassUrl);
        writer.setDeckClassStatisticsWriterFilepath(deckClassUrl);
        writer.setDeckWriterFilePath(deckUrl);
        writer.setMatchStatisticsWriterFilepath(matchStatisticsUrl);
        writer.setMatchWriterFilePath(matchUrl);
        writer.setRewardStatisticsWriterFilePath(rewardUrl);
    }

    private void setUpDeckAndMatches() {
        deck = new Deck(DeckClass.DRUID, 1);
        match1 = new Match(DeckClass.HUNTER, Outcome.WIN, true, 1, 1);
        match2 = new Match(DeckClass.MAGE, Outcome.LOSS, false, 1, 2);
        DeckHandler handler = new DeckHandler();
        handler.setDeck(deck);
        handler.addMatch(match1);
        handler.addMatch(match2);
    }

    private void addDeckAndMatchesToStatisticsKeepers() {
        classStatisticsKeeper.addMatch(match1);
        classStatisticsKeeper.addMatch(match2);
        classVSClassStatisticsKeeper.addMatch(match1);
        classVSClassStatisticsKeeper.addMatch(match2);
        deckClassStatisticsKeeper.addDeck(deck);
        rewardStatisticsKeeper.addDeck(deck);
    }

    @After
    public void tearDown() {
        writer.resetDataTest();
    }

    @Test
    public void resetData_resets_classStatisticsKeeper() {
        writer.resetData();
        assertEquals(0, classStatisticsKeeper.getTotalMatches());
    }

    @Test
    public void resetData_resets_match_statistics_xml() {
        writer.resetData();
        MatchStatisticsParser parser = new MatchStatisticsParser(matchStatisticsUrl);
        parser.addValues();
        assertEquals(0, parser.getKeeper().getTotalMatches());
    }

    @Test
    public void resetData_resets_classVSClassStatisticsKeeper() {
        writer.resetData();
        assertEquals(0, classVSClassStatisticsKeeper.getMatchesInClassVSClass1st(dVSh));
    }

    @Test
    public void resetData_resets_class_vs_class_statistics_xml() {
        writer.resetData();
        ClassVSClassStatisticsParser parser = new ClassVSClassStatisticsParser(classVSClassUrl);
        parser.addValues();
        assertEquals(0, parser.getKeeper().getMatchesInClassVSClass1st(dVSh));
    }

    @Test
    public void resetData_resets_deckClassStatisticsKeeper() {
        writer.resetData();
        assertEquals(0, deckClassStatisticsKeeper.getTotalDeckAmount());
    }

    @Test
    public void resetData_resets_deck_class_statistics_xml() {
        writer.resetData();
        DeckClassStatisticsParser parser = new DeckClassStatisticsParser(deckClassUrl);
        parser.addValues();
        assertEquals(0, parser.getKeeper().getTotalDeckAmount());
    }

    @Test
    public void resetData_resets_rewardStatisticsKeeper() {
        writer.resetData();
        assertEquals(0, rewardStatisticsKeeper.getTotalDeckAmount());
    }

    @Test
    public void resetData_resets_reward_statistics_xml() {
        writer.resetData();
        RewardStatisticsParser parser = new RewardStatisticsParser(rewardUrl);
        parser.addValues();
        assertEquals(0, parser.getKeeper().getTotalDeckAmount());
    }

    @Test
    public void match_statistics_are_written() {
        writer.saveStatistics(deck);
        MatchStatisticsParser parser = new MatchStatisticsParser(matchStatisticsUrl);
        parser.addValues();
        assertEquals(2, parser.getKeeper().getTotalMatches());
    }

    @Test
    public void class_vs_class_statistics_are_written() {
        writer.saveStatistics(deck);
        ClassVSClassStatisticsParser parser = new ClassVSClassStatisticsParser(classVSClassUrl);
        parser.addValues();
        assertEquals(1, parser.getKeeper().getMatchesInClassVSClass1st(dVSh));
    }

    @Test
    public void deck_class_statistics_are_written() {
        writer.saveStatistics(deck);
        DeckClassStatisticsParser parser = new DeckClassStatisticsParser(deckClassUrl);
        parser.addValues();
        assertEquals(1, parser.getKeeper().getTotalDeckAmount());
    }

    @Test
    public void reward_statistics_are_written() {
        writer.saveStatistics(deck);
        RewardStatisticsParser parser = new RewardStatisticsParser(rewardUrl);
        parser.addValues();
        assertEquals(1, parser.getKeeper().getTotalDeckAmount());
    }

    @Test
    public void deck_is_written() {
        writer.saveProgress(deck);
        DeckParser parser = new DeckParser(deckUrl);
        parser.addValues();
        assertEquals(deck, parser.getDeck());
    }

    @Test
    public void correct_amount_of_matches_written() {
        addMatchesAgain();
        MatchParser parser = new MatchParser(matchUrl);
        parser.addValues();
        assertEquals(2, parser.getMatches().size());
    }
    
    private void addMatchesAgain() {
        deck.setMatches(new ArrayList<Match>());
        addMatch(match1);
        addMatch(match2);
    }
    
    private void addMatch(Match match) {
        DeckHandler handler = new DeckHandler();
        handler.setDeck(deck);
        handler.addMatch(match);
        writer.saveProgress(deck);
    }

    @Test
    public void matches_are_written() {
        List<Match> matches = new ArrayList();
        matches.add(match1);
        matches.add(match2);
        addMatchesAgain();
        MatchParser parser = new MatchParser(matchUrl);
        parser.addValues();
        writer.resetData();
        assertEquals(matches, parser.getMatches());
    }
}
