package Util;

import java.util.Random;

public class RandomGenerator {
    private static Random rand;
    private RandomGenerator() {}

    public static void init() {
        rand = new Random();
    }

    public static void init(long seed) {
        rand = new Random(seed);
    }

    public static boolean evalChance(float chance) {
        return rand.nextFloat() < chance;
    }

    public static float getRandFloat() { return rand.nextFloat(); }

    public static int getIntBetween(int a, int b) { return rand.nextInt(a, b); }
}
