package dev.patika.veterinarymanagementsystemapi.v1.dto.request.vaccine;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VaccineSaveRequest {

    @NotNull(message = "Vaccine name cannot be null.")
    private String name;

    @NotNull(message = "Vaccine code cannot be null.")
    private String code;

    @NotNull(message = "Vaccine start date cannot be null.")
    private LocalDate startDate;

    @NotNull(message = "Vaccine end date cannot be null.")
    private LocalDate endDate;

    @NotNull(message = "Animal ID cannot be null.")
    private Animal animal;

}
