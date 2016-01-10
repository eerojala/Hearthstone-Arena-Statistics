package xml;

import domain.Deck;
import domain.Matchup;
import domain.Match;
import logic.MatchStatisticsKeeper;
import logic.MatchupStatisticsKeeper;
import logic.DeckScoreStatisticsKeeper;

import logic.RewardStatisticsKeeper;

public class DataWriter {

    private final MatchStatisticsWriter matchStatisticsWriter;
    private final ClassVSClassStatisticsWriter classVSClassStatisticsWriter;
    private final DeckClassStatisticsWriter deckClassStatisticsWriter;
    private final DeckWriter deckWriter;
    private final MatchWriter matchWriter;
    private final RewardStatisticsWriter rewardStatisticsWriter;
    private final MatchStatisticsKeeper classStatisticsKeeper;
    private final MatchupStatisticsKeeper classVSClassStatisticsKeeper;
    private final DeckScoreStatisticsKeeper deckClassStatisticsKeeper;
    private final RewardStatisticsKeeper rewardStatisticsKeeper;

    public DataWriter(MatchStatisticsKeeper classStatisticsKeeper, MatchupStatisticsKeeper classVSClassStatisticsKeeper,
            DeckScoreStatisticsKeeper deckClassStatisticsKeeper, RewardStatisticsKeeper rewardStatisticsKeeper) {
        matchStatisticsWriter = new MatchStatisticsWriter("src/main/resources/xmlfiles/MatchStatistics.xml");
        classVSClassStatisticsWriter = new ClassVSClassStatisticsWriter("src/main/resources/xmlfiles/ClassVSClassStatistics.xml");
        deckClassStatisticsWriter = new DeckClassStatisticsWriter("src/main/resources/xmlfiles/DeckClassStatistics.xml");
        deckWriter = new DeckWriter("src/main/resources/xmlfiles/Decks.xml");
        matchWriter = new MatchWriter("src/main/resources/xmlfiles/Matches.xml");
        rewardStatisticsWriter = new RewardStatisticsWriter("src/main/resources/xmlfiles/RewardStatistics.xml");
        this.classStatisticsKeeper = classStatisticsKeeper;
        this.deckClassStatisticsKeeper = deckClassStatisticsKeeper;
        this.classVSClassStatisticsKeeper = classVSClassStatisticsKeeper;
        this.rewardStatisticsKeeper = rewardStatisticsKeeper;
    }

    public void saveProgress(Deck deck) {
        deckWriter.removeAll();
        deckWriter.writeContent(deck);
        matchWriter.writeContent(deck.getMatches().get(deck.getMatches().size() - 1));
    }

    public void saveStatistics(Deck deck) {
        deckWriter.removeAll();
        matchWriter.removeAll();
        matchStatisticsWriter.updateSpecific(deck.getDeckClass(), classStatisticsKeeper);
        deckClassStatisticsWriter.updateSpecific(deck.getDeckClass(), deckClassStatisticsKeeper);
        rewardStatisticsWriter.updateSpecific(deck.getWins(), rewardStatisticsKeeper);
        saveSpecificMatchups(deck);
    }

    private void saveSpecificMatchups(Deck deck) {
        for (Match match : deck.getMatches()) {
            Matchup dcp = new Matchup(match.getPlayerClass(), match.getOpponentClass());
            classVSClassStatisticsWriter.updateSpecific(dcp, classVSClassStatisticsKeeper);
        }
    }

    public void setMatchStatisticsWriterFilepath(String filepath) {
        matchStatisticsWriter.setFilepath(filepath);
    }

    public void setClassVSClassStatisticsWriterFilepath(String filepath) {
        classVSClassStatisticsWriter.setFilepath(filepath);
    }

    public void setDeckClassStatisticsWriterFilepath(String filepath) {
        deckClassStatisticsWriter.setFilepath(filepath);
    }

    public void setRewardStatisticsWriterFilePath(String filepath) {
        rewardStatisticsWriter.setFilepath(filepath);
    }

    public void setDeckWriterFilePath(String filepath) {
        deckWriter.setFilepath(filepath);
    }

    public void setMatchWriterFilePath(String filepath) {
        matchWriter.setFilepath(filepath);
    }

    public void resetData() {
        resetDataTest();
        initXml();
    }

    public void resetDataTest() {
        clearXml();
        resetStatisticsKeepers();
    }

    private void clearXml() {
        clearStatisticsXml();
        removeDeckAndMatches();
    }

    private void clearStatisticsXml() {
        matchStatisticsWriter.removeAll();
        classVSClassStatisticsWriter.removeAll();
        deckClassStatisticsWriter.removeAll();
        rewardStatisticsWriter.removeAll();
    }

    private void resetStatisticsKeepers() {
        classStatisticsKeeper.reset();
        classVSClassStatisticsKeeper.reset();
        deckClassStatisticsKeeper.reset();
        rewardStatisticsKeeper.reset();
    }

    public void initXml() {
        clearStatisticsXml();
        matchStatisticsWriter.writeContent(classStatisticsKeeper);
        classVSClassStatisticsWriter.writeContent(classVSClassStatisticsKeeper);
        deckClassStatisticsWriter.writeContent(deckClassStatisticsKeeper);
        rewardStatisticsWriter.writeContent(rewardStatisticsKeeper);
    }

    public void removeDeckAndMatches() {
        matchWriter.removeAll();
        deckWriter.removeAll();
    }
}
