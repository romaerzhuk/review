package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Account.
 *
 * @author Author
 */
@Data
@Entity
public class Account {
    @Id
    private Long id;
    private String accountNumber;
    private String bic;
    private Double amount;
}
