package Commands.CA;

import Commands.model.CommandThread;
import Model.Temperature;
import Model.Tile;
import Util.Vector2;

import java.util.ArrayList;
import java.util.List;

public abstract class Algorithm extends CommandThread {
    protected int neighborhoodSize;

    protected Vector2[] neighbourOffsets = {
            new Vector2(1, 0),
            new Vector2(-1, 0),
            new Vector2(0, 1),
            new Vector2(0, -1)
    };

    public Algorithm() {
        neighborhoodSize = neighbourOffsets.length;
    }

    protected abstract void runForTile(int x, int y);

    protected int countWaterInNeighborhood(Tile[][] cells, int x, int y, boolean water) {
        int counter = 0;
        List<Vector2> neighbors = getNeighbors(new Vector2(x, y), cells.length);

        for(Vector2 neighbour: neighbors) {
            if (cells[neighbour.x][neighbour.y].isWater() == water)
                counter++;
        }

        return counter;
    }

    protected int countTemperatureInNeighborhood(Tile[][] cells, int x, int y, Temperature temperature) {
        int counter = 0;
        List<Vector2> neighbors = getNeighbors(new Vector2(x, y), cells.length);

        for(Vector2 neighbour: neighbors) {
            if (cells[neighbour.x][neighbour.y].getTemperature() == temperature)
                counter++;
        }

        return counter;
    }

    protected List<Vector2> getNeighbors(Vector2 origin, int boundary) {
        List<Vector2> result = new ArrayList<>();

        for(Vector2 offset: neighbourOffsets) {
            Vector2 neighbour = origin.add(offset);
            if (neighbour.x < 0 || neighbour.y < 0
                    || neighbour.x >= boundary || neighbour.y >= boundary)
                continue;

            result.add(neighbour);
        }

        return result;
    }
}
