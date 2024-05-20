package dev.patika.veterinarymanagementsystemapi.v1.dto.response.animal;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Customer;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnimalGetAllResponse {

    private String name;
    private String species;
    private String breed;
    private String gender;
    private String color;
    private LocalDate dateOfBirth;
    private Customer customer;

}
