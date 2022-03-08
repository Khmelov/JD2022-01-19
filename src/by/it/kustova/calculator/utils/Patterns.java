package by.it.kustova.calculator.utils;

public class Patterns {

    private Patterns() {
    }

    public static final String SPACES = "\\s+";
    public static final String OPERATION = "(?<=[^-+*/=,{ ])[-+*/=()]+";
    public static final String SCALAR = "-?\\d+(\\.\\d+)?";
    public static final String VECTOR = "\\{"+SCALAR+"((,[\s]?)"+SCALAR+")*}";
    public static final String MATRIX = "\\{"+VECTOR+"((,[\s]?)"+VECTOR+")*}";

}
