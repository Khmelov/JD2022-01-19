package by.it.yushkevich.jd02_05;

import by.it.yushkevich.jd02_05.resources.ResourceManager;

import java.util.Locale;
import java.util.ResourceBundle;

public class TaskA {


    public static void main(String[] args) {
        ResourceManager lang = ResourceManager.INSTANCE;
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]); // не нашел локаль белорусскую, поэтому подгружает либо язык системы
            // а если выставили по умолчанию, то язык по дефолту, если его тоже нет то тогда файл лагувиж
            lang.set(locale);
        }

        System.out.printf("%s\n%s\n%s %s %s \n",
                lang.get("messages.welcome"),
                lang.get("messages.question"),
                lang.get("user.info"),
                lang.get("user.firstname"),
                lang.get("user.lastname")
        );


    }
}
