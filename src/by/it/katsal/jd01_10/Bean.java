package by.it.katsal.jd01_10;

public class Bean {


    @Param(a=10, b=20)
    static double sum(int first, int second){
        return  first+second;
    }

    @Param(a=10, b=20)
    double max(int first, int second){
        return  Math.max(first, second);
    }

    double avg(int first, int second){
        return  (first+second) / 2d;
    }

    @Param(a=10, b=20)
    static double min(int first, int second){
        return  Math.min(first, second);
    }
}



