package by.it.zaretskaya.calculator.controllers;

import by.it.zaretskaya.calculator.exeptions.ApplicationException;
import by.it.zaretskaya.calculator.exeptions.CalcException;
import by.it.zaretskaya.calculator.model.Var;
import by.it.zaretskaya.calculator.service.CalcService;

public class MainController {
    private final CalcService calcService;

    public MainController(CalcService calcService) {
        this.calcService = calcService;
    }

    public Var process(String request){
        try{
            return calcService.calc(request);
        }
        catch (CalcException e){
            throw new ApplicationException(e);
        }
    }
}
