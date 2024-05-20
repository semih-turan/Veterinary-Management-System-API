package dev.patika.veterinarymanagementsystemapi.v1.dto.response.availableDate;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Doctor;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AvailableDateGetAllResponse {

    private LocalDate date;
    private Doctor doctors;

}
