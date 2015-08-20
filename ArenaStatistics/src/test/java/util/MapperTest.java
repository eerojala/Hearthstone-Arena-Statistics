package util;

import domain.DeckClass;
import domain.DeckClassPair;
import domain.Match;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MapperTest {

    Map<DeckClass, Integer> dcIntMap;
    Map<DeckClassPair, Integer> dcpIntMap;
    Map<DeckClass, Double> dcDoubleMap;
    Map<DeckClassPair, Double> dcpDoubleMap;
    Map<Integer, Integer> intIntMap;
    Map<Integer, Double> intDoubleMap;
    DeckClassPair dcp;
    Map<DeckClass, Integer> dcIntMatchMap;
    Map<DeckClass, Integer> dcIntWinMap;
    Map<DeckClass, Integer> dcIntLossMap;
    Map<DeckClassPair, Integer> dcpIntMatchMap;
    Map<DeckClassPair, Integer> dcpIntWinMap;
    Map<DeckClassPair, Integer> dcpIntLossMap;

    public MapperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dcIntMap = new HashMap();
        dcpIntMap = new HashMap();
        dcDoubleMap = new HashMap();
        dcpDoubleMap = new HashMap();
        intIntMap = new HashMap();
        intDoubleMap = new HashMap();
        dcp = new DeckClassPair(DeckClass.ROGUE, DeckClass.WARRIOR);
        dcIntMatchMap = new HashMap();
        dcIntWinMap = new HashMap();
        dcIntLossMap = new HashMap();
        dcpIntMatchMap = new HashMap();
        dcpIntWinMap = new HashMap();
        dcpIntLossMap = new HashMap();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void mapZeroesToADeckClassIntegerMap_has_correct_keyset_size() {
        Mapper.mapZeroesToADeckClassIntegerMap(dcIntMap);
        assertEquals(9, dcIntMap.keySet().size());
    }

    @Test
    public void mapZeroesToADeckClassIntegerMap_values_are_zeroes() {
        Mapper.mapZeroesToADeckClassIntegerMap(dcIntMap);
        assertTrue(TestForLoop.zeroesInDcIntMap(dcIntMap));
    }

    @Test
    public void mapZeroesToADeckClassPairIntegerMap_has_correct_keyset_size() {
        Mapper.mapZeroesToADeckClassPairIntegerMap(dcpIntMap);
        assertEquals(81, dcpIntMap.keySet().size());
    }

    @Test
    public void mapZeroesToADeckClassPairIntegerMap_maps_zeroes_to_values() {
        Mapper.mapZeroesToADeckClassPairIntegerMap(dcpIntMap);
        assertTrue(TestForLoop.zeroesInDcpIntMap(dcpIntMap));
    }

    @Test
    public void mapZeroesToADeckClassDoubleMap_has_correct_keyset_size() {
        Mapper.mapZeroesToADeckClassDoubleMap(dcDoubleMap);
        assertEquals(9, dcDoubleMap.keySet().size());
    }

    @Test
    public void mapZeroesToADeckClassDoubleMap_maps_zeroes_to_values() {
        Mapper.mapZeroesToADeckClassDoubleMap(dcDoubleMap);
        assertTrue(TestForLoop.zeroesInDcDoubleMap(dcDoubleMap));
    }

    @Test
    public void mapZeroesToADeckClassPairDoubleMap_has_correct_keyset_size() {
        Mapper.mapZeroesToADeckClassPairDoubleMap(dcpDoubleMap);
        assertEquals(81, dcpDoubleMap.keySet().size());
    }

    @Test
    public void mapZeroesToADeckClassPairDoubleMap_maps_zeroes_to_values() {
        Mapper.mapZeroesToADeckClassPairDoubleMap(dcpDoubleMap);
        assertTrue(TestForLoop.zeroesInDcpDoubleMap(dcpDoubleMap));
    }

    @Test
    public void mapZeroesToIntegerIntegerMap_has_correct_keyset_size() {
        Mapper.mapZeroesToIntegerIntegerMap(intIntMap);
        assertEquals(13, intIntMap.keySet().size());
    }

    @Test
    public void mapZeroesToIntegerIntegerMap_maps_zeroes_to_values() {
        Mapper.mapZeroesToIntegerIntegerMap(intIntMap);
        assertTrue(TestForLoop.zeroesInIntIntMap(intIntMap));
    }

    @Test
    public void mapZeroesToIntegerDoubleMap_has_correct_keyset_size() {
        Mapper.mapZeroesToIntegerDoubleMap(intDoubleMap);
        assertEquals(13, intDoubleMap.keySet().size());
    }

    @Test
    public void mapZeroesToIntegerDoubleMap_maps_zeroes_to_values() {
        Mapper.mapZeroesToIntegerDoubleMap(intDoubleMap);
        assertTrue(TestForLoop.zeroesInIntDoubleMap(intDoubleMap));
    }

    @Test
    public void increaseIntegerInDeckClassIntegerMap_increases_value_by_one() {
        dcIntMap.put(DeckClass.MAGE, 2);
        Mapper.increaseIntegerInDeckClassIntegerMap(dcIntMap, DeckClass.MAGE);
        assertEquals(3, (int) dcIntMap.get(DeckClass.MAGE));
    }

    @Test
    public void increaseIntegerInDeckClassIntegerMap_increases_value_by_x_amount() {
        dcIntMap.put(DeckClass.MAGE, 4);
        Mapper.increaseIntegerInDeckClassIntegerMap(dcIntMap, DeckClass.MAGE, 5);
        assertEquals(9, (int) dcIntMap.get(DeckClass.MAGE));
    }

    @Test
    public void increaseIntegerInDeckClassPairIntegerMap_increases_value_by_one() {
        dcpIntMap.put(dcp, 1);
        Mapper.increaseIntegerInDeckClassPairIntegerMap(dcpIntMap, dcp);
        assertEquals(2, (int) dcpIntMap.get(dcp));
    }

    @Test
    public void updateWinPercentageInDeckClassDoubleMap_works_correctly() {
        dcIntMatchMap.put(DeckClass.MAGE, 2);
        dcIntWinMap.put(DeckClass.MAGE, 1);
        dcIntLossMap.put(DeckClass.MAGE, 1);
        Mapper.updateWinPercentageInDeckClassDoubleMap(dcDoubleMap, dcIntMatchMap,
                dcIntWinMap, dcIntLossMap, DeckClass.MAGE);
        assertEquals(0.5, dcDoubleMap.get(DeckClass.MAGE), 0);
    }

    @Test
    public void updateWinPercentageInDeckClassPairDoubleMap_works_correctly() {
        dcpIntMatchMap.put(dcp, 5);
        dcpIntWinMap.put(dcp, 3);
        dcpIntLossMap.put(dcp, 2);
        Mapper.updateWinPercentageInDeckClassPairDoubleMap(dcpDoubleMap, dcpIntMatchMap,
                dcpIntWinMap, dcpIntLossMap, dcp);
        assertEquals(0.6, dcpDoubleMap.get(dcp), 0);
    }

    @Test
    public void decreaseIntegerInDeckClassIntegerMap_decreases_integer_by_one() {
        dcIntMap.put(DeckClass.MAGE, 2);
        Mapper.decreaseIntegerInDeckClassIntegerMap(dcIntMap, DeckClass.MAGE);
        assertEquals(1, (int) dcIntMap.get(DeckClass.MAGE));
    }

    @Test
    public void decreaseIntegerInDeckClassIntegerMap_decreases_integer_by_x() {
        dcIntMap.put(DeckClass.MAGE, 4);
        Mapper.decreaseIntegerInDeckClassIntegerMap(dcIntMap, DeckClass.MAGE, 4);
        assertEquals(0, (int) dcIntMap.get(DeckClass.MAGE));
    }

    @Test
    public void decreaseIntegerInDeckClassIntegerMap_does_not_decrease_integer_below_zero() {
        dcIntMap.put(DeckClass.MAGE, 3);
        Mapper.decreaseIntegerInDeckClassIntegerMap(dcIntMap, DeckClass.MAGE, 4);
        assertEquals(0, (int) dcIntMap.get(DeckClass.MAGE));
    }
    
    @Test
    public void decreaseIntegerInDeckClassPairIntegerMap_decreases_integer_by_one() {
        dcpIntMap.put(dcp, 5);
        Mapper.decreaseIntegerInDeckClassPairIntegerMap(dcpIntMap, dcp);
        assertEquals(4, (int) dcpIntMap.get(dcp));
    }
    
    @Test
    public void decreaseIntegerInDeckClassPairIntegerMap_does_not_decrease_integer_below_zero() {
        dcpIntMap.put(dcp, 0);
        Mapper.decreaseIntegerInDeckClassPairIntegerMap(dcpIntMap, dcp);
        assertEquals(0, (int) dcpIntMap.get(dcp));
    }

    @Test
    public void increaseIntegerInIntegerIntegerMap_increases_integer_by_one() {
        intIntMap.put(0, 0);
        Mapper.increaseIntegerInIntegerIntegerMap(intIntMap, 0);
        assertEquals(1, (int) intIntMap.get(0));
    }

    @Test
    public void increaseIntegerInIntegerIntegerMap_increases_integer_by_x_amount() {
        intIntMap.put(3, 3);
        Mapper.increaseIntegerInIntegerIntegerMap(intIntMap, 3, 6);
        assertEquals(9, (int) intIntMap.get(3));
    }

    @Test
    public void updateAverageInDeckClassDoubleMap_works_correctly() {
        Mapper.updateAverageInDeckClassDoubleMap(dcDoubleMap, DeckClass.MAGE, 3, 5);
        assertEquals(0.6, dcDoubleMap.get(DeckClass.MAGE), 0);
    }

    @Test
    public void updateAverageInIntegerDoubleMap_works_correctly() {
        Mapper.updateAverageInIntegerDoubleMap(intDoubleMap, 4, 4, 10);
        assertEquals(0.4, intDoubleMap.get(4), 0);
    }

    @Test
    public void decreaseIntegerInIntegerIntegerMap_decreases_integer_by_one() {
        intIntMap.put(7, 7);
        Mapper.decreaseIntegerInIntegerIntegerMap(intIntMap, 7);
        assertEquals(6, (int) intIntMap.get(7));
    }
    
    @Test
    public void decreaseIntegerInIntegerIntegerMap_decreases_integer_by_x_amount() {
        intIntMap.put(1, 4);
        Mapper.decreaseIntegerInIntegerIntegerMap(intIntMap, 1, 2);
        assertEquals(2, (int) intIntMap.get(1));
    }
    
    @Test
    public void decreaseIntegerInIntegerIntegerMap_doesnt_decrease_integer_below_zero() {
        intIntMap.put(5, 100);
        Mapper.decreaseIntegerInIntegerIntegerMap(intIntMap, 5, 101);
        assertEquals(0, (int) intIntMap.get(5));
    }
}
