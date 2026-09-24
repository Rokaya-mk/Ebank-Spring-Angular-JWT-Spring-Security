package org.ebank.ebankbackend;

import org.ebank.ebankbackend.entities.AccountOperation;
import org.ebank.ebankbackend.entities.CurrentAccount;
import org.ebank.ebankbackend.entities.Customer;
import org.ebank.ebankbackend.entities.SavingAccount;
import org.ebank.ebankbackend.enums.AccountStatus;
import org.ebank.ebankbackend.enums.Operationtype;
import org.ebank.ebankbackend.exceptions.BalanceNotSufficientException;
import org.ebank.ebankbackend.exceptions.BankAccountNotFoundException;
import org.ebank.ebankbackend.exceptions.CustomerNotFoundException;
import org.ebank.ebankbackend.repositories.AccountOperationRepository;
import org.ebank.ebankbackend.repositories.BankAccountRepository;
import org.ebank.ebankbackend.repositories.CustomerRepository;
import org.ebank.ebankbackend.services.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankbackenApplication {

    public static void main(String[] args) {

        SpringApplication.run(EbankbackenApplication.class, args);
    }

    @Bean

    CommandLineRunner commandLineRunner(BankAccountService bankAccountService){
        return args -> {
            Stream.of("Salma","Asmaa","Kamal").forEach(name->{
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                bankAccountService.saveCustomer(customer);

            });

            bankAccountService.listCustomers().forEach(customer -> {
                try {
                    bankAccountService.saveCurrentBankAccount(Math.random()*40000,3000,customer.getId());
                    bankAccountService.saveCurrentBankAccount(Math.random()*2000,10,customer.getId());
                    bankAccountService.bankAccountList().forEach(account->{
                        for (int i=0 ;i<10 ; i++){
                            try {
                                bankAccountService.credit(account.getId(),1000+Math.random()*3000,"Credit");
                                bankAccountService.debit(account.getId(),100+Math.random()*2000,"Debit");

                            } catch (BankAccountNotFoundException |BalanceNotSufficientException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                }
            });
        };
    }
//    CommandLineRunner start(CustomerRepository customerRepository,
//                            BankAccountRepository bankAccountRepository,
//                            AccountOperationRepository accountOperationRepository
//                           ){
//        return args -> {
//            Stream.of("Hassan","Yassine","Aicha").forEach(name->{
//                Customer customer = new Customer();
//                customer.setName(name);
//                customer.setEmail(name+"@gmail.com");
//                customerRepository.save(customer);
//            });
//            customerRepository.findAll().forEach(c->{
//                CurrentAccount currentAccount = new CurrentAccount();
//                currentAccount.setId(UUID.randomUUID().toString());
//                currentAccount.setBalance(Math.random()*40000);
//                currentAccount.setCreatedAt(new Date());
//                currentAccount.setStatus(AccountStatus.CREATED);
//                currentAccount.setCustomer(c);
//                currentAccount.setOverDraft(600);
//                bankAccountRepository.save(currentAccount);
//
//                SavingAccount savingAccount = new SavingAccount();
//                savingAccount.setId(UUID.randomUUID().toString());
//                savingAccount.setBalance(Math.random()*40000);
//                savingAccount.setCreatedAt(new Date());
//                savingAccount.setStatus(AccountStatus.CREATED);
//                savingAccount.setCustomer(c);
//                savingAccount.setInterestRate(200);
//                bankAccountRepository.save(savingAccount);
//
//            });
//
//            // create operations
//            bankAccountRepository.findAll().forEach(acc->{
//                for (int i =0; i< 5 ; i++){
//                    AccountOperation accountOperation = new AccountOperation();
//                    accountOperation.setAmount(Math.random()*13000);
//                    accountOperation.setOperationDate(new Date());
//                    accountOperation.setType(Math.random() > 0.5 ? Operationtype.DEBIT : Operationtype.CREDIT);
//                    accountOperation.setBankAccount(acc);
//                    accountOperationRepository.save(accountOperation);
//                }
//            });
//            //show account
//
//        };
//    }

}
