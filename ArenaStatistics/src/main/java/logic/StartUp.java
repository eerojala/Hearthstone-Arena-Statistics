package logic;

import Xml.*;
import domain.Deck;
import domain.Match;
import java.util.ArrayList;
import java.util.List;

public class StartUp {

    public static Deck getCurrentDeck(String filepath) {
        DeckParser parser = new DeckParser(filepath);
        parser.addValues();
        List<Deck> decks = parser.getDecks();
        try {
            return decks.get(decks.size() - 1);
        } catch (Exception e) {
            return null;
        }      
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

    public static void assignMatchesToDeck(Deck deck, List<Match> matches) {
        MatchAssigner.assignMatchesToDeck(deck, matches);
    }
}
