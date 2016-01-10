package util;

import domain.Deck;
import domain.DeckClass;
import domain.Matchup;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import xml.DeckParser;
import xml.DeckWriter;
import xml.XmlWriter;

public class TestHelperTest {

    private final Map<DeckClass, Integer> dcIntMap;
    private final Map<DeckClass, Map<Integer, Integer>> dcIntIntMapMap;
    private final Map<Matchup, Integer> dcpIntMap;
    private final Map<DeckClass, Double> dcDoubleMap;
    private final Map<Matchup, Double> dcpDoubleMap;
    private final Map<Integer, Integer> intIntMap;
    private final Map<Integer, Double> intDoubleMap;
    private final XmlWriter writer;
    private static final Matchup dcp1 = new Matchup(DeckClass.PALADIN, DeckClass.PRIEST);
    private static final Matchup dcp2 = new Matchup(DeckClass.ROGUE, DeckClass.HUNTER);
    private static final String filepath = "src/main/resources/xmltestfiles/DeckXmlTest.xml";

    public TestHelperTest() {
        dcIntMap = new HashMap();
        dcIntIntMapMap = new HashMap();
        dcpIntMap = new HashMap();
        dcDoubleMap = new HashMap();
        dcpDoubleMap = new HashMap();
        intIntMap = new HashMap();
        intDoubleMap = new HashMap();
        writer = new DeckWriter(filepath);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void zeroesInDcIntMap_returns_true_if_only_zeroes1() {
        Mapper.mapZeroesToDcIntMap(dcIntMap);
        assertTrue(TestHelper.zeroesInDcIntMap(dcIntMap));
    }

    @Test
    public void zeroesInDcIntMap_returns_true_if_only_zeroes2() {
        Mapper.mapZeroesToDcIntMap(dcIntMap);
        assertTrue(TestHelper.zeroesInDcIntMap(dcIntMap, DeckClass.WARRIOR));
    }

    @Test
    public void zeroesInDcIntMap_returns_true_if_only_zeroes_besides_exceptions() {
        Mapper.mapZeroesToDcIntMap(dcIntMap);
        dcIntMap.put(DeckClass.MAGE, 1);
        assertTrue(TestHelper.zeroesInDcIntMap(dcIntMap, DeckClass.MAGE));
    }

    @Test
    public void zeroesInDcIntMap_returns_false_if_not_all_are_zeroes1() {
        Mapper.mapZeroesToDcIntMap(dcIntMap);
        dcIntMap.put(DeckClass.MAGE, 3);
        assertFalse(TestHelper.zeroesInDcIntMap(dcIntMap));
    }

    @Test
    public void zeroesInDcIntMap_returns_false_if_not_all_zeroes2() {
        Mapper.mapZeroesToDcIntMap(dcIntMap);
        dcIntMap.put(DeckClass.MAGE, 1);
        assertFalse(TestHelper.zeroesInDcIntMap(dcIntMap, DeckClass.SHAMAN));
    }

    @Test
    public void zeroesInDcpIntMap_returns_true_if_only_zeroes1() {
        Mapper.mapZeroesToDcpIntMap(dcpIntMap);
        assertTrue(TestHelper.zeroesInDcpIntMap(dcpIntMap));
    }

    @Test
    public void zeroesInDcpIntMap_returns_true_if_only_zeroes2() {
        Mapper.mapZeroesToDcpIntMap(dcpIntMap);
        assertTrue(TestHelper.zeroesInDcpIntMap(dcpIntMap, dcp1));
    }

    @Test
    public void zeroesInDcpIntMap_returns_true_if_only_zeroes_besides_exceptions() {
        Mapper.mapZeroesToDcpIntMap(dcpIntMap);
        dcpIntMap.put(dcp1, 4);
        assertTrue(TestHelper.zeroesInDcpIntMap(dcpIntMap, dcp1));
    }

    @Test
    public void zeroesInDcpIntMap_returns_false_if_not_all_zeroes1() {
        Mapper.mapZeroesToDcpIntMap(dcpIntMap);
        dcpIntMap.put(dcp1, 1);
        assertFalse(TestHelper.zeroesInDcpIntMap(dcpIntMap));
    }

    @Test
    public void zeroesInDcpIntMap_returns_false_if_not_all_zeroes2() {
        Mapper.mapZeroesToDcpIntMap(dcpIntMap);
        dcpIntMap.put(dcp1, 6);
        assertFalse(TestHelper.zeroesInDcpIntMap(dcpIntMap, dcp2));
    }

    @Test
    public void zeroesInDcDoubleMap_returns_true_if_only_zeroes1() {
        Mapper.mapZeroesToDcDoubleMap(dcDoubleMap);
        assertTrue(TestHelper.zeroesInDcDoubleMap(dcDoubleMap));
    }

    @Test
    public void zeroesInDcDoubleMap_returns_true_if_only_zeroes2() {
        Mapper.mapZeroesToDcDoubleMap(dcDoubleMap);
        assertTrue(TestHelper.zeroesInDcDoubleMap(dcDoubleMap, DeckClass.HUNTER));
    }

    @Test
    public void zeroesInDcDoubleMap_returns_true_if_only_zeroes_besides_exceptions() {
        Mapper.mapZeroesToDcDoubleMap(dcDoubleMap);
        dcDoubleMap.put(DeckClass.MAGE, 4.0);
        dcDoubleMap.put(DeckClass.SHAMAN, 1.2);
        assertTrue(TestHelper.zeroesInDcDoubleMap(dcDoubleMap, DeckClass.MAGE, DeckClass.SHAMAN));
    }

    @Test
    public void zeroesInDcDoubleMap_returns_false_if_not_only_zeroes1() {
        Mapper.mapZeroesToDcDoubleMap(dcDoubleMap);
        dcDoubleMap.put(DeckClass.MAGE, 1.0);
        assertFalse(TestHelper.zeroesInDcDoubleMap(dcDoubleMap));
    }

    @Test
    public void zeroesInDcDoubleMap_returns_false_if_not_only_zeroes2() {
        Mapper.mapZeroesToDcDoubleMap(dcDoubleMap);
        dcDoubleMap.put(DeckClass.MAGE, 3.3);
        assertFalse(TestHelper.zeroesInDcDoubleMap(dcDoubleMap, DeckClass.HUNTER));
    }

    @Test
    public void zeroesInDcpDoubleMap_returns_true_if_only_zeroes1() {
        Mapper.mapZeroesToDcpDoubleMap(dcpDoubleMap);
        assertTrue(TestHelper.zeroesInDcpDoubleMap(dcpDoubleMap));
    }

    @Test
    public void zeroesInDcpDoubleMap_returns_true_if_only_zeroes2() {
        Mapper.mapZeroesToDcpDoubleMap(dcpDoubleMap);
        assertTrue(TestHelper.zeroesInDcpDoubleMap(dcpDoubleMap, dcp1, dcp2));
    }

    @Test
    public void zeroesInDcpDoubleMap_returns_true_if_only_zeroes_besides_exceptions() {
        Mapper.mapZeroesToDcpDoubleMap(dcpDoubleMap);
        dcpDoubleMap.put(dcp1, 1.111);
        dcpDoubleMap.put(dcp2, 111.111);
        assertTrue(TestHelper.zeroesInDcpDoubleMap(dcpDoubleMap, dcp1, dcp2));
    }

    @Test
    public void zeroesInDcpDoubleMap_returns_false_if_not_only_zeroes1() {
        Mapper.mapZeroesToDcpDoubleMap(dcpDoubleMap);
        dcpDoubleMap.put(dcp1, 2.2);
        assertFalse(TestHelper.zeroesInDcpDoubleMap(dcpDoubleMap));
    }

    @Test
    public void zeroesInDcpDoubleMap_returns_false_if_not_only_zeroes2() {
        Mapper.mapZeroesToDcpDoubleMap(dcpDoubleMap);
        dcpDoubleMap.put(dcp1, 1.111);
        dcpDoubleMap.put(dcp2, 44.44);
        assertFalse(TestHelper.zeroesInDcpDoubleMap(dcpDoubleMap, dcp1));
    }

    @Test
    public void zeroesInInIntMap_returns_true_if_only_zeroes1() {
        Mapper.mapZeroesToIntIntMap(intIntMap);
        assertTrue(TestHelper.zeroesInIntIntMap(intIntMap));
    }

    @Test
    public void zeroesInInIntMap_returns_true_if_only_zeroes2() {
        Mapper.mapZeroesToIntIntMap(intIntMap);
        assertTrue(TestHelper.zeroesInIntIntMap(intIntMap, 1));
    }

    @Test
    public void zeroesInInIntMap_returns_true_if_only_zeroes_besides_exceptions() {
        Mapper.mapZeroesToIntIntMap(intIntMap);
        intIntMap.put(4, 4);
        assertTrue(TestHelper.zeroesInIntIntMap(intIntMap, 4));
    }

    @Test
    public void zeroesInInIntMap_returns_false_if_not_all_zeroes1() {
        Mapper.mapZeroesToIntIntMap(intIntMap);
        intIntMap.put(0, 1);
        assertFalse(TestHelper.zeroesInIntIntMap(intIntMap));
    }

    @Test
    public void zeroesInInIntMap_returns_false_if_not_all_zeroes2() {
        Mapper.mapZeroesToIntIntMap(intIntMap);
        intIntMap.put(12, 3);
        assertFalse(TestHelper.zeroesInIntIntMap(intIntMap, 0));
    }

    @Test
    public void zeroesInIntDoubleMap_returns_true_if_only_zeroes1() {
        Mapper.mapZeroesToIntDoubleMap(intDoubleMap);
        assertTrue(TestHelper.zeroesInIntDoubleMap(intDoubleMap));
    }

    @Test
    public void zeroesInIntDoubleMap_returns_true_if_only_zeroes2() {
        Mapper.mapZeroesToIntDoubleMap(intDoubleMap);
        assertTrue(TestHelper.zeroesInIntDoubleMap(intDoubleMap, 6));
    }

    @Test
    public void zeroesInIntDoubleMap_returns_true_if_only_zeroes_besides_exceptions() {
        Mapper.mapZeroesToIntDoubleMap(intDoubleMap);
        intDoubleMap.put(3, 4.4);
        intDoubleMap.put(4, 3.3);
        assertTrue(TestHelper.zeroesInIntDoubleMap(intDoubleMap, 3, 4));
    }

    @Test
    public void zeroesInIntDoubleMap_returns_false_if_not_only_zeroes1() {
        Mapper.mapZeroesToIntDoubleMap(intDoubleMap);
        intDoubleMap.put(12, 3.1);
        assertFalse(TestHelper.zeroesInIntDoubleMap(intDoubleMap));
    }

    @Test
    public void zeroesInIntDoubleMap_returns_false_if_not_only_zeroes2() {
        Mapper.mapZeroesToIntDoubleMap(intDoubleMap);
        intDoubleMap.put(0, 3.11);
        intDoubleMap.put(3, 111.1111);
        assertFalse(TestHelper.zeroesInIntDoubleMap(intDoubleMap, 3));
    }

    @Test
    public void zeroesInDcIntIntMapMap_returns_true_if_only_zeroes() {
        Mapper.mapZeroesToDcIntIntMapMap(dcIntIntMapMap);
        assertTrue(TestHelper.zeroesInDcIntIntMapMap(dcIntIntMapMap));
    }

    @Test
    public void zeroesInDcIntIntMapMap_returns_false_if_not_only_zeroes() {
        Mapper.mapZeroesToDcIntIntMapMap(dcIntIntMapMap);
        Mapper.mapZeroesToIntIntMap(intIntMap);
        intIntMap.put(0, 1);
        dcIntIntMapMap.put(DeckClass.MAGE, intIntMap);
        assertFalse(TestHelper.zeroesInDcIntIntMapMap(dcIntIntMapMap));
    }

    @Test
    public void writeAndParseDeck_works_correctly() {
        Deck deck = new Deck(DeckClass.HUNTER, 3);
        Deck deck2 = TestHelper.writeAndParseDeck(writer, filepath, deck);
        writer.removeAll();
        assertEquals(deck, deck2);
    }
}
