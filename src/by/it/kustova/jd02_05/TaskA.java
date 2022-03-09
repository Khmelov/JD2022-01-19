package by.it.kustova.jd02_05;

import by.it.kustova.jd02_05.constants.Message;
import by.it.kustova.jd02_05.constants.User;

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
        System.out.println("Введите язык: be-белурасский, ru-русский, en-английский");
        String chooseLang = scanner.nextLine();
        switch (chooseLang) {
            case "be" -> {
                locale = new Locale("be", "BY");
                break;
            }
            case "ru" -> {
                locale = new Locale("ru", "RU");
                break;
            }
            case "en" -> {
                locale = new Locale("en", "US");
                break;
            }
        }
        lang.set(locale);
        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
            lang.set(locale);
        }
        System.out.printf("%s\n%s\n%s %s %s\n",
                lang.get(Message.WELCOME),
                lang.get(Message.QUESTION),
                lang.get(User.INFO),
                lang.get(User.FIRST_NAME),
                lang.get(User.LAST_NAME)
        );

        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.of("UTC+3");
        ZonedDateTime time = ZonedDateTime.of(localDateTime, zone);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MM yyyy HH.mm.ss").localizedBy(locale);
        String format = time.format(dateTimeFormatter);
        System.out.println(format);


    }
}
