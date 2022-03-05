package by.it.skorobogatyi.jd02_01.services;

import by.it.skorobogatyi.jd02_01.entity.Good;

public interface CustomerAction {

        void enteredStore();

        Good chooseGood();

        void goOut();
}
