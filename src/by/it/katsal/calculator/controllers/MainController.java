package by.it.katsal.calculator.controllers;

import by.it.katsal.calculator.exceptions.ApplacitionException;
import by.it.katsal.calculator.exceptions.CalcException;
import by.it.katsal.calculator.model.Var;
import by.it.katsal.calculator.services.CalcService;

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
