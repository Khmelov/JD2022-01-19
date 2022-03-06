package by.it.chaikova.jd02_03.utils;

import by.it.chaikova.jd02_03.excertions.StoreExeption;

public class Sleeper {
    private Sleeper() {
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis / Constants.K_SPEED);
        } catch (InterruptedException e) {
            throw new StoreExeption(e);
        }
    }
}
