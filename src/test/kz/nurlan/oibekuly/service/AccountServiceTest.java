package kz.nurlan.oibekuly.service;

import java.util.ArrayList;
import java.util.List;

import kz.nurlan.oibekuly.model.Account;
import kz.nurlan.oibekuly.repository.AccountRepository;
import kz.nurlan.oibekuly.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {AccountService.class})
@ExtendWith(SpringExtension.class)
class AccountServiceTest {

    @MockBean
    private AccountRepository accountRepository;

    @Mock
    Account account;
    @InjectMocks
    AccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAll() {
        ArrayList<Account> accountList = new ArrayList<>();
        when(this.accountRepository.findAll()).thenReturn(accountList);
        List<Account> actualFindAllResult = this.accountService.findAll();
        assertSame(accountList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.accountRepository).findAll();
    }

    @Test
    void testSave() {
        Account account = new Account();
        account.setAccount_id(1);
        account.setAccountnumber(1234567890L);
        account.setBalance(10.0);
        account.setInterest(10.0);
        when(this.accountRepository.save((Account) any())).thenReturn(account);

        Account account1 = new Account();
        account1.setAccount_id(1);
        account1.setAccountnumber(1234567890L);
        account1.setBalance(10.0);
        account1.setInterest(10.0);
        this.accountService.save(account1);
        verify(this.accountRepository).save((Account) any());
        assertTrue(this.accountService.findAll().isEmpty());
    }

    @Test
    void testUpdate() {
        Account account = new Account();
        account.setAccount_id(1);
        account.setAccountnumber(1234567890L);
        account.setBalance(10.0);
        account.setInterest(10.0);
        when(this.accountRepository.save((Account) any())).thenReturn(account);

        Account account1 = new Account();
        account1.setAccount_id(1);
        account1.setAccountnumber(1234567890L);
        account1.setBalance(10.0);
        account1.setInterest(10.0);
        this.accountService.update(account1);
        verify(this.accountRepository).save((Account) any());
        assertTrue(this.accountService.findAll().isEmpty());
    }

    @Test
    void testGetById() {
        Account account = new Account();
        account.setAccount_id(1);
        account.setAccountnumber(1234567890L);
        account.setBalance(10.0);
        account.setInterest(10.0);
        when(this.accountRepository.getOne((Integer) any())).thenReturn(account);
        assertSame(account, this.accountService.getById(1));
        verify(this.accountRepository).getOne((Integer) any());
        assertTrue(this.accountService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        Account account = new Account();
        account.setAccount_id(1);
        account.setAccountnumber(1234567890L);
        account.setBalance(10.0);
        account.setInterest(10.0);
        when(this.accountRepository.getOne((Integer) any())).thenReturn(account);
        this.accountService.deleteById(1);
        verify(this.accountRepository).getOne((Integer) any());
        assertTrue(this.accountService.findAll().isEmpty());
    }

    @Test
    void testTransfer()
    {
        Account account = new Account();
        account.setAccount_id(1);
        account.setAccountnumber(1234567890L);
        account.setBalance(10.0);
        account.setInterest(10.0);

        Account account1 = new Account();
        account1.setAccount_id(1);
        account1.setAccountnumber(1234567890L);
        account1.setBalance(10.0);
        account1.setInterest(10.0);
        this.accountService.transfer(10.0, account, account1);
        assertEquals(0.0, account.getBalance());
        assertEquals(20.0, account1.getBalance());
    }

    @Test
    void testAccountDetails() {
        when(account.getAccountnumber()).thenReturn(Long.valueOf(1));
        when(account.getBalance()).thenReturn(0d);
        when(account.getInterest()).thenReturn(0d);

        String result = accountService.accountDetails();
        Assertions.assertEquals(accountService.accountDetails(), result);
    }
}

