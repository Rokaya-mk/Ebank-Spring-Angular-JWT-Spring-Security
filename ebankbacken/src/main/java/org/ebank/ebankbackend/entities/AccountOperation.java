package org.ebank.ebankbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ebank.ebankbackend.enums.Operationtype;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AccountOperation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operationDate;
    private double amount;
    @Enumerated(EnumType.STRING)
    private Operationtype type;
    @ManyToOne
    private BankAccount bankAccount;

}
