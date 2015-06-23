
package domain;


public enum DeckClass {
    DRUID("Druid"),
    HUNTER("Hunter"),
    MAGE("Mage"),
    PALADIN("Paladin"),
    PRIEST("Priest"),
    ROGUE("Rogue"),
    SHAMAN("Shaman"),
    WARLOCK("Warlock"), 
    WARRIOR("Warrior");
    
    private final String name;

    private DeckClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
