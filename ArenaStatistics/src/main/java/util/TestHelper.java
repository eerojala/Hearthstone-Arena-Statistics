package util;

import domain.Deck;
import domain.DeckClass;
import domain.Matchup;
import java.util.Map;
import xml.DeckParser;
import xml.XmlParser;
import xml.XmlWriter;

/**
 * Class which provides useful methods for test classes.
 */
public class TestHelper {

    private static final DeckClass[] dcArray = DeckClass.values();

    /**
     * Checks if every DeckClass key has an Integer value of 0.
     *
     * @param map Map.
     * @param exceptions DeckClasses which are allowed to have a different value
     * than 0.
     * @return true if all the DeckClass keys besides the exceptions have 0 as
     * their value, otherwise false.
     */
    public static boolean zeroesInDcIntMap(Map<DeckClass, Integer> map, DeckClass... exceptions) {
        for (DeckClass dc : dcArray) {
            if (map.get(dc) != 0 && !objectIsAnException(dc, (Object[]) exceptions)) {
                return false;
            }
        }
        return true;
    }

    private static boolean objectIsAnException(Object o, Object... exceptions) {
        for (Object exception : exceptions) {
            if (o.equals(exception)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if every Matchup key has an Integer value of 0.
     *
     * @param map Map.
     * @param exceptions Matchups which are allowed to have a different value
     * than 0.
     * @return true if all the Matchup keys besides the exceptions have 0 as
     * their value, otherwise false.
     */
    public static boolean zeroesInMatchupIntMap(Map<Matchup, Integer> map, Matchup... exceptions) {
        for (DeckClass dc1 : dcArray) {
            for (DeckClass dc2 : dcArray) {
                Matchup dcp = new Matchup(dc1, dc2);
                if (map.get(dcp) != 0 && !objectIsAnException(dcp, (Object[]) exceptions)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if every DeckClass key has a Double value of 0.
     *
     * @param map Map.
     * @param exceptions DeckClasses which are allowed to have a different value
     * than 0.
     * @return true if all the DeckClass keys besides the exceptions have 0 as
     * their value, otherwise false.
     */
    public static boolean zeroesInDcDoubleMap(Map<DeckClass, Double> map, DeckClass... exceptions) {
        for (DeckClass dc : dcArray) {
            if (map.get(dc) != 0 && !objectIsAnException(dc, (Object[]) exceptions)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if every Matchup key has a Double value of 0.
     *
     * @param map Map.
     * @param exceptions Matchups which are allowed to have a different value
     * than 0.
     * @return true if all the Matchup keys besides the exceptions have 0 as
     * their value, otherwise false.
     */
    public static boolean zeroesInMatchupDoubleMap(Map<Matchup, Double> map, Matchup... exceptions) {
        for (DeckClass dc1 : dcArray) {
            for (DeckClass dc2 : dcArray) {
                Matchup dcp = new Matchup(dc1, dc2);
                if (map.get(dcp) != 0 && !objectIsAnException(dcp, (Object[]) exceptions)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the Integer keys 0-12 have an Integer value of 0.
     *
     * @param map Map.
     * @param exceptions Integers which are allowed to have a different value
     * than 0.
     * @return true if all the Integers 0-12 besides the exception have 0 as
     * their value, otherwise false.
     */
    public static boolean zeroesInIntIntMap(Map<Integer, Integer> map, int... exceptions) {
        for (int i = 0; i < 13; i++) {
            if (map.get(i) != 0 && !integerIsAnException(i, exceptions)) {
                return false;
            }
        }
        return true;
    }

    private static boolean integerIsAnException(int integer, int... exceptions) {
        for (Integer exception : exceptions) {
            if (integer == exception) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the Integer keys 0-12 have a Double value of 0.
     *
     * @param map Map.
     * @param exceptions Integers which are allowed to have a different value
     * than 0.
     * @return true if all the Integers 0-12 besides the exception have 0 as
     * their value, otherwise false.
     */
    public static boolean zeroesInIntDoubleMap(Map<Integer, Double> map, int... exceptions) {
        for (int i = 0; i < 13; i++) {
            if (map.get(i) != 0 && !integerIsAnException(i, exceptions)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the nested Map<Integer, Integer> has 0s as values for keys
     * 0-12.
     *
     * @param map Map
     * @return true if all of the Map<Integer, Integer> keys 0-12 values are 0,
     * false otherwise.
     */
    public static boolean zeroesInDcIntIntMapMap(Map<DeckClass, Map<Integer, Integer>> map) {
        for (DeckClass dc : DeckClass.values()) {
            if (!zeroesInIntIntMap(map.get(dc))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Writes a Deck into a Xml file and parses it's information to another Deck
     * Object.
     *
     * @param writer XmlWriter.
     * @param parseFilepath Filepath where the Deck is parsed from.
     * @param deck Deck which is written to the Xml file.
     * @return The parsed Deck.
     */
    public static Deck writeAndParseDeck(XmlWriter writer, String parseFilepath, Deck deck) {
        writer.writeContent(deck);
        XmlParser parser = new DeckParser(parseFilepath);
        parser.addValues();
        return (Deck) parser.getParsedObject();
    }
}
