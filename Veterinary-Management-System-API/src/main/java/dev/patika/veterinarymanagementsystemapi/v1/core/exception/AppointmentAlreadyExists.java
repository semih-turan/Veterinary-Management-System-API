package dev.patika.veterinarymanagementsystemapi.v1.core.exception;

public class AppointmentAlreadyExists extends RuntimeException{

    public AppointmentAlreadyExists(String message) {
        super(message);
    }

}