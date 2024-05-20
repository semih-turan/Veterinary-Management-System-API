package dev.patika.veterinarymanagementsystemapi.v1.dto.response.availableDate;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AvailableDateResponse {

    private LocalDate date;

}
