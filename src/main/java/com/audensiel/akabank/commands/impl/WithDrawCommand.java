package com.audensiel.akabank.commands.impl;

import com.audensiel.akabank.commands.AkaCommand;
import com.audensiel.akabank.domains.AkaAccount;
import com.audensiel.akabank.domains.AkaOperation;
import com.audensiel.akabank.enums.AkaOperationType;
import com.audensiel.akabank.exceptions.AkaBankFinancialException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WithDrawCommand extends AkaCommand<AkaAccount> {


    private final Long accountNumber;
    private final BigDecimal amount;

    public WithDrawCommand(Long accountNumber, BigDecimal amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }


    @Override
    public AkaAccount execute() throws AkaBankFinancialException {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new AkaBankFinancialException("with draw amout can't be negative");
        }
        AkaAccount account = this.dao.findAccount(accountNumber).
                orElseThrow(() -> new AkaBankFinancialException("No account found with account number"));
        if (this.canWithDraw(account, amount)) {
            this.withDraw(account, amount);
        }
        return account;
    }



    public void withDraw(AkaAccount account, BigDecimal amount) {
        account.setBalance(account.getBalance().subtract(amount));
        account.getOperations().add(new AkaOperation(AkaOperationType.WITHDRAWAL, LocalDate.now(), amount, account.getBalance()));
        this.dao.updateAccount(accountNumber, account);
    }

    public boolean canWithDraw(AkaAccount account, BigDecimal amount) {
        BigDecimal projectedBalance = BigDecimal.valueOf(account.getBalance().doubleValue() - amount.doubleValue());
        return projectedBalance.compareTo(BigDecimal.ZERO) > 0;
    }

}
