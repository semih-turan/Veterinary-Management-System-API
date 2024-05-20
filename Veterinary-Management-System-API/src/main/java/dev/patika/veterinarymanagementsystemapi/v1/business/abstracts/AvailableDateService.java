package dev.patika.veterinarymanagementsystemapi.v1.business.abstracts;

import dev.patika.veterinarymanagementsystemapi.v1.entities.AvailableDate;

public interface AvailableDateService {

    AvailableDate save(AvailableDate availableDate);
    AvailableDate getById(long id);
    AvailableDate update(AvailableDate availableDate);
    boolean deleteById(long id);

    boolean forceDeleteById(long id);
}
