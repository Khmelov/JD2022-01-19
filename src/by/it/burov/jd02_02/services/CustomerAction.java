package by.it.burov.jd02_02.services;

import by.it.burov.jd02_02.entity.Good;

public interface CustomerAction {
void enteredStore();
Good chooseGood();
void goToQueue();
void goOut();

}