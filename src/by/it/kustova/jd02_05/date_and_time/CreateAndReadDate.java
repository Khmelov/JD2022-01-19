package by.it.kustova.jd02_05.date_and_time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateAndReadDate {
    public static void main(String[] args) {
        Date moment= new Date(1546617048666L);
        System.out.println("1. "+moment.getTime()+ " или " +moment);


        Calendar calendar= Calendar.getInstance();
        calendar.set(2019,Calendar.JANUARY,4,18,50,48);
        moment=calendar.getTime();

        System.out.println("2. "+ moment.getTime()+ " или " + moment);

        calendar.set(2019,0,4,18,50,48);
        moment= calendar.getTime();
        System.out.println("3. "+moment.getTime()+ " или "+ moment);

        int[]formats={DateFormat.FULL,DateFormat.LONG,DateFormat.MEDIUM,DateFormat.SHORT};
        for (int dateFormat:formats
             ) {
            System.out.println();
            for (int timeFormat:formats
                 ) {
                DateFormat dateInstance= DateFormat.getDateTimeInstance(dateFormat,timeFormat);
                System.out.println(dateInstance.format(moment));
            }
        }
        System.out.println("\ncustom output");
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        String stringDataAndTime=format.format(moment);
        System.out.println(stringDataAndTime);
        try {
            Date date=format.parse(stringDataAndTime);
            System.out.println(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
