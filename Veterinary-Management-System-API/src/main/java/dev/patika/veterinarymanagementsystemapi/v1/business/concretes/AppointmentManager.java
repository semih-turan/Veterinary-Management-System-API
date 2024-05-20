package dev.patika.veterinarymanagementsystemapi.v1.business.concretes;

import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.AppointmentService;
import dev.patika.veterinarymanagementsystemapi.v1.core.exception.*;
import dev.patika.veterinarymanagementsystemapi.v1.core.utils.Message;
import dev.patika.veterinarymanagementsystemapi.v1.dao.AnimalRepository;
import dev.patika.veterinarymanagementsystemapi.v1.dao.AppointmentRepository;
import dev.patika.veterinarymanagementsystemapi.v1.dao.AvailableRepository;
import dev.patika.veterinarymanagementsystemapi.v1.dao.DoctorRepository;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Appointment;
import dev.patika.veterinarymanagementsystemapi.v1.entities.AvailableDate;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentManager implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final AvailableRepository availableRepository;
    private final AnimalRepository animalRepository;

    @Override
    public Appointment save(Appointment appointment) {

        if (!appointmentRepository.existsByDoctorIdAndAnimalId(appointment.getDoctor().getId(), appointment.getAnimal().getId())) {
            throw new NotFoundException(Message.NOT_FOUND_ID);
        }

        long availableId = availableRepository.findByAvailableIdInEndDateAndDoctorId(appointment.getDateTime().toLocalDate(), appointment.getDoctor().getId());

        // Check if the available date exists for the specified date and doctor
        if (availableRepository.existsByIdAndDateAndDoctors_Id(availableId, appointment.getDateTime().toLocalDate(), appointment.getDoctor().getId())) {

            // Check for appointment conflicts
            for (int i = 0; i < appointmentRepository.findAll().size(); i++) {
                if (appointmentRepository.existsByDoctorId(appointment.getDoctor().getId())) {
                    if (Duration.between(appointment.getDateTime(), appointmentRepository.findAll().get(i).getDateTime()).toHours() == 0) {
                        throw new AppointmentConflictException(Message.APPOINTMENT_CONFLICT);
                    }
                }
            }
            AvailableDate availableDate = availableRepository.findById(availableId).orElseThrow();
            appointment.setAvailableDate(availableDate);
            return appointmentRepository.save(appointment);
        }
        throw new DoctorDaysConflictException(Message.DAYS_CONFLICT);
    }

    @Override
    public Appointment getById(long id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.NOT_FOUND_ID));
    }

    @Override
    public Appointment update(Appointment appointment) {
        getById(appointment.getId());
        return save(appointment);
    }

    @Override
    public boolean deleteById(long id) {
        appointmentRepository.delete(getById(id));
        return true;
    }

    @Override
    public List<Appointment> findAppointmentsByDateRangeAndDoctor(LocalDateTime startDate, LocalDateTime endDate, Doctor doctor) {
        if (doctorRepository.findById(doctor.getId()).isEmpty()) {
            throw new NotFoundDoctorException(Message.NOT_FOUND_DOCTOR);
        }
        if (!appointmentRepository.existsByDateTimeBetween(startDate, endDate)) {
            throw new NotFoundAppointment(Message.NOT_FOUND_APPOINTMENT);
        }
        return appointmentRepository.findByDateTimeBetweenAndDoctor(startDate, endDate, doctor);
    }

    @Override
    public List<Appointment> findAppointmentsByDateRangeAndAnimal(LocalDateTime startDate, LocalDateTime endDate, Animal animal) {
        if (animalRepository.findById(animal.getId()).isEmpty()) {
            throw new NotFoundAnimalException(Message.NOT_FOUND_ANIMAL);
        }
        if (!appointmentRepository.existsByDateTimeBetween(startDate, endDate)) {
            throw new NotFoundAppointment(Message.NOT_FOUND_APPOINTMENT);
        }
        return appointmentRepository.findByDateTimeBetweenAndAnimal(startDate, endDate, animal);
    }
}
