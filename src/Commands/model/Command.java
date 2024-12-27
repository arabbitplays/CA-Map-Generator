package Commands.model;

import Model.Tile;

public abstract class Command<T extends CommandThread> {
    private final Class<T> type;

    public Command(Class<T> type) {
        this.type = type;
    }

    protected Thread createThreadInstance(Tile[][] input, Tile[][] output, int row) throws InstantiationException, IllegalAccessException {
        CommandThread commandThread = type.newInstance();
        commandThread.init(input, output, row);
        return new Thread(commandThread);
    }

    public abstract Tile[][] run(Tile[][] cells);
}
