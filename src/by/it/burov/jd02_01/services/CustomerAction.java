package by.it.burov.jd02_01.services;

import by.it.burov.jd02_01.entity.Good;

public interface CustomerAction {
void enteredStore(); //вошел в магазин (мгновенно)
Good chooseGood(); //выбрал товар (от 0,5 до 2 секунд)
void goOut(); //отправился на выход(мгновенно)
}