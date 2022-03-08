package by.it.kharevich.calculator.exceptions;

import by.it.kharevich.calculator.resources.ResourceManager;
import by.it.kharevich.calculator.utils.ExceptionMessages;

public class CalcException extends Exception {

    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super(ResourceManager.INSTANCE.get(ExceptionMessages.MESSAGE_1) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(ResourceManager.INSTANCE.get(ExceptionMessages.MESSAGE_1) + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
