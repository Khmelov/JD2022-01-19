package by.it.yushkevich.calculator.controllers;

import by.it.yushkevich.calculator.exceptions.ApplicationException;
import by.it.yushkevich.calculator.exceptions.CalcException;
import by.it.yushkevich.calculator.model.Var;
import by.it.yushkevich.calculator.services.CalcService;

public class MainController {
    private final CalcService calcService;

    public MainController(CalcService calcService) {
        this.calcService = calcService;
    }

    public Var process(String request) {
        try {
            return calcService.calc(request);

        } catch (CalcException e) {
            throw new ApplicationException(e);
        }

    }


}
