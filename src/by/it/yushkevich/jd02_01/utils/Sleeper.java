package by.it.yushkevich.jd02_01.utils;

import by.it.yushkevich.jd02_01.exceptions.StoreException;

public class Sleeper {

    public Sleeper() {
    }

    public static void sleep(int milis){
        try {
            Thread.sleep(milis/Constants.K_SPEED);
        } catch (InterruptedException e) {
            throw new StoreException("SOS", e);
        }

    }
}
