package com.audensiel.akabank.domains;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AkaAccount {

    private Long accountNumber;

    private String lastName;

    private String firstName;

    private BigDecimal balance;

    private final List<AkaOperation> operations  = new ArrayList<>();

    public AkaAccount(Long accountNumber, String lastName, String firstName, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.balance = balance;
    }

    public AkaAccount() {
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<AkaOperation> getOperations() {
        return operations;
    }


}
