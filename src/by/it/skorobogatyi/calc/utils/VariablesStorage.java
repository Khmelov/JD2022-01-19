package by.it.skorobogatyi.calc.utils;

import by.it.skorobogatyi.calc.variables.AbstractVar;

import java.util.*;

public class VariablesStorage {

    public static HashMap<String, AbstractVar> variables = new HashMap<>();

    public static String printVar() {

        StringBuilder stringBuilder = new StringBuilder();
        Set<Map.Entry<String, AbstractVar>> entrySet = variables.entrySet();

        for (Map.Entry<String, AbstractVar> entry : entrySet) {
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static String sortVar() {

        StringBuilder stringBuilder = new StringBuilder();
        SortedMap<String, AbstractVar> sortedMap = new TreeMap<>(variables);
        Set<Map.Entry<String, AbstractVar>> entries = sortedMap.entrySet();

        for (Map.Entry<String, AbstractVar> entry : entries) {
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
