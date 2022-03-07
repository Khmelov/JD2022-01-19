package by.it.kharevich.jd02_05;

import by.it.kharevich.jd02_05.constants.Messages;
import by.it.kharevich.jd02_05.constants.PatternTime;
import by.it.kharevich.jd02_05.constants.User;
import by.it.kharevich.jd02_05.resources.ResourceManager;
import by.it.kharevich.jd02_05.resources.ResourceTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TaskB {

    public static void main(String[] args) {
        ResourceManager languageManager = ResourceManager.INSTANCE;
        ResourceTime resourceTime = ResourceTime.TIME;
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            languageManager.set(locale);
            resourceTime.set(locale);
        }

        System.out.printf("%s\n%s\n%s %s %s\n",
                languageManager.get(Messages.WELCOME),
                languageManager.get(Messages.QUESTION),
                languageManager.get(User.USER_INFO),
                languageManager.get(User.FIRSTNAME),
                languageManager.get(User.LASTNAME));

        System.out.println("-------------------------------------------");

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(resourceTime.get(PatternTime.TIME));
        String format = localDateTime.format(dateTimeFormatter);
        System.out.println(format);
    }
}
