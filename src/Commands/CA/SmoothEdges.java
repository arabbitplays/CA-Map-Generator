package Commands.CA;

import Model.Tile;

public class SmoothEdges extends Algorithm {

    @Override
    protected void runForTile(int x, int y) {
        if (input[x][y].isWater())
            output[x][y] = input[x][y];

        if (countWaterInNeighborhood(input, x, y, true) >= 3) {
            output[x][y] = new Tile(input[x][y].getTemperature(), true, false); //The edges of land are always shallow
        }
        output[x][y] = input[x][y];
    }
}
