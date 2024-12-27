package map_generator;

import Commands.model.CommandStack;
import Commands.utility.InitCells;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StepMapGenerator extends VisualMapGenerator {
    @Override
    public void generate() {
        CommandStack commandStack = new CommandStack<>(InitCells.class, commands);
        images.add(new PixelImage(commandStack));

        initFrame();
    }

    @Override
    protected void initFrame() {
        super.initFrame();

        KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    spacebarDown();
                }
            }
        };
        frame.addKeyListener(keyListener);
    }

    private static void spacebarDown() {
        images.forEach(image -> {
            image.spacebarDown();
        });
    }
}
