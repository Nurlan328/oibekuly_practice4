package kz.nurlan.oibekuly.controller;

import kz.nurlan.oibekuly.controller.CustomersController;
import kz.nurlan.oibekuly.model.Customers;
import kz.nurlan.oibekuly.repository.CustomersRepository;
import kz.nurlan.oibekuly.service.CustomersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class CustomersControllerTest {
    @Mock
    Logger logger;
    @Mock
    CustomersRepository customersRepository;
    @Mock
    CustomersService customersService;
    @InjectMocks
    CustomersController customersController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAll() {
        List<Customers> result = customersController.findAll();
        Assertions.assertEquals(Arrays.<Customers>asList(new Customers(0, "james", "johnson", 0, "texas", "iin", true, LocalDate.of(2022, Month.APRIL, 15))), result);
    }

    @Test
    void testAddCustomer() {
        when(customersService.save(any())).thenReturn("saveResponse");

        String result = customersController.addCustomer(new Customers(0, "james", "johnson", 0, "texas", "iin", true, LocalDate.of(2022, Month.APRIL, 15)));
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testUpdateAccount() {
        when(customersService.update(any())).thenReturn("updateResponse");

        String result = customersController.updateAccount(new Customers(0, "james", "johnson", 0, "texas", "iin", true, LocalDate.of(2022, Month.APRIL, 15)));
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testGetById() {
        when(customersService.getById(anyInt())).thenReturn(new Customers(0, "james", "johnson", 0, "texas", "iin", true, LocalDate.of(2022, Month.APRIL, 15)));

        Customers result = customersController.getById(Integer.valueOf(0));
        Assertions.assertEquals(new Customers(0, "james", "johnson", 0, "texas", "iin", true, LocalDate.of(2022, Month.APRIL, 15)), result);
    }

    @Test
    void testDeleteById() {
        String result = customersController.deleteById(Integer.valueOf(0));
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testDoubleNumber() {
        ResponseEntity<String> result = customersController.doubleNumber(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testMultiValue() {
        ResponseEntity<String> result = customersController.multiValue(null);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testPostCustomer() {
        customersController.postCustomer("contentType", new Customers(0, "james", "johnson", 0, "texas", "iin", true, LocalDate.of(2022, Month.APRIL, 15)));
    }

    @Test
    void testEvaluateNonRequiredHeader() {
        ResponseEntity<String> result = customersController.evaluateNonRequiredHeader("optionalHeader");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetCustomerStatus() {
        String result = customersController.getCustomerStatus(Integer.valueOf(0));
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme