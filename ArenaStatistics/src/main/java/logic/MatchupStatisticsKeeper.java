package logic;

import domain.MatchupStatistics;
import domain.Matchup;
import domain.Match;
import domain.Outcome;
import util.Mapper;
import util.StatisticsHelper;

public class MatchupStatisticsKeeper extends MatchRelatedStatisticsKeeper {

    MatchupStatistics statistics;

    public MatchupStatisticsKeeper() {
        statistics = new MatchupStatistics();
    }

    @Override
    protected void addMatchThatWent1st(Match match) {
        Matchup dcp = new Matchup(match.getPlayerClass(), match.getOpponentClass());
        Mapper.increaseIntegerInDcpIntMap(statistics.getMatchesInClassVSClass1st(), dcp);
        if (match.getOutcome() == Outcome.WIN) {
            Mapper.increaseIntegerInDcpIntMap(statistics.getWinsInClassVSClass1st(), dcp);
        } else if (match.getOutcome() == Outcome.LOSS) {
            Mapper.increaseIntegerInDcpIntMap(statistics.getLossesInClassVSClass1st(), dcp);
        }
        updateWinPercentage1st(dcp);
    }

    public void updateWinPercentage1st(Matchup dcp) {
        Mapper.updateWinPercentageInDcpDoubleMap(statistics.getWinPerClassVSClass1st(),
                statistics.getMatchesInClassVSClass1st(), statistics.getWinsInClassVSClass1st(),
                statistics.getLossesInClassVSClass1st(), dcp);
    }

    @Override
    protected void addMatchThatWent2nd(Match match) {
        Matchup dcp = new Matchup(match.getPlayerClass(), match.getOpponentClass());
        Mapper.increaseIntegerInDcpIntMap(statistics.getMatchesInClassVSClass2nd(), dcp);
        if (match.getOutcome() == Outcome.WIN) {
            Mapper.increaseIntegerInDcpIntMap(statistics.getWinsInClassVSClass2nd(), dcp);
        } else if (match.getOutcome() == Outcome.LOSS) {
            Mapper.increaseIntegerInDcpIntMap(statistics.getLossesInClassVSClass2nd(), dcp);
        }
        updateWinPercentage2nd(dcp);
    }

    public void updateWinPercentage2nd(Matchup dcp) {
        Mapper.updateWinPercentageInDcpDoubleMap(statistics.getWinPerClassVSClass2nd(),
                statistics.getMatchesInClassVSClass2nd(), statistics.getWinsInClassVSClass2nd(),
                statistics.getLossesInClassVSClass2nd(), dcp);
    }

    public void setMatchesInClassVSClass1st(Matchup dcp, int matches) {
        statistics.getMatchesInClassVSClass1st().put(dcp, matches);
    }

    public void setMatchesInClassVSClass2nd(Matchup dcp, int matches) {
        statistics.getMatchesInClassVSClass2nd().put(dcp, matches);
    }

    public void setWinsInClassVSClass1st(Matchup dcp, int wins) {
        statistics.getWinsInClassVSClass1st().put(dcp, wins);
    }

    public void setWinsInClassVSClass2nd(Matchup dcp, int wins) {
        statistics.getWinsInClassVSClass2nd().put(dcp, wins);
    }

    public void setLossesInClassVSClass1st(Matchup dcp, int losses) {
        statistics.getLossesInClassVSClass1st().put(dcp, losses);
    }

    public void setLossesInClassVSClass2nd(Matchup dcp, int losses) {
        statistics.getLossesInClassVSClass2nd().put(dcp, losses);
    }

    public void setWinPerClassVSClass1st(Matchup dcp, double percentage) {
        statistics.getWinPerClassVSClass1st().put(dcp, percentage);
    }

    public void setWinPerClassVSClass2nd(Matchup dcp, double percentage) {
        statistics.getWinPerClassVSClass2nd().put(dcp, percentage);
    }

    public int getMatchesInClassVSClass1st(Matchup dcp) {
        return statistics.getMatchesInClassVSClass1st().get(dcp);
    }

    public int getMatchesInClassVSClass2nd(Matchup dcp) {
        return statistics.getMatchesInClassVSClass2nd().get(dcp);
    }

    public int getWinsInClassVSClass1st(Matchup dcp) {
        return statistics.getWinsInClassVSClass1st().get(dcp);
    }

    public int getWinsInClassVSClass2nd(Matchup dcp) {
        return statistics.getWinsInClassVSClass2nd().get(dcp);
    }

    public int getLossesInClassVSClass1st(Matchup dcp) {
        return statistics.getLossesInClassVSClass1st().get(dcp);
    }

    public int getLossesInClassVSClass2nd(Matchup dcp) {
        return statistics.getLossesInClassVSClass2nd().get(dcp);
    }

    public double getWinPerClassVSClass1st(Matchup dcp) {
        return statistics.getWinPerClassVSClass1st().get(dcp);
    }

    public double getWinPerClassVSClass2nd(Matchup dcp) {
        return statistics.getWinPerClassVSClass2nd().get(dcp);
    }

    @Override
    protected void removeMatchThatWent1st(Match match) {
        Matchup dcp = new Matchup(match.getPlayerClass(), match.getOpponentClass());
        Mapper.decreaseIntegerInDcpIntMap(statistics.getMatchesInClassVSClass1st(), dcp);
        if (match.getOutcome() == Outcome.WIN) {
            Mapper.decreaseIntegerInDcpIntMap(statistics.getWinsInClassVSClass1st(), dcp);
        } else if (match.getOutcome() == Outcome.LOSS) {
            Mapper.decreaseIntegerInDcpIntMap(statistics.getLossesInClassVSClass1st(), dcp);
        }
        updateWinPercentage1st(dcp);
    }

    @Override
    protected void removeMatchThatWent2nd(Match match) {
        Matchup dcp = new Matchup(match.getPlayerClass(), match.getOpponentClass());
        Mapper.decreaseIntegerInDcpIntMap(statistics.getMatchesInClassVSClass2nd(), dcp);
        if (match.getOutcome() == Outcome.WIN) {
            Mapper.decreaseIntegerInDcpIntMap(statistics.getWinsInClassVSClass2nd(), dcp);
        } else if (match.getOutcome() == Outcome.LOSS) {
            Mapper.decreaseIntegerInDcpIntMap(statistics.getLossesInClassVSClass2nd(), dcp);
        }
        updateWinPercentage2nd(dcp);
    }

    public MatchupStatistics getStatistics() {
        return statistics;
    }

    public int getMatchesInClassVSClassTotal(Matchup dcp) {
        return getMatchesInClassVSClass1st(dcp) + getMatchesInClassVSClass2nd(dcp);
    }

    public int getWinsInClassVSClassTotal(Matchup dcp) {
        return getWinsInClassVSClass1st(dcp) + getWinsInClassVSClass2nd(dcp);
    }

    public int getLossesInClassVSClassTotal(Matchup dcp) {
        return getLossesInClassVSClass1st(dcp) + getLossesInClassVSClass2nd(dcp);
    }

    public double getLossPerInClassVSClass1st(Matchup dcp) {
        if (getWinsInClassVSClass1st(dcp) + getLossesInClassVSClass1st(dcp) == 0) {
            return 0;
        }
        return 1 - getWinPerClassVSClass1st(dcp);
    }

    public double getLossPerInClassVSClass2nd(Matchup dcp) {
        if (getWinsInClassVSClass2nd(dcp) + getLossesInClassVSClass2nd(dcp) == 0) {
            return 0;
        }
        return 1 - getWinPerClassVSClass2nd(dcp);
    }

    public double getWinPerInClassVSClassTotal(Matchup dcp) {
        int wins = getWinsInClassVSClassTotal(dcp);
        int losses = getLossesInClassVSClassTotal(dcp);
        int validMatches = wins + losses;
        double winPer = StatisticsHelper.getWinPercentage(validMatches, wins);
        return winPer;
    }

    public double getLossPerInClassVSClassTotal(Matchup dcp) {
        if (getWinsInClassVSClassTotal(dcp) + getLossesInClassVSClassTotal(dcp) == 0) {
            return 0;
        }
        return 1 - getWinPerInClassVSClassTotal(dcp);
    }

    public void reset() {
        statistics = new MatchupStatistics();
    }
}
