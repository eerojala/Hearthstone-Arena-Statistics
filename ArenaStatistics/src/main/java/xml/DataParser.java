package xml;

import domain.Deck;
import domain.Match;
import java.util.List;
import logic.ClassStatisticsKeeper;
import logic.ClassVSClassStatisticsKeeper;
import logic.DeckClassStatisticsKeeper;
import logic.MatchAssigner;
import logic.RewardStatisticsKeeper;

public class DataParser {

    private Deck currentDeck;
    private ClassStatisticsKeeper classStatisticsKeeper;
    private ClassVSClassStatisticsKeeper classVSClassStatisticsKeeper;
    private DeckClassStatisticsKeeper deckClassStatisticsKeeper;
    private RewardStatisticsKeeper rewardStatisticsKeeper;
    private String decksFilepath;
    private String matchesFilepath;
    private String matchStatisticsFilepath;
    private String classVSClassStatisticsFilepath;
    private String deckClassStatisticsFilepath;
    private String rewardStatisticsFilepath;

    public DataParser() {
        setDefaultFilepaths();
    }
    
    private void setDefaultFilepaths() {
        decksFilepath = "src/main/resources/xmlfiles/Decks.xml";
        matchesFilepath = "src/main/resources/xmlfiles/Matches.xml";
        matchStatisticsFilepath = "src/main/resources/xmlfiles/MatchStatistics.xml";
        classVSClassStatisticsFilepath = "src/main/resources/xmlfiles/ClassVSClassStatistics.xml";
        deckClassStatisticsFilepath = "src/main/resources/xmlfiles/DeckClassStatistics.xml";
        rewardStatisticsFilepath = "src/main/resources/xmlfiles/RewardStatistics.xml";
    }
    
    public void parseData() {
        setCurrentDeck();
        assignMatchesToDeck();
        setMatchStatistics();
        setClassVSClassStatistics();
        setDeckClassStatistics();
        setRewardStatistics();
    }

    private void setCurrentDeck() {
        DeckParser parser = new DeckParser(decksFilepath);
        parser.addValues();
        List<Deck> decks = parser.getDecks();
        try {
            currentDeck = decks.get(decks.size() - 1);
        } catch (Exception e) {

        }
    }

    private void assignMatchesToDeck() {
        List<Match> matches = getMatches();
        MatchAssigner.assignMatchesToDeck(currentDeck, matches);
    }

    private List<Match> getMatches() {
        MatchParser parser = new MatchParser(matchesFilepath);
        parser.addValues();
        try {
            return parser.getArchiver().getMatchesByDeckNumber(currentDeck.getDeckNumber());
        } catch (Exception e) {
            return null;
        }     
    }

    private void setMatchStatistics() {
        MatchStatisticsParser parser = new MatchStatisticsParser(matchStatisticsFilepath);
        parser.addValues();
        classStatisticsKeeper = parser.getKeeper();
    }

    private void setClassVSClassStatistics() {
        ClassVSClassStatisticsParser parser = new ClassVSClassStatisticsParser(classVSClassStatisticsFilepath);
        parser.addValues();
        classVSClassStatisticsKeeper = parser.getKeeper();
    }

    private void setDeckClassStatistics() {
        DeckClassStatisticsParser parser = new DeckClassStatisticsParser(deckClassStatisticsFilepath);
        parser.addValues();
        deckClassStatisticsKeeper = parser.getKeeper();
    }

    private void setRewardStatistics() {
        RewardStatisticsParser parser = new RewardStatisticsParser(rewardStatisticsFilepath);
        parser.addValues();
        rewardStatisticsKeeper = parser.getKeeper();
    }

    public ClassStatisticsKeeper getClassStatisticsKeeper() {
        return classStatisticsKeeper;
    }

    public ClassVSClassStatisticsKeeper getClassVSClassStatisticsKeeper() {
        return classVSClassStatisticsKeeper;
    }

    public Deck getCurrentDeck() {
        return currentDeck;
    }

    public DeckClassStatisticsKeeper getDeckClassStatisticsKeeper() {
        return deckClassStatisticsKeeper;
    }

    public RewardStatisticsKeeper getRewardStatisticsKeeper() {
        return rewardStatisticsKeeper;
    }

    public void setClassVSClassStatisticsFilepath(String classVSClassStatisticsFilepath) {
        this.classVSClassStatisticsFilepath = classVSClassStatisticsFilepath;
    }

    public void setDeckClassStatisticsFilepath(String deckClassStatisticsFilepath) {
        this.deckClassStatisticsFilepath = deckClassStatisticsFilepath;
    }

    public void setDecksFilepath(String decksFilepath) {
        this.decksFilepath = decksFilepath;
    }

    public void setMatchStatisticsFilepath(String matchStatisticsFilepath) {
        this.matchStatisticsFilepath = matchStatisticsFilepath;
    }

    public void setMatchesFilepath(String matchesFilepath) {
        this.matchesFilepath = matchesFilepath;
    }

    public void setRewardStatisticsFilepath(String rewardStatisticsFilepath) {
        this.rewardStatisticsFilepath = rewardStatisticsFilepath;
    }
}