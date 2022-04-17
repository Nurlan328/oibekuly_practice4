
package kz.nurlan.oibekuly.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import kz.nurlan.oibekuly.controller.AccountController;
import kz.nurlan.oibekuly.model.Account;
import kz.nurlan.oibekuly.service.AccountService;
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

@ContextConfiguration(classes = {AccountController.class})
@ExtendWith(SpringExtension.class)
class AccountControllerTest {
    @Autowired
    private AccountController accountController;

    @MockBean
    private AccountService accountService;

    @Test
    void testFindAll() throws Exception {
        when(this.accountService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accountController/getAccounts");
        MockMvcBuilders.standaloneSetup(this.accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testUpdate() throws Exception {
        doNothing().when(this.accountService).update((Account) any());

        Account account = new Account();
        account.setAccount_id(1);
        account.setAccountnumber(1234567890L);
        account.setBalance(10.0);
        account.setInterest(10.0);
        String content = (new ObjectMapper()).writeValueAsString(account);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/accountController/updateAccount")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(" has been updated!"));
    }

    @Test
    void testGetById() throws Exception {
        Account account = new Account();
        account.setAccount_id(1);
        account.setAccountnumber(1234567890L);
        account.setBalance(10.0);
        account.setInterest(10.0);
        when(this.accountService.getById((Integer) any())).thenReturn(account);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/accountController/findBankById/{account_id}", 1);
        MockMvcBuilders.standaloneSetup(this.accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"account_id\":1,\"accountnumber\":1234567890,\"balance\":10.0,\"interest\":10.0}"));
    }

    @Test
    void testDeleteById() throws Exception {
        doNothing().when(this.accountService).deleteById((Integer) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders
                .delete("/accountController/deleteAccountById/{account_id}", 1);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.accountController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testAddAccount() throws Exception {
        doNothing().when(this.accountService).save((Account) any());

        Account account = new Account();
        account.setAccount_id(1);
        account.setAccountnumber(1234567890L);
        account.setBalance(10.0);
        account.setInterest(10.0);
        String content = (new ObjectMapper()).writeValueAsString(account);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountController/addAccount")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(" has been saved!"));
    }
}

