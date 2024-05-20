package dev.patika.veterinarymanagementsystemapi.v1.api;

import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.DoctorService;
import dev.patika.veterinarymanagementsystemapi.v1.core.config.modelMapper.ModelMapperService;
import dev.patika.veterinarymanagementsystemapi.v1.core.result.Result;
import dev.patika.veterinarymanagementsystemapi.v1.core.result.ResultData;
import dev.patika.veterinarymanagementsystemapi.v1.core.utils.ResultHelper;
import dev.patika.veterinarymanagementsystemapi.v1.dto.request.doctor.DoctorSaveRequest;
import dev.patika.veterinarymanagementsystemapi.v1.dto.request.doctor.DoctorUpdateRequest;
import dev.patika.veterinarymanagementsystemapi.v1.dto.response.doctor.DoctorResponse;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Doctor;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final ModelMapperService modelMapperService;
    private final DoctorService doctorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<DoctorResponse> save(@Valid @RequestBody DoctorSaveRequest doctorSaveRequest) {
        return ResultHelper.CREATED(modelMapperService.forResponse().map(doctorService.save(modelMapperService.forRequest().map(doctorSaveRequest, Doctor.class)), DoctorResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<DoctorResponse> getById(@PathVariable("id") long id) {
        return ResultHelper.OK(modelMapperService.forResponse().map(doctorService.getById(id), DoctorResponse.class));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<DoctorResponse> update(@Valid @RequestBody DoctorUpdateRequest doctorUpdateRequest) {
        return ResultHelper.OK(modelMapperService.forResponse().map(doctorService.update(modelMapperService.forRequest().map(doctorUpdateRequest, Doctor.class)), DoctorResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteById(@PathVariable("id") long id) {
        return ResultHelper.OK(doctorService.deleteById(id));
    }

}
