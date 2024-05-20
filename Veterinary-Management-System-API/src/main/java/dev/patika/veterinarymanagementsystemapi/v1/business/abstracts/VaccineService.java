package dev.patika.veterinarymanagementsystemapi.v1.business.abstracts;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Vaccine;

import java.time.LocalDate;
import java.util.List;

public interface VaccineService {
    Vaccine save(Vaccine vaccine);
    Vaccine getById(long id);
    Vaccine update(Vaccine vaccine);
    boolean deleteById(long id);

    Vaccine forceUpdate(Vaccine vaccine);
    List<Vaccine> getAnimalVaccineById(long id);
    List<Vaccine> findVaccinesByDateRange(LocalDate starDate, LocalDate endDate);
}
