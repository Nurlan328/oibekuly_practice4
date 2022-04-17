package kz.nurlan.oibekuly.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kz.nurlan.oibekuly.model.Account;
import kz.nurlan.oibekuly.model.Customers;
import kz.nurlan.oibekuly.repository.CustomersRepository;
import kz.nurlan.oibekuly.service.CustomersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {CustomersService.class, Customers.class})
@ExtendWith(SpringExtension.class)
class CustomersServiceTest {

    @MockBean
    private CustomersRepository customersRepository;
    @MockBean
    private CustomersService customersService;

    @Test
    void testConstructor() {
        CustomersService actualCustomersService = new CustomersService();
        actualCustomersService.deposit(10.0);
        assertEquals(10010.0, actualCustomersService.getBalance());
        Account account = actualCustomersService.account;
        assertNull(account.getAccount_id());
        assertEquals("Account(account_id=null, accountnumber=null, balance=10000.0, interest=0.0)", account.toString());
        assertEquals(0.0, account.getInterest());
        assertEquals(10000.0, account.getBalance());
        assertNull(account.getAccountnumber());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.customersRepository).deleteById((Integer) any());
        this.customersService.deleteById(1);
        verify(this.customersRepository).deleteById((Integer) any());
        assertTrue(this.customersService.findAll().isEmpty());
    }

    @Test
    void testGetById() {
        Customers customers = new Customers();
        customers.setAddress("42 Main St");
        customers.setAge(1);
        customers.setCustomer_id(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        customers.setDateOfBirth(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        customers.setFirstname("Jane");
        customers.setIin("https://example.org/example");
        customers.setLastname("Doe");
        customers.setRegistered(true);
        when(this.customersRepository.getOne((Integer) any())).thenReturn(customers);
        assertSame(customers, this.customersService.getById(1));
        verify(this.customersRepository).getOne((Integer) any());
        assertTrue(this.customersService.findAll().isEmpty());
    }

    @Test
    void testSave() {
        Customers customers = new Customers();
        customers.setAddress("42 Main St");
        customers.setAge(1);
        customers.setCustomer_id(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        customers.setDateOfBirth(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        customers.setFirstname("Jane");
        customers.setIin("https://example.org/example");
        customers.setLastname("Doe");
        customers.setRegistered(true);
        when(this.customersRepository.save((Customers) any())).thenReturn(customers);

        Customers customers1 = new Customers();
        customers1.setAddress("42 Main St");
        customers1.setAge(1);
        customers1.setCustomer_id(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        customers1.setDateOfBirth(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        customers1.setFirstname("Jane");
        customers1.setIin("https://example.org/example");
        customers1.setLastname("Doe");
        customers1.setRegistered(true);
        this.customersService.save(customers1);
        verify(this.customersRepository).save((Customers) any());
        assertTrue(this.customersService.findAll().isEmpty());
    }

    @Test
    void testUpdate() {
        Customers customers = new Customers();
        customers.setAddress("42 Main St");
        customers.setAge(1);
        customers.setCustomer_id(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        customers.setDateOfBirth(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        customers.setFirstname("Jane");
        customers.setIin("https://example.org/example");
        customers.setLastname("Doe");
        customers.setRegistered(true);
        when(this.customersRepository.save((Customers) any())).thenReturn(customers);

        Customers customers1 = new Customers();
        customers1.setAddress("42 Main St");
        customers1.setAge(1);
        customers1.setCustomer_id(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        customers1.setDateOfBirth(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        customers1.setFirstname("Jane");
        customers1.setIin("https://example.org/example");
        customers1.setLastname("Doe");
        customers1.setRegistered(true);
        this.customersService.update(customers1);
        verify(this.customersRepository).save((Customers) any());
        assertTrue(this.customersService.findAll().isEmpty());
    }

    @Test
    void testFindAll() {
        ArrayList<Customers> customersList = new ArrayList<>();
        when(this.customersRepository.findAll()).thenReturn(customersList);
        List<Customers> actualFindAllResult = this.customersService.findAll();
        assertSame(customersList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.customersRepository).findAll();
    }

    @Test
    void testMakeWithdraw() {
        assertEquals("You have withdrawn 10.0 tenge and incurred a fee of 5%\nYour balance: 9989.5 tenge",
                this.customersService.makeWithdraw(10.0));
        assertEquals(9989.5, this.customersService.getBalance());
    }

    @Test
    void testFindCustomerStatus() {
        assertEquals("Inactive", this.customersService.findCustomerStatus(1));
    }
}
