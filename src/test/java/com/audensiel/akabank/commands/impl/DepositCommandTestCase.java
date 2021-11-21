package com.audensiel.akabank.commands.impl;

import com.audensiel.akabank.dao.AkaAccountDAO;
import com.audensiel.akabank.exceptions.AkaBankFinancialException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {DepositCommand.class})
@RunWith(SpringRunner.class)
public class DepositCommandTestCase {

    @Mock
    AkaAccountDAO dao;

    @Mock
    DepositCommand depositCommand;

    @Before
    public void init() {
        depositCommand = Mockito.mock(DepositCommand.class);
        depositCommand.setDao(dao);
        depositCommand.setAmount(new BigDecimal(12));
        depositCommand.setAccountNumber(12L);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void depositTestCaseExceptionNoAccountFound() throws AkaBankFinancialException {
       try{
           doReturn(Optional.empty()).when(dao).findAccount(anyLong());
           depositCommand.execute();
       } catch (Exception e){
           verify(depositCommand).execute();
           verify(dao).findAccount(anyLong());
       }
    }

}
