package dev.patika.veterinarymanagementsystemapi.v1.api;

import dev.patika.veterinarymanagementsystemapi.v1.business.abstracts.CustomerService;
import dev.patika.veterinarymanagementsystemapi.v1.core.config.modelMapper.ModelMapperService;
import dev.patika.veterinarymanagementsystemapi.v1.core.result.Result;
import dev.patika.veterinarymanagementsystemapi.v1.core.result.ResultData;
import dev.patika.veterinarymanagementsystemapi.v1.core.utils.ResultHelper;
import dev.patika.veterinarymanagementsystemapi.v1.dto.request.customer.CustomerSaveRequest;
import dev.patika.veterinarymanagementsystemapi.v1.dto.request.customer.CustomerUpdateRequest;
import dev.patika.veterinarymanagementsystemapi.v1.dto.response.animal.AnimalResponse;
import dev.patika.veterinarymanagementsystemapi.v1.dto.response.customer.CustomerResponse;
import dev.patika.veterinarymanagementsystemapi.v1.entities.Customer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final ModelMapperService modelMapperService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CustomerResponse> save(@Valid @RequestBody CustomerSaveRequest customerSaveRequest) {
        return ResultHelper.CREATED(modelMapperService.forResponse().map(customerService.save(modelMapperService.forRequest().map(customerSaveRequest, Customer.class)), CustomerResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CustomerResponse> getById(@PathVariable("id") long id) {
        return ResultHelper.OK(modelMapperService.forResponse().map(customerService.getById(id), CustomerResponse.class));
    }

    @GetMapping("/customer-by-name")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<CustomerResponse>> getByCustomerName(@RequestParam String name) {
        return ResultHelper.OK(customerService.getByCustomerName(name).stream().map(customer -> modelMapperService.forResponse().map(customer, CustomerResponse.class)).collect(Collectors.toList()));
    }

    @GetMapping("/customer-by-animal-id/{id}")
    public ResultData<List<AnimalResponse>> getByAnimalId(@PathVariable("id") long id) {
        return ResultHelper.OK(customerService.getByAnimalId(id).stream().map(customer -> modelMapperService.forResponse().map(customer, AnimalResponse.class)).collect(Collectors.toList()));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CustomerResponse> update(@Valid @RequestBody CustomerUpdateRequest customerUpdateRequest) {
        return ResultHelper.OK(modelMapperService.forResponse().map(customerService.update(modelMapperService.forRequest().map(customerUpdateRequest, Customer.class)), CustomerResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteById(@PathVariable("id") long id) {
        return ResultHelper.DELETE(customerService.deleteById(id));
    }

}
