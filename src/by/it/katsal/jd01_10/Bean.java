package by.it.katsal.jd01_10;

public class Bean {
    @Param(a=10,b=30)
    double sum(int first, int second){
        return first + second;
    }
    @Param(a=10,b=30)
    double max(int first, int second){
        return Math.max(first, second);
    }
   static  double min(int first, int second){
        return Math.min(first, second );
    }
    @Param(a=10,b=30)
    static  double avg(int first, int second){
        return (first + second)/2d;
    }


}


