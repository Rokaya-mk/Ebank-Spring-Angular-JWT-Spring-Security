package org.ebank.ebankbackend.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ebank.ebankbackend.entities.BankAccount;
import org.ebank.ebankbackend.enums.Operationtype;

import java.util.Date;


@Data
public class AccountOperationDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private Operationtype type;
    private String desciption;

}
