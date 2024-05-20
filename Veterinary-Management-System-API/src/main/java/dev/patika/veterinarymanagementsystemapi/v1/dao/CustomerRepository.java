package dev.patika.veterinarymanagementsystemapi.v1.dao;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {
}
