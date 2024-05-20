package dev.patika.veterinarymanagementsystemapi.v1.dto.request.availableDate;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Doctor;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AvailableDateSaveRequest {

    @NotNull(message = "Date cannot be null.")
    private LocalDate date;

    @NotNull(message = "Doctor ID cannot be null.")
    private Doctor doctors;

}
