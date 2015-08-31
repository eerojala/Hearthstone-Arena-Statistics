package logic;

import domain.Deck;
import domain.DeckClass;
import domain.Match;
import domain.MatchArchive;
import domain.Outcome;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MatchArchiver {

    MatchArchive archive;

    public MatchArchiver(List<Deck> decks) {
        archive = new MatchArchive();
        addMatchesToArchive(decks);
    }

    public MatchArchiver() {
        archive = new MatchArchive();
    }
    
    private void addMatchesToArchive(List<Deck> decks) {
        for (Deck deck : decks) {
            for (Match match : deck.getMatches()) {
                addMatch(match);
            }
        }
    }
    
    public void addMatch(Match match) {
//        String id = "" + match.getDeckNumber() + "." + match.getMatchNumber();
//        archive.getMatchesByID().put(id, match);
        addMatchToMatchesByOpponent(match);
//        addMatchToMapWithDeckClassKey(archive.getMatchesByPlayerDeckClass(), match.getPlayerDeckClass(), match);
//        addMatchToMapWithDeckClassKey(archive.getMatchesByOpponentDeckClass(), match.getOpponentDeckClass(), match);
//        addMatchToMatchesByOutcome(match);
    }
    
    private void addMatchToMatchesByOpponent(Match match) {
        List list;
        if (archive.getMatchesByOpponent().containsKey(match.getOpponentName())) {
            list = archive.getMatchesByOpponent().get(match.getOpponentName());
        } else {
            list = new ArrayList();
        }
        list.add(match);
        archive.getMatchesByOpponent().put(match.getOpponentName(), list);
    }

//    private void addMatchToMapWithDeckClassKey(Map<DeckClass, List<Match>> map,
//            DeckClass key, Match match) {
//        List<Match> list;
//        if (map.containsKey(key)) {
//            list = map.get(key);
//        } else {
//            list = new ArrayList();
//        }
//        list.add(match);
//        map.put(key, list);
//    }
//
//    private void addMatchToMatchesByOutcome(Match match) {
//        List<Match> list;
//        if (archive.getMatchesByOutcome().containsKey(match.getOutcome())) {
//            list = archive.getMatchesByOutcome().get(match.getOutcome());
//        } else {
//            list = new ArrayList();
//        }
//        list.add(match);
//        archive.getMatchesByOutcome().put(match.getOutcome(), list);
//    }
//
//
//    public Match getMatchByID(String ID) {
//        return archive.getMatchesByID().get(ID);
//    }
//
//    public List<Match> getMatchesByPlayerDeckClass(DeckClass deckClass) {
//        return archive.getMatchesByPlayerDeckClass().get(deckClass);
//    }
//
//    public List<Match> getMatchesByOpponentDeckClass(DeckClass deckClass) {
//        return archive.getMatchesByOpponentDeckClass().get(deckClass);
//    }
//
//    public List<Match> getMatchesByOutcome(Outcome outcome) {
//        return archive.getMatchesByOutcome().get(outcome);
//    }
    
    public List<Match> getMatchesByOpponent(String name) {
        return archive.getMatchesByOpponent().get(name);
    }

    public MatchArchive getArchive() {
        return archive;
    }
}
