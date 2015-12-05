package domain;

public class Match implements Comparable<Match> {

    private DeckClass playerClass;
    private final DeckClass opponentClass;
    private String opponentName;
    private final Outcome outcome;
    private final boolean wentFirst;
    private final int deckNumber;
    private int matchNumber;
    private Deck deck;
    
    public Match(DeckClass opponentClass, Outcome outcome, boolean wentFirst, 
            int deckNumber, int matchNumber) {
        this.opponentClass = opponentClass;
        this.outcome = outcome;
        this.wentFirst = wentFirst;
        this.deckNumber = deckNumber;
        this.matchNumber = matchNumber;
    }

    public Match(DeckClass opponentClass, String opponentName,
            Outcome outcome, boolean wentFirst, int deckNumber, int matchNumber) {
        this(opponentClass, outcome, wentFirst, deckNumber, matchNumber);
        this.opponentName = opponentName;
    }

    public Match(DeckClass playerClass, DeckClass opponentClass, String opponentName,
            Outcome outcome, boolean wentFirst, int deckNumber, int matchNumber) {
        this(opponentClass, opponentName, outcome, wentFirst, deckNumber, matchNumber);
        this.playerClass = playerClass;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getDeckNumber() {
        return deckNumber;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public DeckClass getOpponentClass() {
        return opponentClass;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public DeckClass getPlayerClass() {
        return playerClass;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public boolean wentFirst() {
        return wentFirst;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public void setPlayerClass(DeckClass playerClass) {
        this.playerClass = playerClass;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Match match = (Match) obj;

        if (this.deckNumber == match.getDeckNumber()
                && this.matchNumber == match.getMatchNumber()) {
            return true;
        }
        return false;
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
