package domain;

import java.util.List;
import util.DeckClassList;

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

    public static DeckClass parseDeckClass(String text) {
        List<DeckClass> list = DeckClassList.getDeckClassList();
        for (DeckClass deckClass : list) {
            if (text.equals(deckClass.getName())) {
                return deckClass;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
