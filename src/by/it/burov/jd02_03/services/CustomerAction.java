package by.it.burov.jd02_03.services;

import by.it.burov.jd02_03.entity.Good;

public interface CustomerAction {
void enteredStore();
Good chooseGood();
void goToQueue();
void goOut();

}