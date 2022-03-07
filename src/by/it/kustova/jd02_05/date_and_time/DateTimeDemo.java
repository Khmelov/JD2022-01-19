package by.it.kustova.jd02_05.date_and_time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeDemo {
    public static void main(String[] args) {
        Instant instant= Instant.now();
        System.out.println(instant);
        ZonedDateTime zonedDateTime = ZonedDateTime
                .ofInstant(instant, ZoneId.of("UTC+3"));

        DateTimeFormatter dateTimeFormatter= DateTimeFormatter
                .ofPattern("HH.mm dd.MM.yyyy г.", new Locale("ru"));
        String stringTime= dateTimeFormatter
                .format(zonedDateTime);
        System.out.println(stringTime);

        LocalDateTime localDateTime= LocalDateTime.parse(stringTime,dateTimeFormatter);
        System.out.println(localDateTime);
    }
}
