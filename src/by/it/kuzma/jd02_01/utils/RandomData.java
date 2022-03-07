package by.it.kuzma.jd02_01.utils;

import java.util.Random;

public class RandomData {

    private RandomData() {
    }

    private static final Random random = new Random();

    public static int get(int max){
        return get(0, max);
    }

    public static int get(int min, int max){
        return min + random.nextInt(max - min + 1);
    }
}
