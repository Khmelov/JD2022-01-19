package by.it.kharevich.calculator.controllers;

import by.it.kharevich.calculator.exceptions.ApplicationException;
import by.it.kharevich.calculator.exceptions.CalcException;
import by.it.kharevich.calculator.model.Var;
import by.it.kharevich.calculator.services.CalcService;

public class MainController {

    private final CalcService calcService;

    public MainController(CalcService calcService) {
        this.calcService = calcService;
    }

    public Var processCalcService(String request){
        try {
            return calcService.calc(request);
        } catch (CalcException e) {
            throw new ApplicationException(e);
        }
    }
}
