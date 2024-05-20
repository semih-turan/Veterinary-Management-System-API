package dev.patika.veterinarymanagementsystemapi.v1.dao;

import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
