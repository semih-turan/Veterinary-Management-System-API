package dev.patika.veterinarymanagementsystemapi.v1.dao;

import dev.patika.veterinarymanagementsystemapi.v1.entities.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableRepository  extends JpaRepository<AvailableDate, Long> {
}
