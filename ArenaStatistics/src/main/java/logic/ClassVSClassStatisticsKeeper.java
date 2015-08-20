package logic;

import domain.ClassVsClassStatistics;
import domain.DeckClassPair;
import domain.Match;
import domain.Outcome;
import util.Mapper;
import util.StatisticsHelper;

public class ClassVSClassStatisticsKeeper extends MatchStatisticsKeeper {

    ClassVsClassStatistics statistics;

    public ClassVSClassStatisticsKeeper() {
        statistics = new ClassVsClassStatistics();
    }

    @Override
    protected void addMatchThatWent1st(Match match) {
        DeckClassPair dcp = new DeckClassPair(match.getPlayerDeckClass(), match.getOpponentDeckClass());
        Mapper.increaseIntegerInDeckClassPairIntegerMap(statistics.getMatchesInClassVSClass1st(), dcp);
        if (match.getOutcome() == Outcome.WIN) {
            Mapper.increaseIntegerInDeckClassPairIntegerMap(statistics.getWinsInClassVSClass1st(), dcp);
        } else if (match.getOutcome() == Outcome.LOSS) {
            Mapper.increaseIntegerInDeckClassPairIntegerMap(statistics.getLossesInClassVSClass1st(), dcp);
        }
        updateWinPercentage1st(dcp);
    }

    public void updateWinPercentage1st(DeckClassPair dcp) {
        Mapper.updateWinPercentageInDeckClassPairDoubleMap(statistics.getWinPerClassVSClass1st(),
                statistics.getMatchesInClassVSClass1st(), statistics.getWinsInClassVSClass1st(),
                statistics.getLossesInClassVSClass1st(), dcp);
    }

    @Override
    protected void addMatchThatWent2nd(Match match) {
        DeckClassPair dcp = new DeckClassPair(match.getPlayerDeckClass(), match.getOpponentDeckClass());
        Mapper.increaseIntegerInDeckClassPairIntegerMap(statistics.getMatchesInClassVSClass2nd(), dcp);
        if (match.getOutcome() == Outcome.WIN) {
            Mapper.increaseIntegerInDeckClassPairIntegerMap(statistics.getWinsInClassVSClass2nd(), dcp);
        } else if (match.getOutcome() == Outcome.LOSS) {
            Mapper.increaseIntegerInDeckClassPairIntegerMap(statistics.getLossesInClassVSClass2nd(), dcp);
        }
        updateWinPercentage2nd(dcp);
    }

    public void updateWinPercentage2nd(DeckClassPair dcp) {
        Mapper.updateWinPercentageInDeckClassPairDoubleMap(statistics.getWinPerClassVSClass2nd(),
                statistics.getMatchesInClassVSClass2nd(), statistics.getWinsInClassVSClass2nd(),
                statistics.getLossesInClassVSClass2nd(), dcp);
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

    public void setWinPerClassVSClass1st(DeckClassPair dcp, double percentage) {
        statistics.getWinPerClassVSClass1st().put(dcp, percentage);
    }

    public void setWinPerClassVSClass2nd(DeckClassPair dcp, double percentage) {
        statistics.getWinPerClassVSClass2nd().put(dcp, percentage);
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

    public double getWinPerClassVSClass1st(DeckClassPair dcp) {
        return statistics.getWinPerClassVSClass1st().get(dcp);
    }

    public double getWinPerClassVSClass2nd(DeckClassPair dcp) {
        return statistics.getWinPerClassVSClass2nd().get(dcp);
    }

    @Override
    protected void removeMatchThatWent1st(Match match) {
        DeckClassPair dcp = new DeckClassPair(match.getPlayerDeckClass(), match.getOpponentDeckClass());
        Mapper.decreaseIntegerInDeckClassPairIntegerMap(statistics.getMatchesInClassVSClass1st(), dcp);
        if (match.getOutcome() == Outcome.WIN) {
            Mapper.decreaseIntegerInDeckClassPairIntegerMap(statistics.getWinsInClassVSClass1st(), dcp);
        } else if (match.getOutcome() == Outcome.LOSS) {
            Mapper.decreaseIntegerInDeckClassPairIntegerMap(statistics.getLossesInClassVSClass1st(), dcp);
        }
        updateWinPercentage1st(dcp);
    }

    @Override
    protected void removeMatchThatWent2nd(Match match) {
        DeckClassPair dcp = new DeckClassPair(match.getPlayerDeckClass(), match.getOpponentDeckClass());
        Mapper.decreaseIntegerInDeckClassPairIntegerMap(statistics.getMatchesInClassVSClass2nd(), dcp);
        if (match.getOutcome() == Outcome.WIN) {
            Mapper.decreaseIntegerInDeckClassPairIntegerMap(statistics.getWinsInClassVSClass2nd(), dcp);
        } else if (match.getOutcome() == Outcome.LOSS) {
            Mapper.decreaseIntegerInDeckClassPairIntegerMap(statistics.getLossesInClassVSClass2nd(), dcp);
        }
        updateWinPercentage2nd(dcp);
    }

    public ClassVsClassStatistics getStatistics() {
        return statistics;
    }

    public int getMatchesInClassVSClassTotal(DeckClassPair dcp) {
        return getMatchesInClassVSClass1st(dcp) + getMatchesInClassVSClass2nd(dcp);
    }

    public int getWinsInClassVSClassTotal(DeckClassPair dcp) {
        return getWinsInClassVSClass1st(dcp) + getWinsInClassVSClass2nd(dcp);
    }

    public int getLossesInClassVSClassTotal(DeckClassPair dcp) {
        return getLossesInClassVSClass1st(dcp) + getLossesInClassVSClass2nd(dcp);
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

    public double getWinPerInClassVSClassTotal(DeckClassPair dcp) {
        int wins = getWinsInClassVSClassTotal(dcp);
        int losses = getLossesInClassVSClassTotal(dcp);
        int validMatches = wins + losses;
        double winPer = StatisticsHelper.getWinPercentage(validMatches, wins);
        return winPer;
    }

    public double getLossPerInClassVSClassTotal(DeckClassPair dcp) {
        if (getWinsInClassVSClassTotal(dcp) + getLossesInClassVSClassTotal(dcp) == 0) {
            return 0;
        }
        return 1 - getWinPerInClassVSClassTotal(dcp);
    }

    public void reset() {
        this.statistics = new ClassVsClassStatistics();
    }
}
