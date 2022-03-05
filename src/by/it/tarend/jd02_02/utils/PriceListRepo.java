package by.it.tarend.jd02_02.utils;


import by.it.tarend.jd02_02.entity.Good;

import java.util.HashMap;


public class PriceListRepo {

    public static final HashMap<Good, Double> priceList = new HashMap<>();

     public static void createPriceList() {
        for (char i = 'A'; i < 'Z'; i++) {
            String goodName = "Good " + i;
            Good newGood = new Good(goodName, RandomData.get(10, 100));
            priceList.put(newGood, newGood.getPrice());
        }
    }
}


