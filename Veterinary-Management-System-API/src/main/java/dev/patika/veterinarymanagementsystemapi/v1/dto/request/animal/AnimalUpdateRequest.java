package dev.patika.veterinarymanagementsystemapi.v1.dto.request.animal;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Customer;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnimalUpdateRequest {
    @NotNull(message = "Animal ID cannot be null.")
    private long id;

    @NotNull(message = "Animal name cannot be null.")
    private String name;

    @NotNull(message = "Animal species cannot be null.")
    private String species;

    @NotNull(message = "Animal breed cannot be null.")
    private String breed;

    @NotNull(message = "Animal gender cannot be null.")
    private String gender;

    @NotNull(message = "Animal color cannot be null.")
    private String color;

    @NotNull(message = "Animal birth date cannot be null.")
    private LocalDate dateOfBirth;

    @NotNull(message = "Animal customer ID cannot be null.")
    private Customer customer;
}
