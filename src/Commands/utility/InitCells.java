package Commands.utility;

import Commands.model.CommandThread;
import Configuration.GenConfig;
import Model.Temperature;
import Model.Tile;
import Util.RandomGenerator;

public class InitCells extends CommandThread {
    @Override
    protected void runForTile(int x, int y) {
        output[x][y] = RandomGenerator.evalChance(GenConfig.INIT_LAND_CHANCE)
                ? new Tile(Temperature.TEMPERATE, false, false)
                : new Tile(Temperature.TEMPERATE, true, false);
    }
}
