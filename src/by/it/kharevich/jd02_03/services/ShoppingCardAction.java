package by.it.kharevich.jd02_03.services;

import by.it.kharevich.jd02_03.entity.Good;

public interface ShoppingCardAction {

    void takeCart(); //взял корзину

    int putToCart(Good good); //положил товар в корзину(возвращает число товаров)
}