 package kz.nurlan.oibekuly.service;

 import kz.nurlan.oibekuly.model.Account;
 import kz.nurlan.oibekuly.repository.AccountRepository;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

     public List<Account> findAll() {
         return accountRepository.findAll();
     }

     public void save(Account account) {
         accountRepository.save(account);
     }

     public void update(Account account) {
         accountRepository.save(account);
     }

     public Account getById(Integer account_id) {
         return accountRepository.getOne(account_id);
     }


     public void deleteById(Integer account_id) {
         accountRepository.getOne(account_id);
     }
    Account account = new Account();
    double balance = account.getBalance();

    public void transfer(double amount, Account from, Account to) {
        if(from.getBalance() >= amount) {
            double b1 = from.getBalance() - amount;
            from.setBalance(b1);
            double b2 = to.getBalance() + amount;
            to.setBalance(b2);
            System.out.println("Successfully transfered.");
        } else {
            System.out.println("Insufficient funds");
        }
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

    public String accountDetails() {
        return "Account information: " +'\n' +
                "Account number: " + account.getAccountnumber() + '\n' +
                "Balance: " + account.getBalance() + '\n' +
                "Interest: " + account.getInterest() + '\n';
    }


 }
