package by.it.yushkevich.calculator;

import java.io.Serial;

public class CalcException extends Exception{
    @Serial
    private static final long serialVersionUID = 7921605211738398468L;

    public CalcException() {
    }

    public CalcException(String message) {
        super("ERROR: "+message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
