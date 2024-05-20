package dev.patika.veterinarymanagementsystemapi.v1.dto.response.customer;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerListResponse {

    List<Animal> animalList;

}
