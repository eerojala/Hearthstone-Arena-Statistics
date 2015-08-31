package logic;

import domain.ClassStatistics;
import domain.DeckClass;
import domain.Match;
import domain.Outcome;
import util.Mapper;
import util.StatisticsHelper;

public class ClassStatisticsKeeper extends MatchStatisticsKeeper{

    private ClassStatistics statistics;

    public ClassStatisticsKeeper() {
        statistics = new ClassStatistics();
    }
    
    @Override
    protected void addMatchThatWent1st(Match match) {
        increaseIntegerIn1stMatchMaps(match);
        if (match.getOutcome() == Outcome.WIN) {
            addMatchThatWent1stAndWon(match);
        } else if (match.getOutcome() == Outcome.LOSS) {
            addMatchThatWent1stAndLost(match);
        }
        updateWinPercentageIn1stMatchMaps(match.getPlayerDeckClass(), match.getOpponentDeckClass());
    }

    private void increaseIntegerIn1stMatchMaps(Match match) {
        Mapper.increaseIntegerInDcIntMap(statistics.getMatchesAsClass1st(), match.getPlayerDeckClass());
        Mapper.increaseIntegerInDcIntMap(statistics.getMatchesVSClass1st(), match.getOpponentDeckClass());
    }

    private void addMatchThatWent1stAndWon(Match match) {
        Mapper.increaseIntegerInDcIntMap(statistics.getWinsAsClass1st(), match.getPlayerDeckClass());
        Mapper.increaseIntegerInDcIntMap(statistics.getWinsVSClass1st(), match.getOpponentDeckClass());
    }

    private void addMatchThatWent1stAndLost(Match match) {
        Mapper.increaseIntegerInDcIntMap(statistics.getLossesAsClass1st(), match.getPlayerDeckClass());
        Mapper.increaseIntegerInDcIntMap(statistics.getLossesVSClass1st(), match.getOpponentDeckClass());
    }
    
    public void updateWinPercentageIn1stMatchMaps(DeckClass playerClass, DeckClass opponentClass) {
        Mapper.updateWinPercentageInDcDoubleMap(statistics.getWinPerAsClass1st(),
                statistics.getMatchesAsClass1st(), statistics.getWinsAsClass1st(),
                statistics.getLossesAsClass1st(), playerClass);
        Mapper.updateWinPercentageInDcDoubleMap(statistics.getWinPerVSClass1st(),
                statistics.getMatchesVSClass1st(), statistics.getWinsVSClass1st(),
                statistics.getLossesVSClass1st(), opponentClass);
    }

    @Override
    protected void addMatchThatWent2nd(Match match) {
        addMatchTo2ndMatchMaps(match);
        if (match.getOutcome() == Outcome.WIN) {
            addMatchThatWent2ndAndWon(match);
        } else if (match.getOutcome() == Outcome.LOSS) {
            addMatchThatWent2ndAndLost(match);
        }
        updateWinPercentageIn2ndMatchMaps(match.getPlayerDeckClass(), match.getOpponentDeckClass());
    }

    private void addMatchTo2ndMatchMaps(Match match) {
        Mapper.increaseIntegerInDcIntMap(statistics.getMatchesAsClass2nd(), match.getPlayerDeckClass());
        Mapper.increaseIntegerInDcIntMap(statistics.getMatchesVSClass2nd(), match.getOpponentDeckClass());
    }

    private void addMatchThatWent2ndAndWon(Match match) {
        Mapper.increaseIntegerInDcIntMap(statistics.getWinsAsClass2nd(), match.getPlayerDeckClass());
        Mapper.increaseIntegerInDcIntMap(statistics.getWinsVSClass2nd(), match.getOpponentDeckClass());
    }

    private void addMatchThatWent2ndAndLost(Match match) {
        Mapper.increaseIntegerInDcIntMap(statistics.getLossesAsClass2nd(), match.getPlayerDeckClass());
        Mapper.increaseIntegerInDcIntMap(statistics.getLossesVSClass2nd(), match.getOpponentDeckClass());
    }

    public void updateWinPercentageIn2ndMatchMaps(DeckClass playerClass, DeckClass opponentClass) {
        Mapper.updateWinPercentageInDcDoubleMap(statistics.getWinPerAsClass2nd(), statistics.getMatchesAsClass2nd(),
                statistics.getWinsAsClass2nd(), statistics.getLossesAsClass2nd(), playerClass);
        Mapper.updateWinPercentageInDcDoubleMap(statistics.getWinPerVSClass2nd(), statistics.getMatchesVSClass2nd(),
                statistics.getWinsVSClass2nd(), statistics.getLossesVSClass2nd(), opponentClass);
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

    @Override
    protected void removeMatchThatWent1st(Match match) {
        removeMatchFrom1stMatchMaps(match);
        if (match.getOutcome() == Outcome.WIN) {
            removeMatchThatWent1stAndWon(match);
        } else if (match.getOutcome() == Outcome.LOSS) {
            removeMatchThatWent1stAndLost(match);
        }
        updateWinPercentageIn1stMatchMaps(match.getPlayerDeckClass(), match.getOpponentDeckClass());
    }

    private void removeMatchFrom1stMatchMaps(Match match) {
        Mapper.decreaseIntegerInDcIntMap(statistics.getMatchesAsClass1st(), match.getPlayerDeckClass());
        Mapper.decreaseIntegerInDcIntMap(statistics.getMatchesVSClass1st(), match.getOpponentDeckClass());
    }

    private void removeMatchThatWent1stAndWon(Match match) {
        Mapper.decreaseIntegerInDcIntMap(statistics.getWinsAsClass1st(), match.getPlayerDeckClass());
        Mapper.decreaseIntegerInDcIntMap(statistics.getWinsVSClass1st(), match.getOpponentDeckClass());
    }

    private void removeMatchThatWent1stAndLost(Match match) {
        Mapper.decreaseIntegerInDcIntMap(statistics.getLossesAsClass1st(), match.getPlayerDeckClass());
        Mapper.decreaseIntegerInDcIntMap(statistics.getLossesVSClass1st(), match.getOpponentDeckClass());
    }

    @Override
    protected void removeMatchThatWent2nd(Match match) {
        removeMatchFrom2ndMatchMaps(match);
        if (match.getOutcome() == Outcome.WIN) {
            removeMatchThatWent2ndAndWon(match);
        } else if (match.getOutcome() == Outcome.LOSS) {
            removeMatchThatWent2ndAndLost(match);
        }
        updateWinPercentageIn2ndMatchMaps(match.getPlayerDeckClass(), match.getOpponentDeckClass());
    }

    private void removeMatchFrom2ndMatchMaps(Match match) {
        Mapper.decreaseIntegerInDcIntMap(statistics.getMatchesAsClass2nd(), match.getPlayerDeckClass());
        Mapper.decreaseIntegerInDcIntMap(statistics.getMatchesVSClass2nd(), match.getOpponentDeckClass());
    }

    private void removeMatchThatWent2ndAndWon(Match match) {
        Mapper.decreaseIntegerInDcIntMap(statistics.getWinsAsClass2nd(), match.getPlayerDeckClass());
        Mapper.decreaseIntegerInDcIntMap(statistics.getWinsVSClass2nd(), match.getOpponentDeckClass());
    }

    private void removeMatchThatWent2ndAndLost(Match match) {
        Mapper.decreaseIntegerInDcIntMap(statistics.getLossesAsClass2nd(), match.getPlayerDeckClass());
        Mapper.decreaseIntegerInDcIntMap(statistics.getLossesVSClass2nd(), match.getOpponentDeckClass());
    }

    public ClassStatistics getStatistics() {
        return statistics;
    }

    public int getMatchesAsClassTotal(DeckClass dc) {
        return getMatchesAsClass1st(dc) + getMatchesAsClass2nd(dc);
    }

    public int getMatchesVSClassTotal(DeckClass dc) {
        return getMatchesVSClass1st(dc) + getMatchesVSClass2nd(dc);
    }

    public int getWinsAsClassTotal(DeckClass dc) {
        return getWinsAsClass1st(dc) + getWinsAsClass2nd(dc);
    }

    public int getWinsVSClassTotal(DeckClass dc) {
        return getWinsVSClass1st(dc) + getWinsVSClass2nd(dc);
    }

    public int getLossesAsClassTotal(DeckClass dc) {
        return getLossesAsClass1st(dc) + getLossesAsClass2nd(dc);
    }

    public int getLossesVSClassTotal(DeckClass dc) {
        return getLossesVSClass1st(dc) + getLossesVSClass2nd(dc);
    }


    public double getWinPerAsClassTotal(DeckClass dc) {
        int wins = getWinsAsClassTotal(dc);
        int losses = getLossesAsClassTotal(dc);
        int validMatches = wins + losses;
        return StatisticsHelper.getWinPercentage(validMatches, wins);
    }

    public double getWinPerVSClassTotal(DeckClass dc) {
        int wins = getWinsVSClassTotal(dc);
        int losses = getLossesVSClassTotal(dc);
        int validMatches = wins+ losses;
        return StatisticsHelper.getWinPercentage(validMatches, wins);
    }

    public int getTotalMatches() {
        int total = 0;
        for (DeckClass dc : DeckClass.values()) {
            total += getMatchesAsClassTotal(dc);
        }
        return total;
    }

    public int getTotalWins() {
        int total = 0;
        for (DeckClass dc : DeckClass.values()) {
            total += getWinsAsClassTotal(dc);
        }
        return total;
    }

    public int getTotalLosses() {
        int total = 0;
        for (DeckClass dc : DeckClass.values()) {
            total += getLossesAsClassTotal(dc);
        }
        return total;
    }

    public double getTotalWinPer() {;
        int wins = getTotalWins();
        int losses = getTotalLosses();
        int validMatches = wins + losses;
        return StatisticsHelper.getWinPercentage(validMatches, wins);
    }

    public void reset() {
        statistics = new ClassStatistics();
    }
}
