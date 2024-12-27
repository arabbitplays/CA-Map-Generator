package Model;

public class Tile {
    private final Temperature temperature;
    private final boolean water;
    private final boolean deap;

    public Tile(Temperature temperature, boolean water, boolean deap) {
        this.temperature = temperature;
        this.water = water;
        this.deap = deap;
    }

    public boolean isWater() {
        return water;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public boolean isDeap() {
        return deap;
    }
}
