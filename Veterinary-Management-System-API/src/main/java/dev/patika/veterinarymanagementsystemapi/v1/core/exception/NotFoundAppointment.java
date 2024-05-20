package dev.patika.veterinarymanagementsystemapi.v1.core.exception;

public class NotFoundAppointment extends RuntimeException {

    public NotFoundAppointment(String message) {
        super(message);
    }

}
