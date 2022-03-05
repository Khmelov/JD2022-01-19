package by.it.burov.calculator;


import by.it.burov.calculator.controllers.MainController;
import by.it.burov.calculator.model.Var;
import by.it.burov.calculator.services.CalcService;
import by.it.burov.calculator.view.Printer;

import java.util.Scanner;

public class Application {
    private static final String END = "end";
    private final Printer printer;
    private final CalcService calcService;
    private final MainController controller;


    public Application(Printer printer, CalcService parser, MainController controller) {
        this.printer = printer;
        this.calcService = parser;
        this.controller = controller;
    }

    public void run(){
        System.out.println("App started");
        Scanner scan = new Scanner(System.in);
        while (true){
            String line = scan.nextLine();
            if(!line.equals(END)){
                try {
                    Var result = controller.process(line);
                    printer.print(result);
                }catch (ArithmeticException e){
                    printer.print(e);
                }
            }else{
                System.out.println("App finished");
                break;
            }
        }
    }
}
