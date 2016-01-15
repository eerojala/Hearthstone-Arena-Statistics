package xml;

import domain.Deck;
import domain.Match;
import java.util.List;
import logic.MatchStatisticsKeeper;
import logic.MatchupStatisticsKeeper;
import logic.DeckScoreStatisticsKeeper;
import logic.MatchAssigner;
import logic.RewardStatisticsKeeper;

/**
 * Class which parses all of the data from the Xml files.
 */
public class DataParser {

    private Deck currentDeck;
    private MatchStatisticsKeeper matchStatisticsKeeper;
    private MatchupStatisticsKeeper matchupStatisticsKeeper;
    private DeckScoreStatisticsKeeper deckScoreStatisticsKeeper;
    private RewardStatisticsKeeper rewardStatisticsKeeper;
    private XmlParser parser;
    private String decksFilePath;
    private String matchesFilePath;
    private String matchStatisticsFilepath;
    private String matchupStatisticsFilePath;
    private String deckScoreStatisticsFilePath;
    private String rewardStatisticsFilepath;

    /**
     * Creates a new DataParser object.
     */
    public DataParser() {
        setDefaultFilepaths();
    }
    
    private void setDefaultFilepaths() {
        decksFilePath = "src/main/resources/xmlfiles/Decks.xml";
        matchesFilePath = "src/main/resources/xmlfiles/Matches.xml";
        matchStatisticsFilepath = "src/main/resources/xmlfiles/MatchStatistics.xml";
        matchupStatisticsFilePath = "src/main/resources/xmlfiles/ClassVSClassStatistics.xml";
        deckScoreStatisticsFilePath = "src/main/resources/xmlfiles/DeckClassStatistics.xml";
        rewardStatisticsFilepath = "src/main/resources/xmlfiles/RewardStatistics.xml";
    }
    
    /**
     * Parses the data from all of the Xml files.
     */
    public void parseData() {
        setCurrentDeck();
        assignMatchesToDeck();
        setMatchStatistics();
        setClassVSClassStatistics();
        setDeckClassStatistics();
        setRewardStatistics();
    }

    private void setCurrentDeck() {
        parser = new DeckParser(decksFilePath);
        parser.addValues();
        try {
            currentDeck = (Deck) parser.getParsedObject();
        } catch (Exception e) {

        }
    }

    private void assignMatchesToDeck() {
        List<Match> matches = getMatches();
        MatchAssigner.assignMatchesToDeck(currentDeck, matches);
    }

    private List<Match> getMatches() {
        parser = new MatchParser(matchesFilePath);
        parser.addValues();
        try {
            return (List<Match>) parser.getParsedObject();
        } catch (Exception e) {
            return null;
        }     
    }

    private void setMatchStatistics() {
        parser = new MatchStatisticsParser(matchStatisticsFilepath);
        parser.addValues();
        matchStatisticsKeeper = (MatchStatisticsKeeper) parser.getParsedObject();
    }

    private void setClassVSClassStatistics() {
        parser = new MatchupStatisticsParser(matchupStatisticsFilePath);
        parser.addValues();
        matchupStatisticsKeeper = (MatchupStatisticsKeeper) parser.getParsedObject();
    }

    private void setDeckClassStatistics() {
        parser = new DeckScoreStatisticsParser(deckScoreStatisticsFilePath);
        parser.addValues();
        deckScoreStatisticsKeeper = (DeckScoreStatisticsKeeper) parser.getParsedObject();
    }

    private void setRewardStatistics() {
        parser = new RewardStatisticsParser(rewardStatisticsFilepath);
        parser.addValues();
        rewardStatisticsKeeper = (RewardStatisticsKeeper) parser.getParsedObject();
    }

    /**
     * Returns the MatchStatisticsKeeper parsed from the Xml file.
     * 
     * @return MatchStatisticsKeeper
     */
    public MatchStatisticsKeeper getMatchStatisticsKeeper() {
        return matchStatisticsKeeper;
    }

    /**
     * Returns the MatchupStatisticsKeeper parsed from the Xml file.
     * 
     * @return MatchupStatisitcsKeeper
     */
    public MatchupStatisticsKeeper getMatchupStatisticsKeeper() {
        return matchupStatisticsKeeper;
    }

    /**
     * Returns the Deck parsed from the Xml file.
     * 
     * @return Deck
     */
    public Deck getCurrentDeck() {
        return currentDeck;
    }

    /**
     * Returns the DeckScoreStatisticsKeeper parsed from the Xml file.
     * 
     * @return DeckScoreStatisticsKeeper
     */
    public DeckScoreStatisticsKeeper getDeckScoreStatisticsKeeper() {
        return deckScoreStatisticsKeeper;
    }

    /**
     * Returns the RewardStatisticsKeeper parsed from the Xml file.
     * 
     * @return RewardStatisticsKeeper.
     */
    public RewardStatisticsKeeper getRewardStatisticsKeeper() {
        return rewardStatisticsKeeper;
    }

    /**
     * Sets the file path to the Xml file which contains matchup related statistics.
     * 
     * @param matchupStatisticsFilePath File path
     */
    public void setMatchupStatisticsFilePath(String matchupStatisticsFilePath) {
        this.matchupStatisticsFilePath = matchupStatisticsFilePath;
    }

    /**
     * Sets the file path where the Xml file which contains deck score related statistics can be found.
     * 
     * @param deckScoreStatisticsFilePath File path
     */
    public void setDeckScoreStatisticsFilePath(String deckScoreStatisticsFilePath) {
        this.deckScoreStatisticsFilePath = deckScoreStatisticsFilePath;
    }

    /**
     * Sets the file path where the Xml file which contains the currently ongoing arena Deck can be found.
     * 
     * @param decksFilePath File path
     */
    public void setDecksFilePath(String decksFilePath) {
        this.decksFilePath = decksFilePath;
    }

    /**
     * Sets the file path where the Xml file which contains match related statistics can be found.
     * 
     * @param matchStatisticsFilepath File path
     */
    public void setMatchStatisticsFilepath(String matchStatisticsFilepath) {
        this.matchStatisticsFilepath = matchStatisticsFilepath;
    }

    /**
     * Sets the file path where the Xml file which contains the current deck's matches can be found.
     * 
     * @param matchesFilePath File path
     */
    public void setMatchesFilePath(String matchesFilePath) {
        this.matchesFilePath = matchesFilePath;
    }

    /**
     * Sets the file path where the Xml file which contains reward related statistics can be found.
     * 
     * @param rewardStatisticsFilepath
     */
    public void setRewardStatisticsFilepath(String rewardStatisticsFilepath) {
        this.rewardStatisticsFilepath = rewardStatisticsFilepath;
    }
}
