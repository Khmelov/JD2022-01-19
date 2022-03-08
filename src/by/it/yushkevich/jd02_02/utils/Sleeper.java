package by.it.yushkevich.jd02_02.utils;

import by.it.yushkevich.jd02_02.exceptions.StoreException;

public class Sleeper {

    public Sleeper() {
    }

    public static void sleep(int millis){
        try {
            Thread.sleep(millis/ Constants.K_SPEED);
        } catch (InterruptedException e) {
            throw new StoreException("OMG", e);
        }

    }
}
