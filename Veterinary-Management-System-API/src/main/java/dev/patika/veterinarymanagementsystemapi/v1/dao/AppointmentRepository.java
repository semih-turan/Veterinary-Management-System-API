package dev.patika.veterinarymanagementsystemapi.v1.dao;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Appointment;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByDoctorId(long id);
    boolean existsByDateTime(LocalDateTime dateTime);
    boolean existsByDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
    boolean existsByAvailableDateId(long id);
    boolean existsByDoctorIdAndAnimalId(long doctorId, long animalId);
    List<Appointment> findByDateTimeBetweenAndDoctor(LocalDateTime startDate, LocalDateTime endDate, Doctor doctor);
    List<Appointment> findByDateTimeBetweenAndAnimal(LocalDateTime startDate, LocalDateTime endDate, Animal animal);

}
