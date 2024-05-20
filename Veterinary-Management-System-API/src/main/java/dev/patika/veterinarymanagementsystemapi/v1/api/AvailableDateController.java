package dev.patika.veterinarymanagementsystemapi.v1.api;

import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.AvailableDateService;
import dev.patika.veterinarymanagementsystemapi.v1.core.config.modelMapper.ModelMapperService;
import dev.patika.veterinarymanagementsystemapi.v1.core.result.Result;
import dev.patika.veterinarymanagementsystemapi.v1.core.result.ResultData;
import dev.patika.veterinarymanagementsystemapi.v1.core.utils.ResultHelper;
import dev.patika.veterinarymanagementsystemapi.v1.dto.request.availableDate.AvailableDateSaveRequest;
import dev.patika.veterinarymanagementsystemapi.v1.dto.request.availableDate.AvailableDateUpdateRequest;
import dev.patika.veterinarymanagementsystemapi.v1.dto.response.availableDate.AvailableDateGetAllResponse;
import dev.patika.veterinarymanagementsystemapi.v1.dto.response.availableDate.AvailableDateResponse;
import dev.patika.veterinarymanagementsystemapi.v1.entities.AvailableDate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/available-dates")
@RequiredArgsConstructor
public class AvailableDateController {

    private final AvailableDateService availableDateService;
    private final ModelMapperService modelMapperService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AvailableDateResponse> save(@Valid @RequestBody AvailableDateSaveRequest availableDateSaveRequest) {
        return ResultHelper.CREATED(modelMapperService.forResponse().map(availableDateService.save(modelMapperService.forRequest().map(availableDateSaveRequest, AvailableDate.class)), AvailableDateResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AvailableDateGetAllResponse> getById(@PathVariable("id") long id) {
        return ResultHelper.OK(modelMapperService.forResponse().map(availableDateService.getById(id), AvailableDateGetAllResponse.class));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AvailableDateResponse> update(@Valid @RequestBody AvailableDateUpdateRequest availableDateUpdateRequest) {
        return ResultHelper.OK(modelMapperService.forResponse().map(availableDateService.update(modelMapperService.forRequest().map(availableDateUpdateRequest, AvailableDate.class)), AvailableDateResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteById(@PathVariable("id") long id) {
        return ResultHelper.DELETE(availableDateService.deleteById(id));
    }

    @DeleteMapping("/force-delete-by-id/{id}")
    public Result forceDeleteById(@PathVariable("id") long id) {
        return ResultHelper.DELETE(availableDateService.forceDeleteById(id));
    }


}
