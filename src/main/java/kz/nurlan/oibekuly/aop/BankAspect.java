package kz.nurlan.oibekuly.aop;

import kz.nurlan.oibekuly.model.Bank;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BankAspect {

    @Before("execution( * listOffBanks())")
    public String bankDetails() {
        Bank bank = new Bank();
        String bankInfo = "";
        bankInfo += "Bank id: "  + bank.getBank_id() +
                "\n Bank name: " + bank.getBankname() +
                "\n Number of customer account " + bank.getCustomer_account_number();
        System.out.println("Method bankDetails() has worked");
        return bankInfo;
    }
}
