package by.it.yushkevich.jd02_05;

import by.it.yushkevich.jd02_05.constants.Messages;
import by.it.yushkevich.jd02_05.constants.User;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class TaskA {


    public static void main(String[] args) {
        ResourceManager lang = ResourceManager.INSTANCE;
        Locale locale = null;

        Scanner scanner = new Scanner(System.in);
        String choseLanguage = scanner.nextLine();
        switch (choseLanguage) {

            case "en":
                locale = new Locale("en", "US");
                break;
            case "ru":
                locale = new Locale("ru", "RU");
                break;
            case "be":
                locale = new Locale("be", "BY");
                break;
            default:
                System.out.println("Please input correct info en / ru / be");
        }

        lang.set(locale);


        if (args.length == 2) {
            locale = new Locale(args[0], args[1]); // не нашел локаль белорусскую, поэтому подгружает либо язык системы
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



        LocalDateTime localTime = LocalDateTime.now();

        ZoneId zoneId = ZoneId.of(lang.get(Messages.ZONE));
        ZonedDateTime fullTime = ZonedDateTime.of(localTime, zoneId);
        System.out.println(fullTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM.yyyy HH:mm:ss z").localizedBy(locale);//подсомтрел
        String format = fullTime.format(formatter);
        System.out.println(format);


    }
}
