package dev.patika.veterinarymanagementsystemapi.v1.dao;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
