package dev.patika.veterinarymanagementsystemapi.v1.business.concretes;

import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.AvailableDateService;
import dev.patika.veterinarymanagementsystemapi.v1.core.config.modelMapper.ModelMapperService;
import dev.patika.veterinarymanagementsystemapi.v1.core.exception.AppointmentAlreadyExists;
import dev.patika.veterinarymanagementsystemapi.v1.core.exception.NotFoundDoctorException;
import dev.patika.veterinarymanagementsystemapi.v1.core.exception.NotFoundException;
import dev.patika.veterinarymanagementsystemapi.v1.core.exception.SameValuesException;
import dev.patika.veterinarymanagementsystemapi.v1.core.utils.Message;
import dev.patika.veterinarymanagementsystemapi.v1.dao.AppointmentRepository;
import dev.patika.veterinarymanagementsystemapi.v1.dao.AvailableRepository;
import dev.patika.veterinarymanagementsystemapi.v1.dao.DoctorRepository;
import dev.patika.veterinarymanagementsystemapi.v1.entities.AvailableDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvailableDateManager implements AvailableDateService {

    private final AvailableRepository availableRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    @Override
    public AvailableDate save(AvailableDate availableDate) {
        if(doctorRepository.findById(availableDate.getDoctors().getId()).isEmpty()){
            throw new NotFoundDoctorException(Message.NOT_FOUND_DOCTOR);
        }
        if(availableRepository.existsByDateAndDoctors_Id(availableDate.getDate(),availableDate.getDoctors().getId())){
            throw new SameValuesException(Message.SAME_VALUES);
        }
        return availableRepository.save(availableDate);
    }

    @Override
    public AvailableDate getById(long id) {
        return availableRepository.findById(id).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND_ID));
    }

    @Override
    public AvailableDate update(AvailableDate availableDate) {
        if(appointmentRepository.existsByAvailableDate_Id(availableDate.getId())){
            throw new AppointmentAlreadyExists(Message.EXISTING_APPOINTMENT);
        }
        availableRepository.findById(availableDate.getId()).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND_ID));
        if(doctorRepository.findById(availableDate.getDoctors().getId()).isEmpty()){
            throw new NotFoundDoctorException(Message.NOT_FOUND_DOCTOR);
        }
        if(availableRepository.existsByDateAndDoctors_Id(availableDate.getDate(),availableDate.getDoctors().getId())){
            throw new SameValuesException(Message.SAME_VALUES);
        }
        return availableRepository.save(availableDate);
    }

    @Override
    public boolean deleteById(long id) {
        if(appointmentRepository.existsByAvailableDate_Id(id)){
            throw new AppointmentAlreadyExists(Message.EXISTING_APPOINTMENT);
        }
        availableRepository.delete(getById(id));
        return true;
    }

    @Override
    public boolean forceDeleteById(long id) {
        availableRepository.delete(getById(id));
        return true;
    }
}
