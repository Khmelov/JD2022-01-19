package by.it.katsal.jd02_02.entity;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {


    public List<Good> goodsInCart = new ArrayList<>();


    public void putGoodIntoCart(Good good) {
        goodsInCart.add(good);
    }
}


