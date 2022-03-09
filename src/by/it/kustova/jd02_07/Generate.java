package by.it.kustova.jd02_07;

import java.util.Random;

public class Generate {


    public static void main(String[] args) {
        int X = new Random().nextInt(100);
        int Y = new Random().nextInt(100);
        int Z = new Random().nextInt(100);
        int count = 3;
        if (X > Z) {
            System.out.println(X + Y);
        } else {
            System.out.println(Z);
        }
        System.out.println((X + Y + Z) / count);
    }
}
