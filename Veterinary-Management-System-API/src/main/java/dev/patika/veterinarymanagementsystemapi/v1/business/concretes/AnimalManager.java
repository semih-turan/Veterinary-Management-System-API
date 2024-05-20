package dev.patika.veterinarymanagementsystemapi.v1.business.concretes;

import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.AnimalService;
import dev.patika.veterinarymanagementsystemapi.v1.core.exception.ForUpdateNotFoundIdException;
import dev.patika.veterinarymanagementsystemapi.v1.core.exception.NotFoundCustomerException;
import dev.patika.veterinarymanagementsystemapi.v1.core.exception.NotFoundException;
import dev.patika.veterinarymanagementsystemapi.v1.core.exception.NotFoundObjectRequest;
import dev.patika.veterinarymanagementsystemapi.v1.core.utils.Message;
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
        if (customerRepository.findById(animal.getCustomer().getId()).isEmpty()) {
            throw new NotFoundCustomerException(Message.NOT_FOUND_CUSTOMER);
        }
        return animalRepository.save(animal);
    }

    @Override
    public Animal getById(long id) {
        return animalRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.NOT_FOUND_ID));
    }

    @Override
    public Animal update(Animal animal) {
        animalRepository.findById(animal.getId()).orElseThrow(()-> new ForUpdateNotFoundIdException(Message.UPDATE_NOT_FOUND_ID));
        if (customerRepository.findById(animal.getCustomer().getId()).isEmpty()) {
            throw new NotFoundCustomerException(Message.NOT_FOUND_CUSTOMER);
        }
        return animalRepository.save(animal);
    }

    @Override
    public List<Animal> getAnimalByName(String name) {
        if(animalRepository.findByName(name).isEmpty()){
            throw new NotFoundObjectRequest(Message.NOT_FOUND);
        }
        return animalRepository.findByName(name);
    }

    @Override
    public List<Animal> getCustomerById(long animalCustomerId) {
        if(animalRepository.findByCustomerId(animalCustomerId).isEmpty()){
            throw new NotFoundCustomerException(Message.NOT_FOUND_CUSTOMER);
        }
        return animalRepository.findByCustomerId(animalCustomerId);
    }

    @Override
    public List<Animal> getCustomerByName(String name) {
        if(animalRepository.findByCustomerName(name).isEmpty()){
            throw new NotFoundObjectRequest(Message.NOT_FOUND);
        }
        return animalRepository.findByCustomerName(name);
    }

    @Override
    public boolean deleteById(long id) {
        animalRepository.delete(getById(id));
        return true;
    }

}
