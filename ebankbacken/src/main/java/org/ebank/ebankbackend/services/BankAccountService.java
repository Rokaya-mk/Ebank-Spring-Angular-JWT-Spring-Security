package org.ebank.ebankbackend.services;

import org.ebank.ebankbackend.entities.BankAccount;
import org.ebank.ebankbackend.entities.CurrentAccount;
import org.ebank.ebankbackend.entities.Customer;
import org.ebank.ebankbackend.entities.SavingAccount;
import org.ebank.ebankbackend.exceptions.BalanceNotSufficientException;
import org.ebank.ebankbackend.exceptions.BankAccountNotFoundException;
import org.ebank.ebankbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
     Customer saveCustomer(Customer customer);
     CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId ) throws CustomerNotFoundException;
     SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId ) throws CustomerNotFoundException;
     List<Customer> listCustomers();
     BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
     void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
     void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
     void transfer(String accountIdSource,String accountIdDestination,double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccount> bankAccountList();
}
