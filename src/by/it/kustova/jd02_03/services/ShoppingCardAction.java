package by.it.kustova.jd02_03.services;

import by.it.kustova.jd02_03.entity.Good;

public interface ShoppingCardAction {
    void takeCart();

    int putToCart(Good goods);
}
