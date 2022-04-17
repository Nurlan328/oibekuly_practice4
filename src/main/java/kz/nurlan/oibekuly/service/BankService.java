
package kz.nurlan.oibekuly.service;

//import kz.iitu.itse1910.nurlan.oibekuly.aop.AccountOperation;

import kz.nurlan.oibekuly.model.Account;
import kz.nurlan.oibekuly.model.Bank;
import kz.nurlan.oibekuly.repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BankService {

    private static Logger logger = LoggerFactory.getLogger(BankService.class);

    private BankRepository bankRepository;
    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    public void save(Bank bank) {
        bankRepository.save(bank);
    }

    public void update(Bank bank) {
        bankRepository.save(bank);
    }

    public Bank getById(Integer bank_id) {
        return bankRepository.getOne(bank_id);
    }

    public void deleteById(Integer bank_id) {
        bankRepository.deleteById(bank_id);
    }

//    @AccountOperation(operation = "deposit")
    public void deposit(Account account, Double amount) {
        account.setBalance(account.getBalance() + amount);
    }

//    @AccountOperation(operation = "withdraw")
    public void withdraw(Account account, Double amount) {

        if (amount < 0) {
            logger.info("The withdrawn amount must exceed 1000");
        }

        account.setBalance(account.getBalance() - amount);

    }

    public String bankDetails() {
        Bank bank = new Bank();
        return "Bank id: "  + bank.getBank_id() +
               "\n Bank name: " + bank.getBankname() +
                "\n Number of customer account " + bank.getCustomer_account_number();
    }



}
