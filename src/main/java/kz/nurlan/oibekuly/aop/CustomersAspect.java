package kz.nurlan.oibekuly.aop;

import kz.nurlan.oibekuly.model.Account;
import kz.nurlan.oibekuly.model.Customers;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomersAspect {

    @Pointcut("execution(String getFirstname())|| execution( void getLastName()))")
    public void getNameSurname(){}

    @Before("execution(public String getFirstname())")
    public void getLastName() {
        Customers customers = new Customers();
        System.out.println(customers.getLastname());
        System.out.println("Method getLastName has worked");
    }

    @AfterReturning(pointcut = "execution(public String accountDetails())")
    public String getFirstname() {
        Customers customers = new Customers();
        System.out.println("Method getFirstname has worked");
        return customers.getFirstname();
    }

    @After("execution(* accountDetails())")
    public String makeWithdraw () {
        Account account = new Account();
        double balance = account.getBalance();
        double amount = 10000;
        System.out.println("Method makeWithdraw has worked");
        if (amount > balance) {
            return "You have insufficient funds.";
        } else {
            balance = balance - amount - (amount * 0.05);
            return "You have withdrawn " + amount + " tenge and incurred a fee of 5%" + "\n" +
                    "Your balance: " + balance + " tenge";
        }
    }

    @AfterThrowing(pointcut = "execution(public String getLastName())")
    public String accountDetails() {
        Account account = new Account();
        String info = "";
        info = String.format("Account information: " +
                "\nAccount number: " +
                "%d\nBalance: " +
                "%s\nInterest: %s\n",
                account.getAccountnumber(), account.getBalance(), account.getInterest());
        System.out.println("Method accountDetails has worked");
        if (info != null) {
            return info;
        } else {
            System.out.println("NullPointerException exception");
            throw new NullPointerException();
        }
    }


}
