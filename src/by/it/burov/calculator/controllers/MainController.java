package by.it.burov.calculator.controllers;

import by.it.burov.calculator.ecxeptions.ApplicationException;
import by.it.burov.calculator.ecxeptions.CalcException;
import by.it.burov.calculator.model.Var;
import by.it.burov.calculator.services.CalcService;

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

