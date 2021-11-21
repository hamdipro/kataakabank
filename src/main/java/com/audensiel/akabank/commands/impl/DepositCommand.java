package com.audensiel.akabank.commands.impl;

import com.audensiel.akabank.commands.AkaCommand;
import com.audensiel.akabank.domains.AkaAccount;
import com.audensiel.akabank.domains.AkaOperation;
import com.audensiel.akabank.enums.AkaOperationType;
import com.audensiel.akabank.exceptions.AkaBankFinancialException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DepositCommand extends AkaCommand<AkaAccount> {


    private  Long accountNumber;
    private  BigDecimal amount;

    public DepositCommand(Long accountNumber, BigDecimal amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public DepositCommand() {
    }

    @Override
    public AkaAccount execute() throws AkaBankFinancialException {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new AkaBankFinancialException("Deposed amout can't be negative");
        }
        AkaAccount account = this.dao.findAccount(accountNumber).
                orElseThrow(() -> new AkaBankFinancialException("No account found with account number"));
        this.deposit(account, amount);
        return account;
    }

    public void deposit(AkaAccount account, BigDecimal amount) {
        account.setBalance(account.getBalance().add(amount));
        account.getOperations().add(new AkaOperation(AkaOperationType.DEPOSIT, LocalDate.now(), amount, account.getBalance()));
        this.dao.updateAccount(accountNumber, account);
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
