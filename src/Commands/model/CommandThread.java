package Commands.model;

import Model.Tile;

public abstract class CommandThread implements Runnable {
    protected Tile[][]input, output;
    private int row;

    public void init(Tile[][] input, Tile[][] output, int row) {
        this.input = input;
        this.output = output;
        this.row = row;
    }

    @Override
    public void run() {
        for (int col = 0; col < input[row].length; col++) {
            runForTile(row, col);
        }
    }

    protected abstract void runForTile(int x, int y);
}
