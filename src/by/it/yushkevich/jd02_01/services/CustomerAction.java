package by.it.yushkevich.jd02_01.services;

import by.it.yushkevich.jd02_01.entity.Good;

public interface CustomerAction {

    void enteredStore();

    Good chooseGood();

    void goOut();

}
