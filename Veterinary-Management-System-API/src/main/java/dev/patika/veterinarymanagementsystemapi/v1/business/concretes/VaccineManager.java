package dev.patika.veterinarymanagementsystemapi.v1.business.concretes;

import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.VaccineService;
import dev.patika.veterinarymanagementsystemapi.v1.dao.AnimalRepository;
import dev.patika.veterinarymanagementsystemapi.v1.dao.VaccineRepository;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Vaccine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VaccineManager implements VaccineService {
    private final VaccineRepository vaccineRepository;
    private final AnimalRepository animalRepository;

    @Override
    public Vaccine save(Vaccine vaccine) {
        return null;
    }

    @Override
    public Vaccine getById(long id) {
        return null;
    }

    @Override
    public Vaccine update(Vaccine vaccine) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Vaccine forceUpdate(Vaccine vaccine) {
        return null;
    }

    @Override
    public List<Vaccine> getAnimalVaccineById(long id) {
        return List.of();
    }

    @Override
    public List<Vaccine> findVaccinesByDateRange(LocalDate starDate, LocalDate endDate) {
        return List.of();
    }
}
