package Commands.model;

import Model.Tile;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadCommand<T extends CommandThread> extends Command<T> {

    public MultiThreadCommand(Class<T> type) {
        super(type);
    }

    @Override
    public Tile[][] run(Tile[][] cells) {
        Thread[] threads = new Thread[cells[0].length];
        Tile[][] result = new Tile[cells.length][cells[0].length];
        for (int row = 0; row < cells.length; row++) {
            try {
                threads[row] = createThreadInstance(cells, result, row);
                threads[row].start();
            } catch (Exception e) {
                System.out.println("Thread could not be instantiated!");
            }
        }

        for (Thread thread: threads) {
            try {
                thread.join();
            } catch(Exception e) {
                System.out.println("Thread interupted!");
            }
        }

        return result;
    }
}
