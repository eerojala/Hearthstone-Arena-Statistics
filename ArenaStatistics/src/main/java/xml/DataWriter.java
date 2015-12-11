package xml;

import domain.Deck;
import domain.Match;
import logic.ClassStatisticsKeeper;
import logic.ClassVSClassStatisticsKeeper;
import logic.DeckClassStatisticsKeeper;

import logic.RewardStatisticsKeeper;

public class DataWriter {

    private final MatchStatisticsWriter matchStatisticsWriter;
    private final ClassVSClassStatisticsWriter classVSClassStatisticsWriter;
    private final DeckClassStatisticsWriter deckClassStatisticsWriter;
    private final DeckWriter deckWriter;
    private final MatchWriter matchWriter;
    private final RewardStatisticsWriter rewardStatisticsWriter;
    private final ClassStatisticsKeeper classStatisticsKeeper;
    private final ClassVSClassStatisticsKeeper classVSClassStatisticsKeeper;
    private final DeckClassStatisticsKeeper deckClassStatisticsKeeper;
    private final RewardStatisticsKeeper rewardStatisticsKeeper;

    public DataWriter(ClassStatisticsKeeper classStatisticsKeeper, ClassVSClassStatisticsKeeper classVSClassStatisticsKeeper,
            DeckClassStatisticsKeeper deckClassStatisticsKeeper, RewardStatisticsKeeper rewardStatisticsKeeper) {
        matchStatisticsWriter = new MatchStatisticsWriter("src/main/resources/xml/MatchStatistics.xml");
        classVSClassStatisticsWriter = new ClassVSClassStatisticsWriter("src/main/resources/xml/ClassVSClassStatistics.xml");
        deckClassStatisticsWriter = new DeckClassStatisticsWriter("src/main/resources/xml/DeckClassStatistics.xml");
        deckWriter = new DeckWriter("src/main/resources/xml/Decks.xml");
        matchWriter = new MatchWriter("src/main/resources/xml/Matches.xml");
        rewardStatisticsWriter = new RewardStatisticsWriter("src/main/resources/xml/RewardStatistics.xml");
        this.classStatisticsKeeper = classStatisticsKeeper;
        this.deckClassStatisticsKeeper = deckClassStatisticsKeeper;
        this.classVSClassStatisticsKeeper = classVSClassStatisticsKeeper;
        this.rewardStatisticsKeeper = rewardStatisticsKeeper;
    }

    public void save(Deck deck) {
        writeStatisticsKeepers();
        deckWriter.writeContent(deck);
        writeMatches(deck);
    }

    private void writeStatisticsKeepers() {
        matchStatisticsWriter.writeContent(classStatisticsKeeper);
        classVSClassStatisticsWriter.writeContent(classVSClassStatisticsKeeper);
        deckClassStatisticsWriter.writeContent(deckClassStatisticsKeeper);
        rewardStatisticsWriter.writeContent(rewardStatisticsKeeper);
    }

    private void writeMatches(Deck deck) {
        for (Match match : deck.getMatches()) {
            matchWriter.writeContent(match);
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
        writeStatisticsKeepers();
    }

    public void resetDataTest() {
        clearXml();
        resetStatisticsKeepers();
    }

    private void clearXml() {
        matchStatisticsWriter.removeAll();
        classVSClassStatisticsWriter.removeAll();
        deckClassStatisticsWriter.removeAll();
        rewardStatisticsWriter.removeAll();
        matchWriter.removeAll();
        deckWriter.removeAll();
    }

    private void resetStatisticsKeepers() {
        classStatisticsKeeper.reset();
        classVSClassStatisticsKeeper.reset();
        deckClassStatisticsKeeper.reset();
        rewardStatisticsKeeper.reset();
    }
}
