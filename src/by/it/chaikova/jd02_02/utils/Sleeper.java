package by.it.chaikova.jd02_02.utils;

import by.it.chaikova.jd02_02.excertions.StoreExeption;

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
