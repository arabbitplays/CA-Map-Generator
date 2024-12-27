package Commands.CA;

import Configuration.GenConfig;
import Model.Tile;
import Util.Vector2;

public class AddDeepWater extends Algorithm {

    public AddDeepWater() {
        super();
        neighbourOffsets = new Vector2[4];
        neighbourOffsets[0] = new Vector2(GenConfig.DEEP_OCEAN_DISTANCE_TO_SHORE, 0);
        neighbourOffsets[1] = new Vector2(-GenConfig.DEEP_OCEAN_DISTANCE_TO_SHORE, 0);
        neighbourOffsets[2] = new Vector2(0, GenConfig.DEEP_OCEAN_DISTANCE_TO_SHORE);
        neighbourOffsets[3] = new Vector2(0, -GenConfig.DEEP_OCEAN_DISTANCE_TO_SHORE);
    }

    @Override
    protected void runForTile(int x, int y) {
        if (!input[x][y].isWater() || input[x][y].isDeap())
            output[x][y] = input[x][y];

        // Compare to size of actual neighborhood so account für the edges of the image
        if (countWaterInNeighborhood(input, x, y, true) == getNeighbors(new Vector2(x, y), input.length).size()) {
            output[x][y] = new Tile(input[x][y].getTemperature(), true, true);
        }
        output[x][y] = input[x][y];
    }
}
