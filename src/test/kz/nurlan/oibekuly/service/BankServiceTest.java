package kz.nurlan.oibekuly.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import kz.nurlan.oibekuly.model.Account;
import kz.nurlan.oibekuly.model.Bank;
import kz.nurlan.oibekuly.repository.BankRepository;
import kz.nurlan.oibekuly.service.BankService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BankService.class})
@ExtendWith(SpringExtension.class)
class BankServiceTest {
    @MockBean
    private BankRepository bankRepository;

    @MockBean
    private BankService bankService;

    @Test
    void testFindAll() {
        ArrayList<Bank> bankList = new ArrayList<>();
        when(this.bankRepository.findAll()).thenReturn(bankList);
        List<Bank> actualFindAllResult = this.bankService.findAll();
        assertSame(bankList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.bankRepository).findAll();
    }

    @Test
    void testSave() {
        Bank bank = new Bank();
        bank.setBank_id(1);
        bank.setBankname("https://example.org/example");
        bank.setCustomer_account_number(1234567890L);
        when(this.bankRepository.save((Bank) any())).thenReturn(bank);

        Bank bank1 = new Bank();
        bank1.setBank_id(1);
        bank1.setBankname("https://example.org/example");
        bank1.setCustomer_account_number(1234567890L);
        this.bankService.save(bank1);
        verify(this.bankRepository).save((Bank) any());
        assertTrue(this.bankService.findAll().isEmpty());
    }

    @Test
    void testUpdate() {
        Bank bank = new Bank();
        bank.setBank_id(1);
        bank.setBankname("https://example.org/example");
        bank.setCustomer_account_number(1234567890L);
        when(this.bankRepository.save((Bank) any())).thenReturn(bank);

        Bank bank1 = new Bank();
        bank1.setBank_id(1);
        bank1.setBankname("https://example.org/example");
        bank1.setCustomer_account_number(1234567890L);
        this.bankService.update(bank1);
        verify(this.bankRepository).save((Bank) any());
        assertTrue(this.bankService.findAll().isEmpty());
    }

    @Test
    void testGetById() {
        Bank bank = new Bank();
        bank.setBank_id(1);
        bank.setBankname("https://example.org/example");
        bank.setCustomer_account_number(1234567890L);
        when(this.bankRepository.getOne((Integer) any())).thenReturn(bank);
        assertSame(bank, this.bankService.getById(1));
        verify(this.bankRepository).getOne((Integer) any());
        assertTrue(this.bankService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.bankRepository).deleteById((Integer) any());
        this.bankService.deleteById(1);
        verify(this.bankRepository).deleteById((Integer) any());
        assertTrue(this.bankService.findAll().isEmpty());
    }

    @Test
    void testDeposit() {
        Account account = new Account();
        account.setAccount_id(1);
        account.setAccountnumber(1234567890L);
        account.setBalance(10.0);
        account.setInterest(10.0);
        this.bankService.deposit(account, 10.0);
        assertEquals(20.0, account.getBalance());
    }
    @Test
    void testWithdraw() {
        Account account = new Account();
        account.setAccount_id(1);
        account.setAccountnumber(1234567890L);
        account.setBalance(10.0);
        account.setInterest(10.0);
        this.bankService.withdraw(account, 10.0);
        assertEquals(0.0, account.getBalance());
    }
    @Test
    void testBankDetails() {
        assertEquals("Bank id: 0\n Bank name: null\n Number of customer account null", this.bankService.bankDetails());
    }
}

