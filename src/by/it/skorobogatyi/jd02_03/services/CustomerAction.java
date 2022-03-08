package by.it.skorobogatyi.jd02_03.services;

import by.it.skorobogatyi.jd02_03.entity.Good;

public interface CustomerAction {

        void enteredStore();

        Good chooseGood();

        void goToQueue();

        void goOut();
}
