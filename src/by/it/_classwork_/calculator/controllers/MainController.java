package by.it._classwork_.calculator.controllers;

import by.it._classwork_.calculator.exceptions.ApplacitionException;
import by.it._classwork_.calculator.exceptions.CalcException;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.services.CalcService;

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
