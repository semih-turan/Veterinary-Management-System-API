package dev.patika.veterinarymanagementsystemapi.v1.dto.request.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerSaveRequest {

    @NotNull(message = "Customer name cannot be null.")
    private String name;

    @NotNull(message = "Customer phone cannot be null.")
    private String phone;

    @NotNull(message = "Customer email cannot be null.")
    @Email(message = "Email format is wrong. Format : email@email.com")
    private String email;

    @NotNull(message = "Customer address cannot be null.")
    private String address;

    @NotNull(message = "Customer city cannot be null.")
    private String city;

}
