package logic;

import domain.MatchupStatistics;
import domain.Matchup;
import domain.Match;
import domain.Outcome;
import util.Mapper;
import util.StatisticsHelper;

/**
 * Class which handles matchup-specific statistics.
 */
public class MatchupStatisticsKeeper extends MatchRelatedStatisticsKeeper {

    private MatchupStatistics statistics;

    /**
     * Creates a new MatchUpStatisticsKeeper Object.
     */
    public MatchupStatisticsKeeper() {
        statistics = new MatchupStatistics();
    }

    @Override
    protected void addMatchThatWent1st(Match match) {
        Matchup dcp = new Matchup(match.getPlayerClass(), match.getOpponentClass());
        Mapper.increaseIntegerInMatchupIntMap(statistics.getMatchesInMatchup1st(), dcp);
        if (match.getOutcome() == Outcome.WIN) {
            Mapper.increaseIntegerInMatchupIntMap(statistics.getWinsInMatchup1st(), dcp);
        } else if (match.getOutcome() == Outcome.LOSS) {
            Mapper.increaseIntegerInMatchupIntMap(statistics.getLossesInMatchup1st(), dcp);
        }
        updateWinRatio1st(dcp);
    }

    /**
     * Updates the win ratio of matches where there is a specific matchup and
     * the player went 1st.
     *
     * @param matchup Matchup
     */
    public void updateWinRatio1st(Matchup matchup) {
        Mapper.updateWinRatioInMatchupDoubleMap(statistics.getMatchupWinRatio1st(),
                statistics.getMatchesInMatchup1st(), statistics.getWinsInMatchup1st(),
                statistics.getLossesInMatchup1st(), matchup);
    }

    @Override
    protected void addMatchThatWent2nd(Match match) {
        Matchup dcp = new Matchup(match.getPlayerClass(), match.getOpponentClass());
        Mapper.increaseIntegerInMatchupIntMap(statistics.getMatchesInMatchup2nd(), dcp);
        if (match.getOutcome() == Outcome.WIN) {
            Mapper.increaseIntegerInMatchupIntMap(statistics.getWinsInMatchup2nd(), dcp);
        } else if (match.getOutcome() == Outcome.LOSS) {
            Mapper.increaseIntegerInMatchupIntMap(statistics.getLossesInMatchup2nd(), dcp);
        }
        updateWinRatio2nd(dcp);
    }

    /**
     * Updates the win ratio of matches where there is a specific matchup and
     * the player went 2nd.
     *
     * @param matchup Matchup
     */
    public void updateWinRatio2nd(Matchup matchup) {
        Mapper.updateWinRatioInMatchupDoubleMap(statistics.getMatchupWinRatio2nd(),
                statistics.getMatchesInMatchup2nd(), statistics.getWinsInMatchup2nd(),
                statistics.getLossesInMatchup2nd(), matchup);
    }

    /**
     * Sets the amount of matches where there was a specific matchup and the
     * user went 1st.
     *
     * @param matchup Matchup
     * @param matches Amount of matches.
     */
    public void setMatchesInMatchup1st(Matchup matchup, int matches) {
        statistics.getMatchesInMatchup1st().put(matchup, matches);
    }

    /**
     * Sets the amount of matches where there was a specific matchup and the
     * user went 2nd.
     *
     * @param matchup Matchup
     * @param matches Amount of matches.
     */
    public void setMatchesInMatchup2nd(Matchup matchup, int matches) {
        statistics.getMatchesInMatchup2nd().put(matchup, matches);
    }

    /**
     * Sets the amount of wins where there was a specific matchup and the user
     * went 1st.
     *
     * @param matchup Matchup
     * @param wins Amount of matches.
     */
    public void setWinsInMatchup1st(Matchup matchup, int wins) {
        statistics.getWinsInMatchup1st().put(matchup, wins);
    }

    /**
     * Sets the amount of wins where there was a specific matchup and the user
     * went 2nd.
     *
     * @param matchup Matchup
     * @param wins Amount of matches.
     */
    public void setWinsInMatchup2nd(Matchup matchup, int wins) {
        statistics.getWinsInMatchup2nd().put(matchup, wins);
    }

    /**
     * Sets the amount of losses where there was a specific matchup and the user
     * went 1st.
     *
     * @param matchup Matchup
     * @param losses Amount of matches.
     */
    public void setLossesInMatchup1st(Matchup matchup, int losses) {
        statistics.getLossesInMatchup1st().put(matchup, losses);
    }

    /**
     * Sets the amount of losses where there was a specific matchup and the user
     * went 2nd.
     *
     * @param matchup Matchup
     * @param losses Amount of matches.
     */
    public void setLossesInMatchup2nd(Matchup matchup, int losses) {
        statistics.getLossesInMatchup2nd().put(matchup, losses);
    }

    /**
     * Sets the win ratio of matches where there was a specific matchup and the
     * player went 1st.
     *
     * @param matchup Matchup
     * @param ratio Win ratio.
     */
    public void setMatchupWinRatio1st(Matchup matchup, double ratio) {
        statistics.getMatchupWinRatio1st().put(matchup, ratio);
    }

    /**
     * Sets the win ratio of matches where there was a specific matchup and the
     * player went 2nd.
     *
     * @param matchup Matchup
     * @param ratio Win ratio.
     */
    public void setMatchupWinRatio2nd(Matchup matchup, double ratio) {
        statistics.getMatchupWinRatio2nd().put(matchup, ratio);
    }

    /**
     * Returns the amount of matches where there was a specific matchup and the
     * player went 1st.
     *
     * @param matchup Matchup
     * @return Amount of matches.
     */
    public int getMatchesInMatchup1st(Matchup matchup) {
        return statistics.getMatchesInMatchup1st().get(matchup);
    }

    /**
     * Returns the amount of matches where there was a specific matchup and the
     * player went 2nd.
     *
     * @param matchup Matchup
     * @return Amount of matches.
     */
    public int getMatchesInMatchup2nd(Matchup matchup) {
        return statistics.getMatchesInMatchup2nd().get(matchup);
    }

    /**
     * Returns the amount of wins where there was a specific matchup and the
     * player went 1st.
     *
     * @param matchup Matchup
     * @return Amount of wins.
     */
    public int getWinsInMatchup1st(Matchup matchup) {
        return statistics.getWinsInMatchup1st().get(matchup);
    }

    /**
     * Returns the amount of wins where there was a specific matchup and the
     * player went 2nd.
     *
     * @param matchup Matchup
     * @return Amount of wins.
     */
    public int getWinsInMatchup2nd(Matchup matchup) {
        return statistics.getWinsInMatchup2nd().get(matchup);
    }

    /**
     * Returns the amount of losses where there was a specific matchup and the
     * player went 1st.
     *
     * @param matchup Matchup
     * @return Amount of losses.
     */
    public int getLossesInMatchup1st(Matchup matchup) {
        return statistics.getLossesInMatchup1st().get(matchup);
    }

    /**
     * Returns the amount of losses where there was a specific matchup and the
     * player went 2nd.
     *
     * @param matchup Matchup
     * @return Amount of losses.
     */
    public int getLossesInMatchup2nd(Matchup matchup) {
        return statistics.getLossesInMatchup2nd().get(matchup);
    }

    /**
     * Returns the win ratio of matches where there was a specific matchup and
     * the player went 1st. ¨
     *
     * @param matchup Matchup
     * @return Win ratio.
     */
    public double getMatchupWinRatio1st(Matchup matchup) {
        return statistics.getMatchupWinRatio1st().get(matchup);
    }

    /**
     * Returns the win ratio of matches where there was a specific matchup and
     * the player went 2nd. ¨
     *
     * @param matchup Matchup
     * @return Win ratio.
     */
    public double getMatchupWinRatio2nd(Matchup matchup) {
        return statistics.getMatchupWinRatio2nd().get(matchup);
    }

    @Override
    protected void removeMatchThatWent1st(Match match) {
        Matchup dcp = new Matchup(match.getPlayerClass(), match.getOpponentClass());
        Mapper.decreaseIntegerInMatchupIntMap(statistics.getMatchesInMatchup1st(), dcp);
        if (match.getOutcome() == Outcome.WIN) {
            Mapper.decreaseIntegerInMatchupIntMap(statistics.getWinsInMatchup1st(), dcp);
        } else if (match.getOutcome() == Outcome.LOSS) {
            Mapper.decreaseIntegerInMatchupIntMap(statistics.getLossesInMatchup1st(), dcp);
        }
        updateWinRatio1st(dcp);
    }

    @Override
    protected void removeMatchThatWent2nd(Match match) {
        Matchup dcp = new Matchup(match.getPlayerClass(), match.getOpponentClass());
        Mapper.decreaseIntegerInMatchupIntMap(statistics.getMatchesInMatchup2nd(), dcp);
        if (match.getOutcome() == Outcome.WIN) {
            Mapper.decreaseIntegerInMatchupIntMap(statistics.getWinsInMatchup2nd(), dcp);
        } else if (match.getOutcome() == Outcome.LOSS) {
            Mapper.decreaseIntegerInMatchupIntMap(statistics.getLossesInMatchup2nd(), dcp);
        }
        updateWinRatio2nd(dcp);
    }

    /**
     * Returns the MatchUpStatistics used by the MatchUpStatisticsKeeper.
     * 
     * @return MatchupStatistics
     */
    public MatchupStatistics getStatistics() {
        return statistics;
    }

    /**
     * Returns the total amount of matches in a specific matchup.
     * 
     * @param matchup
     * @return Amount of matches.
     */
    public int getMatchesInMatchupTotal(Matchup matchup) {
        return getMatchesInMatchup1st(matchup) + getMatchesInMatchup2nd(matchup);
    }

    /**
     * Returns the total amount of wins in a specific matchup.
     * 
     * @param matchup
     * @return Amount of wins.
     */
    public int getWinsInMatchupTotal(Matchup matchup) {
        return getWinsInMatchup1st(matchup) + getWinsInMatchup2nd(matchup);
    }

    /**
     * Returns the total amount of losses in a specific matchup.
     * 
     * @param matchup
     * @return Amount of losses.
     */
    public int getLossesInMatchupTotal(Matchup matchup) {
        return getLossesInMatchup1st(matchup) + getLossesInMatchup2nd(matchup);
    }

    /**
     * Returns the win ratio of a specific matchup.
     * 
     * @param matchup Matchup
     * @return Win ratio.
     */
    public double getWinRatioInMatchupTotal(Matchup matchup) {
        int wins = getWinsInMatchupTotal(matchup);
        int losses = getLossesInMatchupTotal(matchup);
        int validMatches = wins + losses;
        double winPer = StatisticsHelper.getWinRatio(validMatches, wins);
        return winPer;
    }

    /**
     * Resets the matchup statistics
     */
    public void reset() {
        statistics = new MatchupStatistics();
    }
}
