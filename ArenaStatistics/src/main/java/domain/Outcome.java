
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
    
    
}
