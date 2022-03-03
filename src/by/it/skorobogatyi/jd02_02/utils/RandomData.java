package by.it.skorobogatyi.jd02_02.utils;

import by.it.skorobogatyi.jd02_02.entity.Store;
import by.it.skorobogatyi.jd02_02.services.CustomerRunner;
import by.it.skorobogatyi.jd02_02.services.PensionerRunner;
import by.it.skorobogatyi.jd02_02.services.StudentRunner;

import java.util.Random;

public class RandomData {

    private RandomData(){
    }

    private static final Random random = new Random();

    public static int getRandomNumber(int min, int max){
        return random.nextInt(min, max + 1);
    }

    public static int getRandomNumber(int max){
        return getRandomNumber(0, max);
    }

    public static int getRandomNumberOfGoods(CustomerRunner runner) {

        if (runner instanceof StudentRunner) {
            return getRandomNumber(2);

        } else {
            return getRandomNumber(2, 5);
        }
    }

    public static int getRandomTimeForGoodsChoosing(CustomerRunner runner) {

        if (runner instanceof PensionerRunner) {
            return (int) (getRandomNumber(500, 2000) * Constants.PENSIONER_SLOW);

        } else {
            return getRandomNumber(500, 2000);
        }
    }

    public static double getRandomTimeForGoodsPacking(CustomerRunner runner) {

        if (runner instanceof PensionerRunner) {
            return (int) (getRandomNumber(100, 300) * Constants.PENSIONER_SLOW);

        } else {
            return getRandomNumber(100, 300);
        }
    }

    public static int getRandomStoreNameIndex(int number) {
        return getRandomNumber(number - 1);
    }

    public static int getRandomGoodsAmount(Store store) {
        return getRandomNumber(store.getStorage().priceList.size() - 1);
    }
}
