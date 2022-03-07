package by.it.tarend.jd02_05;

import by.it.tarend.jd02_05.costants.Message;
import by.it.tarend.jd02_05.costants.User;

import java.util.Locale;

public class TaskA {

    public static void main(String[] args) {
        ResourceManager lang = ResourceManager.INSTANCE;
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            lang.set(locale);
        }
        System.out.printf("%s\n%s\n%s %s %s\n",
                lang.get(Message.WELCOME),
                lang.get(Message.QUESTION),
                lang.get(User.INFO),
                lang.get(User.FIRST_NAME),
                lang.get(User.LAST_NAME)
        );




    }

}
