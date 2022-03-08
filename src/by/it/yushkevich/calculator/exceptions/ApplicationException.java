package by.it.yushkevich.calculator.exceptions;

import java.io.Serial;

@SuppressWarnings("unused")
public class ApplicationException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -1541440925442545840L;

    public ApplicationException() {
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }
}
