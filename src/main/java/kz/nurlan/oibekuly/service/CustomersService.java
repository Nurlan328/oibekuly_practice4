package kz.nurlan.oibekuly.service;

import kz.nurlan.oibekuly.controller.CustomersController;
import kz.nurlan.oibekuly.model.Account;
import kz.nurlan.oibekuly.model.Customers;
import kz.nurlan.oibekuly.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CustomersService {

    private CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public CustomersService() {}

    public void deleteById(Integer customer_id) {
        customersRepository.deleteById(customer_id);
    }

    public Customers getById(Integer customer_id) {
        return customersRepository.getOne(customer_id);
    }

    public String save(@RequestBody Customers customer) {
        customersRepository.save(customer);
        return "Customer: " + customer + ", has been saved!";
    }

    public String update(Customers customer) {
        customersRepository.save(customer);
        return "Customer: " + customer + ", has been saved!";
    }

    public List<Customers> findAll() {
        return customersRepository.findAll();
    }

    Account account = new Account(10000.0);
    double balance = account.getBalance();

    public double getBalance() {
        return balance;
    }

    public String makeWithdraw (double amount) {
        if (amount > balance) {
            return "You have insufficient funds.";
        } else {
            balance = balance - amount - (amount * 0.05);
            return "You have withdrawn " + amount + " tenge and incurred a fee of 5%" + "\n" +
                    "Your balance: " + balance + " tenge";
        }
    }

     public void deposit(double amount) {
         balance = balance + amount;
     }

    public String findCustomerStatus(Integer customer_id) {
        CustomersController customersController = new CustomersController();
        return customersController.getCustomerStatus(customer_id);
//        return "Customers " + customer_id + " status: " + customersController.getCustomerStatus(customer_id);
    }
 }
