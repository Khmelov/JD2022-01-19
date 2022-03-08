package by.it.skorobogatyi.jd02_03.services;

import by.it.skorobogatyi.jd02_03.entity.Good;

public interface ShoppingCartAction {

    void takeCart();

    int putToCart(Good good);
}
