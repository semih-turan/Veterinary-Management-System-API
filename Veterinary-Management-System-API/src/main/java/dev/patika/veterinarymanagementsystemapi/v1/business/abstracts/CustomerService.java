package dev.patika.veterinarymanagementsystemapi.v1.business.abstracts;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);
    Customer getById(long id);
    Customer update(Customer customer);
    boolean deleteById(long id);

    List<Customer> getByCustomerName(String name);
    List<Animal> getByAnimalId(long id);
}
