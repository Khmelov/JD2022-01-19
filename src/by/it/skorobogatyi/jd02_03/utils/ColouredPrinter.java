package by.it.skorobogatyi.jd02_03.utils;

import static by.it.skorobogatyi.jd02_02.utils.Constants.*;

public class ColouredPrinter {

    public static void yellowColourPrint(String message) {
        System.out.println(YELLOW_COLOUR + message + FORMATTING_END);
    }

    public static void blueColourPrint(String message) {
        System.out.println(BLUE_COLOUR + message + FORMATTING_END);

    }
}
