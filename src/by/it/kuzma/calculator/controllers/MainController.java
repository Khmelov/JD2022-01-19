package by.it.kuzma.calculator.controllers;

import by.it.kuzma.calculator.exceptions.ApplicationException;
import by.it.kuzma.calculator.exceptions.CalcException;
import by.it.kuzma.calculator.model.Var;
import by.it.kuzma.calculator.servces.CalcService;

public class MainController {

    private final CalcService calcService;

    public MainController(CalcService calcService) {
        this.calcService = calcService;
    }

    public Var process(String request){
        try {
            return calcService.calc(request);
        } catch (CalcException e){
            throw new ApplicationException(e);
        }
    }
}
