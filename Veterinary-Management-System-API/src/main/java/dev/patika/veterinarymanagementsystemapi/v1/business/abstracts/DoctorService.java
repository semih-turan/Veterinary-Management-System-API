package dev.patika.veterinarymanagementsystemapi.v1.business.abstracts;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Doctor;

public interface DoctorService {
    Doctor save(Doctor doctor);
    Doctor getById(long id);
    Doctor update(Doctor doctor);
    boolean deleteById(long id);
}
