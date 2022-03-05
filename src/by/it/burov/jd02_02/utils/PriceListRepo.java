package by.it.burov.jd02_02.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PriceListRepo {

    public static Map<String, BigDecimal> catalog = new HashMap<>();

    public static void fillCatalog(){
        catalog.put("Milk",BigDecimal.valueOf(2.5));
        catalog.put("Juice",BigDecimal.valueOf(4));
        catalog.put("Chocolate",BigDecimal.valueOf(3));
        catalog.put("Bread",BigDecimal.valueOf(1.5));
        catalog.put("Butter",BigDecimal.valueOf(2.5));
        catalog.put("Meat",BigDecimal.valueOf(10));
        catalog.put("Sausages",BigDecimal.valueOf(6));
        catalog.put("Chicken",BigDecimal.valueOf(7));
        catalog.put("Fish",BigDecimal.valueOf(10));
        catalog.put("Water",BigDecimal.valueOf(1.5));
    }
}
