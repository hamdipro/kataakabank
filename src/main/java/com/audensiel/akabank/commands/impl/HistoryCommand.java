package com.audensiel.akabank.commands.impl;

import com.audensiel.akabank.commands.AkaCommand;
import com.audensiel.akabank.domains.AkaAccount;
import com.audensiel.akabank.domains.AkaOperation;
import com.audensiel.akabank.exceptions.AkaBankFinancialException;

import java.util.List;

public class HistoryCommand extends AkaCommand<List<AkaOperation>> {

    private final Long accountNumber;

    public HistoryCommand(Long accountNumber) {
        this.accountNumber = accountNumber;
    }


    @Override
    public List<AkaOperation> execute() throws AkaBankFinancialException {
        AkaAccount account = this.dao.findAccount(accountNumber).
                orElseThrow(() -> new AkaBankFinancialException("No account found with account number"));
        return account.getOperations();
    }
}
