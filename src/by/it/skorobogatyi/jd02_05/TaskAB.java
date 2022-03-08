package by.it.skorobogatyi.jd02_05;

import by.it.skorobogatyi.jd02_05.constants.Messages;
import by.it.skorobogatyi.jd02_05.constants.User;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class TaskAB {

    public static void main(String[] args) {

        ResourceManager lang = ResourceManager.INSTANCE;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose language | Выберите язык | Выберыце мову:");

        String language = scanner.next();

        switch (language) {
            case "ru" -> lang.set(new Locale("ru", "RU"));
            case "be" -> lang.set(new Locale("be", "BY"));
            default -> lang.set(new Locale("en", "US"));
        }

        if (args.length >= 2) {
            Locale locale = new Locale(args[0], args[1]);
            lang.set(locale);
        }

        ZonedDateTime currentTime = ZonedDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH-mm-ss VV");
        String timeForPrint = dateTimeFormatter.format(currentTime);

        System.out.printf("%s %n%s %n%s %s %s %n%s %s ",
                lang.get(Messages.WELCOME),
                lang.get(Messages.QUESTION),
                lang.get(User.INFO),
                lang.get(User.FIRST_NAME),
                lang.get(User.LAST_NAME),
                lang.get(Messages.DATE),
                timeForPrint
        );
    }
}
