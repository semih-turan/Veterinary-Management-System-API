package dev.patika.veterinarymanagementsystemapi.v1.dao;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Appointment;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByDoctor_Id(long id);
    boolean existsByDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
    boolean existsByAvailableDate_Id(long id);
    boolean existsByDoctor_IdAndAnimal_Id(long doctor_id, long animal_id);
    List<Appointment> findByDateTimeBetweenAndDoctor(LocalDateTime startDate, LocalDateTime endDate, Doctor doctor);
    List<Appointment> findByDateTimeBetweenAndAnimal(LocalDateTime startDate, LocalDateTime endDate, Animal animal);
}
