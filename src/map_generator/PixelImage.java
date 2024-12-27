package map_generator;

import Commands.model.CommandStack;
import Configuration.GenConfig;
import Model.Temperature;
import Model.Tile;
import Util.ColorUtil;
import Util.StateDistribution;

import javax.swing.*;
import java.awt.*;

public class PixelImage extends JPanel {
    private int cellSize;

    private Tile[][] cells;
    private final CommandStack commandStack;

    public PixelImage(CommandStack commandStack) {
        super();
        this.cells = new Tile[GenConfig.INIT_CELL_COUNT][GenConfig.INIT_CELL_COUNT];
        this.commandStack = commandStack;

        setSize(GenConfig.IMAGE_SIZE, GenConfig.IMAGE_SIZE);
        setVisible(true);
        setMinimumSize(new Dimension(GenConfig.IMAGE_SIZE, GenConfig.IMAGE_SIZE));
    }

    @Override
    public void paint(Graphics g) {
        cellSize = (GenConfig.IMAGE_SIZE / cells.length);

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells.length; y++) {
                g.setColor(ColorUtil.getColorOfTile(cells[x][y]));
                int pixelX = x * cellSize;
                int pixelY = y * cellSize;
                g.fillRect(pixelX, pixelY, cellSize, cellSize);
                g.setColor(Color.BLACK);
                //g.drawRect(pixelX, pixelY, cellSize, cellSize);
            }
        }
    }

    public void spacebarDown() {
        cells = commandStack.nextCommand(cells);
        repaint();
    }

    public void executeStack() {
        cells = commandStack.run(cells);
        repaint();
    }

    public void printDistribution() {
        StateDistribution distribution = new StateDistribution(cells);
        distribution.printDistribution();
    }
}