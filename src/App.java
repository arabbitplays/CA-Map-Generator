
import map_generator.CompareMapGenerator;
import map_generator.MapGenerator;
import map_generator.StepMapGenerator;
import map_generator.TimingMapGenerator;


public class App {


    public static void main(String[] args)
    {
        MapGenerator generator = new CompareMapGenerator();
        generator.generate();
    }





}