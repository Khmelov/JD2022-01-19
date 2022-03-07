package by.it.kuzma.jd02_01.utils;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepo {

    public static Map<String, Double> priceList = new HashMap<>();

    public static void priceGood() {
        priceList.put("apple", 2.5);
        priceList.put("banana", 3.50);
        priceList.put("bun", 1.30);
        priceList.put("bread", 1.20);
        priceList.put("meat", 9.50);
        priceList.put("fish", 6.00);
        priceList.put("milk", 1.40);
        priceList.put("eggs", 2.40);
        priceList.put("tea", 4.00);
        priceList.put("coffee", 5.00);

    }

}
