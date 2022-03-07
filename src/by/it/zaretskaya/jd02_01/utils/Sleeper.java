package by.it.zaretskaya.jd02_01.utils;

import by.it.zaretskaya.jd02_01.exeptions.StoreException;

public class Sleeper {

    private Sleeper() {
    }
    public static void sleeper(int millis){
        try {
            Thread.sleep(millis/Constants.K_SPEED);
        } catch (InterruptedException e) {
            throw new StoreException(e);
        }
    }
}
