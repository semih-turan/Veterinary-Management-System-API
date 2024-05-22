package dev.patika.veterinarymanagementsystemapi.v1.core.exception;

public class AppointmentConflictException extends RuntimeException{ // Criteria 25 - Is Exception used (such as throwing an error if there is no data in the id entered in update, delete operations with id)


    public AppointmentConflictException(String message) {
        super(message);
    }

}
