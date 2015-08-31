package logic;

import Xml.*;
import domain.Deck;
import domain.Match;
import java.util.ArrayList;
import java.util.List;

public class StartUp {

    public static List<Deck> getDecks(String filepath) {
        DeckParser parser = new DeckParser(filepath);
        parser.addValues();
        return parser.getDecks();
    }
    
    public static MatchArchiver getMatchArchiver(String filepath) {
             MatchParser parser = new MatchParser(filepath);
            parser.addValues();
            return parser.getArchiver();
    }

    public static ClassStatisticsKeeper getClassStatistics(String filepath) {
        ClassStatisticsParser parser = new ClassStatisticsParser(filepath);
        parser.addValues();
        return parser.getKeeper();
    }

    public static ClassVSClassStatisticsKeeper getClassVSClassStatistics(String filepath) {
        ClassVSClassStatisticsParser parser = new ClassVSClassStatisticsParser(filepath);
        parser.addValues();
        return parser.getKeeper();
    }

    public static DeckClassStatisticsKeeper getDeckClassStatisticsKeeper(String filepath) {
        DeckClassStatisticsParser parser = new DeckClassStatisticsParser(filepath);
        parser.addValues();
        return parser.getKeeper();
    }

    public static RewardStatisticsKeeper getDeckWinStatisticsKeeper(String filepath) {
        RewardStatisticsParser parser = new RewardStatisticsParser(filepath);
        parser.addValues();
        return parser.getKeeper();
    }

    public static void assignMatchesToDecks(List<Deck> decks, List<Match> matches) {
        MatchAssigner.assignMatches(decks, matches);
    }
}
