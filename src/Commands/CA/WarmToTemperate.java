package Commands.CA;

import Model.Temperature;
import Model.Tile;

public class WarmToTemperate extends Algorithm {

    @Override
    protected void runForTile(int x, int y) {
        if (input[x][y].getTemperature() != Temperature.WARM)
            output[x][y] = input[x][y];

        if (countTemperatureInNeighborhood(input, x, y, Temperature.COLD) > 0
                || countTemperatureInNeighborhood(input, x, y, Temperature.FREEZING) > 0) {
            output[x][y] = new Tile(Temperature.TEMPERATE, input[x][y].isWater(), input[x][y].isDeap());
        }
        output[x][y] = input[x][y];
    }
}
