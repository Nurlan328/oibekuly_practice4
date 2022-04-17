package kz.nurlan.oibekuly.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import kz.nurlan.oibekuly.controller.CustomersController;
import kz.nurlan.oibekuly.model.Customers;
import kz.nurlan.oibekuly.repository.CustomersRepository;
import kz.nurlan.oibekuly.service.CustomersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CustomersController.class})
@ExtendWith(SpringExtension.class)
class CustomersControllerTest1 {
    @Autowired
    private CustomersController customersController;

    @MockBean
    private CustomersRepository customersRepository;

    @MockBean
    private CustomersService customersService;

    @Test
    void testFindAll() throws Exception {
        when(this.customersRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/getCustomers");
        MockMvcBuilders.standaloneSetup(this.customersController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testAddCustomer() throws Exception {
        when(this.customersService.save((Customers) any())).thenReturn("https://example.org/example");

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
        String content = (new ObjectMapper()).writeValueAsString(customers);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/addCustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.customersController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(" has been saved!"));
    }

    @Test
    void testDeleteById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/deleteCustomerById/{customer_id}", 1);
        MockMvcBuilders.standaloneSetup(this.customersController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        "Customer with id 1 has been deleted"));
    }

    @Test
    void testDoubleNumber() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/double").header("my-number", 10);
        MockMvcBuilders.standaloneSetup(this.customersController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("10 * 2 = 20"));
    }

    @Test
    void testEvaluateNonRequiredHeader() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/nonRequiredHeader");
        MockMvcBuilders.standaloneSetup(this.customersController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Was the optional header present? No!"));
    }

    @Test
    void testMultiValue() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/multiValue");
        MockMvcBuilders.standaloneSetup(this.customersController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Listed 0 headers"));
    }

    @Test
    void testPostCustomer() throws Exception {
        Customers customers = new Customers();
        customers.setAddress("Seyfullina 32");
        customers.setAge(1);
        customers.setCustomer_id(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        customers.setDateOfBirth(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        customers.setFirstname("Jane");
        customers.setIin("017383948394834");
        customers.setLastname("Doe");
        customers.setRegistered(true);
        String content = (new ObjectMapper()).writeValueAsString(customers);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/postCustomer")
                .header("content-type", "Not all who wander are lost")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.customersController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testUpdateAccount() throws Exception {
        when(this.customersService.update((Customers) any())).thenReturn("2020-03-01");

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
        String content = (new ObjectMapper()).writeValueAsString(customers);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/updateCustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.customersController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(" has been updated!"));
    }
}

