package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchArchive {

//    private final Map<String, Match> matchesByID;
    private final Map<String, List<Match>> matchesByOpponent;
//    private final Map<DeckClass, List<Match>> matchesByPlayerDeckClass;
//    private final Map<DeckClass, List<Match>> matchesByOpponentDeckClass;
//    private final Map<Outcome, List<Match>> matchesByOutcome;
    private final Map<Integer, List<Match>> matchesByDeckNumber;

    public MatchArchive() {
//        matchesByID = new HashMap();
        matchesByOpponent = new HashMap();
//        matchesByPlayerDeckClass = new HashMap();
//        matchesByOpponentDeckClass = new HashMap();
//        matchesByOutcome = new HashMap();
        matchesByDeckNumber = new HashMap();
    }

//    public Map<String, Match> getMatchesByID() {
//        return matchesByID;
//    }

    public Map<String, List<Match>> getMatchesByOpponent() {
        return matchesByOpponent;
    }
    

//    public Map<DeckClass, List<Match>> getMatchesByOpponentDeckClass() {
//        return matchesByOpponentDeckClass;
//    }
//
//    public Map<Outcome, List<Match>> getMatchesByOutcome() {
//        return matchesByOutcome;
//    }
//
//    public Map<DeckClass, List<Match>> getMatchesByPlayerDeckClass() {
//        return matchesByPlayerDeckClass;
//    }

    public Map<Integer, List<Match>> getMatchesByDeckNumber() {
        return matchesByDeckNumber;
    }
    
}
