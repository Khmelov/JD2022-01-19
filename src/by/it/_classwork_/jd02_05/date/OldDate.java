package by.it._classwork_.jd02_05.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OldDate {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022,Calendar.MARCH,4,12,22,0);
        Date time = calendar.getTime();
        System.out.println(time);
        long millis = time.getTime();
        Date date1 = new Date(millis);
        System.out.println(date1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
        String str = simpleDateFormat.format(date1);
        System.out.println(str);
    }
}
