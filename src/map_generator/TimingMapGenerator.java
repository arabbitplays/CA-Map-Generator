package map_generator;

import Commands.model.CommandStack;
import Commands.utility.InitCells;

public class TimingMapGenerator extends VisualMapGenerator {
    @Override
    public void generate() {
        int SAMPLE_COUNT = 100;
        int sum = 0;
        for (int i = 0; i < SAMPLE_COUNT; i++) {

            CommandStack commandStack = new CommandStack<>(InitCells.class, commands);
            images.clear();
            images.add(new PixelImage(commandStack));

            long start = System.currentTimeMillis();
            executeImageStacks();
            long finish = System.currentTimeMillis();
            long timeElapsed = finish - start;
            System.out.println(String.format("%d in %d ms", i, timeElapsed));
            sum += timeElapsed;
        }

        System.out.println(String.format("Average: %d ms", sum / SAMPLE_COUNT));

        initFrame();
    }
}
