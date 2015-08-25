package logic;

import Xml.MatchClassStatisticsParser;
import Xml.ClassVSClassStatisticsParser;
import Xml.DeckParser;
import Xml.MatchParser;
import domain.Deck;
import domain.Match;
import java.util.List;

public class StartUp {
    
    public static List<Deck> getDecks(String filepath) {
        DeckParser parser = new DeckParser(filepath);
        parser.addValues();
        return parser.getDecks();
    }
    
    public static List<Match> getMatches(String filepath) {
        MatchParser parser = new MatchParser(filepath);
        parser.addValues();
        return parser.getMatches();
    }
    
    public static MatchClassStatisticsKeeper getClassStatistics(String filepath) {
        MatchClassStatisticsParser parser = new MatchClassStatisticsParser(filepath);
        parser.addValues();
        return parser.getKeeper();
    }
    
    public static ClassVSClassStatisticsKeeper getClassVSClassStatistics(String filepath) {
        ClassVSClassStatisticsParser parser = new ClassVSClassStatisticsParser(filepath);
        parser.addValues();
        return parser.getKeeper();
    }
    
    public static void assignMatchesToDecks(List<Deck> decks, List<Match> matches) {
        MatchAssigner assigner = new MatchAssigner();
        assigner.assignMatches(decks, matches);
    }
}
