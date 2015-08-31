package domain;

import java.util.HashMap;
import java.util.Map;
import util.Mapper;

public class RewardStatistics {

    private final Map<Integer, Integer> decksByWins;
    private final Map<Integer, Integer> dustByWins;
    private final Map<Integer, Integer> goldByWins;
    private final Map<Integer, Integer> extraPacksByWins;
    private final Map<Integer, Integer> cardsByWins;
    private final Map<Integer, Integer> goldCardsByWins;
    private final Map<Integer, Double> avgDustByWins;
    private final Map<Integer, Double> avgGoldByWins;
    private final Map<Integer, Double> avgExtraPacksByWins;
    private final Map<Integer, Double> avgCardsByWins;
    private final Map<Integer, Double> avgGoldCardsByWins;

    public RewardStatistics() {
        decksByWins = new HashMap();
        dustByWins = new HashMap();
        goldByWins = new HashMap();
        extraPacksByWins = new HashMap();
        cardsByWins = new HashMap();
        goldCardsByWins = new HashMap();
        avgDustByWins = new HashMap();
        avgGoldByWins = new HashMap();
        avgExtraPacksByWins = new HashMap();
        avgCardsByWins = new HashMap();
        avgGoldCardsByWins = new HashMap();
        mapZeroesToValues();
    }

    private void mapZeroesToValues() {
        mapZeroesToIntegerIntegerMaps();
        mapZeroesToIntegerDoubleMaps();
    }

    private void mapZeroesToIntegerIntegerMaps() {
        Mapper.mapZeroesToIntIntMap(decksByWins);
        Mapper.mapZeroesToIntIntMap(dustByWins);
        Mapper.mapZeroesToIntIntMap(goldByWins);
        Mapper.mapZeroesToIntIntMap(extraPacksByWins);
        Mapper.mapZeroesToIntIntMap(cardsByWins);
        Mapper.mapZeroesToIntIntMap(goldCardsByWins);
    }

    private void mapZeroesToIntegerDoubleMaps() {
        Mapper.mapZeroesToIntDoubleMap(avgDustByWins);
        Mapper.mapZeroesToIntDoubleMap(avgGoldByWins);
        Mapper.mapZeroesToIntDoubleMap(avgExtraPacksByWins);
        Mapper.mapZeroesToIntDoubleMap(avgCardsByWins);
        Mapper.mapZeroesToIntDoubleMap(avgGoldCardsByWins);
    }

    public Map<Integer, Double> getAvgDustByWins() {
        return avgDustByWins;
    }

    public Map<Integer, Double> getAvgExtraPacksByWins() {
        return avgExtraPacksByWins;
    }

    public Map<Integer, Double> getAvgGoldByWins() {
        return avgGoldByWins;
    }

    public Map<Integer, Integer> getDecksByWins() {
        return decksByWins;
    }

    public Map<Integer, Integer> getDustByWins() {
        return dustByWins;
    }

    public Map<Integer, Integer> getExtraPacksByWins() {
        return extraPacksByWins;
    }

    public Map<Integer, Integer> getGoldByWins() {
        return goldByWins;
    }

    public Map<Integer, Double> getAvgCardsByWins() {
        return avgCardsByWins;
    }

    public Map<Integer, Double> getAvgGoldCardsByWins() {
        return avgGoldCardsByWins;
    }

    public Map<Integer, Integer> getCardsByWins() {
        return cardsByWins;
    }

    public Map<Integer, Integer> getGoldCardsByWins() {
        return goldCardsByWins;
    }
}
