package dev.patika.veterinarymanagementsystemapi.v1.core.exception;

public class AppointmentConflictException extends RuntimeException{

    public AppointmentConflictException(String message) {
        super(message);
    }

}
