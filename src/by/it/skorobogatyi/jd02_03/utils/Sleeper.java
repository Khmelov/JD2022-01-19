package by.it.skorobogatyi.jd02_03.utils;

import by.it.skorobogatyi.jd02_03.exceptions.StoreException;

public class Sleeper {


    private Sleeper(){
    }


    public static void sleep(double millis){

        try {
            Thread.sleep((long) millis);
        } catch (InterruptedException e) {
            throw new StoreException(e);
        }
    }
}
