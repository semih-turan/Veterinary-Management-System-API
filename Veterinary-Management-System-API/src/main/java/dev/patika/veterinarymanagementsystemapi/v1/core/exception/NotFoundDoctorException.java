package dev.patika.veterinarymanagementsystemapi.v1.core.exception;

public class NotFoundDoctorException extends RuntimeException {

    public NotFoundDoctorException(String message) {
        super(message);
    }

}
