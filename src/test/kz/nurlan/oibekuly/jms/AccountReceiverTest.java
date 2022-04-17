package kz.nurlan.oibekuly.jms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import kz.nurlan.oibekuly.jms.AccountReceiver;
import kz.nurlan.oibekuly.model.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AccountReceiver.class, Account.class})
@ExtendWith(SpringExtension.class)
class AccountReceiverTest {
    @Autowired
    private Account account;

    @Autowired
    private AccountReceiver accountReceiver;

    @Test
    void testReceiveAccountInfo() {
        Account account = new Account();
        account.setAccount_id(1);
        account.setAccountnumber(1234567890L);
        account.setBalance(10.0);
        account.setInterest(10.0);
        this.accountReceiver.receiveAccountInfo(account);
        assertEquals(1, account.getAccount_id().intValue());
        assertEquals(10.0, account.getInterest());
        assertEquals(10.0, account.getBalance());
        assertEquals(1234567890L, account.getAccountnumber().longValue());
    }
}

