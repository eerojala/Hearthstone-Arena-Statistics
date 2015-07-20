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
        List<DeckClass> list = initClassList();
        for (DeckClass deckClass : list) {
            if (text.equals(deckClass.getName())) {
                return deckClass;
            }
        }
        return null;
    }

    private static List<DeckClass> initClassList() {
        List<DeckClass> classList = new ArrayList();
        classList.add(DeckClass.DRUID);
        classList.add(DeckClass.HUNTER);
        classList.add(DeckClass.MAGE);
        classList.add(DeckClass.PALADIN);
        classList.add(DeckClass.PRIEST);
        classList.add(DeckClass.ROGUE);
        classList.add(DeckClass.SHAMAN);
        classList.add(DeckClass.WARLOCK);
        classList.add(DeckClass.WARRIOR);
        return classList;
    }
}
