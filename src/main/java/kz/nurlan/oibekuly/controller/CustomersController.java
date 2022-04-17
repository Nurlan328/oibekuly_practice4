package kz.nurlan.oibekuly.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.nurlan.oibekuly.model.Customers;
import kz.nurlan.oibekuly.repository.CustomersRepository;
import kz.nurlan.oibekuly.service.CustomersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
@Component
@Api(value = "Customers Rest Controller", description = "REST API for Customers")
public class CustomersController {

    private static Logger logger = LoggerFactory.getLogger(CustomersController.class);

    private CustomersRepository customersRepository;
    private CustomersService customersService;

    @Autowired
    public CustomersController(CustomersRepository customersRepository, CustomersService customersService) {
        this.customersRepository = customersRepository;
        this.customersService = customersService;
    }

    public CustomersController() {

    }

    @GetMapping(value = "/getCustomers")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Customers ", response = ArrayList.class, tags = "GetCustomers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not Authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not Found!"),
            @ApiResponse(code = 500, message = "Server Error!")})
    public List<Customers> findAll() {
        return customersRepository.findAll();
    }

    @PostMapping("/addCustomer")
    @ResponseStatus(HttpStatus.CREATED)
    public String addCustomer(@RequestBody Customers customers) {
        customersService.save(customers);
        System.out.print(customers);
        return " has been saved!";
    }

    @PutMapping("/updateCustomer")
    public String updateAccount(@RequestBody  Customers customers) {
        customersService.update(customers);
        System.out.print(customers);
        return " has been updated!";
    }

    @GetMapping("/findCustomerById/{customer_id}")
    public Customers getById(@PathVariable("customer_id") Integer customer_id) {
        return customersService.getById(customer_id);
    }

    @DeleteMapping("/deleteCustomerById/{customer_id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteById(@PathVariable("customer_id") Integer customer_id) {
        customersService.deleteById(customer_id);
        return "Customer with id " + customer_id + " has been deleted";
    }

    @GetMapping("/double")
    public ResponseEntity<String> doubleNumber(@RequestHeader("my-number") int myNumber) {
        return new ResponseEntity<String>(String.format("%d * 2 = %d",
                myNumber, (myNumber * 2)), HttpStatus.OK);
    }

    @GetMapping("/multiValue")
    public ResponseEntity<String> multiValue(
            @RequestHeader MultiValueMap<String, String> headers) {
        headers.forEach((key, value) -> {
            logger.info(String.format(
                    "Header '%s' = %s", key, value.stream().collect(Collectors.joining("|"))));
        });

        return new ResponseEntity<String>(
                String.format("Listed %d headers", headers.size()), HttpStatus.OK);
    }

    @PostMapping("/postCustomer")
    public void postCustomer(
            @RequestHeader("content-type") String contentType,
            @RequestBody Customers customers) {

        logger.info("Header value - Content-Type: {}", contentType);
    }

    @GetMapping("/nonRequiredHeader")
    public ResponseEntity<String> evaluateNonRequiredHeader(
            @RequestHeader(value = "optional-header", required = false) String optionalHeader) {
        return new ResponseEntity<String>(String.format(
                "Was the optional header present? %s!",
                (optionalHeader == null ? "No" : "Yes")),HttpStatus.OK);
    }
    public String getCustomerStatus(Integer customer_id) {
        return "Inactive";
    }
}
