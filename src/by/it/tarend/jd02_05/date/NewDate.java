package by.it.tarend.jd02_05.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class NewDate {
    public static void main(String[] args) {
        LocalDateTime localNowTime = LocalDateTime.now();
        System.out.println(localNowTime);

        Instant gmtNow = Instant.now();
        System.out.println(gmtNow);

        ZoneId minsk = ZoneId.of("UTC+3");
        ZonedDateTime fullTimeWithZone = ZonedDateTime.of(localNowTime, minsk);
        System.out.println(fullTimeWithZone);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MMMM.yyyy HH.mm.ss");
        String formattedFullTime = fullTimeWithZone.format(dateTimeFormatter);
        System.out.println(formattedFullTime);

    }
}
