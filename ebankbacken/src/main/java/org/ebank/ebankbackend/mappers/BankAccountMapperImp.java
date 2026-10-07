package org.ebank.ebankbackend.mappers;

import org.ebank.ebankbackend.dto.AccountOperationDTO;
import org.ebank.ebankbackend.dto.CurrentBankAccountDTO;
import org.ebank.ebankbackend.dto.CustomerDTO;
import org.ebank.ebankbackend.dto.SavingBankAccountDTO;
import org.ebank.ebankbackend.entities.AccountOperation;
import org.ebank.ebankbackend.entities.CurrentAccount;
import org.ebank.ebankbackend.entities.Customer;
import org.ebank.ebankbackend.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImp {

    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();

        BeanUtils.copyProperties(customer,customerDTO);
//        customerDTO.setId(customer.getId());
//        customerDTO.setName(customer.getName());
//        customerDTO.setEmail(customer.getEmail());

        return customerDTO;
    }

    public Customer fromCustomerDTO(CustomerDTO customerDTO){
        Customer customer= new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        return  customer;
    }

    public SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount){
        SavingBankAccountDTO savingBankAccountDTO = new SavingBankAccountDTO();
        BeanUtils.copyProperties(savingAccount,savingBankAccountDTO);
        savingBankAccountDTO.setType(savingAccount.getClass().getSimpleName());
        savingBankAccountDTO.setCustomerDTO(fromCustomer(savingAccount.getCustomer()));

        return  savingBankAccountDTO;
    }

    public SavingAccount fromSavingBankAccountDTO(SavingBankAccountDTO savingAccountDTO){
        SavingAccount savingAccount = new SavingAccount();
        BeanUtils.copyProperties(savingAccountDTO,savingAccount);
        return savingAccount;
    }

    public CurrentBankAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount){
        CurrentBankAccountDTO currentBankAccountDTO = new CurrentBankAccountDTO();
        BeanUtils.copyProperties(currentAccount,currentBankAccountDTO);
        currentBankAccountDTO.setType(currentAccount.getClass().getSimpleName());
        currentBankAccountDTO.setCustomerDTO(fromCustomer(currentAccount.getCustomer()));
        return  currentBankAccountDTO;
    }

    public CurrentAccount fromCurrentBankAccountDTO(CurrentBankAccountDTO currentBankAccountDTO){
        CurrentAccount currentAccount = new CurrentAccount();
        BeanUtils.copyProperties(currentBankAccountDTO,currentAccount);
        return currentAccount;
    }

    public AccountOperationDTO fromAccountOperation(AccountOperation accountOperation){
        AccountOperationDTO accountOperationDTO = new AccountOperationDTO();
        BeanUtils.copyProperties(accountOperation,accountOperationDTO);

        return accountOperationDTO;
    }
}
