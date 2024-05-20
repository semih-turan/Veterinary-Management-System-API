package dev.patika.veterinarymanagementsystemapi.v1.dto.response.vaccine;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VaccineResponse {

    private String name;
    private String code;
    private LocalDate startDate;
    private LocalDate endDate;

}
