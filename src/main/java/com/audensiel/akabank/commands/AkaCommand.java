package com.audensiel.akabank.commands;

import com.audensiel.akabank.dao.AkaAccountDAO;
import com.audensiel.akabank.exceptions.AkaBankFinancialException;

/**
 * Aka Command abstract class
 * @param <T> given template type
 */
public abstract class AkaCommand<T> {

    protected AkaAccountDAO dao;

    public AkaAccountDAO getDao() {
        return dao;
    }

    public void setDao(AkaAccountDAO dao) {
        this.dao = dao;
    }

    /**
     * execute command function
     * @return T template with return command type
     * @throws AkaBankFinancialException can be thrown when a financial exeption detected
     */
    public abstract T execute() throws AkaBankFinancialException;


    // We can add rollback method to rollback the command as transaction
    // public abstract T rollback() throws AkaBankFinancialException;

}
