package by.it.skorobogatyi.jd02_02.services;

import by.it.skorobogatyi.jd02_02.entity.Good;

public interface ShoppingCartAction {

    void takeCart();

    int putToCart(Good good);
}
