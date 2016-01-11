package domain;

/**
 * Class which represents the match played during the arena run.
 */
public class Match implements Comparable<Match> {

    private DeckClass playerClass;
    private DeckClass opponentClass;
    private String opponentName;
    private Outcome outcome;
    private boolean wentFirst;
    private int deckNumber;
    private int matchNumber;
    private Deck deck;

    /**
     * Creates a new Match object.
     *
     * @param opponentClass Class of the opponent who the player played against
     * during the match.
     * @param outcome Outcome of the match.
     * @param wentFirst Boolean signifying if the player had the first turn or
     * not.
     * @param deckNumber Number identifying the deck which was used during the
     * match.
     * @param matchNumber Number identifying the match.
     */
    public Match(DeckClass opponentClass, Outcome outcome, boolean wentFirst,
            int deckNumber, int matchNumber) {
        this.opponentClass = opponentClass;
        this.outcome = outcome;
        this.wentFirst = wentFirst;
        this.deckNumber = deckNumber;
        this.matchNumber = matchNumber;
    }

    /**
     * Creates a new Match object.
     *
     * @param opponentClass Class of the opponent who the player played against
     * during the match.
     * @param opponentName Name of the opponent who the player played against
     * during the match.
     * @param outcome Outcome of the match.
     * @param wentFirst Boolean signifying if the player had the first turn or
     * not.
     * @param deckNumber Number identifying the deck which was used during the
     * match.
     * @param matchNumber Number identifying the match.
     */
    public Match(DeckClass opponentClass, String opponentName,
            Outcome outcome, boolean wentFirst, int deckNumber, int matchNumber) {
        this(opponentClass, outcome, wentFirst, deckNumber, matchNumber);
        this.opponentName = opponentName;
    }

    /**
     * Creates a new match object.
     *
     * @param playerClass Class of the deck which the player used during the
     * match.
     * @param opponentClass Class of the opponent who the player played against
     * during the match.
     * @param opponentName Name of the opponent who the player played against
     * during the match.
     * @param outcome Outcome of the match.
     * @param wentFirst Boolean signifying if the player had the first turn or
     * not.
     * @param deckNumber Number identifying the deck which was used during the
     * match.
     * @param matchNumber Number identifying the match.
     */
    public Match(DeckClass playerClass, DeckClass opponentClass, String opponentName,
            Outcome outcome, boolean wentFirst, int deckNumber, int matchNumber) {
        this(opponentClass, opponentName, outcome, wentFirst, deckNumber, matchNumber);
        this.playerClass = playerClass;
    }

    /**
     * Returns the deck which was used during the match.
     *
     * @return Deck which was used during the match.
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Returns the number of the deck which was used during the match.
     *
     * @return Number of the deck which was used during the match as int.
     */
    public int getDeckNumber() {
        return deckNumber;
    }

    /**
     * Returns the number identifying the match.
     *
     * @return Number identifying the match as int.
     */
    public int getMatchNumber() {
        return matchNumber;
    }

    /**
     * Returns the class of which the opponent used during the match.
     *
     * @return DeckClass which the opponent used during the match.
     */
    public DeckClass getOpponentClass() {
        return opponentClass;
    }

    /**
     * Returns the name of the opponent.
     *
     * @return Name of the opponent as String.
     */
    public String getOpponentName() {
        return opponentName;
    }

    /**
     * Returns the class which the player used during the match.
     *
     * @return DeckClass which the player used during the match.
     */
    public DeckClass getPlayerClass() {
        return playerClass;
    }

    /**
     * Returns the outcome of the match.
     *
     * @return Outcome of the match.
     */
    public Outcome getOutcome() {
        return outcome;
    }

    /**
     * Returns if the player had the first turn or not.
     *
     * @return true if the player went first, false if the player went second.
     */
    public boolean wentFirst() {
        return wentFirst;
    }

    /**
     * Sets the deck which was used during the match.
     *
     * @param deck Deck which was used during the match.
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * Sets the number identifying the match.
     *
     * @param matchNumber Number identifying the deck as int.
     */
    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    /**
     * Sets the class which the player used during the match.
     *
     * @param playerClass DeckClass which the player used during the match.
     */
    public void setPlayerClass(DeckClass playerClass) {
        this.playerClass = playerClass;
    }

    /**
     * Sets the boolean signifying if the player went first or not.
     *
     * @param wentFirst true if went first, false if went second.
     */
    public void setWentFirst(boolean wentFirst) {
        this.wentFirst = wentFirst;
    }

    /**
     * Sets the outcome of the match.
     *
     * @param outcome Outcome of the match.
     */
    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    /**
     * Sets the name of the opponent of the match.
     *
     * @param opponentName Name of the opponent as String.
     */
    public void setOpponentName(String opponentName) {
        this.opponentName = opponentName;
    }

    /**
     * Sets the class which the opponent used during the match.
     *
     * @param opponentClass DeckClass which the opponent used during the match.
     */
    public void setOpponentClass(DeckClass opponentClass) {
        this.opponentClass = opponentClass;
    }

    /**
     * Sets the number that identifies the deck which was used in the match.
     *
     * @param deckNumber Number identifying the deck as int.
     */
    public void setDeckNumber(int deckNumber) {
        this.deckNumber = deckNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Match match = (Match) obj;

        return this.deckNumber == match.getDeckNumber()
                && this.matchNumber == match.getMatchNumber()
                && this.playerClass == match.getPlayerClass()
                && this.opponentClass == match.getOpponentClass()
                && this.wentFirst == match.wentFirst
                && this.outcome == match.getOutcome();
    }

    @Override
    public int compareTo(Match o) {
        if (this.deckNumber == o.getDeckNumber()) {
            return this.matchNumber - o.getMatchNumber();
        }
        return this.deckNumber - o.getDeckNumber();
    }

    @Override
    public String toString() {
        return "Match #" + matchNumber + ": " + playerClass + " VS " + opponentClass;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
