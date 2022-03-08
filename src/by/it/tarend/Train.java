package by.it.tarend;


import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Train {
    public static void main(String[] args) {

        ArrayList<Integer> ar = new ArrayList<Integer>();
        List temp = ar;
        temp.add(new java.util.Date());

        System.out.println(ar.get(0));

    }
}
