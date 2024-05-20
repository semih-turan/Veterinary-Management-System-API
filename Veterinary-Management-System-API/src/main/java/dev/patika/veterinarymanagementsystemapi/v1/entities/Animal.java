package dev.patika.veterinarymanagementsystemapi.v1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id", columnDefinition = "serial")
    private long id;

    @Column(name = "animal_name")
    private String name;

    @Column(name = "animal_species")
    private String species;

    @Column(name = "animal_breed")
    private String breed;

    @Column(name = "animal_gender")
    private String gender;

    @Column(name = "animal_color")
    private String color;

    @Column(name = "animal_date_of_birth")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.EAGER) // Section - 9 : Relationships between entities
    @JoinColumn(name = "animal_customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    // Section - 9 : Relationships between entities
    private List<Vaccine> vaccines;

    @JsonIgnore
    @OneToMany(mappedBy = "animal", cascade = CascadeType.REMOVE) // Section - 9 : Relationships between entities
    private List<Appointment> appointments;

}