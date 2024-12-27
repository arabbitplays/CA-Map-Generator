package Commands.utility;

import Commands.model.Command;
import Commands.model.CommandThread;
import Model.Tile;

public class SplitCells<T extends CommandThread> extends Command<T> {
    public SplitCells(Class<T> type) {
        super(type);
    }

    @Override
    public Tile[][] run(Tile[][] cells) {
        Tile[][] result = new Tile[2*cells.length][2*cells.length];
        for (int y = 0; y < cells.length; y++) {
            for (int x = 0; x < cells.length; x++) {
                result[2*x][2*y] = copyTile(cells[x][y]);
                result[2*x][2*y+1] = copyTile(cells[x][y]);
                result[2*x+1][2*y] = copyTile(cells[x][y]);
                result[2*x+1][2*y+1] = copyTile(cells[x][y]);
            }
        }
        return result;
    }

    private Tile copyTile(Tile tile) {
        return new Tile(tile.getTemperature(), tile.isWater(), tile.isDeap());
    }


}
