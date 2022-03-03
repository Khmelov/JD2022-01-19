package by.it.skorobogatyi.jd02_01.services;

import by.it.skorobogatyi.jd02_01.entity.Good;

public interface ShoppingCartAction {

    void takeCart();

    int putToCart(Good good);
}
