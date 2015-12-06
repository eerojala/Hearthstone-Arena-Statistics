
package Xml;


public class DataWriter {
    private MatchStatisticsWriter matchStatisticsWriter;
    private ClassVSClassStatisticsWriter classVSClassStatisticsWriter;
    private DeckClassStatisticsWriter deckClassStatisticsWriter;
    private DeckWriter deckWriter;
    private MatchWriter matchWriter;
    private RewardStatisticsWriter rewardStatisticsWriter;

    public DataWriter() {
        matchStatisticsWriter = new MatchStatisticsWriter("src/main/resources/xml/MatchStatistics.xml");
        classVSClassStatisticsWriter = new ClassVSClassStatisticsWriter("src/main/resources/xml/ClassVSClassStatistics.xml");
        deckClassStatisticsWriter = new DeckClassStatisticsWriter("src/main/resources/xml/DeckClassStatistics.xml");
        deckWriter = new DeckWriter("src/main/resources/xml/Decks.xml");
        matchWriter = new MatchWriter("src/main/resources/xml/Matches.xml");
        rewardStatisticsWriter = new RewardStatisticsWriter("src/main/resources/xml/RewardStatistics.xml");
    }
    
    
}
