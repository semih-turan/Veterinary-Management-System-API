package dev.patika.veterinarymanagementsystemapi.v1.business.concretes;

import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.AnimalService;
import dev.patika.veterinarymanagementsystemapi.v1.dao.AnimalRepository;
import dev.patika.veterinarymanagementsystemapi.v1.dao.CustomerRepository;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalManager implements AnimalService {
    private final AnimalRepository animalRepository;
    private final CustomerRepository customerRepository;


    @Override
    public Animal save(Animal animal) {
        return null;
    }

    @Override
    public Animal update(Animal animal) {
        return null;
    }

    @Override
    public Animal getById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public List<Animal> getAnimalByName(String name) {
        return List.of();
    }

    @Override
    public List<Animal> getCustomerId(long animalCustomerId) {
        return List.of();
    }

    @Override
    public List<Animal> getCustomerName(String name) {
        return List.of();
    }
}
