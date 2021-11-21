package com.audensiel.akabank.services;

import com.audensiel.akabank.domains.AkaAccount;
import com.audensiel.akabank.domains.AkaOperation;
import com.audensiel.akabank.exceptions.AkaBankFinancialException;

import java.math.BigDecimal;
import java.util.List;

public interface AkaBankService<T> {

    /**
     * deposit method (can be used in main class or called by rest controller as needed)
     * @param accountNumber given account Number
     * @param amount given amount to deposit
     * @return return the Aka Account
     * @throws AkaBankFinancialException thrown when a financial exception detected
     */
    AkaAccount deposit(Long accountNumber, BigDecimal amount) throws AkaBankFinancialException;

    /**
     * withdrow method
     * @param accountNumber given account Number
     * @param amount given amount to withdraw
     * @return return the Aka Account
     * @throws AkaBankFinancialException thrown when a financial exception detected
     */
    AkaAccount withDraw(Long accountNumber, BigDecimal amount) throws AkaBankFinancialException;

    /**
     * get client history
     * @param accountNumber given account number
     * @return return list operations
     * @throws AkaBankFinancialException thrown when a financial exception detected
     */
    List<AkaOperation> getClientHistory(Long accountNumber) throws AkaBankFinancialException;


}
