package dev.patika.veterinarymanagementsystemapi.v1.business.concretes;

import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.DoctorService;
import dev.patika.veterinarymanagementsystemapi.v1.core.exception.ForUpdateNotFoundIdException;
import dev.patika.veterinarymanagementsystemapi.v1.core.exception.NotFoundException;
import dev.patika.veterinarymanagementsystemapi.v1.core.exception.NotUniqueValues;
import dev.patika.veterinarymanagementsystemapi.v1.core.utils.Message;
import dev.patika.veterinarymanagementsystemapi.v1.dao.DoctorRepository;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorManager implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor save(Doctor doctor) {
        if(doctorRepository.existsByEmailOrPhone(doctor.getEmail(),doctor.getPhone())){
            throw new NotUniqueValues(Message.NOT_UNIQUE);
        }
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getById(long id) {
        return doctorRepository.findById(id).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND_ID));
    }

    @Override
    public Doctor update(Doctor doctor) {
        doctorRepository.findById(doctor.getId()).orElseThrow(()-> new ForUpdateNotFoundIdException(Message.UPDATE_NOT_FOUND_ID));
        return doctorRepository.save(doctor);
    }

    @Override
    public boolean deleteById(long id) {
        doctorRepository.delete(getById(id));
        return true;
    }
}
