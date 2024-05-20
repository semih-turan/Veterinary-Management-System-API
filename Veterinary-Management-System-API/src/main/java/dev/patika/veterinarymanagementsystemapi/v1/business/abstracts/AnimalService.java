package dev.patika.veterinarymanagementsystemapi.v1.business.abstracts;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;

import java.util.List;

public interface AnimalService {

    Animal save(Animal animal);
    Animal getById(long id);
    Animal update(Animal animal);
    boolean deleteById(long id);

    List<Animal> getAnimalByName(String name);

    List<Animal> getCustomerId(long animalCustomerId);
    List<Animal> getCustomerName(String name);

}
