package dev.patika.veterinarymanagementsystemapi.v1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "vaccines")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id",columnDefinition = "serial")
    private long id;

    @Column(name = "vaccine_name")
    private String name;

    @Column(name = "vaccine_code")
    private String code;

    @Column(name = "vaccine_protection_start_date")
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @Column(name = "vaccine_protection_end_date")
    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.EAGER) // Section - 9 : Relationships between entities
    @JoinColumn(name = "vaccine_animal_id",referencedColumnName = "animal_id")
    private Animal animal;

}
