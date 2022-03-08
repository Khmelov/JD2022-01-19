package by.it.yushkevich.jd02_03.services;

import by.it.yushkevich.jd02_03.entity.Good;

public interface ShoppingCardAction {


    void takeCart();
    int putToCart(Good good);

}
