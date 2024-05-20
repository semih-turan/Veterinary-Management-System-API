package dev.patika.veterinarymanagementsystemapi.v1.core.exception;

public class NotFoundCustomerException extends RuntimeException {

    public NotFoundCustomerException(String message) {
        super(message);
    }

}
