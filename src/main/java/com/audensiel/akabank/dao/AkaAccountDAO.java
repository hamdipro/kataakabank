package com.audensiel.akabank.dao;

import com.audensiel.akabank.domains.AkaAccount;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class AkaAccountDAO {

    private final Map<Long, AkaAccount> akaAccountMap = new HashMap<>();


    public Optional<AkaAccount> findAccount(Long accountNumber) {
        if (akaAccountMap.containsKey(accountNumber)) {
            return Optional.of(akaAccountMap.get(accountNumber));
        } else {
            return Optional.empty();
        }
    }

    public void updateAccount(Long accountNumber, AkaAccount account) {
        if (akaAccountMap.containsKey(accountNumber)) {
            akaAccountMap.put(accountNumber, account);
        }
    }

    /**
     * user for Unit tests
     */
    public void initAccounts() {
        akaAccountMap.put(1L,
                new AkaAccount(1L, "Test", "Test User", new BigDecimal(12)));
        akaAccountMap.put(2L,
                new AkaAccount(2L, "Test", "Test User", new BigDecimal(12)));
        akaAccountMap.put(3L,
                new AkaAccount(3L, "Test", "Test User", new BigDecimal(12)));
        akaAccountMap.put(4L,
                new AkaAccount(4L, "Test", "Test User", new BigDecimal(12)));
        akaAccountMap.put(5L,
                new AkaAccount(5L, "Test", "Test User", new BigDecimal(12)));
    }
}
