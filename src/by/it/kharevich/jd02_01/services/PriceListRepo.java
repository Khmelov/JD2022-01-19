package by.it.kharevich.jd02_01.services;
import by.it.kharevich.jd02_01.utils.RandomData;
import by.it.kharevich.jd02_01.entity.Good;
import java.util.HashMap;

public class PriceListRepo{

    public static final HashMap<Good, Double> priceList = new HashMap<>();

    public static void priceListRepo() {
        for (char i = 97; i < 123; i++) {
            String good = "Good " + i;
            Good newGood = new Good(good, RandomData.get(10, 100));
            priceList.put(newGood, newGood.getPrice());
        }
    }
}
