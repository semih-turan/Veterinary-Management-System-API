package dev.patika.veterinarymanagementsystemapi.v1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "doctors")
public class Doctor { // Criteria 8 - Are entities defined correctly?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id", columnDefinition = "serial")
    private long id;

    @Column(name = "doctor_name")
    private String name;

    @Column(name = "doctor_phone", unique = true)
    private String phone;

    @Column(name = "doctor_email", unique = true)
    private String email;

    @Column(name = "doctor_address")
    private String address;

    @Column(name = "doctor_city")
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // Criteria 9 - Are the relationships between entities (@OneToMany, @ManyToOne, @ManyToMany etc.) defined correctly?
    private List<Appointment> appointments;

    @JsonIgnore
    @OneToMany(mappedBy = "doctors", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // Criteria 9 - Are the relationships between entities (@OneToMany, @ManyToOne, @ManyToMany etc.) defined correctly?
    private List<AvailableDate> availableDates;

}
