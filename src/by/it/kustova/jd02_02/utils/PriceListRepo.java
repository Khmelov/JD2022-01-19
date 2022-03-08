package by.it.kustova.jd02_02.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PriceListRepo {
    public static Map<String, BigDecimal> priceList= new HashMap<>();


    public static void PriceGoods(){
        priceList.put("Apple", BigDecimal.valueOf(1));
        priceList.put("Lemon", BigDecimal.valueOf(2));
        priceList.put("Juice", BigDecimal.valueOf(3));
        priceList.put("Orange", BigDecimal.valueOf(4));
        priceList.put("Meat", BigDecimal.valueOf(5));
        priceList.put("Chicken", BigDecimal.valueOf(6));
        priceList.put("Sugar", BigDecimal.valueOf(7));
        priceList.put("Milk", BigDecimal.valueOf(8));
        priceList.put("Tea", BigDecimal.valueOf(9));
        priceList.put("Ice-Cream", BigDecimal.valueOf(10));
    }
}
