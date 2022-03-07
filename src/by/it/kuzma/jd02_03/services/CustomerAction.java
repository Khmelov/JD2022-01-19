package by.it.kuzma.jd02_03.services;

import by.it.kuzma.jd02_03.entity.Good;

public interface CustomerAction {
    void enteredStore(); //вошел в магазин (мгновенно)

    Good chooseGood(); //выбрал товар (от 0,5 до 2 секунд)

    void goToQueue();

    void goOut();
//отправился на выход(мгновенно)
}