package dev.patika.veterinarymanagementsystemapi.v1.api;

import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.AnimalService;
import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.AppointmentService;
import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.DoctorService;
import dev.patika.veterinarymanagementsystemapi.v1.core.config.modelMapper.ModelMapperService;
import dev.patika.veterinarymanagementsystemapi.v1.core.result.Result;
import dev.patika.veterinarymanagementsystemapi.v1.core.result.ResultData;
import dev.patika.veterinarymanagementsystemapi.v1.core.utils.ResultHelper;
import dev.patika.veterinarymanagementsystemapi.v1.dto.request.appointment.AppointmentSaveRequest;
import dev.patika.veterinarymanagementsystemapi.v1.dto.request.appointment.AppointmentUpdateRequest;
import dev.patika.veterinarymanagementsystemapi.v1.dto.response.appointment.AppointmentGetAllResponse;
import dev.patika.veterinarymanagementsystemapi.v1.dto.response.appointment.AppointmentResponse;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Animal;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Appointment;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Doctor;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final DoctorService doctorService;
    private final ModelMapperService modelMapperService;
    private final AnimalService animalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AppointmentResponse> save(@Valid @RequestBody AppointmentSaveRequest appointmentSaveRequest) {
        return ResultHelper.CREATED(modelMapperService.forResponse().map(appointmentService.save(modelMapperService.forRequest().map(appointmentSaveRequest, Appointment.class)), AppointmentResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AppointmentGetAllResponse> getById(@PathVariable("id") long id) {
        return ResultHelper.OK(modelMapperService.forResponse().map(appointmentService.getById(id), AppointmentGetAllResponse.class));
    }

    @GetMapping("/appointments-by-date-by-doctor")
    public ResultData<List<AppointmentGetAllResponse>> findAppointmentsByDateRangeAndDoctor(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                                               @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
                                                                               @RequestParam("doctorId") long id) {
        Doctor doctor = doctorService.getById(id);
        return ResultHelper.OK(appointmentService.findAppointmentsByDateRangeAndDoctor(startDate, endDate, doctor).stream().map(appointment -> modelMapperService.forResponse().map(appointment, AppointmentGetAllResponse.class)).collect(Collectors.toList()));
    }

    @GetMapping("/appointments-by-date-by-animal")
    public ResultData<List<AppointmentGetAllResponse>> findAppointmentsByDateRangeAndAnimal(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                                               @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
                                                                               @RequestParam("animalId") long id) {
        Animal animal = animalService.getById(id);
        return ResultHelper.OK(appointmentService.findAppointmentsByDateRangeAndAnimal(startDate, endDate, animal).stream().map(appointment -> modelMapperService.forResponse().map(appointment, AppointmentGetAllResponse.class)).collect(Collectors.toList()));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AppointmentResponse> update(@Valid @RequestBody AppointmentUpdateRequest appointmentUpdateRequest) {
        return ResultHelper.OK(modelMapperService.forResponse().map(appointmentService.update(modelMapperService.forRequest().map(appointmentUpdateRequest, Appointment.class)), AppointmentResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteById(@PathVariable("id") long id) {
        return ResultHelper.DELETE(appointmentService.deleteById(id));
    }

}
