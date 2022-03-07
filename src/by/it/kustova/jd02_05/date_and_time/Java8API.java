package by.it.kustova.jd02_05.date_and_time;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Java8API {

    @Test
    public void go() throws InterruptedException {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());
        System.out.println(clock.instant());
        Thread.sleep(1500);
        System.out.println(clock.millis());
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("Europe/Moscow"));
        System.out.println(zdt);
    }
}
