package kz.nurlan.oibekuly.converter;

import kz.nurlan.oibekuly.dto.AccountDto;
import kz.nurlan.oibekuly.dto.AccountRequestDto;
import kz.nurlan.oibekuly.dto.AccountResponseDto;
import kz.nurlan.oibekuly.model.Account;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    public AccountResponseDto entityAccountToDto(Account account) {
        AccountResponseDto accountResponseDto = new AccountResponseDto();
        accountResponseDto.setAccount_id(account.getAccount_id());
        accountResponseDto.setAccountnumber(account.getAccountnumber());
        accountResponseDto.setBalance(account.getBalance());
        accountResponseDto.setInterest(account.getInterest());
        return accountResponseDto;
    }

    public Account dtoToAccount(AccountRequestDto accountRequestDto) {
        Account account = new Account();
        account.setBalance(account.getBalance());
        account.setAccountnumber(account.getAccountnumber());
        account.setInterest(account.getInterest());
        return account;
    }
    public AccountDto entityToDto (Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccount_id(account.getAccount_id());
        accountDto.setAccountnumber(account.getAccountnumber());
        accountDto.setBalance(account.getBalance());
        accountDto.setInterest(account.getInterest());
        return accountDto;
    }
}
