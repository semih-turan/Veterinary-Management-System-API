package dev.patika.veterinarymanagementsystemapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="Veterinary-Management-System-API",version = "1.0",description = "VeterinaryManagementSystemApp"))

public class VeterinaryManagementSystemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VeterinaryManagementSystemApiApplication.class, args);
    }

}
