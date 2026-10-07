package org.ebank.ebankbackend.services;

import org.ebank.ebankbackend.dto.*;
import org.ebank.ebankbackend.entities.BankAccount;
import org.ebank.ebankbackend.entities.CurrentAccount;
import org.ebank.ebankbackend.entities.Customer;
import org.ebank.ebankbackend.entities.SavingAccount;
import org.ebank.ebankbackend.exceptions.BalanceNotSufficientException;
import org.ebank.ebankbackend.exceptions.BankAccountNotFoundException;
import org.ebank.ebankbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId ) throws CustomerNotFoundException;
     SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId ) throws CustomerNotFoundException;
     List<CustomerDTO> listCustomers();
     BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
     void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
     void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
     void transfer(String accountIdSource,String accountIdDestination,double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();

     CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHitory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
}
