package dev.patika.veterinarymanagementsystemapi.v1.dto.response.vaccine;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VaccineGetAllResponse {

    private String name;
    private String code;
    private LocalDate startDate;
    private LocalDate endDate;
    private Animal animal;

}
