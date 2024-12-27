package Commands.model;

import Model.Tile;

public class CommandStack<T extends CommandThread> extends Command<T> {
    private int currCommandIndex;
    private final Command[] commands;

    public CommandStack(Class<T> type, Command[] commands) {
        super(type);
        this.commands = commands;
    }

    public Tile[][] nextCommand(Tile[][] cells) {
        cells = commands[currCommandIndex].run(cells);
        currCommandIndex = (currCommandIndex+1) % commands.length;
        return cells;
    }

    @Override
    public Tile[][] run(Tile[][] cells) {
        for(int i = 0; i < commands.length; i++) {
            cells = commands[i].run(cells);
        }
        return cells;
    }
}
