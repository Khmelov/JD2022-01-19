package by.it.kustova.jd02_01.services;

import by.it.kustova.jd02_01.entity.Good;

public interface ShoppingCardAction {
    void takeCart();

    int putToCart(Good goods);
}
