package org.ebank.ebankbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.ebank.ebankbackend.enums.AccountStatus;

import java.util.Date;

@Data
public class BankAccountDTO {

    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private String type;





}
