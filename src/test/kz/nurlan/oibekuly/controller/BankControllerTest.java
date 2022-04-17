package kz.nurlan.oibekuly.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import kz.nurlan.oibekuly.controller.BankController;
import kz.nurlan.oibekuly.model.Bank;
import kz.nurlan.oibekuly.service.BankService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BankController.class})
@ExtendWith(SpringExtension.class)
class BankControllerTest {
    @Autowired
    private BankController bankController;

    @MockBean
    private BankService bankService;

    @Test
    void testFindAll() throws Exception {
        when(this.bankService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/findAll");
        MockMvcBuilders.standaloneSetup(this.bankController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetById() throws Exception {
        Bank bank = new Bank();
        bank.setBank_id(1);
        bank.setBankname("Home bank");
        bank.setCustomer_account_number(1234567890L);
        when(this.bankService.getById((Integer) any())).thenReturn(bank);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/findBankById/{bank_id}", 1);
        MockMvcBuilders.standaloneSetup(this.bankController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                    "{\"bank_id\":1,\"bankname\":\"Home bank\",\"customer_account_number\":1234567890}"));
    }

    @Test
    void testAddBank() throws Exception {
        doNothing().when(this.bankService).save((Bank) any());

        Bank bank = new Bank();
        bank.setBank_id(1);
        bank.setBankname("Home bank");
        bank.setCustomer_account_number(1234567890L);
        String content = (new ObjectMapper()).writeValueAsString(bank);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/addBank")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.bankController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(" has been saved!"));
    }

    @Test
    void testDeleteById() throws Exception {
        doNothing().when(this.bankService).deleteById((Integer) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/deleteBankById/{bank_id}", 1);
        MockMvcBuilders.standaloneSetup(this.bankController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Bank with id 1 has been deleted"));
    }

    @Test
    void testUpdateBank() throws Exception {
        doNothing().when(this.bankService).update((Bank) any());

        Bank bank = new Bank();
        bank.setBank_id(1);
        bank.setBankname("Home bank");
        bank.setCustomer_account_number(1234567890L);
        String content = (new ObjectMapper()).writeValueAsString(bank);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/updateBank")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.bankController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(" has been updated!"));
    }
}

