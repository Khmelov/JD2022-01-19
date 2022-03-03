package by.it.skorobogatyi.jd02_02.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class GoodsAndPricesStorage {

    public Map<String, BigDecimal> priceList;

    public GoodsAndPricesStorage() {
        priceList = new HashMap<>();
        priceList.put("Orange", BigDecimal.valueOf(5));
        priceList.put("Beer", BigDecimal.valueOf(2));
        priceList.put("Cognac \"Chars'o'Nil\"", BigDecimal.valueOf(2.5));
        priceList.put("Apple", BigDecimal.valueOf(1.5));
        priceList.put("Cake", BigDecimal.valueOf(10));
        priceList.put("Cheese", BigDecimal.valueOf(16));
        priceList.put("Sausages", BigDecimal.valueOf(4));
        priceList.put("Tea", BigDecimal.valueOf(3));
        priceList.put("Coffee", BigDecimal.valueOf(3));
    }
}
