package dev.patika.veterinarymanagementsystemapi.v1.dto.request.doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DoctorSaveRequest {

    @NotNull(message = "Doctor name cannot be null.")
    private String name;

    @NotNull(message = "Doctor phone cannot be null.")
    private String phone;

    @NotNull(message = "Doctor email cannot be null.")
    @Email(message = "Email format is wrong. Format : email@email.com")
    private String email;

    @NotNull(message = "Doctor address cannot be null.")
    private String address;

    @NotNull(message = "Doctor city cannot be null.")
    private String city;

}
