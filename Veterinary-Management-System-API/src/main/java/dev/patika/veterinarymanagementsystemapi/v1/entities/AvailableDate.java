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
@Table(name = "availableDate")
public class AvailableDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available_date_id")
    private long id;

    @Column(name = "available_date")
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER) // Section - 9 : Relationships between entities
    @JoinColumn(name = "available_date_doctor_id",referencedColumnName = "doctor_id")
    private Doctor doctors;

    @JsonIgnore
    @OneToMany(mappedBy = "availableDate",cascade = {CascadeType.REMOVE,CascadeType.MERGE},fetch = FetchType.LAZY) // Section - 9 : Relationships between entities
    private List<Appointment> appointments;

}
