package logic;

import domain.Deck;
import domain.DeckClass;
import domain.DeckClassPair;
import domain.Match;
import domain.MatchStatistics;
import domain.Outcome;
import java.util.List;
import java.util.Map;
import util.Mapper;
import util.StatisticsHelper;

public class MatchStatisticsKeeper {

    private MatchStatistics statistics;

    public MatchStatisticsKeeper() {
        statistics = new MatchStatistics();
    }

    public void addMatches(List<Deck> decks) {
        for (Deck deck : decks) {
            for (Match match : deck.getMatches()) {
                addMatch(match);
            }
        }
    }

    public void addMatch(Match match) {
        if (match.wentFirst()) {
            addMatchThatWent1st(match);
        } else {
            addMatchThatWent2nd(match);
        }
    }

    private void addMatchThatWent1st(Match match) {
        increaseIntegerIn1stMatchMaps(match);
        if (match.getOutcome() == Outcome.WIN) {
            addMatchThatWent1stAndWon(match);
        } else if (match.getOutcome() == Outcome.LOSS) {
            addMatchThatWent1stAndLost(match);
        }
        updateWinPercentageIn1stMatchMaps(match);
    }

    private void increaseIntegerIn1stMatchMaps(Match match) {
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getMatchesAsClass1st(), match.getPlayerDeckClass());
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getMatchesVSClass1st(), match.getOpponentDeckClass());
        Mapper.increaseIntegerInDeckClassPairIntegerMap(match, statistics.getMatchesInClassVSClass1st());
    }

    private void addMatchThatWent1stAndWon(Match match) {
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getWinsAsClass1st(), match.getPlayerDeckClass());
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getWinsVSClass1st(), match.getOpponentDeckClass());
        Mapper.increaseIntegerInDeckClassPairIntegerMap(match, statistics.getWinsInClassVSClass1st());
    }

    private void addMatchThatWent1stAndLost(Match match) {
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getLossesAsClass1st(), match.getPlayerDeckClass());
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getLossesVSClass1st(), match.getOpponentDeckClass());
        Mapper.increaseIntegerInDeckClassPairIntegerMap(match, statistics.getLossesInClassVSClass1st());
    }

    private void updateWinPercentageIn1stMatchMaps(Match match) {
        Mapper.updateWinPercentageInDeckClassDoubleMap(statistics.getWinPerAsClass1st(),
                statistics.getMatchesAsClass1st(), statistics.getWinsAsClass1st(),
                statistics.getLossesAsClass1st(), match.getPlayerDeckClass());
        Mapper.updateWinPercentageInDeckClassDoubleMap(statistics.getWinPerVSClass1st(),
                statistics.getMatchesVSClass1st(), statistics.getWinsVSClass1st(),
                statistics.getLossesVSClass1st(), match.getOpponentDeckClass());
        Mapper.updateWinPercentageInDeckClassPairDoubleMap(match, statistics.getWinPerClassVSClass1st(),
                statistics.getMatchesInClassVSClass1st(), statistics.getWinsInClassVSClass1st(),
                statistics.getLossesInClassVSClass1st());
    }

    private void addMatchThatWent2nd(Match match) {
        addMatchTo2ndMatchMaps(match);
        if (match.getOutcome() == Outcome.WIN) {
            addMatchThatWent2ndAndWon(match);
        } else if (match.getOutcome() == Outcome.LOSS) {
            addMatchThatWent2ndAndLost(match);
        }
        updateWinPercentageIn2ndMatchMaps(match);
    }

    private void addMatchTo2ndMatchMaps(Match match) {
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getMatchesAsClass2nd(), match.getPlayerDeckClass());
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getMatchesVSClass2nd(), match.getOpponentDeckClass());
        Mapper.increaseIntegerInDeckClassPairIntegerMap(match, statistics.getMatchesInClassVSClass2nd());
    }

    private void addMatchThatWent2ndAndWon(Match match) {
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getWinsAsClass2nd(), match.getPlayerDeckClass());
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getWinsVSClass2nd(), match.getOpponentDeckClass());
        Mapper.increaseIntegerInDeckClassPairIntegerMap(match, statistics.getWinsInClassVSClass2nd());
    }

    private void addMatchThatWent2ndAndLost(Match match) {
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getLossesAsClass2nd(), match.getPlayerDeckClass());
        Mapper.increaseIntegerInDeckClassIntegerMap(statistics.getLossesVSClass2nd(), match.getOpponentDeckClass());
        Mapper.increaseIntegerInDeckClassPairIntegerMap(match, statistics.getLossesInClassVSClass2nd());
    }

    private void updateWinPercentageIn2ndMatchMaps(Match match) {
        Mapper.updateWinPercentageInDeckClassDoubleMap(statistics.getWinPerAsClass2nd(), statistics.getMatchesAsClass2nd(),
                statistics.getWinsAsClass2nd(), statistics.getLossesAsClass2nd(), match.getPlayerDeckClass());
        Mapper.updateWinPercentageInDeckClassDoubleMap(statistics.getWinPerVSClass2nd(), statistics.getMatchesVSClass2nd(),
                statistics.getWinsVSClass2nd(), statistics.getLossesVSClass2nd(), match.getOpponentDeckClass());
        Mapper.updateWinPercentageInDeckClassPairDoubleMap(match, statistics.getWinPerClassVSClass2nd(),
                statistics.getMatchesInClassVSClass2nd(), statistics.getWinsInClassVSClass2nd(),
                statistics.getLossesInClassVSClass2nd());
    }

    public void setMatchesVSClass1st(DeckClass deckClass, int matches) {
        statistics.getMatchesVSClass1st().put(deckClass, matches);
    }

    public void setMatchesVSClass2nd(DeckClass deckClass, int matches) {
        statistics.getMatchesVSClass2nd().put(deckClass, matches);
    }

    public void setMatchesAsClass1st(DeckClass deckClass, int matches) {
        statistics.getMatchesAsClass1st().put(deckClass, matches);
    }

    public void setMatchesAsClass2nd(DeckClass deckClass, int matches) {
        statistics.getMatchesAsClass2nd().put(deckClass, matches);
    }

    public void setWinsAsClass1st(DeckClass deckClass, int wins) {
        statistics.getWinsAsClass1st().put(deckClass, wins);
    }

    public void setWinsAsClass2nd(DeckClass deckClass, int wins) {
        statistics.getWinsAsClass2nd().put(deckClass, wins);
    }

    public void setLossesAsClass1st(DeckClass deckClass, int losses) {
        statistics.getLossesAsClass1st().put(deckClass, losses);
    }

    public void setLossesAsClass2nd(DeckClass deckClass, int losses) {
        statistics.getLossesAsClass2nd().put(deckClass, losses);
    }

    public void setWinsVSClass1st(DeckClass deckClass, int wins) {
        statistics.getWinsVSClass1st().put(deckClass, wins);
    }

    public void setWinsVSClass2nd(DeckClass deckClass, int wins) {
        statistics.getWinsVSClass2nd().put(deckClass, wins);
    }

    public void setLossesVSClass1st(DeckClass deckClass, int losses) {
        statistics.getLossesVSClass1st().put(deckClass, losses);
    }

    public void setLossesVSClass2nd(DeckClass deckClass, int losses) {
        statistics.getLossesVSClass2nd().put(deckClass, losses);
    }

    public void setMatchesInClassVSClass1st(DeckClassPair dcp, int matches) {
        statistics.getMatchesInClassVSClass1st().put(dcp, matches);
    }

    public void setMatchesInClassVSClass2nd(DeckClassPair dcp, int matches) {
        statistics.getMatchesInClassVSClass2nd().put(dcp, matches);
    }

    public void setWinsInClassVSClass1st(DeckClassPair dcp, int wins) {
        statistics.getWinsInClassVSClass1st().put(dcp, wins);
    }

    public void setWinsInClassVSClass2nd(DeckClassPair dcp, int wins) {
        statistics.getWinsInClassVSClass2nd().put(dcp, wins);
    }

    public void setLossesInClassVSClass1st(DeckClassPair dcp, int losses) {
        statistics.getLossesInClassVSClass1st().put(dcp, losses);
    }

    public void setLossesInClassVSClass2nd(DeckClassPair dcp, int losses) {
        statistics.getLossesInClassVSClass2nd().put(dcp, losses);
    }

    public void setWinPerVSClass1st(DeckClass deckClass, double percentage) {
        statistics.getWinPerVSClass1st().put(deckClass, percentage);
    }

    public void setWinPerVSClass2nd(DeckClass deckClass, double percentage) {
        statistics.getWinPerVSClass2nd().put(deckClass, percentage);
    }

    public void setWinPerAsClass1st(DeckClass deckClass, double percentage) {
        statistics.getWinPerAsClass1st().put(deckClass, percentage);
    }

    public void setWinPerAsClass2nd(DeckClass deckClass, double percentage) {
        statistics.getWinPerAsClass2nd().put(deckClass, percentage);
    }

    public void setWinPerClassVSClass1st(DeckClassPair dcp, double percentage) {
        statistics.getWinPerClassVSClass1st().put(dcp, percentage);
    }

    public void setWinPerClassVSClass2nd(DeckClassPair dcp, double percentage) {
        statistics.getWinPerClassVSClass2nd().put(dcp, percentage);
    }

    public int getMatchesVSClass1st(DeckClass deckClass) {
        return statistics.getMatchesVSClass1st().get(deckClass);
    }

    public int getMatchesVSClass2nd(DeckClass deckClass) {
        return statistics.getMatchesVSClass2nd().get(deckClass);
    }

    public int getMatchesAsClass1st(DeckClass deckClass) {
        return statistics.getMatchesAsClass1st().get(deckClass);
    }

    public int getMatchesAsClass2nd(DeckClass deckClass) {
        return statistics.getMatchesAsClass2nd().get(deckClass);
    }

    public int getWinsAsClass1st(DeckClass deckClass) {
        return statistics.getWinsAsClass1st().get(deckClass);
    }

    public int getWinsAsClass2nd(DeckClass deckClass) {
        return statistics.getWinsAsClass2nd().get(deckClass);
    }

    public int getLossesAsClass1st(DeckClass deckClass) {
        return statistics.getLossesAsClass1st().get(deckClass);
    }

    public int getLossesAsClass2nd(DeckClass deckClass) {
        return statistics.getLossesAsClass2nd().get(deckClass);
    }

    public int getWinsVSClass1st(DeckClass deckClass) {
        return statistics.getWinsVSClass1st().get(deckClass);
    }

    public int getWinsVSClass2nd(DeckClass deckClass) {
        return statistics.getWinsVSClass2nd().get(deckClass);
    }

    public int getLossesVSClass1st(DeckClass deckClass) {
        return statistics.getLossesVSClass1st().get(deckClass);
    }

    public int getLossesVSClass2nd(DeckClass deckClass) {
        return statistics.getLossesVSClass2nd().get(deckClass);
    }

    public int getMatchesInClassVSClass1st(DeckClassPair dcp) {
        return statistics.getMatchesInClassVSClass1st().get(dcp);
    }

    public int getMatchesInClassVSClass2nd(DeckClassPair dcp) {
        return statistics.getMatchesInClassVSClass2nd().get(dcp);
    }

    public int getWinsInClassVSClass1st(DeckClassPair dcp) {
        return statistics.getWinsInClassVSClass1st().get(dcp);
    }

    public int getWinsInClassVSClass2nd(DeckClassPair dcp) {
        return statistics.getWinsInClassVSClass2nd().get(dcp);
    }

    public int getLossesInClassVSClass1st(DeckClassPair dcp) {
        return statistics.getLossesInClassVSClass1st().get(dcp);
    }

    public int getLossesInClassVSClass2nd(DeckClassPair dcp) {
        return statistics.getLossesInClassVSClass2nd().get(dcp);
    }

    public double getWinPerVSClass1st(DeckClass deckClass) {
        return statistics.getWinPerVSClass1st().get(deckClass);
    }

    public double getWinPerVSClass2nd(DeckClass deckClass) {
        return statistics.getWinPerVSClass2nd().get(deckClass);
    }

    public double getWinPerAsClass1st(DeckClass deckClass) {
        return statistics.getWinPerAsClass1st().get(deckClass);
    }

    public double getWinPerAsClass2nd(DeckClass deckClass) {
        return statistics.getWinPerAsClass2nd().get(deckClass);
    }

    public double getWinPerClassVSClass1st(DeckClassPair dcp) {
        return statistics.getWinPerClassVSClass1st().get(dcp);
    }

    public double getWinPerClassVSClass2nd(DeckClassPair dcp) {
        return statistics.getWinPerClassVSClass2nd().get(dcp);
    }

    public void removeMatchFromStatistics(Match match) {
        if (match.wentFirst()) {
            removeMatchThatWent1st(match);
        } else {
            removeMatchThatWent2nd(match);
        }
    }

    private void removeMatchThatWent1st(Match match) {
        removeMatchFrom1stMatchMaps(match);
        if (match.getOutcome() == Outcome.WIN) {
            removeMatchThatWent1stAndWon(match);
        } else if (match.getOutcome() == Outcome.LOSS) {
            removeMatchThatWent1stAndLost(match);
        }
        updateWinPercentageIn1stMatchMaps(match);
    }

    private void removeMatchFrom1stMatchMaps(Match match) {
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getMatchesAsClass1st(), match.getPlayerDeckClass());
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getMatchesVSClass1st(), match.getOpponentDeckClass());
        Mapper.decreaseIntegerInDeckClassPairIntegerMap(match, statistics.getMatchesInClassVSClass1st());
    }

    private void removeMatchThatWent1stAndWon(Match match) {
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getWinsAsClass1st(), match.getPlayerDeckClass());
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getWinsVSClass1st(), match.getOpponentDeckClass());
        Mapper.decreaseIntegerInDeckClassPairIntegerMap(match, statistics.getWinsInClassVSClass1st());
    }

    private void removeMatchThatWent1stAndLost(Match match) {
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getLossesAsClass1st(), match.getPlayerDeckClass());
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getLossesVSClass1st(), match.getOpponentDeckClass());
        Mapper.decreaseIntegerInDeckClassPairIntegerMap(match, statistics.getLossesInClassVSClass1st());
    }

    private void removeMatchThatWent2nd(Match match) {
        removeMatchFrom2ndMatchMaps(match);
        if (match.getOutcome() == Outcome.WIN) {
            removeMatchThatWent2ndAndWon(match);
        } else if (match.getOutcome() == Outcome.LOSS) {
            removeMatchThatWent2ndAndLost(match);
        }
        updateWinPercentageIn2ndMatchMaps(match);
    }

    private void removeMatchFrom2ndMatchMaps(Match match) {
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getMatchesAsClass2nd(), match.getPlayerDeckClass());
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getMatchesVSClass2nd(), match.getOpponentDeckClass());
        Mapper.decreaseIntegerInDeckClassPairIntegerMap(match, statistics.getMatchesInClassVSClass2nd());
    }

    private void removeMatchThatWent2ndAndWon(Match match) {
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getWinsAsClass2nd(), match.getPlayerDeckClass());
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getWinsVSClass2nd(), match.getOpponentDeckClass());
        Mapper.decreaseIntegerInDeckClassPairIntegerMap(match, statistics.getWinsInClassVSClass2nd());
    }

    private void removeMatchThatWent2ndAndLost(Match match) {
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getLossesAsClass2nd(), match.getPlayerDeckClass());
        Mapper.decreaseIntegerInDeckClassIntegerMap(statistics.getLossesVSClass2nd(), match.getOpponentDeckClass());
        Mapper.decreaseIntegerInDeckClassPairIntegerMap(match, statistics.getLossesInClassVSClass2nd());
    }

    public MatchStatistics getStatistics() {
        return statistics;
    }

    public int getMatchesAsClassTotal(DeckClass dc) {
        return getMatchesAsClass1st(dc) + getMatchesAsClass2nd(dc);
    }

    public int getMatchesVSClassTotal(DeckClass dc) {
        return getMatchesVSClass1st(dc) + getMatchesVSClass2nd(dc);
    }

    public int getMatchesInClassVSClassTotal(DeckClassPair dcp) {
        return getMatchesInClassVSClass1st(dcp) + getMatchesInClassVSClass2nd(dcp);
    }

    public int getWinsAsClassTotal(DeckClass dc) {
        return getWinsAsClass1st(dc) + getWinsAsClass2nd(dc);
    }

    public int getWinsVSClassTotal(DeckClass dc) {
        return getWinsVSClass1st(dc) + getWinsVSClass2nd(dc);
    }

    public int getWinsInClassVSClassTotal(DeckClassPair dcp) {
        return getWinsInClassVSClass1st(dcp) + getWinsInClassVSClass2nd(dcp);
    }

    public int getLossesAsClassTotal(DeckClass dc) {
        return getLossesAsClass1st(dc) + getLossesAsClass2nd(dc);
    }

    public int getLossesVSClassTotal(DeckClass dc) {
        return getLossesVSClass1st(dc) + getLossesVSClass2nd(dc);
    }

    public int getLossesInClassVSClassTotal(DeckClassPair dcp) {
        return getLossesInClassVSClass1st(dcp) + getLossesInClassVSClass2nd(dcp);
    }

    public double getLossPerAsClass1st(DeckClass dc) {
        if (getWinsAsClass1st(dc) + getLossesAsClass1st(dc) == 0) {
            return 0;
        }
        return 1 - getWinPerAsClass1st(dc);
    }

    public double getLossPerAsClass2nd(DeckClass dc) {
        if (getWinsAsClass2nd(dc) + getLossesAsClass2nd(dc) == 0) {
            return 0;
        }
        return 1 - getWinPerAsClass2nd(dc);
    }

    public double getLossPerVSClass1st(DeckClass dc) {
        if (getWinsVSClass1st(dc) + getLossesVSClass1st(dc) == 0) {
            return 0;
        }
        return 1 - getWinPerVSClass1st(dc);
    }

    public double getLossPerVSClass2nd(DeckClass dc) {
        if (getWinsVSClass2nd(dc) + getLossesVSClass2nd(dc) == 0) {
            return 0;
        }
        return 1 - getWinPerVSClass2nd(dc);
    }

    public double getLossPerInClassVSClass1st(DeckClassPair dcp) {
        if (getWinsInClassVSClass1st(dcp) + getLossesInClassVSClass1st(dcp) == 0) {
            return 0;
        }
        return 1 - getWinPerClassVSClass1st(dcp);
    }

    public double getLossPerInClassVSClass2nd(DeckClassPair dcp) {
        if (getWinsInClassVSClass2nd(dcp) + getLossesInClassVSClass2nd(dcp) == 0) {
            return 0;
        }
        return 1 - getWinPerClassVSClass2nd(dcp);
    }

    public double getWinPerAsClassTotal(DeckClass dc) {
        int matches = getMatchesAsClassTotal(dc);
        int wins = getWinsAsClassTotal(dc);
        int losses = getLossesAsClassTotal(dc);
        int disconnects = matches - wins - losses;
        return StatisticsHelper.getWinPercentage(matches, wins, losses, disconnects);
    }

    public double getWinPerVSClassTotal(DeckClass dc) {
        int matches = getMatchesVSClassTotal(dc);
        int wins = getWinsVSClassTotal(dc);
        int losses = getLossesVSClassTotal(dc);
        int disconnects = matches - wins - losses;
        return StatisticsHelper.getWinPercentage(matches, wins, losses, disconnects);
    }

    public double getWinPerInClassVSClassTotal(DeckClassPair dcp) {
        int matches = getMatchesInClassVSClassTotal(dcp);
        int wins = getWinsInClassVSClassTotal(dcp);
        int losses = getLossesInClassVSClassTotal(dcp);
        int disconnects = matches - wins - losses;
        double winPer = StatisticsHelper.getWinPercentage(matches, wins, losses, disconnects);
        return winPer;
    }

    public double getLossPerAsClassTotal(DeckClass dc) {
        if (getWinsAsClassTotal(dc) + getLossesAsClassTotal(dc) == 0) {
            return 0;
        }
        return 1 - getWinPerAsClassTotal(dc);
    }

    public double getLossPerVSClassTotal(DeckClass dc) {
        if (getWinsVSClassTotal(dc) + getLossesVSClassTotal(dc) == 0) {
            return 0;
        }
        return 1 - getWinPerVSClassTotal(dc);
    }

    public double getLossPerInClassVSClassTotal(DeckClassPair dcp) {
        if (getWinsInClassVSClassTotal(dcp) + getLossesInClassVSClassTotal(dcp) == 0) {
            return 0;
        }
        return 1 - getWinPerInClassVSClassTotal(dcp);
    }

    public int getTotalMatches() {
        int total = 0;
        for (DeckClass dc : DeckClass.getDeckClassList()) {
            total += getMatchesAsClassTotal(dc);
        }
        return total;
    }

    public int getTotalWins() {
        int total = 0;
        for (DeckClass dc : DeckClass.getDeckClassList()) {
            total += getWinsAsClassTotal(dc);
        }
        return total;
    }

    public int getTotalLosses() {
        int total = 0;
        for (DeckClass dc : DeckClass.getDeckClassList()) {
            total += getLossesAsClassTotal(dc);
        }
        return total;
    }

    public double getTotalWinPer() {
        int matches = getTotalMatches();
        int wins = getTotalWins();
        int losses = getTotalLosses();
        int disconnects = matches - wins - losses;
        return StatisticsHelper.getWinPercentage(matches, wins, losses, disconnects);
    }
    
    public double getTotalLossPer() {
        if (getTotalWins() + getTotalLosses() == 0) {
            return 0;
        }
        return 1 - getTotalWinPer();
    }
    
    public void reset() {
        this.statistics = new MatchStatistics();
    }
    
}
