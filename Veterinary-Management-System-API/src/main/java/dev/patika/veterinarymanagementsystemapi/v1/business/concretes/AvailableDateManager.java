package dev.patika.veterinarymanagementsystemapi.v1.business.concretes;

import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.AvailableDateService;
import dev.patika.veterinarymanagementsystemapi.v1.core.config.modelMapper.ModelMapperService;
import dev.patika.veterinarymanagementsystemapi.v1.entities.AvailableDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvailableDateManager implements AvailableDateService {
    private final AvailableDateService availableDateService;
    private final ModelMapperService modelMapperService;

    @Override
    public AvailableDate save(AvailableDate availableDate) {
        return null;
    }

    @Override
    public AvailableDate getById(long id) {
        return null;
    }

    @Override
    public AvailableDate update(AvailableDate availableDate) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public boolean forceDeleteById(long id) {
        return false;
    }
}
