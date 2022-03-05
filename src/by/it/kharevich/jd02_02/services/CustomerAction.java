package by.it.kharevich.jd02_02.services;

import by.it.kharevich.jd02_02.entity.Good;

public interface CustomerAction {

    void enteredStore(); //вошел в магазин (мгновенно)

    Good chooseGood(); //выбрал товар (от 0,5 до 2 секунд)

    void goToQueue();

    void goOut(); //отправился на выход(мгновенно)
}