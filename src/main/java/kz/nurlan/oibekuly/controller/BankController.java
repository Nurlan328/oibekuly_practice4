package kz.nurlan.oibekuly.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.nurlan.oibekuly.model.Bank;
import kz.nurlan.oibekuly.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Bank Rest Controller", description = "REST API for Bank")
public class BankController {

    private BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Get Banks ", response = ArrayList.class, tags = "GetBanks")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not Authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not Found!"),
            @ApiResponse(code = 500, message = "Server Error!")})
    public List<Bank> findAll() {
        return bankService.findAll();
    }

    @PostMapping("/addBank")
    @ResponseBody
    public String addBank(@RequestBody Bank bank) {
        bankService.save(bank);
        System.out.print(bank);
        return " has been saved!";
    }

    @PutMapping("/updateBank")
    @ResponseBody
    public String updateBank(@RequestBody  Bank bank) {
        bankService.update(bank);
        System.out.print(bank);
        return " has been updated!";
    }

    @GetMapping("/findBankById/{bank_id}")
    @ResponseBody
    public Bank getById(@PathVariable("bank_id") Integer bank_id) {
        return bankService.getById(bank_id);
    }

    @DeleteMapping("/deleteBankById/{bank_id}")
    @ResponseBody
    public String deleteById(@PathVariable("bank_id") Integer bank_id) {
        bankService.deleteById(bank_id);
        return "Bank with id " + bank_id + " has been deleted";
    }
}
