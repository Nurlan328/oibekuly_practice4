package kz.nurlan.oibekuly.jms;

import kz.nurlan.oibekuly.model.Account;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AccountReceiver {

    @JmsListener(destination = "accountReceiver")
    public void receiveAccountInfo(Account account) {
        System.out.println("Received information about account: ");
        System.out.println("Account id: " + account.getAccount_id());
        System.out.println("Account number: " + account.getAccountnumber());
        System.out.println("Balance in account: " + account.getBalance());
    }

}
