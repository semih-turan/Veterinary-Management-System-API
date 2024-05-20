package dev.patika.veterinarymanagementsystemapi.v1.dao;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
