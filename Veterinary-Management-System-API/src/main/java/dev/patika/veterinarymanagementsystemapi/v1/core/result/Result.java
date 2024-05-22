package dev.patika.veterinarymanagementsystemapi.v1.core.result;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Result { // Criteria 26 - Are HTTP status codes used appropriately?

    private boolean status;
    private String message;
    private String httpCode;

}
