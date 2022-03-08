package by.it.yushkevich.jd02_05;

import by.it.yushkevich.jd02_05.constants.Messages;
import by.it.yushkevich.jd02_05.constants.User;

import java.util.Locale;

public class TaskA {


    public static void main(String[] args) {
        ResourceManager lang = ResourceManager.INSTANCE;
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]); // не нашел локаль белорусскую, поэтому подгружает либо язык системы
            // а если выставили по умолчанию, то язык по дефолту, если его тоже нет то тогда файл лагувиж
            lang.set(locale);
        }

        System.out.printf("%s\n%s\n%s %s %s \n",
                lang.get(Messages.WELCOME),
                lang.get(Messages.QUESTION),
                lang.get(User.INFO),
                lang.get(User.FIRSTNAME),
                lang.get(User.LASTNAME)
        );
    }
}
