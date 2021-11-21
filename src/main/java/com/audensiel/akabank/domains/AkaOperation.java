package com.audensiel.akabank.domains;



import com.audensiel.akabank.enums.AkaOperationType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AkaOperation {

    private AkaOperationType operationType;

    private LocalDate operationDate;

    private BigDecimal amount;

    private BigDecimal remainingBalance;

    public AkaOperation(AkaOperationType operationType, LocalDate operationDate, BigDecimal amount, BigDecimal remainingBalance) {
        this.operationType = operationType;
        this.operationDate = operationDate;
        this.amount = amount;
        this.remainingBalance = remainingBalance;
    }

    public AkaOperation() {
    }

    public AkaOperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(AkaOperationType operationType) {
        this.operationType = operationType;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(BigDecimal remainingBalance) {
        this.remainingBalance = remainingBalance;
    }
}
