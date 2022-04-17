package kz.nurlan.oibekuly.jms;

import kz.nurlan.oibekuly.model.Account;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;

public class Sender {

    @JmsListener(destination = "accountSender")
    @SendTo("accountReceiver")
    public Account sendAccountInfo(Account account) {
        account.setAccount_id(1);
        account.setAccountnumber(664385393928L);
        account.setBalance(4300000d);
        account.setInterest(0.01d);
        return account;
    }

    @JmsListener(destination = "Sender")
    @SendTo("withDrawReceiver")
    public void sendWithDrawNotification(double amount) {
        CustomerReceiver customerReceiver = new CustomerReceiver();
        amount = 20000d;
        customerReceiver.notifyWithdrawing(amount);
    }
}
