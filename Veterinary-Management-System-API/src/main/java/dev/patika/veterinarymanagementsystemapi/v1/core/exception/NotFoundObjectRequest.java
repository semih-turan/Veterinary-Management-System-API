package dev.patika.veterinarymanagementsystemapi.v1.core.exception;

public class NotFoundObjectRequest extends RuntimeException {

    public NotFoundObjectRequest(String message) {
        super(message);
    }

}
