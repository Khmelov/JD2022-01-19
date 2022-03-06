package by.it.skorobogatyi.jd02_05;

import by.it.skorobogatyi.jd02_05.resources.ResourceManager;

import java.util.Locale;

public class TaskA {

    public static void main(String[] args) {

        ResourceManager lang = ResourceManager.INSTANCE;

        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            lang.set(locale);
        }

        System.out.printf("%s %n%s %n%s %s %s",
                lang.get("message.welcome"),
                lang.get("message.question"),
                lang.get("user.info"),
                lang.get("user.firstname"),
                lang.get("user.lastname")
        );

    }
}
