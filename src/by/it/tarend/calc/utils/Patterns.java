package by.it.tarend.calc.utils;

public class Patterns {

    private Patterns() { // что бы никто не мог пользоваться делаем приватный конструктор
    }
    // 2.0322+2 1.04*5.9{-1, -2.2, 3}+{1,1,1}  {{1,1,1},{2,2,2}} + {{1,1,1}, {3,3,3}}
    // {{5.0, 7.0, 9.0}, {9.0, 7.0, 5.0}}
    // -3+-1.3--2.5*-4+{-1,-2.3,-3}
    // {1.0,2.0,3.0}
    // C=B+(A*2)
    // D=((C-0.15)-20)/(7-5)
    // E={2,3}*(D/2)
    // \{(-?[0-9]+(\.[0-9]*)?)(,-?[0-9]+(\.[0-9]*)?)*\} - vector
    // \{(\{(-?[0-9]+(\.[0-9]*)?)(,-?[0-9]+(\.[0-9]*)?)*\})(,\{(-?[0-9]+(\.[0-9]*)?)(,-?[0-9]+(\.[0-9]*)?)*\})*\} - matrix

    public static final String OPERATION = "(?<=[^-+*/=,{ ])[-+*/=]";
    public static final String SPACES = "//s";
    public static final String BRACES = "[\\(\\)]+";
    public static final String EXPRESSION_IN_BRACES = "";
    public static final String SCALAR = "-?[0-9]+(\\.[0-9]*)?";
    public static final String VECTOR = "\\{("+ SCALAR +")(," + SCALAR +")*\\}";
    public static final String MATRIX = "\\{("+ VECTOR +")(," + VECTOR +")*\\}";
}
