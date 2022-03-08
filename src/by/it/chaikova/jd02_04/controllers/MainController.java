package by.it.chaikova.jd02_04.controllers;

import by.it.chaikova.jd02_04.exceptions.ApplacitionException;
import by.it.chaikova.jd02_04.exceptions.CalcException;
import by.it.chaikova.jd02_04.model.Var;
import by.it.chaikova.jd02_04.services.CalcService;

public class MainController {
    private final CalcService calcService;

    public MainController(CalcService calcService) {
        this.calcService = calcService;
    }

    public Var process(String request) {
        try {
            return calcService.calc(request);
        } catch (CalcException e) {
            throw new ApplacitionException(e);
        }
    }
}
