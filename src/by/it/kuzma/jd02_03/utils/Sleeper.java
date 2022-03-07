package by.it.kuzma.jd02_03.utils;

import by.it.kuzma.jd02_03.exceptions.StoreException;

public class Sleeper {

    private Sleeper() {
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis / Constants.K_SPEED);
        } catch (InterruptedException e) {
            throw new StoreException(e);
        }
    }
}
