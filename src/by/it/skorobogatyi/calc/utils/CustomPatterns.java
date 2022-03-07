package by.it.skorobogatyi.calc.utils;

public class CustomPatterns {
//-?[\d]+(\.[\d]+)?

    public static final String SPACES = "\\s+";
    public static final String OPERATION = "(?<=[^-+*/=,{ ])[-+*/=]";
    public static final String SCALAR = "-?[\\d]+(\\.[\\d]+)?";
    public static final String VECTOR = "\\{"+SCALAR+"((,)"+SCALAR+")+}";
    public static final String MATRIX = "\\{"+VECTOR+"((,)"+VECTOR+")+}";
    public static final String VARIABLE = "[A-Za-z]";
    public static final String COMMAND_PRINTVAR = "printvar";
    public static final String COMMAND_SORTVAR = "sortvar";



}
