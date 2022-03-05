package by.it.skorobogatyi.jd02_02.services;

import by.it.skorobogatyi.jd02_02.entity.Good;

public interface CustomerAction {

        void enteredStore();

        Good chooseGood();

        void goToQueue();

        void goOut();
}
