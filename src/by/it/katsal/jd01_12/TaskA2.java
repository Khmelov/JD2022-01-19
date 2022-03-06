package by.it.katsal.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] left = {1, 2, 3, 4, 4, 4, 5, 5, 5, 6, 6};
        List<Integer> listLeft = Arrays.asList(left);
        List<Integer> listRight = Arrays.asList(4, 4, 5, 5, 9, 9, 8, 7, 6, 5, 4, 6);
        Set<Integer> leftSet = new HashSet<>(listLeft);
        Set<Integer> rightSet = new TreeSet<>(listRight ) ;
        System.out.printf("Left set=%s%n", leftSet );
        System.out.printf("Right set=%s%n", rightSet );

        Set<Integer> union = getUnion(leftSet,rightSet );
        System.out.printf("union set=%s%n", union  );
        System.out.printf("Left set=%s%n", leftSet );
        System.out.printf("Right set=%s%n", rightSet );


        Set<Integer> cross = getCross(leftSet,rightSet );
        System.out.printf("cross set=%s%n", cross );
        System.out.printf("Left set=%s%n", leftSet );
        System.out.printf("Right set=%s%n", rightSet );
    }

    private static Set<Integer> getUnion(Set<Integer> leftSet, Set<Integer> rightSet) {
        HashSet<Integer> result = new HashSet<>(leftSet);
        result.addAll(rightSet);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> leftSet, Set<Integer> rightSet) {

        HashSet<Integer> result = new HashSet<>(leftSet);
        result.retainAll(rightSet);
        return result;
    }
}



