package by.it.kustova.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class l18nSample01 {
    public static void main(String[] args) {
        for (Integer i = 0; i < 3; i++) {
            char j = i.toString().charAt(0);
            String country = "";
            String language = "";
            switch (j) {
                case '1':
                    country = "US";
                    language = "EN";
                    System.out.println("\n" + j + " - английский");
                    break;
                case '2':
                    country = "BY";
                    language = "BE";
                    System.out.println("\n" + j + " - белорусский");
                    break;
                default:
                    System.out.println("\n" + j + " - руссккий");
            }
            Locale current = new Locale(language, country);
            ResourceBundle rb = ResourceBundle.getBundle("by.it.kustova.jd02_05.ok.str", current);
            String s1 = rb.getString("str1");
            System.out.println(s1);
            String s2 = rb.getString("str2");
            System.out.println(s2);
        }
    }
}

