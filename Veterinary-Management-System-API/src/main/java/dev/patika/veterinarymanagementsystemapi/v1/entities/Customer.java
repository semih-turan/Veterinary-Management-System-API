package dev.patika.veterinarymanagementsystemapi.v1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id",columnDefinition = "serial")
    private long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_phone",unique = true)
    private String phone;

    @Email
    @Column(name = "customer_email",unique = true)
    private String email;


    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_city")
    private String city;

}
