package Commands.CA;

import Model.Temperature;
import Model.Tile;

public class FreezingToCold extends Algorithm {
    @Override
    protected void runForTile(int x, int y) {
        if (input[x][y].getTemperature() != Temperature.FREEZING)
            output[x][y] = input[x][y];

        if (countTemperatureInNeighborhood(input, x, y, Temperature.WARM) > 0
                || countTemperatureInNeighborhood(input, x, y, Temperature.TEMPERATE) > 0) {
            output[x][y] = new Tile(Temperature.COLD, input[x][y].isWater(), input[x][y].isDeap());
        }
        output[x][y] = input[x][y];
    }
}
