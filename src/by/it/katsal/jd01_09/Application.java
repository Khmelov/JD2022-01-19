package by.it.katsal.jd01_09;


import java.util.Scanner;

public class Application {

    private static final String END = "end";
    private final Printer printer;
    private final Parcer parcer;


    public Application(Printer printer, Parcer parcer) {
        this.printer = printer;
        this.parcer = parcer;
    }

    public void run(){
        System.out.println("App started");
        Scanner scan = new Scanner(System.in);
        while (true){
            String line = scan.nextLine();
            if(!line.equals(END)){
                Var result = parcer.calc(line);
                printer.print(result);
            }else{
                System.out.println("App finished");

                break;

            }
        }
    }
}

