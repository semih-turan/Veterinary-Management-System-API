package dev.patika.veterinarymanagementsystemapi.v1.dto.response.appointment;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Doctor;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AppointmentGetAllResponse {

    private LocalDateTime dateTime;
    private Doctor doctor;
    private Animal animal;

}
