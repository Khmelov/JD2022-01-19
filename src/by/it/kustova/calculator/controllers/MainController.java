package by.it.kustova.calculator.controllers;

import by.it.kustova.calculator.exceptions.ApplacitionException;
import by.it.kustova.calculator.exceptions.CalcException;
import by.it.kustova.calculator.model.Var;
import by.it.kustova.calculator.services.CalcService;

public class MainController {
    private final CalcService calcService;

    public MainController(CalcService calcService) {
        this.calcService = calcService;
    }

    public Var process(String request) {
        try {
            return (Var) calcService.calc(request);
        } catch (CalcException e) {
            throw new ApplacitionException(e);
        }
    }
}
