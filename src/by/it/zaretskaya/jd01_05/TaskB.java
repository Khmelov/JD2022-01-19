package by.it.zaretskaya.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
    step1();
    step2();
    }

    private static void step1() {
        System.out.println("-".repeat(30));
        System.out.println("  A           Y(Sum)");
        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                double temp = pow(7,a) - cos(x);
                y = y + temp;
            }
            System.out.printf("%8.4f   %8.4f%n",a,y);
        }
    }

    private static void step2(){
        System.out.println("-".repeat(30));
        for (double x = -5.5; x<2; x=x+0.5){
            double beta;
            if(x/2>-2 && x/2<=-1){
                beta = sin(pow(x,2));
                double a = log10(abs(beta+2.74));
                System.out.printf("При x/2=%-8.2f  a = %-10f%n",x/2,a);
            }else if(x/2>-1 && x/2<0.2){
                beta = cos(pow(x,2));
                double a = log10(abs(beta+2.74));
                System.out.printf("При x/2=%-8.2f  a = %-10f%n",x/2,a);
            }else if(x/2 == 0.2){
                beta = 1 / tan(pow(x,2));
                double a = log10(abs(beta+2.74));
                System.out.printf("При x/2=%-8.2f  a = %-10f%n",x/2,a);
            }else{
                System.out.printf("При x/2=%-6.2f вычисления не определены%n",x/2);
            }
        }
    }
}
