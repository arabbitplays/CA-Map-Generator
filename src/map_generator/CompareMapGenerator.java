package map_generator;

import Commands.CA.*;
import Commands.model.Command;
import Commands.model.CommandStack;
import Commands.model.MultiThreadCommand;
import Commands.utility.AddTemperature;
import Commands.utility.InitCells;
import Commands.utility.SplitCells;
import Configuration.GenConfig;

import java.awt.*;

public class CompareMapGenerator extends VisualMapGenerator {
    @Override
    public void generate() {

        Command[] newCommands = {
                new MultiThreadCommand<InitCells>(InitCells.class),
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

        int sampleCount = GenConfig.SAMPLE_SIDE_LENGTH * GenConfig.SAMPLE_SIDE_LENGTH;

        CommandStack commandStack = new CommandStack<>(InitCells.class, commands);
        for (int i = 0; i < sampleCount / 2; i++)
            images.add(new PixelImage(commandStack));

        commandStack = new CommandStack<>(InitCells.class, newCommands);
        for (int i = 0; i < sampleCount / 2; i++)
            images.add(new PixelImage(commandStack));

        initFrame();
        executeImageStacks();
        printDistributions();
    }

    @Override
    protected void initFrame() {
        super.initFrame();
        frame.setLayout(new GridLayout(GenConfig.SAMPLE_SIDE_LENGTH, GenConfig.SAMPLE_SIDE_LENGTH));
    }


}
