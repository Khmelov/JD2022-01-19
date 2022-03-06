package by.it.yushkevich.jd02_01.utils;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepo {

    public static Map<String, Double> listOfProducts = new HashMap<>();

    public static void fillingListOfPruducts(){

        listOfProducts.put("молоко", 3.);
        listOfProducts.put("кефир", 2.0);
        listOfProducts.put("мед", 5.);
        listOfProducts.put("сок", 2.4);
        listOfProducts.put("батон",1.);
        listOfProducts.put("шоколад",2.);
        listOfProducts.put("мармелад", 3.);
        listOfProducts.put("сахар", 4.);
        listOfProducts.put("колбаса", 10.);
    }

}
