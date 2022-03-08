package by.it.chaikova.jd02_05;


import by.it.chaikova.jd02_05.constants.Messages;
import by.it.chaikova.jd02_05.constants.User;
import by.it.chaikova.jd02_05.resources.ResourceManager;

import java.util.Locale;

public class TaskA {


    public static void main(String[] args) {
        ResourceManager lang = ResourceManager.INSTANCE;
if (args.length==2) {
    Locale locale = new Locale(args[0], args[1]);
    lang.set(locale);
}
        System.out.printf("%s\n%s\n%s %s\n",
                lang.get(Messages.WELCOME),
                lang.get(Messages.QUESTION),
                lang.get(User.INFO),
                lang.get(User.FIRSTNAME),
                lang.get(User.LASTNAME)
        );

    }
}