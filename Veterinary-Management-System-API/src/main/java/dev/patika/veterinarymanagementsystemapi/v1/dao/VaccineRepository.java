package dev.patika.veterinarymanagementsystemapi.v1.dao;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

    boolean existsVaccineByCodeAndNameAndAnimalId(String code, String name, long id);
    boolean existsByEndDate(LocalDate endDate);
    long countVaccineByNameAndCodeAndAnimalId(String name, String code, long animalId);
    List<Vaccine> findByAnimalId(long animalId);
    List<Vaccine> findByEndDateBetween(LocalDate firstDate, LocalDate endDate);
    List<Vaccine> findByEndDateAfterOrderByEndDate(LocalDate endDate);
    Vaccine findByStartDate(LocalDate startDate);

}
