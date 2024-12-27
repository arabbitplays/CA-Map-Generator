package map_generator;


import Commands.model.Command;
import Commands.model.MultiThreadCommand;
import Commands.utility.AddTemperature;
import Commands.CA.*;
import Commands.utility.InitCells;
import Commands.utility.SplitCells;
import Util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public abstract class MapGenerator {
    protected static final List<PixelImage> images = new ArrayList<>();

    protected Command[] commands = {
            new MultiThreadCommand<>(InitCells.class),
            new SplitCells(InitCells.class),
            new MultiThreadCommand<>(LandCreationAlgorithm.class),
            new SplitCells(InitCells.class),
            new MultiThreadCommand<>(LandCreationAlgorithm.class),
            new SplitCells(InitCells.class),
            new MultiThreadCommand<>(LandCreationAlgorithm.class),
            new MultiThreadCommand<>(AddTemperature.class),
            new SplitCells(InitCells.class),
            new MultiThreadCommand<>(WarmToTemperate.class),
            new MultiThreadCommand<>(FreezingToCold.class),
            new MultiThreadCommand<>(LandCreationAlgorithm.class),
            new MultiThreadCommand<>(AddDeepWater.class),
            new SplitCells(InitCells.class),
            new MultiThreadCommand<>(BlendTemperature.class),
            new MultiThreadCommand<>(BlendStates.class),
            new MultiThreadCommand<>(LandCreationAlgorithm.class),
            new MultiThreadCommand<>(LandCreationAlgorithm.class),
            new MultiThreadCommand<>(FillHoles.class),
            new MultiThreadCommand<>(SmoothEdges.class),
    };

    public MapGenerator(long seed) {
        RandomGenerator.init(seed);
    }

    public MapGenerator() {
        RandomGenerator.init();
    }

    public abstract void generate();

    protected static void executeImageStacks() {
        images.forEach(image -> {
            image.executeStack();
        });
    }

    protected static void printDistributions() {
        images.forEach(image -> {
            image.printDistribution();
        });
    }
}
