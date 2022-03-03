package by.it.skorobogatyi.jd02_02.exceptions;

public class StoreException extends RuntimeException{


    public StoreException() {
        super();
    }

    public StoreException(String message) {
        super(message);
    }

    public StoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreException(Throwable cause) {
        super(cause);
    }

    public StoreException(InterruptedException e) {


    }
}
