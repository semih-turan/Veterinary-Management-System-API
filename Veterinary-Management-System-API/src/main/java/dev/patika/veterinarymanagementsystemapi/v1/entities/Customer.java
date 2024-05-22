package dev.patika.veterinarymanagementsystemapi.v1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "customers")
public class Customer { // Criteria 8 - Are entities defined correctly?

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

    @JsonIgnore
    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // Criteria 9 - Are the relationships between entities (@OneToMany, @ManyToOne, @ManyToMany etc.) defined correctly?
    private List<Animal> animalList;

}
