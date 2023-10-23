package sliit.oop.tour.sliitoop.exception;

public class DatabaseOperationFailException extends RuntimeException{
    public DatabaseOperationFailException() {
        super();
    }

    public DatabaseOperationFailException(String message) {
        super(message);
    }

    public DatabaseOperationFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseOperationFailException(Throwable cause) {
        super(cause);
    }

    protected DatabaseOperationFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
