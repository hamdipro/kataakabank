package com.audensiel.akabank.dtos;

import com.audensiel.akabank.enums.AkaOperationType;

import java.math.BigDecimal;

public class AkaCommandDTO {

    private Long accountNumber;

    private BigDecimal amount;

    private AkaOperationType operationType;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public AkaOperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(AkaOperationType operationType) {
        this.operationType = operationType;
    }
}
