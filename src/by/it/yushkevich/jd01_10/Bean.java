package by.it.yushkevich.jd01_10;

public class Bean {

    @Param(a=10,b=20)
    static double sum(int first, int second) {
        return first + second;
    }

    double max(int first, int second) {
        return Math.max(first, second); //first > second ? first : second;
    }

    @Param(a=10,b=20)
    static double min(int first, int second) {
        return Math.min(first, second);
    }

    @Param(a=10,b=20)
    double avg(int first, int second) {
        return (first + second) / 2.0;
    }
}
