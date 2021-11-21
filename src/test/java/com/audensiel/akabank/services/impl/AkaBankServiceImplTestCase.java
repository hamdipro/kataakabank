package com.audensiel.akabank.services.impl;

import com.audensiel.akabank.dao.AkaAccountDAO;
import com.audensiel.akabank.exceptions.AkaBankFinancialException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest(classes = {AkaBankServiceImpl.class})
@RunWith(SpringRunner.class)
public class AkaBankServiceImplTestCase {

    @Mock
    AkaAccountDAO dao;

    @InjectMocks
    AkaBankServiceImpl akaBankService;

    @Before
    public void init() {
        akaBankService = Mockito.mock(AkaBankServiceImpl.class);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void depositTestCaseException() throws AkaBankFinancialException {
        try {
            akaBankService.deposit(12L, new BigDecimal(12));
        } catch (Exception e) {
            Mockito.verify(akaBankService).deposit(anyLong(), any());
            Mockito.verify(dao).findAccount(anyLong());
        }
    }

    @Test
    public void withDrawTestCaseException() throws AkaBankFinancialException {
        try {
            akaBankService.withDraw(12L, new BigDecimal(12));
        } catch (Exception e) {
            Mockito.verify(akaBankService).deposit(anyLong(), any());
            Mockito.verify(dao).findAccount(anyLong());
        }
    }

}
