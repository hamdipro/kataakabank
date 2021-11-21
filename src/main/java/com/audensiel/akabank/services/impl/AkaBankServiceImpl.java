package com.audensiel.akabank.services.impl;

import com.audensiel.akabank.commands.impl.DepositCommand;
import com.audensiel.akabank.commands.impl.HistoryCommand;
import com.audensiel.akabank.commands.impl.WithDrawCommand;
import com.audensiel.akabank.dao.AkaAccountDAO;
import com.audensiel.akabank.domains.AkaAccount;
import com.audensiel.akabank.domains.AkaOperation;
import com.audensiel.akabank.exceptions.AkaBankFinancialException;
import com.audensiel.akabank.services.AkaBankService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class AkaBankServiceImpl implements AkaBankService {

    @Autowired
    protected AkaAccountDAO dao;

    // For Unit tests
    AkaBankServiceImpl(AkaAccountDAO dao) {
        this.dao = dao;
    }

    AkaBankServiceImpl() {
    }


    @Override
    public AkaAccount deposit(Long accountNumber, BigDecimal amount) throws AkaBankFinancialException {
        DepositCommand command = new DepositCommand(accountNumber, amount);
        command.setDao(dao);
        return command.execute();
    }

    @Override
    public AkaAccount withDraw(Long accountNumber, BigDecimal amount) throws AkaBankFinancialException {
        WithDrawCommand command = new WithDrawCommand(accountNumber, amount);
        command.setDao(dao);
        return command.execute();
    }

    @Override
    public List<AkaOperation> getClientHistory(Long accountNumber) throws AkaBankFinancialException {
        HistoryCommand command = new HistoryCommand(accountNumber);
        command.setDao(dao);
        return command.execute();
    }
}
