package by.it.burov.jd02_03.services;

import by.it.burov.jd02_03.entity.Good;

public interface ShoppingCardAction {
void takeCart();
int putToCart(Good good);
}