package Commands.CA;

import Model.Tile;
import Util.RandomGenerator;
import Util.Vector2;
import Configuration.GenConfig;

import java.util.List;

public class BlendStates extends Algorithm {
    @Override
    protected void runForTile(int x, int y) {
        if (!RandomGenerator.evalChance(GenConfig.BLEND_CHANCE))
            output[x][y] = input[x][y];

        List<Vector2> neighbours = getNeighbors(new Vector2(x, y), input.length);
        int randIndex = RandomGenerator.getIntBetween(0, neighborhoodSize);
        if (randIndex < neighbours.size()) {
            Tile randTile = input[neighbours.get(randIndex).x][neighbours.get(randIndex).y];
            output[x][y] = new Tile(randTile.getTemperature(), randTile.isWater(), randTile.isDeap());
        }

        output[x][y] = input[x][y];
    }
}
