package xml;

import domain.Deck;
import domain.Matchup;
import domain.Match;
import logic.MatchStatisticsKeeper;
import logic.MatchupStatisticsKeeper;
import logic.DeckScoreStatisticsKeeper;

import logic.RewardStatisticsKeeper;

/**
 * Class which writes all of the data to the Xml files.
 */
public class DataWriter {

    private final StatisticsWriter matchStatisticsWriter;
    private final StatisticsWriter matchupStatisticsWriter;
    private final StatisticsWriter deckScoreStatisticsWriter;
    private final DeckWriter deckWriter;
    private final MatchWriter matchWriter;
    private final StatisticsWriter rewardStatisticsWriter;
    private final MatchStatisticsKeeper matchStatisticsKeeper;
    private final MatchupStatisticsKeeper matchupStatisticsKeeper;
    private final DeckScoreStatisticsKeeper deckScoreStatisticsKeeper;
    private final RewardStatisticsKeeper rewardStatisticsKeeper;

    /**
     * Creates a new DataWriter object.
     *
     * @param matchStatisticsKeeper MatchStatisticsKeeper which is written to
     * the Xml file.
     * @param matchupStatisticsKeeper MatchupStatisticsKeeper which is written
     * to the Xml file.
     * @param deckScoreStatisticsKeeper DeckScoreStatisitcsKeeper which is
     * written to the Xml file.
     * @param rewardStatisticsKeeper RewardStatisticsKeeper which is written to
     * the Xml file.
     */
    public DataWriter(MatchStatisticsKeeper matchStatisticsKeeper, MatchupStatisticsKeeper matchupStatisticsKeeper,
            DeckScoreStatisticsKeeper deckScoreStatisticsKeeper, RewardStatisticsKeeper rewardStatisticsKeeper) {
        matchStatisticsWriter = new MatchStatisticsWriter("src/main/resources/xmlfiles/MatchStatistics.xml");
        matchupStatisticsWriter = new MatchupStatisticsWriter("src/main/resources/xmlfiles/ClassVSClassStatistics.xml");
        deckScoreStatisticsWriter = new DeckScoreStatisticsWriter("src/main/resources/xmlfiles/DeckClassStatistics.xml");
        deckWriter = new DeckWriter("src/main/resources/xmlfiles/Decks.xml");
        matchWriter = new MatchWriter("src/main/resources/xmlfiles/Matches.xml");
        rewardStatisticsWriter = new RewardStatisticsWriter("src/main/resources/xmlfiles/RewardStatistics.xml");
        this.matchStatisticsKeeper = matchStatisticsKeeper;
        this.deckScoreStatisticsKeeper = deckScoreStatisticsKeeper;
        this.matchupStatisticsKeeper = matchupStatisticsKeeper;
        this.rewardStatisticsKeeper = rewardStatisticsKeeper;
    }

    /**
     * Writes the data of the current deck and it's matches to the Xml files.
     *
     * @param deck Deck which data is written to the Xml files.
     */
    public void saveProgress(Deck deck) {
        deckWriter.removeAll();
        deckWriter.writeContent(deck);
        matchWriter.writeContent(deck.getMatches().get(deck.getMatches().size() - 1));
    }

    /**
     * Writes the data from the statistics keepers to the Xml files, removes
     * data of the current deck and it's matches from the Xml files.
     *
     * @param deck Deck which data is removed from the Xml files.
     */
    public void saveStatistics(Deck deck) {
        deckWriter.removeAll();
        matchWriter.removeAll();
        matchStatisticsWriter.updateSpecific(deck.getDeckClass(), matchStatisticsKeeper);
        deckScoreStatisticsWriter.updateSpecific(deck.getDeckClass(), deckScoreStatisticsKeeper);
        rewardStatisticsWriter.updateSpecific(deck.getWins(), rewardStatisticsKeeper);
        saveSpecificMatchups(deck);
    }

    private void saveSpecificMatchups(Deck deck) {
        for (Match match : deck.getMatches()) {
            Matchup dcp = new Matchup(match.getPlayerClass(), match.getOpponentClass());
            matchupStatisticsWriter.updateSpecific(dcp, matchupStatisticsKeeper);
        }
    }

    /**
     * Sets the file path where the Xml which stores match statistics can be
     * found
     *
     * @param filePath File path
     */
    public void setMatchStatisticsWriterFilePath(String filePath) {
        matchStatisticsWriter.setFilePath(filePath);
    }

    /**
     * Sets the file path where the Xml which stores matchup statistics can be
     * found
     *
     * @param filePath File path
     */
    public void setMatchupStatisticsWriterFilePath(String filePath) {
        matchupStatisticsWriter.setFilePath(filePath);
    }

    /**
     * Sets the file path where the Xml which stores deck score statistics can
     * be found
     *
     * @param filePath File path
     */
    public void setDeckScoreStatisticsWriterFilePath(String filePath) {
        deckScoreStatisticsWriter.setFilePath(filePath);
    }

    /**
     * Sets the file path where the Xml which stores reward statistics can be
     * found
     *
     * @param filePath File path
     */
    public void setRewardStatisticsWriterFilePath(String filePath) {
        rewardStatisticsWriter.setFilePath(filePath);
    }

    /**
     * Sets the file path where the Xml which stores the current deck can be
     * found.
     *
     * @param filePath File path
     */
    public void setDeckWriterFilePath(String filePath) {
        deckWriter.setFilePath(filePath);
    }

    /**
     * Sets the file path where the Xml which stores the current deck's matches.
     *
     * @param filePath File path
     */
    public void setMatchWriterFilePath(String filePath) {
        matchWriter.setFilePath(filePath);
    }

    /**
     * Resets all of the data in the statistics keepers and the Xml, and
     * rewrites the empty statistics back into the Xml.
     */
    public void resetData() {
        resetDataWithoutRewritingTheXml();
        initXml();
    }

    /**
     * Resets all of the data in the statistics keeper and the Xml.
     */
    public void resetDataWithoutRewritingTheXml() {
        clearXml();
        resetStatisticsKeepers();
    }

    private void clearXml() {
        clearStatisticsXml();
        clearDeckAndMatchesXml();
    }

    private void clearStatisticsXml() {
        matchStatisticsWriter.removeAll();
        matchupStatisticsWriter.removeAll();
        deckScoreStatisticsWriter.removeAll();
        rewardStatisticsWriter.removeAll();
    }

    private void resetStatisticsKeepers() {
        matchStatisticsKeeper.reset();
        matchupStatisticsKeeper.reset();
        deckScoreStatisticsKeeper.reset();
        rewardStatisticsKeeper.reset();
    }

    /**
     * Clears the data from the Xml files which contains statistics data and
     * write the contents of the statistics keepers back into the Xml files.
     */
    public void initXml() {
        clearStatisticsXml();
        matchStatisticsWriter.writeContent(matchStatisticsKeeper);
        matchupStatisticsWriter.writeContent(matchupStatisticsKeeper);
        deckScoreStatisticsWriter.writeContent(deckScoreStatisticsKeeper);
        rewardStatisticsWriter.writeContent(rewardStatisticsKeeper);
    }

    /**
     * Clears the data from the Xml files which contains data about the current
     * deck and it's matches.
     */
    public void clearDeckAndMatchesXml() {
        matchWriter.removeAll();
        deckWriter.removeAll();
    }
}
