package Commands.utility;

import Commands.model.CommandThread;
import Configuration.GenConfig;
import Model.Temperature;
import Model.Tile;
import Util.RandomGenerator;

public class AddTemperature extends CommandThread {
    @Override
    protected void runForTile(int x, int y) {
        Temperature temperature;
        float rand = RandomGenerator.getRandFloat();
        if (rand < GenConfig.INIT_WARM_CHANCE) {
            temperature = Temperature.WARM;
        } else if (rand < GenConfig.INIT_WARM_CHANCE + GenConfig.INIT_TEMPERATE_CHANCE) {
            temperature = Temperature.TEMPERATE;
        } else if (rand < GenConfig.INIT_WARM_CHANCE + GenConfig.INIT_TEMPERATE_CHANCE + GenConfig.INIT_COLD_CHANCE) {
            temperature = Temperature.COLD;
        } else {
            temperature = Temperature.FREEZING;
        }
        output[x][y] = new Tile(temperature, input[x][y].isWater(), input[x][y].isDeap());
    }
}
