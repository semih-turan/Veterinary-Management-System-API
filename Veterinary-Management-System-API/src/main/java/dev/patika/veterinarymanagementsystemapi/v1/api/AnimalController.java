package dev.patika.veterinarymanagementsystemapi.v1.api;

import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.AnimalService;
import dev.patika.veterinarymanagementsystemapi.v1.core.config.modelMapper.ModelMapperService;
import dev.patika.veterinarymanagementsystemapi.v1.core.result.Result;
import dev.patika.veterinarymanagementsystemapi.v1.core.result.ResultData;
import dev.patika.veterinarymanagementsystemapi.v1.core.utils.ResultHelper;
import dev.patika.veterinarymanagementsystemapi.v1.dto.request.animal.AnimalSaveRequest;
import dev.patika.veterinarymanagementsystemapi.v1.dto.request.animal.AnimalUpdateRequest;
import dev.patika.veterinarymanagementsystemapi.v1.dto.response.animal.AnimalGetAllResponse;
import dev.patika.veterinarymanagementsystemapi.v1.dto.response.animal.AnimalResponse;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/animals")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;
    private final ModelMapperService modelMapperService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AnimalResponse> save(@Valid @RequestBody() AnimalSaveRequest animalSaveRequest) {
        return ResultHelper.CREATED(modelMapperService.forResponse().map(animalService.save(modelMapperService.forRequest().map(animalSaveRequest, Animal.class)), AnimalResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AnimalGetAllResponse> getById(@PathVariable("id") long id) {
        return ResultHelper.OK(modelMapperService.forResponse().map(animalService.getById(id), AnimalGetAllResponse.class));
    }

    @GetMapping("/customer-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalGetAllResponse> getCustomerById(@PathVariable("id") long id) {
        return animalService.getCustomerById(id).stream().map(animal -> modelMapperService.forResponse().map(animal, AnimalGetAllResponse.class)).collect(Collectors.toList());
    }

    @GetMapping("/customer-by-name")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AnimalGetAllResponse>> getCustomerByName(@RequestParam String name) {
        return ResultHelper.OK(animalService.getCustomerByName(name).stream().map(animal -> modelMapperService.forResponse().map(animal, AnimalGetAllResponse.class)).collect(Collectors.toList()));
    }

    @GetMapping("/animal-by-name")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AnimalGetAllResponse>> getAnimalByName(@RequestParam String name) {
        return ResultHelper.OK(animalService.getAnimalByName(name).stream().map(animal -> modelMapperService.forResponse().map(animal, AnimalGetAllResponse.class)).collect(Collectors.toList()));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AnimalResponse> update(@Valid @RequestBody AnimalUpdateRequest animalUpdateRequest) {
        animalService.update(modelMapperService.forRequest().map(animalUpdateRequest, Animal.class));
        return ResultHelper.OK(modelMapperService.forResponse().map(animalService.update(modelMapperService.forRequest().map(animalUpdateRequest, Animal.class)), AnimalResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteById(@PathVariable long id) {
        return ResultHelper.DELETE(animalService.deleteById(id));
    }

}
