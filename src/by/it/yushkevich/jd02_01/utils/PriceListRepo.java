package by.it.yushkevich.jd02_01.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PriceListRepo {

    public static Map<String, BigDecimal> listOfProducts = new HashMap<>();


    public static void fillingListOfPruducts(){

        listOfProducts.put("молоко", BigDecimal.valueOf(1));
        listOfProducts.put("кефир", BigDecimal.valueOf(2));
        listOfProducts.put("мед", BigDecimal.valueOf(3));
        listOfProducts.put("сок", BigDecimal.valueOf(4));
        listOfProducts.put("батон",BigDecimal.valueOf(5));
        listOfProducts.put("шоколад", BigDecimal.valueOf(6));
        listOfProducts.put("мармелад", BigDecimal.valueOf(7));
        listOfProducts.put("сахар", BigDecimal.valueOf(8));
        listOfProducts.put("колбаса", BigDecimal.valueOf(9));
        listOfProducts.put("кофе", BigDecimal.valueOf(10));
    }

}
