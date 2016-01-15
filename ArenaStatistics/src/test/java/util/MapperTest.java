package util;

import domain.DeckClass;
import domain.Matchup;
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
    Map<Matchup, Integer> dcpIntMap;
    Map<DeckClass, Double> dcDoubleMap;
    Map<Matchup, Double> dcpDoubleMap;
    Map<Integer, Integer> intIntMap;
    Map<Integer, Double> intDoubleMap;
    Matchup dcp;
    Map<DeckClass, Integer> dcIntMatchMap;
    Map<DeckClass, Integer> dcIntWinMap;
    Map<DeckClass, Integer> dcIntLossMap;
    Map<Matchup, Integer> dcpIntMatchMap;
    Map<Matchup, Integer> dcpIntWinMap;
    Map<Matchup, Integer> dcpIntLossMap;
    Map<DeckClass, Map<Integer, Integer>> dcIntIntMapMap;

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
        dcp = new Matchup(DeckClass.ROGUE, DeckClass.WARRIOR);
        dcIntMatchMap = new HashMap();
        dcIntWinMap = new HashMap();
        dcIntLossMap = new HashMap();
        dcpIntMatchMap = new HashMap();
        dcpIntWinMap = new HashMap();
        dcpIntLossMap = new HashMap();
        dcIntIntMapMap = new HashMap();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void mapZeroesToADeckClassIntegerMap_has_correct_keyset_size() {
        Mapper.mapZeroesToDcIntMap(dcIntMap);
        assertEquals(9, dcIntMap.keySet().size());
    }

    @Test
    public void mapZeroesToADeckClassIntegerMap_values_are_zeroes() {
        Mapper.mapZeroesToDcIntMap(dcIntMap);
        assertTrue(TestHelper.zeroesInDcIntMap(dcIntMap));
    }

    @Test
    public void mapZeroesToADeckClassPairIntegerMap_has_correct_keyset_size() {
        Mapper.mapZeroesToMatchupIntMap(dcpIntMap);
        assertEquals(81, dcpIntMap.keySet().size());
    }

    @Test
    public void mapZeroesToADeckClassPairIntegerMap_maps_zeroes_to_values() {
        Mapper.mapZeroesToMatchupIntMap(dcpIntMap);
        assertTrue(TestHelper.zeroesInMatchupIntMap(dcpIntMap));
    }

    @Test
    public void mapZeroesToADeckClassDoubleMap_has_correct_keyset_size() {
        Mapper.mapZeroesToDcDoubleMap(dcDoubleMap);
        assertEquals(9, dcDoubleMap.keySet().size());
    }

    @Test
    public void mapZeroesToADeckClassDoubleMap_maps_zeroes_to_values() {
        Mapper.mapZeroesToDcDoubleMap(dcDoubleMap);
        assertTrue(TestHelper.zeroesInDcDoubleMap(dcDoubleMap));
    }

    @Test
    public void mapZeroesToADeckClassPairDoubleMap_has_correct_keyset_size() {
        Mapper.mapZeroesToMatchupDoubleMap(dcpDoubleMap);
        assertEquals(81, dcpDoubleMap.keySet().size());
    }

    @Test
    public void mapZeroesToADeckClassPairDoubleMap_maps_zeroes_to_values() {
        Mapper.mapZeroesToMatchupDoubleMap(dcpDoubleMap);
        assertTrue(TestHelper.zeroesInMatchupDoubleMap(dcpDoubleMap));
    }

    @Test
    public void mapZeroesToIntegerIntegerMap_has_correct_keyset_size() {
        Mapper.mapZeroesToIntIntMap(intIntMap);
        assertEquals(13, intIntMap.keySet().size());
    }

    @Test
    public void mapZeroesToIntegerIntegerMap_maps_zeroes_to_values() {
        Mapper.mapZeroesToIntIntMap(intIntMap);
        assertTrue(TestHelper.zeroesInIntIntMap(intIntMap));
    }

    @Test
    public void mapZeroesToIntegerDoubleMap_has_correct_keyset_size() {
        Mapper.mapZeroesToIntDoubleMap(intDoubleMap);
        assertEquals(13, intDoubleMap.keySet().size());
    }

    @Test
    public void mapZeroesToIntegerDoubleMap_maps_zeroes_to_values() {
        Mapper.mapZeroesToIntDoubleMap(intDoubleMap);
        assertTrue(TestHelper.zeroesInIntDoubleMap(intDoubleMap));
    }

    @Test
    public void mapZeroesToDcIntIntMapMap_has_correct_keyset_size() {
        Mapper.mapZeroesToDcIntIntMapMap(dcIntIntMapMap);
        assertEquals(9, dcIntIntMapMap.keySet().size());
    }

    @Test
    public void mapZeroesToDcIntIntMapMap_maps_zeroes_to_values() {
        Mapper.mapZeroesToDcIntIntMapMap(dcIntIntMapMap);
        assertTrue(TestHelper.zeroesInDcIntIntMapMap(dcIntIntMapMap));
    }

    @Test
    public void increaseIntegerInDeckClassIntegerMap_increases_value_by_one() {
        dcIntMap.put(DeckClass.MAGE, 2);
        Mapper.increaseIntegerInDcIntMap(dcIntMap, DeckClass.MAGE);
        assertEquals(3, (int) dcIntMap.get(DeckClass.MAGE));
    }

    @Test
    public void increaseIntegerInDeckClassIntegerMap_increases_value_by_x_amount() {
        dcIntMap.put(DeckClass.MAGE, 4);
        Mapper.increaseIntegerInDcIntMap(dcIntMap, DeckClass.MAGE, 5);
        assertEquals(9, (int) dcIntMap.get(DeckClass.MAGE));
    }

    @Test
    public void increaseIntegerInDeckClassPairIntegerMap_increases_value_by_one() {
        dcpIntMap.put(dcp, 1);
        Mapper.increaseIntegerInMatchupIntMap(dcpIntMap, dcp);
        assertEquals(2, (int) dcpIntMap.get(dcp));
    }

    @Test
    public void updateWinPercentageInDeckClassDoubleMap_works_correctly() {
        dcIntMatchMap.put(DeckClass.MAGE, 2);
        dcIntWinMap.put(DeckClass.MAGE, 1);
        dcIntLossMap.put(DeckClass.MAGE, 1);
        Mapper.updateWinRatioInDcDoubleMap(dcDoubleMap, dcIntMatchMap,
                dcIntWinMap, dcIntLossMap, DeckClass.MAGE);
        assertEquals(0.5, dcDoubleMap.get(DeckClass.MAGE), 0);
    }

    @Test
    public void updateWinPercentageInDeckClassPairDoubleMap_works_correctly() {
        dcpIntMatchMap.put(dcp, 5);
        dcpIntWinMap.put(dcp, 3);
        dcpIntLossMap.put(dcp, 2);
        Mapper.updateWinRatioInMatchupDoubleMap(dcpDoubleMap, dcpIntMatchMap,
                dcpIntWinMap, dcpIntLossMap, dcp);
        assertEquals(0.6, dcpDoubleMap.get(dcp), 0);
    }

    @Test
    public void decreaseIntegerInDeckClassIntegerMap_decreases_integer_by_one() {
        dcIntMap.put(DeckClass.MAGE, 2);
        Mapper.decreaseIntegerInDcIntMap(dcIntMap, DeckClass.MAGE);
        assertEquals(1, (int) dcIntMap.get(DeckClass.MAGE));
    }

    @Test
    public void decreaseIntegerInDeckClassIntegerMap_decreases_integer_by_x() {
        dcIntMap.put(DeckClass.MAGE, 4);
        Mapper.decreaseIntegerInDcIntMap(dcIntMap, DeckClass.MAGE, 4);
        assertEquals(0, (int) dcIntMap.get(DeckClass.MAGE));
    }

    @Test
    public void decreaseIntegerInDeckClassIntegerMap_does_not_decrease_integer_below_zero() {
        dcIntMap.put(DeckClass.MAGE, 3);
        Mapper.decreaseIntegerInDcIntMap(dcIntMap, DeckClass.MAGE, 4);
        assertEquals(0, (int) dcIntMap.get(DeckClass.MAGE));
    }

    @Test
    public void decreaseIntegerInDeckClassPairIntegerMap_decreases_integer_by_one() {
        dcpIntMap.put(dcp, 5);
        Mapper.decreaseIntegerInMatchupIntMap(dcpIntMap, dcp);
        assertEquals(4, (int) dcpIntMap.get(dcp));
    }

    @Test
    public void decreaseIntegerInDeckClassPairIntegerMap_does_not_decrease_integer_below_zero() {
        dcpIntMap.put(dcp, 0);
        Mapper.decreaseIntegerInMatchupIntMap(dcpIntMap, dcp);
        assertEquals(0, (int) dcpIntMap.get(dcp));
    }

    @Test
    public void increaseIntegerInIntegerIntegerMap_increases_integer_by_one() {
        intIntMap.put(0, 0);
        Mapper.increaseIntegerInIntIntMap(intIntMap, 0);
        assertEquals(1, (int) intIntMap.get(0));
    }

    @Test
    public void increaseIntegerInIntegerIntegerMap_increases_integer_by_x_amount() {
        intIntMap.put(3, 3);
        Mapper.increaseIntegerInIntIntMap(intIntMap, 3, 6);
        assertEquals(9, (int) intIntMap.get(3));
    }

    @Test
    public void updateAverageInDeckClassDoubleMap_works_correctly() {
        Mapper.updateAverageInDcDoubleMap(dcDoubleMap, DeckClass.MAGE, 3, 5);
        assertEquals(0.6, dcDoubleMap.get(DeckClass.MAGE), 0);
    }

    @Test
    public void updateAverageInIntegerDoubleMap_works_correctly() {
        Mapper.updateAverageInIntDoubleMap(intDoubleMap, 4, 4, 10);
        assertEquals(0.4, intDoubleMap.get(4), 0);
    }

    @Test
    public void decreaseIntegerInIntegerIntegerMap_decreases_integer_by_one() {
        intIntMap.put(7, 7);
        Mapper.decreaseIntegerInIntIntMap(intIntMap, 7);
        assertEquals(6, (int) intIntMap.get(7));
    }

    @Test
    public void decreaseIntegerInIntegerIntegerMap_decreases_integer_by_x_amount() {
        intIntMap.put(1, 4);
        Mapper.decreaseIntegerInIntIntMap(intIntMap, 1, 2);
        assertEquals(2, (int) intIntMap.get(1));
    }

    @Test
    public void decreaseIntegerInIntegerIntegerMap_doesnt_decrease_integer_below_zero() {
        intIntMap.put(5, 100);
        Mapper.decreaseIntegerInIntIntMap(intIntMap, 5, 101);
        assertEquals(0, (int) intIntMap.get(5));
    }

    @Test
    public void increaseIntegerInDcIntIntMapMap_increases_integer_by_one() {
        intIntMap.put(3, 64);
        dcIntIntMapMap.put(DeckClass.MAGE, intIntMap);
        Mapper.increaseIntegerInDcIntIntMapMap(dcIntIntMapMap, DeckClass.MAGE, 3);
        assertEquals(65, (int) dcIntIntMapMap.get(DeckClass.MAGE).get(3));
    }

    @Test
    public void increaseIntegerInDcIntIntMapMap_increases_integer_by_x_amount() {
        intIntMap.put(1, 99);
        dcIntIntMapMap.put(DeckClass.MAGE, intIntMap);
        Mapper.increaseIntegerInDcIntIntMapMap(dcIntIntMapMap, DeckClass.MAGE, 1, 41);
        assertEquals(140, (int) dcIntIntMapMap.get(DeckClass.MAGE).get(1));
    }
    
    @Test
    public void increaseIntegerInDcIntIntMapMap_doesnt_increase_other_integers_by_x_amount() {
        Mapper.mapZeroesToIntIntMap(intIntMap);
        Mapper.mapZeroesToDcIntIntMapMap(dcIntIntMapMap);
        Mapper.increaseIntegerInDcIntIntMapMap(dcIntIntMapMap, DeckClass.DRUID, 1, 11);
        assertEquals(0, (int) dcIntIntMapMap.get(DeckClass.ROGUE).get(1));
    }

    @Test
    public void decreaseIntegerInDcIntIntMapMap_decreases_integer_by_one() {
        intIntMap.put(5, 3);
        dcIntIntMapMap.put(DeckClass.MAGE, intIntMap);
        Mapper.decreaseIntegerInDcIntIntMapMap(dcIntIntMapMap, DeckClass.MAGE, 5);
        assertEquals(2, (int) dcIntIntMapMap.get(DeckClass.MAGE).get(5));
    }

    @Test
    public void increaseIntegerInDcIntIntMapMap_doesnt_increase_other_integers_by_one() {
        Mapper.mapZeroesToIntIntMap(intIntMap);
        Mapper.mapZeroesToDcIntIntMapMap(dcIntIntMapMap);
        Mapper.increaseIntegerInDcIntIntMapMap(dcIntIntMapMap, DeckClass.DRUID, 10);
        assertEquals(0, (int) dcIntIntMapMap.get(DeckClass.PALADIN).get(10));
    }

    @Test
    public void decreaseIntegerInDcIntIntMapMap_decreases_integer_by_x_amount() {
        intIntMap.put(7, 1000);
        dcIntIntMapMap.put(DeckClass.MAGE, intIntMap);
        Mapper.decreaseIntegerInDcIntIntMapMap(dcIntIntMapMap, DeckClass.MAGE, 7, 400);
        assertEquals(600, (int) dcIntIntMapMap.get(DeckClass.MAGE).get(7));
    }

    @Test
    public void decreaseIntegerInDcIntIntMapMap_doesnt_decrease_integer_below_zero() {
        intIntMap.put(8, 599);
        dcIntIntMapMap.put(DeckClass.MAGE, intIntMap);
        Mapper.decreaseIntegerInDcIntIntMapMap(dcIntIntMapMap, DeckClass.MAGE, 8, 600);
        assertEquals(0, (int) dcIntIntMapMap.get(DeckClass.MAGE).get(8));
    }
}
