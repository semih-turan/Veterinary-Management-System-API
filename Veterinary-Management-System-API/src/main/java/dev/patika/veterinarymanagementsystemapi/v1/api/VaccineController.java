package dev.patika.veterinarymanagementsystemapi.v1.api;


import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.VaccineService;
import dev.patika.veterinarymanagementsystemapi.v1.core.config.modelMapper.ModelMapperService;
import dev.patika.veterinarymanagementsystemapi.v1.core.result.Result;
import dev.patika.veterinarymanagementsystemapi.v1.core.result.ResultData;
import dev.patika.veterinarymanagementsystemapi.v1.core.utils.ResultHelper;
import dev.patika.veterinarymanagementsystemapi.v1.dto.request.vaccine.VaccineSaveRequest;
import dev.patika.veterinarymanagementsystemapi.v1.dto.request.vaccine.VaccineUpdateRequest;
import dev.patika.veterinarymanagementsystemapi.v1.dto.response.vaccine.VaccineGetAllResponse;
import dev.patika.veterinarymanagementsystemapi.v1.dto.response.vaccine.VaccineResponse;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Vaccine;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/vaccines")
@RequiredArgsConstructor
public class VaccineController {

    private final VaccineService vaccineService;
    private final ModelMapperService mapperService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<VaccineResponse> save(@Valid @RequestBody VaccineSaveRequest vaccineSaveRequest) {
        return ResultHelper.CREATED(mapperService.forResponse().map(vaccineService.save(mapperService.forRequest().map(vaccineSaveRequest, Vaccine.class)), VaccineResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<VaccineGetAllResponse> getById(@PathVariable long id) {
        return ResultHelper.OK(mapperService.forResponse().map(vaccineService.getById(id), VaccineGetAllResponse.class));
    }

    @GetMapping("/animal/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<VaccineGetAllResponse>> getAnimalVaccineById(@PathVariable("id") long id) {
        return ResultHelper.OK(vaccineService.getAnimalVaccineById(id).stream().map(vaccine -> mapperService.forResponse().map(vaccine, VaccineGetAllResponse.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-date") // 1
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<VaccineGetAllResponse>> findVaccinesByDateRange(@RequestParam("firstDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firsDate, @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResultHelper.OK(vaccineService.findVaccinesByDateRange(firsDate, endDate).stream().map(vaccine -> mapperService.forResponse().map(vaccine, VaccineGetAllResponse.class)).collect(Collectors.toList()));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<VaccineResponse> update(@Valid @RequestBody VaccineUpdateRequest vaccineUpdateRequest) {
        return ResultHelper.OK(mapperService.forResponse().map(vaccineService.update(mapperService.forRequest().map(vaccineUpdateRequest, Vaccine.class)), VaccineResponse.class));
    }

    @PutMapping("/force-update")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<VaccineResponse> forceUpdate(@Valid @RequestBody VaccineUpdateRequest vaccineUpdateRequest) {
        return ResultHelper.RESOLVE(mapperService.forResponse().map(vaccineService.forceUpdate(mapperService.forRequest().map(vaccineUpdateRequest, Vaccine.class)), VaccineResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteById(@PathVariable("id") long id) {
        return ResultHelper.DELETE(vaccineService.deleteById(id));
    }



}
