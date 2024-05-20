package dev.patika.veterinarymanagementsystemapi.v1.core.result;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Result {

    private boolean status;
    private String message;
    private String httpCode;

}
