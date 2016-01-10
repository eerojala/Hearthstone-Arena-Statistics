package xml;

import domain.Deck;
import domain.DeckClass;
import domain.Matchup;
import domain.Match;
import domain.Outcome;
import java.util.ArrayList;
import java.util.List;
import logic.MatchStatisticsKeeper;
import logic.MatchupStatisticsKeeper;
import logic.DeckScoreStatisticsKeeper;
import logic.DeckHandler;
import logic.RewardStatisticsKeeper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataParserAndWriterTest {

    private DataWriter writer;
    private DataParser parser;
    private MatchStatisticsKeeper classStatisticsKeeper;
    private MatchupStatisticsKeeper classVSClassStatisticsKeeper;
    private DeckScoreStatisticsKeeper deckClassStatisticsKeeper;
    private RewardStatisticsKeeper rewardStatisticsKeeper;
    private Deck deck;
    private Match match1;
    private Match match2;
    private static final String classVSClassUrl = "src/main/resources/xmltestfiles/ClassVSClassStatisticsXmlTest.xml";
    private static final String deckClassUrl = "src/main/resources/xmltestfiles/DeckClassStatisticsXmlTest.xml";
    private static final String deckUrl = "src/main/resources/xmltestfiles/DeckXmlTest.xml";
    private static final String matchStatisticsUrl = "src/main/resources/xmltestfiles/MatchStatisticsXmlTest.xml";
    private static final String matchUrl = "src/main/resources/xmltestfiles/MatchXmlTest.xml";
    private static final String rewardUrl = "src/main/resources/xmltestfiles/RewardStatisticsXmlTest.xml";
    private static final Matchup dVSh = new Matchup(DeckClass.DRUID, DeckClass.HUNTER);

    public DataParserAndWriterTest() {
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
        classStatisticsKeeper = new MatchStatisticsKeeper();
        classVSClassStatisticsKeeper = new MatchupStatisticsKeeper();
        deckClassStatisticsKeeper = new DeckScoreStatisticsKeeper();
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
        resetAndParse();
        classStatisticsKeeper = parser.getClassStatisticsKeeper();
        assertEquals(0, classStatisticsKeeper.getTotalMatches());
    }

    private void resetAndParse() {
        writer.resetData();
        parseData();
    }

    private void parseData() {
        parser = new DataParser();
        parser.setClassVSClassStatisticsFilepath(classVSClassUrl);
        parser.setDeckClassStatisticsFilepath(deckClassUrl);
        parser.setDecksFilepath(deckUrl);
        parser.setMatchStatisticsFilepath(matchStatisticsUrl);
        parser.setMatchesFilepath(matchUrl);
        parser.setRewardStatisticsFilepath(rewardUrl);
        parser.parseData();
    }

    @Test
    public void resetData_resets_match_statistics_xml() {
        writer.resetData();
        MatchStatisticsParser mStatParser = new MatchStatisticsParser(matchStatisticsUrl);
        mStatParser.addValues();
        assertEquals(0, mStatParser.getKeeper().getTotalMatches());
    }

    @Test
    public void resetData_resets_classVSClassStatisticsKeeper() {
        resetAndParse();
        classVSClassStatisticsKeeper = parser.getClassVSClassStatisticsKeeper();
        assertEquals(0, classVSClassStatisticsKeeper.getMatchesInClassVSClass1st(dVSh));
    }

    @Test
    public void resetData_resets_class_vs_class_statistics_xml() {
        writer.resetData();
        ClassVSClassStatisticsParser matchupParser = new ClassVSClassStatisticsParser(classVSClassUrl);
        matchupParser.addValues();
        assertEquals(0, matchupParser.getKeeper().getMatchesInClassVSClass1st(dVSh));
    }

    @Test
    public void resetData_resets_deckClassStatisticsKeeper() {
        resetAndParse();
        deckClassStatisticsKeeper = parser.getDeckClassStatisticsKeeper();
        assertEquals(0, deckClassStatisticsKeeper.getTotalDeckAmount());
    }

    @Test
    public void resetData_resets_deck_class_statistics_xml() {
        writer.resetData();
        DeckClassStatisticsParser dParser = new DeckClassStatisticsParser(deckClassUrl);
        dParser.addValues();
        assertEquals(0, dParser.getKeeper().getTotalDeckAmount());
    }

    @Test
    public void resetData_resets_rewardStatisticsKeeper() {
        resetAndParse();
        rewardStatisticsKeeper = parser.getRewardStatisticsKeeper();
        assertEquals(0, rewardStatisticsKeeper.getTotalDeckAmount());
    }

    @Test
    public void resetData_resets_reward_statistics_xml() {
        writer.resetData();
        RewardStatisticsParser rParser = new RewardStatisticsParser(rewardUrl);
        rParser.addValues();
        assertEquals(0, rParser.getKeeper().getTotalDeckAmount());
    }

    @Test
    public void match_statistics_are_written() {
        writer.saveStatistics(deck);
        parseData();
        assertEquals(2, parser.getClassStatisticsKeeper().getTotalMatches());
    }

    @Test
    public void class_vs_class_statistics_are_written() {
        writer.saveStatistics(deck);
        parseData();
        assertEquals(1, parser.getClassVSClassStatisticsKeeper().getMatchesInClassVSClass1st(dVSh));
    }

    @Test
    public void deck_class_statistics_are_written() {
        writer.saveStatistics(deck);
        parseData();
        assertEquals(1, parser.getDeckClassStatisticsKeeper().getTotalDeckAmount());
    }

    @Test
    public void reward_statistics_are_written() {
        writer.saveStatistics(deck);
        parseData();
        assertEquals(1, parser.getRewardStatisticsKeeper().getTotalDeckAmount());
    }

    @Test
    public void deck_is_written() {
        writer.saveProgress(deck);
        parseData();
        assertEquals(deck, parser.getCurrentDeck());
    }

    @Test
    public void correct_amount_of_matches_written() {
        addMatchesAgain();
        parseData();
        assertEquals(2, parser.getCurrentDeck().getMatches().size());
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
        parseData();
        assertEquals(matches, parser.getCurrentDeck().getMatches());
    }
}
