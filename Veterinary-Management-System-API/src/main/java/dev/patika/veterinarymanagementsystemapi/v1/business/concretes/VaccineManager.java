package dev.patika.veterinarymanagementsystemapi.v1.business.concretes;

import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.VaccineService;
import dev.patika.veterinarymanagementsystemapi.v1.core.exception.*;
import dev.patika.veterinarymanagementsystemapi.v1.core.utils.Message;
import dev.patika.veterinarymanagementsystemapi.v1.dao.AnimalRepository;
import dev.patika.veterinarymanagementsystemapi.v1.dao.VaccineRepository;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Vaccine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VaccineManager implements VaccineService {
    private final VaccineRepository vaccineRepository;
    private final AnimalRepository animalRepository;

    @Override
    public Vaccine save(Vaccine vaccine) {
        if (animalRepository.findById(vaccine.getAnimal().getId()).isEmpty()) {
            throw new NotFoundAnimalException(Message.NOT_FOUND_ANIMAL);
        }
        if (vaccineRepository.existsVaccineByCodeAndNameAndAnimalId(vaccine.getCode(), vaccine.getName(), vaccine.getAnimal().getId())) {
            if(vaccineRepository.findByEndDateAfterOrderByEndDate(vaccine.getStartDate()).isEmpty()){ // Section 22 - Vaccine day check
                if (ChronoUnit.DAYS.between(vaccine.getStartDate(), vaccine.getEndDate()) < 0) {
                    throw new NoneSenseInformationException(Message.BAD_DATE);
                }
                return vaccineRepository.save(vaccine);
            }
            throw new DateMismatchException(Message.DATE_MISMATCH);
        }
        if (ChronoUnit.DAYS.between(vaccine.getStartDate(), vaccine.getEndDate()) < 0) {
            throw new NoneSenseInformationException(Message.BAD_DATE);
        }
        return vaccineRepository.save(vaccine);
    }

    @Override
    public Vaccine getById(long id) {
        return vaccineRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.NOT_FOUND_ID));
    }

    @Override
    public List<Vaccine> getAnimalVaccineById(long id) {
        if (vaccineRepository.findByAnimalId(id).isEmpty()) {
            throw new NotFoundAnimalException(Message.NOT_FOUND_ANIMAL);
        }
        return vaccineRepository.findByAnimalId(id);
    }

    @Override
    public List<Vaccine> findVaccinesByDateRange(LocalDate starDate, LocalDate endDate) {
        if (vaccineRepository.findByEndDateBetween(starDate,endDate).isEmpty()) {
            throw new NotFoundObjectRequest(Message.NOT_FOUND);
        }
        return vaccineRepository.findByEndDateBetween(starDate,endDate);
    }

    @Override
    public Vaccine update(Vaccine vaccine) {
        getById(vaccine.getId());
        if (vaccineRepository.existsVaccineByCodeAndNameAndAnimalId(vaccine.getCode(), vaccine.getName(), vaccine.getAnimal().getId())) {
            if(vaccineRepository.findByEndDateAfterOrderByEndDate(vaccine.getStartDate()).isEmpty()){
                if (ChronoUnit.DAYS.between(vaccine.getStartDate(), vaccine.getEndDate()) < 0) {
                    throw new NoneSenseInformationException(Message.BAD_DATE);
                }
                return vaccineRepository.save(vaccine);
            }
            throw new ForceUpdateException(Message.FORCE_UPDATE);
        }
        return save(vaccine);
    }

    @Override
    public Vaccine forceUpdate(Vaccine vaccine) {
        getById(vaccine.getId());
        if(!animalRepository.existsById(vaccine.getAnimal().getId())){
            throw new NotFoundAnimalException(Message.NOT_FOUND_ANIMAL);
        }
        if (vaccine.getEndDate().isBefore(vaccine.getStartDate())) {
            throw new NoneSenseInformationException(Message.BAD_DATE);
        }
        return vaccineRepository.save(vaccine);
    }

    @Override
    public boolean deleteById(long id) {
        vaccineRepository.delete(getById(id));
        return true;
    }


}
