package domain;

import java.util.ArrayList;
import java.util.List;

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
        List<DeckClass> list = getDeckClassList();
        for (DeckClass deckClass : list) {
            if (text.equals(deckClass.getName())) {
                return deckClass;
            }
        }
        return null;
    }
    
    public static List<DeckClass> getDeckClassList() {
        List<DeckClass> list = new ArrayList();
        list.add(DeckClass.DRUID);
        list.add(DeckClass.HUNTER);
        list.add(DeckClass.MAGE);
        list.add(DeckClass.PALADIN);
        list.add(DeckClass.PRIEST);
        list.add(DeckClass.ROGUE);
        list.add(DeckClass.SHAMAN);
        list.add(DeckClass.WARLOCK);
        list.add(DeckClass.WARRIOR);
        return list;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
