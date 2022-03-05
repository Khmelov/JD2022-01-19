package by.it.kuzma.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskA2 {
    public static void main(String[] args) {

        Integer[] left = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        Integer[] right = {4, 5, 4, 7, 8, 7, 8, 9, 6};

        List<Integer> leftList = Arrays.asList(left);
        List<Integer> rightList = Arrays.asList(right);
        Set<Integer> leftSet = new HashSet<>(leftList);
        Set<Integer> rightSet = new HashSet<>(rightList);
        System.out.printf("Left set=%s%n",leftSet);
        System.out.printf("Right set=%s%n",rightSet);

        Set<Integer> union = getUnion(leftSet, rightSet);
        System.out.printf("union set=%s%n", union);
        Set<Integer> cross = getCross(leftSet, rightSet);
        System.out.printf("cross set=%s%n", cross);


    }

    private static Set<Integer> getCross(Set<Integer> leftSet, Set<Integer> rightSet) {
        HashSet<Integer> result = new HashSet<>(leftSet);
        result.retainAll(rightSet);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> leftSet, Set<Integer> rightSet) {
        HashSet<Integer> result = new HashSet<>(leftSet);
        result.addAll(rightSet);
        return result;
    }
}
