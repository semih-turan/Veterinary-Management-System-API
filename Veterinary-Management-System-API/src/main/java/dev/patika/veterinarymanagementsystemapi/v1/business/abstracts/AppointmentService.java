package dev.patika.veterinarymanagementsystemapi.v1.business.abstracts;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Appointment;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Doctor;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    Appointment save(Appointment appointment);
    Appointment getById(long id);
    Appointment update(Appointment appointment);
    boolean deleteById(long id);

    List<Appointment> findAppointmentsByDateRangeAndDoctor(LocalDateTime startDate, LocalDateTime endDate, Doctor doctor);
    List<Appointment> findAppointmentsByDateRangeAndAnimal(LocalDateTime startDate, LocalDateTime endDate, Animal animal);
}
