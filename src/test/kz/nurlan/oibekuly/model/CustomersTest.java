package kz.nurlan.oibekuly.model;

import kz.nurlan.oibekuly.model.Customers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class CustomersTest {

    @Mock
    Date dateOfBirth;

    Date date = new Date(1993, Calendar.JANUARY, 1);
    Customers customers = new Customers(0, "Jason", "Steve", 22, "Massachusets", "9876543", true, date);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCustomertoString() {
        String result = customers.customertoString();
        String moskResult = customers.customertoString();
        Assertions.assertEquals(moskResult, result);
    }

    @Test
    void testSetCustomer_id() {
        customers.setCustomer_id(Integer.valueOf(0));
    }

    @Test
    void testSetFirstname() {
        customers.setFirstname("firstname");
    }

    @Test
    void testSetLastname() {
        customers.setLastname("lastname");
    }

    @Test
    void testSetAge() {
        customers.setAge(0);
    }

    @Test
    void testSetAddress() {
        customers.setAddress("address");
    }

    @Test
    void testSetIin() {
        customers.setIin("iin");
    }

    @Test
    void testSetRegistered() {
        customers.setRegistered(true);
    }

    @Test
    void testSetDateOfBirth() {
        customers.setDateOfBirth(new GregorianCalendar(2022, Calendar.APRIL, 15, 15, 33).getTime());
    }

//    @Test
//    void testEquals() {
//        boolean result = customers.equals("o");
//        Assertions.assertEquals(true, result);
//    }

    @Test
    void testCanEqual() {
        boolean result = customers.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = customers.hashCode();
        int mockHashCode =  customers.hashCode();
        Assertions.assertEquals(mockHashCode, result);
    }
}

