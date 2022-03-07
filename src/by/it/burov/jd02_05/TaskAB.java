package by.it.burov.jd02_05;

import by.it.burov.jd02_05.resources.contains.Messages;
import by.it.burov.jd02_05.resources.contains.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class TaskAB {


    public static void main(String[] args) {
        ResourceManager resourceManager = ResourceManager.INSTANCE;
        Locale locale = null;
        Scanner scanner = new Scanner(System.in);
        String choosingLocale = scanner.nextLine();
        switch (choosingLocale) {
            case "be" -> locale = new Locale("be", "BY");
            case "ru" -> locale = new Locale("ru", "RU");
            case "en" -> locale = new Locale("en", "US");
        }
        resourceManager.set(locale);

        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
            resourceManager.set(locale);
        }

        System.out.printf("%s\n%s\n%s %s %s\n",
                resourceManager.get(Messages.GREETINGS),
                resourceManager.get(Messages.QUESTION),
                resourceManager.get(User.INFO),
                resourceManager.get(User.FIRSTNAME),
                resourceManager.get(User.LASTNAME));

        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.of(resourceManager.get("zone.time"));
        ZonedDateTime fullTime = ZonedDateTime.of(localDateTime,zone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss z").localizedBy(locale);
        String dateToString = fullTime.format(formatter);
        System.out.println(dateToString);
    }


}
