package Commands.CA;

import Commands.model.MultiThreadCommand;
import Configuration.GenConfig;
import Model.Tile;
import Util.RandomGenerator;

public class LandCreationAlgorithm extends Algorithm {
    @Override
    protected void runForTile(int x, int y) {
        if(!input[x][y].isWater())
            output[x][y] = input[x][y];

        int landCounter = countWaterInNeighborhood(input, x, y, false);

        if ((landCounter != 0 && RandomGenerator.evalChance(GenConfig.LAND_CREATION_CHANCE))) {
            output[x][y] = new Tile(input[x][y].getTemperature(), false, false);
        }
        output[x][y] = input[x][y];
    }
}
