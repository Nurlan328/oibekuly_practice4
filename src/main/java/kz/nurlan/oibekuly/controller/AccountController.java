package kz.nurlan.oibekuly.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.nurlan.oibekuly.dto.AccountRequestDto;
//import kz.nurlan.oibekuly.kafka.KafkaProducer;
import kz.nurlan.oibekuly.model.Account;
import kz.nurlan.oibekuly.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/accountController")
@Api(value = "Account Rest Controller", description = "REST API for Account")
public class AccountController {

    private AccountService accountService;

//    public KafkaProducer kafkaProducer;
//    @Autowired
//    public AccountController(AccountService accountService, KafkaProducer kafkaProducer) {
//        this.accountService = accountService;
//        this.kafkaProducer = kafkaProducer;
//    }
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(value = "/msg")
    public void sendMessageToKafkaTopic(@RequestParam("msgId") Long msgId,
                                        @RequestParam("accountnumber") Long accountnumber,
                                        @RequestParam("balance") double balance,
                                        @RequestParam("interest") double interest)
    {
        AccountRequestDto accountRequestDto = new AccountRequestDto(accountnumber,balance,interest);
//        this.kafkaProducer.sendOrder(msgId,accountRequestDto);
    }


    @GetMapping("/getAccounts")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Accounts ", response = ArrayList.class, tags = "GetAccounts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not Authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not Found!"),
            @ApiResponse(code = 500, message = "Server Error!")})
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @PostMapping("/addAccount")
    public String addAccount(@RequestBody Account account) {
        accountService.save(account);
        System.out.print(account);
        return " has been saved!";
    }

    @PutMapping("/updateAccount")
    public String update(@RequestBody Account account) {
        accountService.update(account);
        System.out.print(account);
        return " has been updated!";
    }

    @GetMapping("/findBankById/{account_id}")
    public Account getById(@PathVariable("account_id") Integer account_id) {
        return accountService.getById(account_id);
    }

    @DeleteMapping("/deleteAccountById/{account_id}")
    public void deleteById(@PathVariable("account_id") Integer account_id) {
        accountService.deleteById(account_id);
    }
}
