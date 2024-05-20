package dev.patika.veterinarymanagementsystemapi.v1.dto.response.appointment;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AppointmentResponse {

    private LocalDateTime dateTime;

}
