package map_generator;

import Configuration.GenConfig;

import javax.swing.*;

public abstract class VisualMapGenerator extends MapGenerator {
    protected static JFrame frame;

    protected void initFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(GenConfig.IMAGE_SIZE, GenConfig.IMAGE_SIZE);
        frame.setVisible(true);

        images.forEach(image -> {
            frame.add(image);
        });
    }
}
