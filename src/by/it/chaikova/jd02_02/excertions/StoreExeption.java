package by.it.chaikova.jd02_02.excertions;

public class StoreExeption extends RuntimeException {
    public StoreExeption() {
    }

    public StoreExeption(String message) {
        super(message);
    }

    public StoreExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreExeption(Throwable cause) {
        super(cause);
    }

    public StoreExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
