package dev.patika.veterinarymanagementsystemapi.v1.core.config.modelMapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();
}
