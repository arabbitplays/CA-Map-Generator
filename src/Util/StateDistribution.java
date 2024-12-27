package Util;

import Model.Tile;

public class StateDistribution {
    private float shallowWater, deepWater, warm, temperate, cold, freezing;

    public StateDistribution(Tile[][] tiles) {
        calcDistribution(tiles);
    }

    private void calcDistribution(Tile[][] tiles) {
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles.length; x++) {
                Tile tile = tiles[x][y];
                if (tile.isWater() && tile.isDeap())
                    deepWater++;
                else if (tile.isWater() && !tile.isDeap())
                    shallowWater++;

                switch(tile.getTemperature()) {
                    case WARM -> { warm++; }
                    case TEMPERATE -> { temperate++; }
                    case COLD -> { cold++; }
                    case FREEZING -> { freezing++; }
                }
            }
        }
        int count = tiles.length * tiles.length;
        shallowWater = Math.round(shallowWater / count * 100);
        deepWater = Math.round(deepWater / count * 100);
        warm = Math.round(warm / count * 100);
        temperate = Math.round(temperate / count * 100);
        cold = Math.round(cold / count * 100);
        freezing = Math.round(freezing / count * 100);
    }

    public void printDistribution() {
        System.out.println(String.format("Shallow: %d%% --- Deep: %d%% --- Warm: %d%% --- Temperate: %d%% --- Cold: %d%% --- Freezing: %d%%",
                (int)shallowWater, (int)deepWater, (int)warm, (int)temperate, (int)cold, (int)freezing));
    }
}
