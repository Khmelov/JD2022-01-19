package by.it.burov.jd02_02.utils;

import java.util.Random;

public class RandomData {
    public RandomData() {
    }

    private static Random random = new Random();

    public static int get(int min, int max){
        return min+ random.nextInt(max-min+1);
    }

    public static int get(int max){
        return get(0,max);
    }
}
