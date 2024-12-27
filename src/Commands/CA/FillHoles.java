package Commands.CA;

import Model.Tile;

public class FillHoles extends Algorithm {

    @Override
    protected void runForTile(int x, int y) {
        if(!input[x][y].isWater())
            output[x][y] = input[x][y];

        int landCounter = countWaterInNeighborhood(input, x, y, false);
        if (landCounter == neighborhoodSize)
            output[x][y] = new Tile(input[x][y].getTemperature(), false, false);
        else
            output[x][y] = input[x][y];
    }
}
