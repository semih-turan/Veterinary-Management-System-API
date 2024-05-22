package dev.patika.veterinarymanagementsystemapi.v1.business.concretes;

import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.CustomerService;
import dev.patika.veterinarymanagementsystemapi.v1.core.exception.*;
import dev.patika.veterinarymanagementsystemapi.v1.core.utils.Message;
import dev.patika.veterinarymanagementsystemapi.v1.dao.CustomerRepository;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) { // Criteria 10 - Is the animal owner registered according to project requirements?
        if(customerRepository.existsByEmail(customer.getEmail()) || customerRepository.existsByPhone(customer.getPhone())){
            throw new NotUniqueValues(Message.NOT_UNIQUE);
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(long id) {
        return customerRepository.findById(id).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND_ID));
    }

    @Override
    public List<Customer> getByCustomerName(String name) { // Criteria 11 - Are animal owners filtered by name?
        if(customerRepository.findByName(name).isEmpty()){
            throw new NotFoundObjectRequest(Message.NOT_FOUND);
        }
        return customerRepository.findByName(name);
    }

    @Override
    public List<Animal> getByAnimalId(long id) {
        if(customerRepository.findById(id).isEmpty()){
            throw new NotFoundCustomerException(Message.NOT_FOUND_CUSTOMER);
        }
        if(getById(id).getAnimalList().isEmpty()){
            throw new NotFoundObjectRequest(Message.NOT_FOUND);
        }
        return getById(id).getAnimalList();
    }

    @Override
    public Customer update(Customer customer) {
        customerRepository.findById(customer.getId()).orElseThrow(()-> new ForUpdateNotFoundIdException(Message.UPDATE_NOT_FOUND_ID));
        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteById(long id) {
        customerRepository.delete(getById(id));
        return true;
    }

}
