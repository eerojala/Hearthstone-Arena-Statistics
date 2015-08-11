package domain;

public class Match implements Comparable<Match> {

    private DeckClass playerDeckClass;
    private final DeckClass opponentDeckClass;
    private final String opponentName;
    private final Outcome outcome;
    private final boolean wentFirst;
    private final int deckNumber;
    private final int matchNumber;
    private Deck deck;

    public Match(DeckClass opponentClass, String opponentName,
            Outcome outcome, boolean wentFirst, int deckNumber, int matchNumber) {
        this.opponentDeckClass = opponentClass;
        this.opponentName = opponentName;
        this.outcome = outcome;
        this.wentFirst = wentFirst;
        this.deckNumber = deckNumber;
        this.matchNumber = matchNumber;
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

    public DeckClass getOpponentDeckClass() {
        return opponentDeckClass;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public DeckClass getPlayerDeckClass() {
        return playerDeckClass;
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

    public void setPlayerDeckClass(DeckClass playerDeckClass) {
        this.playerDeckClass = playerDeckClass;
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
        return "Deck#: " + this.deckNumber + ", Match#: " + this.matchNumber;
    }

    
}
