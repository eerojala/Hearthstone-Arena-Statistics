
package domain;

public enum Outcome {
    WIN("Win"),
    LOSS("Loss"),
    DISCONNECT("Disconnect");
    
    private final String name;

    private Outcome(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public static Outcome parseOutcome(String text) {
        if (text.equals(Outcome.WIN.getName())) {
            return Outcome.WIN;
        } else if (text.equals(Outcome.LOSS.getName())) {
            return Outcome.LOSS;
        } else if (text.equals(Outcome.DISCONNECT.getName())) {
            return Outcome.DISCONNECT;
        }
        return null;
    }
}
