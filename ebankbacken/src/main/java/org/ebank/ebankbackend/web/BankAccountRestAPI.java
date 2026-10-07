package org.ebank.ebankbackend.web;

import org.ebank.ebankbackend.dto.AccountHistoryDTO;
import org.ebank.ebankbackend.dto.AccountOperationDTO;
import org.ebank.ebankbackend.dto.BankAccountDTO;
import org.ebank.ebankbackend.exceptions.BankAccountNotFoundException;
import org.ebank.ebankbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRestAPI {
    private BankAccountService bankAccountService;

    public BankAccountRestAPI(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountId);
    }

    @GetMapping("/accounts")
    public List<BankAccountDTO> getAccounts(){
        return bankAccountService.bankAccountList();
    }

    @GetMapping("/accounts/{id}/operations")
    public List<AccountOperationDTO> getHitory(String accountId){
        return bankAccountService.accountHitory(accountId);
    }

    @GetMapping("/accounts/{id}/pageOperations")
    public AccountHistoryDTO getAccountHitory(
                                            @PathVariable String accountId,
                                            @RequestParam(name="page",defaultValue="0") int page,
                                            @RequestParam(name="size",defaultValue="5") int size
    ){
        return bankAccountService.getAccountHistory( accountId,page,size);
    }


}
