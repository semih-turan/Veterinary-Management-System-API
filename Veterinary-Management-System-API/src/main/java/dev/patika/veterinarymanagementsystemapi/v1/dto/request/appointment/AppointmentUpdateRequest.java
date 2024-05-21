package dev.patika.veterinarymanagementsystemapi.v1.dto.request.appointment;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Doctor;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AppointmentUpdateRequest {

    @NotNull(message = "ID cannot be null.")
    private long id;

    @NotNull(message = "Animal ID cannot be null.")
    private Animal animal;

    @NotNull(message = "Doctor ID cannot be null.")
    private Doctor doctor;

    @NotNull(message = "Date Time cannot be null.")
    private LocalDateTime dateTime;

}
