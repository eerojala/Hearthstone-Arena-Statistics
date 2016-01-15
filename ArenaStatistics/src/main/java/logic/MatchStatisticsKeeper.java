package logic;

import domain.MatchStatistics;
import domain.DeckClass;
import domain.Match;
import domain.Outcome;
import util.Mapper;
import util.StatisticsHelper;

/**
 * Class which handles general match statistics.
 */
public class MatchStatisticsKeeper extends MatchRelatedStatisticsKeeper {

    private MatchStatistics statistics;

    /**
     * Creates a new MatchStatisticsKeeper Object.
     */
    public MatchStatisticsKeeper() {
        statistics = new MatchStatistics();
    }

    @Override
    protected void addMatchThatWent1st(Match match) {
        increaseIntegerIn1stMatchMaps(match);
        if (match.getOutcome() == Outcome.WIN) {
            addMatchThatWent1stAndWon(match);
        } else if (match.getOutcome() == Outcome.LOSS) {
            addMatchThatWent1stAndLost(match);
        }
        updateWinRatioIn1stMatchMaps(match.getPlayerClass(), match.getOpponentClass());
    }

    private void increaseIntegerIn1stMatchMaps(Match match) {
        Mapper.increaseIntegerInDcIntMap(statistics.getMatchesAsClass1st(), match.getPlayerClass());
        Mapper.increaseIntegerInDcIntMap(statistics.getMatchesVSClass1st(), match.getOpponentClass());
    }

    private void addMatchThatWent1stAndWon(Match match) {
        Mapper.increaseIntegerInDcIntMap(statistics.getWinsAsClass1st(), match.getPlayerClass());
        Mapper.increaseIntegerInDcIntMap(statistics.getWinsVSClass1st(), match.getOpponentClass());
    }

    private void addMatchThatWent1stAndLost(Match match) {
        Mapper.increaseIntegerInDcIntMap(statistics.getLossesAsClass1st(), match.getPlayerClass());
        Mapper.increaseIntegerInDcIntMap(statistics.getLossesVSClass1st(), match.getOpponentClass());
    }

    /**
     * Updates the values in HashMaps which store the win ratios of matches
     * where the player went 1st.
     *
     * @param playerClass The user's DeckClass.
     * @param opponentClass The opponent's DeckClass.
     */
    public void updateWinRatioIn1stMatchMaps(DeckClass playerClass, DeckClass opponentClass) {
        Mapper.updateWinRatioInDcDoubleMap(statistics.getWinRatioAsClass1st(),
                statistics.getMatchesAsClass1st(), statistics.getWinsAsClass1st(),
                statistics.getLossesAsClass1st(), playerClass);
        Mapper.updateWinRatioInDcDoubleMap(statistics.getWinRatioVSClass1st(),
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
        updateWinRatioIn2ndMatchMaps(match.getPlayerClass(), match.getOpponentClass());
    }

    private void addMatchTo2ndMatchMaps(Match match) {
        Mapper.increaseIntegerInDcIntMap(statistics.getMatchesAsClass2nd(), match.getPlayerClass());
        Mapper.increaseIntegerInDcIntMap(statistics.getMatchesVSClass2nd(), match.getOpponentClass());
    }

    private void addMatchThatWent2ndAndWon(Match match) {
        Mapper.increaseIntegerInDcIntMap(statistics.getWinsAsClass2nd(), match.getPlayerClass());
        Mapper.increaseIntegerInDcIntMap(statistics.getWinsVSClass2nd(), match.getOpponentClass());
    }

    private void addMatchThatWent2ndAndLost(Match match) {
        Mapper.increaseIntegerInDcIntMap(statistics.getLossesAsClass2nd(), match.getPlayerClass());
        Mapper.increaseIntegerInDcIntMap(statistics.getLossesVSClass2nd(), match.getOpponentClass());
    }

    /**
     * Updates the value in HashMaps which store the win ratios of matches where
     * the player went 2nd.
     *
     * @param playerClass The user's DeckClass.
     * @param opponentClass The opponent's DeckClass.
     */
    public void updateWinRatioIn2ndMatchMaps(DeckClass playerClass, DeckClass opponentClass) {
        Mapper.updateWinRatioInDcDoubleMap(statistics.getWinRatioAsClass2nd(), statistics.getMatchesAsClass2nd(),
                statistics.getWinsAsClass2nd(), statistics.getLossesAsClass2nd(), playerClass);
        Mapper.updateWinRatioInDcDoubleMap(statistics.getWinRatioVSClass2nd(), statistics.getMatchesVSClass2nd(),
                statistics.getWinsVSClass2nd(), statistics.getLossesVSClass2nd(), opponentClass);
    }

    /**
     * Sets the amount of matches against a specific class where the player went
     * 1st.
     *
     * @param deckClass Opponent's DeckClass.
     * @param matches Amount of matches.
     */
    public void setMatchesVSClass1st(DeckClass deckClass, int matches) {
        statistics.getMatchesVSClass1st().put(deckClass, matches);
    }

    /**
     * Sets the amount of matches against a specific class where the player went
     * 2nd.
     *
     * @param deckClass Opponent's DeckClass.
     * @param matches Amount of matches.
     */
    public void setMatchesVSClass2nd(DeckClass deckClass, int matches) {
        statistics.getMatchesVSClass2nd().put(deckClass, matches);
    }

    /**
     * Sets the amount of matches where the player played a specific class and
     * went 1st.
     *
     * @param deckClass Player's DeckClass.
     * @param matches Amount of matches.
     */
    public void setMatchesAsClass1st(DeckClass deckClass, int matches) {
        statistics.getMatchesAsClass1st().put(deckClass, matches);
    }

    /**
     * Sets the amount of matches where the player played a specific class and
     * went 2nd.
     *
     * @param deckClass Player's DeckClass.
     * @param matches Amount of matches.
     */
    public void setMatchesAsClass2nd(DeckClass deckClass, int matches) {
        statistics.getMatchesAsClass2nd().put(deckClass, matches);
    }

    /**
     * Sets the amount of wins where the player played a specific class and went
     * 1st.
     *
     * @param deckClass Player's DeckClass.
     * @param wins Amount of wins.
     */
    public void setWinsAsClass1st(DeckClass deckClass, int wins) {
        statistics.getWinsAsClass1st().put(deckClass, wins);
    }

    /**
     * Sets the amount of wins where the player played a specific class and went
     * 2nd.
     *
     * @param deckClass Player's DeckClass.
     * @param wins Amount of wins.
     */
    public void setWinsAsClass2nd(DeckClass deckClass, int wins) {
        statistics.getWinsAsClass2nd().put(deckClass, wins);
    }

    /**
     * Sets the amount of losses where the player played a specific class and
     * went 1st.
     *
     * @param deckClass Player's DeckClass.
     * @param losses Amount of losses.
     */
    public void setLossesAsClass1st(DeckClass deckClass, int losses) {
        statistics.getLossesAsClass1st().put(deckClass, losses);
    }

    /**
     * Sets the amount of losses where the player played a specific class and
     * went 2nd.
     *
     * @param deckClass Player's DeckClass.
     * @param losses Amount of losses.
     */
    public void setLossesAsClass2nd(DeckClass deckClass, int losses) {
        statistics.getLossesAsClass2nd().put(deckClass, losses);
    }

    /**
     * Sets the amount of wins against a specific class and the player went 1st.
     *
     * @param deckClass Opponent's DeckClass.
     * @param wins Amount of wins.
     */
    public void setWinsVSClass1st(DeckClass deckClass, int wins) {
        statistics.getWinsVSClass1st().put(deckClass, wins);
    }

    /**
     * Sets the amount of wins against a specific class and the player went 2nd.
     *
     * @param deckClass Opponent's DeckClass.
     * @param wins Amount of wins.
     */
    public void setWinsVSClass2nd(DeckClass deckClass, int wins) {
        statistics.getWinsVSClass2nd().put(deckClass, wins);
    }

    /**
     * Sets the amount of losses against a specific class and the player went
     * 1st.
     *
     * @param deckClass Opponent's DeckClass.
     * @param losses Amount of losses.
     */
    public void setLossesVSClass1st(DeckClass deckClass, int losses) {
        statistics.getLossesVSClass1st().put(deckClass, losses);
    }

    /**
     * Sets the amount of wins against a specific class and the player went 2nd.
     *
     * @param deckClass Opponent's DeckClass.
     * @param losses Amount of losses.
     */
    public void setLossesVSClass2nd(DeckClass deckClass, int losses) {
        statistics.getLossesVSClass2nd().put(deckClass, losses);
    }

    /**
     * Sets the win ratio of matches against a specific class where the user
     * went 1st.
     *
     * @param deckClass Opponent's DeckClass.
     * @param winRatio Win ratio.
     */
    public void setWinRatioVSClass1st(DeckClass deckClass, double winRatio) {
        statistics.getWinRatioVSClass1st().put(deckClass, winRatio);
    }

    /**
     * Sets the win ratio of matches against a specific class where the user
     * went 2nd.
     *
     * @param deckClass Opponent's DeckClass.
     * @param winRatio Win ratio.
     */
    public void setWinRatioVSClass2nd(DeckClass deckClass, double winRatio) {
        statistics.getWinRatioVSClass2nd().put(deckClass, winRatio);
    }

    /**
     * Sets the win ratio of matches where the user played a specific class and
     * went 1st.
     *
     * @param deckClass Opponent's DeckClass.
     * @param winRatio Win ratio.
     */
    public void setWinRatioAsClass1st(DeckClass deckClass, double winRatio) {
        statistics.getWinRatioAsClass1st().put(deckClass, winRatio);
    }

    /**
     * Sets the win ratio of matches where the user played a specific class and
     * went 2nd.
     *
     * @param deckClass Opponent's DeckClass.
     * @param winRatio Win ratio.
     */
    public void setWinRatioAsClass2nd(DeckClass deckClass, double winRatio) {
        statistics.getWinRatioAsClass2nd().put(deckClass, winRatio);
    }

    /**
     * Returns the amount of matches where the user went 1st against a specific
     * class.
     *
     * @param deckClass Opponent's DeckClass.
     * @return Amount of matches.
     */
    public int getMatchesVSClass1st(DeckClass deckClass) {
        return statistics.getMatchesVSClass1st().get(deckClass);
    }

    /**
     * Returns the amount of matches where the user went 2nd against a specific
     * class.
     *
     * @param deckClass Opponent's DeckClass.
     * @return Amount of matches.
     */
    public int getMatchesVSClass2nd(DeckClass deckClass) {
        return statistics.getMatchesVSClass2nd().get(deckClass);
    }

    /**
     * Returns the amount of matches where the user played a specific class and
     * went 1st.
     *
     * @param deckClass Player's DeckClass.
     * @return Amount of matches.
     */
    public int getMatchesAsClass1st(DeckClass deckClass) {
        return statistics.getMatchesAsClass1st().get(deckClass);
    }

    /**
     * Returns the amount of matches where the user played a specific class and
     * went 2nd.
     *
     * @param deckClass Player's DeckClass.
     * @return Amount of matches.
     */
    public int getMatchesAsClass2nd(DeckClass deckClass) {
        return statistics.getMatchesAsClass2nd().get(deckClass);
    }

    /**
     * Returns the amount of wins where the user played a specific class and
     * went 1st.
     *
     * @param deckClass Player's DeckClass.
     * @return Amount of wins.
     */
    public int getWinsAsClass1st(DeckClass deckClass) {
        return statistics.getWinsAsClass1st().get(deckClass);
    }

    /**
     * Returns the amount of wins where the user played a specific class and
     * went 2nd.
     *
     * @param deckClass Player's DeckClass.
     * @return Amount of wins.
     */
    public int getWinsAsClass2nd(DeckClass deckClass) {
        return statistics.getWinsAsClass2nd().get(deckClass);
    }

    /**
     * Returns the amount of losses where the user played a specific class and
     * went 1st.
     *
     * @param deckClass Player's DeckClass.
     * @return Amount of losses.
     */
    public int getLossesAsClass1st(DeckClass deckClass) {
        return statistics.getLossesAsClass1st().get(deckClass);
    }

    /**
     * Returns the amount of losses where the user played a specific class and
     * went 2nd.
     *
     * @param deckClass Player's DeckClass.
     * @return Amount of losses.
     */
    public int getLossesAsClass2nd(DeckClass deckClass) {
        return statistics.getLossesAsClass2nd().get(deckClass);
    }

    /**
     * Returns the amount of wins where the user went 1st against a specific
     * class
     *
     * @param deckClass Opponent's DeckClass.
     * @return Amount of wins.
     */
    public int getWinsVSClass1st(DeckClass deckClass) {
        return statistics.getWinsVSClass1st().get(deckClass);
    }

    /**
     * Returns the amount of wins where the user went 2nd against a specific
     * class
     *
     * @param deckClass Opponent's DeckClass.
     * @return Amount of wins.
     */
    public int getWinsVSClass2nd(DeckClass deckClass) {
        return statistics.getWinsVSClass2nd().get(deckClass);
    }

    /**
     * Returns the amount of losses where the user went 1st against a specific
     * class
     *
     * @param deckClass Opponent's DeckClass.
     * @return Amount of losses.
     */
    public int getLossesVSClass1st(DeckClass deckClass) {
        return statistics.getLossesVSClass1st().get(deckClass);
    }

    /**
     * Returns the amount of losses where the user went 2nd against a specific
     * class
     *
     * @param deckClass Opponent's DeckClass.
     * @return Amount of losses.
     */
    public int getLossesVSClass2nd(DeckClass deckClass) {
        return statistics.getLossesVSClass2nd().get(deckClass);
    }

    /**
     * Returns the win ratio of matches where the player went 1st against a
     * specific class.
     *
     * @param deckClass Opponent's DeckClass.
     * @return Win ratio.
     */
    public double getWinRatioVSClass1st(DeckClass deckClass) {
        return statistics.getWinRatioVSClass1st().get(deckClass);
    }

    /**
     * Returns the win ratio of matches where the player went 2nd against a
     * specific class.
     *
     * @param deckClass Opponent's DeckClass.
     * @return Win ratio.
     */
    public double getWinRatioVSClass2nd(DeckClass deckClass) {
        return statistics.getWinRatioVSClass2nd().get(deckClass);
    }

    /**
     * Returns the win ratio of matches where the player played as a specific
     * class and went 1st.
     *
     * @param deckClass Player's DeckClass.
     * @return Win ratio.
     */
    public double getWinRatioAsClass1st(DeckClass deckClass) {
        return statistics.getWinRatioAsClass1st().get(deckClass);
    }

    /**
     * Returns the win ratio of matches where the player played as a specific
     * class and went 2nd.
     *
     * @param deckClass Player's DeckClass.
     * @return Win ratio.
     */
    public double getWinPerAsClass2nd(DeckClass deckClass) {
        return statistics.getWinRatioAsClass2nd().get(deckClass);
    }

    @Override
    protected void removeMatchThatWent1st(Match match) {
        removeMatchFrom1stMatchMaps(match);
        if (match.getOutcome() == Outcome.WIN) {
            removeMatchThatWent1stAndWon(match);
        } else if (match.getOutcome() == Outcome.LOSS) {
            removeMatchThatWent1stAndLost(match);
        }
        updateWinRatioIn1stMatchMaps(match.getPlayerClass(), match.getOpponentClass());
    }

    private void removeMatchFrom1stMatchMaps(Match match) {
        Mapper.decreaseIntegerInDcIntMap(statistics.getMatchesAsClass1st(), match.getPlayerClass());
        Mapper.decreaseIntegerInDcIntMap(statistics.getMatchesVSClass1st(), match.getOpponentClass());
    }

    private void removeMatchThatWent1stAndWon(Match match) {
        Mapper.decreaseIntegerInDcIntMap(statistics.getWinsAsClass1st(), match.getPlayerClass());
        Mapper.decreaseIntegerInDcIntMap(statistics.getWinsVSClass1st(), match.getOpponentClass());
    }

    private void removeMatchThatWent1stAndLost(Match match) {
        Mapper.decreaseIntegerInDcIntMap(statistics.getLossesAsClass1st(), match.getPlayerClass());
        Mapper.decreaseIntegerInDcIntMap(statistics.getLossesVSClass1st(), match.getOpponentClass());
    }

    @Override
    protected void removeMatchThatWent2nd(Match match) {
        removeMatchFrom2ndMatchMaps(match);
        if (match.getOutcome() == Outcome.WIN) {
            removeMatchThatWent2ndAndWon(match);
        } else if (match.getOutcome() == Outcome.LOSS) {
            removeMatchThatWent2ndAndLost(match);
        }
        updateWinRatioIn2ndMatchMaps(match.getPlayerClass(), match.getOpponentClass());
    }

    private void removeMatchFrom2ndMatchMaps(Match match) {
        Mapper.decreaseIntegerInDcIntMap(statistics.getMatchesAsClass2nd(), match.getPlayerClass());
        Mapper.decreaseIntegerInDcIntMap(statistics.getMatchesVSClass2nd(), match.getOpponentClass());
    }

    private void removeMatchThatWent2ndAndWon(Match match) {
        Mapper.decreaseIntegerInDcIntMap(statistics.getWinsAsClass2nd(), match.getPlayerClass());
        Mapper.decreaseIntegerInDcIntMap(statistics.getWinsVSClass2nd(), match.getOpponentClass());
    }

    private void removeMatchThatWent2ndAndLost(Match match) {
        Mapper.decreaseIntegerInDcIntMap(statistics.getLossesAsClass2nd(), match.getPlayerClass());
        Mapper.decreaseIntegerInDcIntMap(statistics.getLossesVSClass2nd(), match.getOpponentClass());
    }

    /**
     * Returns the MatchStatistics used by the MatchStatisticsKeeper.
     *
     * @return MatchStatistics
     */
    public MatchStatistics getStatistics() {
        return statistics;
    }

    /**
     * Returns the total amount of matches where the player played as a specific
     * class.
     *
     * @param dc Player's DeckClass.
     * @return Amount of matches.
     */
    public int getMatchesAsClassTotal(DeckClass dc) {
        return getMatchesAsClass1st(dc) + getMatchesAsClass2nd(dc);
    }

    /**
     * Returns the total amount of matches where the player played against a
     * specific class.
     *
     * @param dc Opponent's DeckClass.
     * @return Amount of matches.
     */
    public int getMatchesVSClassTotal(DeckClass dc) {
        return getMatchesVSClass1st(dc) + getMatchesVSClass2nd(dc);
    }

    /**
     * Returns the total amount of wins where the player played as a specific
     * class.
     *
     * @param dc Player's DeckClass.
     * @return Amount of wins.
     */
    public int getWinsAsClassTotal(DeckClass dc) {
        return getWinsAsClass1st(dc) + getWinsAsClass2nd(dc);
    }

    /**
     * Returns the total amount of wins where the player played against a
     * specific class.
     *
     * @param dc Opponent's DeckClass.
     * @return Amount of wins.
     */
    public int getWinsVSClassTotal(DeckClass dc) {
        return getWinsVSClass1st(dc) + getWinsVSClass2nd(dc);
    }

    /**
     * Returns the total amount of losses where the player played as a specific
     * class.
     *
     * @param dc Player's DeckClass.
     * @return Amount of losses.
     */
    public int getLossesAsClassTotal(DeckClass dc) {
        return getLossesAsClass1st(dc) + getLossesAsClass2nd(dc);
    }

    /**
     * Returns the total amount of losses where the player played against a
     * specific class.
     *
     * @param dc Opponent's DeckClass.
     * @return Amount of losses.
     */
    public int getLossesVSClassTotal(DeckClass dc) {
        return getLossesVSClass1st(dc) + getLossesVSClass2nd(dc);
    }

    /**
     * Returns the win ratio of all the matches where the player played as a
     * specific class.
     *
     * @param dc Player's DeckClass.
     * @return Win ratio.
     */
    public double getWinRatioAsClassTotal(DeckClass dc) {
        int wins = getWinsAsClassTotal(dc);
        int losses = getLossesAsClassTotal(dc);
        int validMatches = wins + losses;
        return StatisticsHelper.getWinRatio(validMatches, wins);
    }

    /**
     * Returns the win ratio of all the matches where the player played against
     * a specific class.
     *
     * @param dc Opponent's DeckClass.
     * @return Win ratio.
     */
    public double getWinRatioVSClassTotal(DeckClass dc) {
        int wins = getWinsVSClassTotal(dc);
        int losses = getLossesVSClassTotal(dc);
        int validMatches = wins + losses;
        return StatisticsHelper.getWinRatio(validMatches, wins);
    }

    /**
     * Returns the total amount of matches played by the user.
     *
     * @return Amount of matches.
     */
    public int getTotalMatches() {
        int total = 0;
        for (DeckClass dc : DeckClass.values()) {
            total += getMatchesAsClassTotal(dc);
        }
        return total;
    }

    /**
     * Returns the total amount of wins.
     *
     * @return Amount of wins.
     */
    public int getTotalWins() {
        int total = 0;
        for (DeckClass dc : DeckClass.values()) {
            total += getWinsAsClassTotal(dc);
        }
        return total;
    }

    /**
     * Returns the total amount of losses
     *
     * @return Amount of losses.
     */
    public int getTotalLosses() {
        int total = 0;
        for (DeckClass dc : DeckClass.values()) {
            total += getLossesAsClassTotal(dc);
        }
        return total;
    }

    /**
     * Returns the player's total win ratio.
     *
     * @return Win ratio.
     */
    public double getTotalWinRatio() {;
        int wins = getTotalWins();
        int losses = getTotalLosses();
        int validMatches = wins + losses;
        return StatisticsHelper.getWinRatio(validMatches, wins);
    }

    /**
     * Resets the match statistics.
     */
    public void reset() {
        statistics = new MatchStatistics();
    }
}
