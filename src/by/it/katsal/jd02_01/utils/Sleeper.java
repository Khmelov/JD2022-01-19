package by.it.katsal.jd02_01.utils;

import by.it.katsal.jd02_02.exceptions.StoreException;

public class Sleeper {


    private Sleeper() {

    }


    public static void sleep(double millis) {
        try {
            Thread.sleep((long) (millis / Constants.K_SPEED));
        } catch (InterruptedException e) {
            throw new StoreException(e);

        }
    }
}
