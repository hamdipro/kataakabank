package com.audensiel.akabank.dao;

import com.audensiel.akabank.domains.AkaAccount;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;


@SpringBootTest(classes = {AkaAccountDAO.class})
@RunWith(SpringRunner.class)
public class AkaAccountDAOTestCase {

    @Autowired
    private AkaAccountDAO akaAccountDAO;

    @Before
    public void init() {
        akaAccountDAO.initAccounts();
    }

    @Test
    public void findAccountTestCaseEmpty() {
        Optional<AkaAccount> account = akaAccountDAO.findAccount(11L);
        assertFalse(account.isPresent());
    }

    @Test
    public void findAccountTestCaseFound() {
        Optional<AkaAccount> account = akaAccountDAO.findAccount(1L);
        assertTrue(account.isPresent());
    }

    @Test
    public void updateAccountTestCase() {
        Optional<AkaAccount> account = akaAccountDAO.findAccount(1L);
        assertTrue(account.isPresent());
        account.get().setFirstName("Updated firstname");
        akaAccountDAO.updateAccount(1L, account.get());
        account = akaAccountDAO.findAccount(1L);
        assertTrue(account.isPresent());
        assertEquals(account.get().getFirstName(), "Updated firstname");
    }


}
