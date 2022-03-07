package by.it.kustova.jd02_02.services;

import by.it.kustova.jd02_02.entity.Good;

public interface ShoppingCardAction {
    void takeCart();

    int putToCart(Good goods);
}
