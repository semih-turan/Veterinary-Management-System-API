package dev.patika.veterinarymanagementsystemapi.v1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private long id;

    @Column(name = "appointment_date")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER) // Section - 9 : Relationships between entities
    @JoinColumn(name = "appointment_doctor_id",referencedColumnName = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER) // Section - 9 : Relationships between entities
    @JoinColumn(name = "appointment_animal_id",referencedColumnName = "animal_id")
    private Animal animal;

    @ManyToOne(fetch = FetchType.EAGER) // Section - 9 : Relationships between entities
    @JoinColumn(name = "appointment_available_date_id",referencedColumnName = "available_date_id")
    private AvailableDate availableDate;


}
