package com.bank;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @Test
    void testInitialBalance() {
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void testWithdraw() {
        account.deposit(200.0);
        account.withdraw(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        account.deposit(50.0);
        account.withdraw(100.0);
        assertEquals(50.0, account.getBalance()); // Withdrawal should not happen if amount > balance
    }

    @Test
    void testTransactionHistory() {
        account.deposit(100.0);
        account.withdraw(50.0);
        List<String> transactions = account.getTransactionHistory();
        assertEquals(2, transactions.size());
        assertEquals("Deposited: $100.0", transactions.get(0));
        assertEquals("Withdrew: $50.0", transactions.get(1));
    }

    @Test
    void testNegativeDeposit() {
        account.deposit(-50.0);
        assertEquals(0.0, account.getBalance()); // Balance should not change
    }

    @Test
    void testNegativeWithdraw() {
        account.withdraw(-50.0);
        assertEquals(0.0, account.getBalance()); // Balance should not change
    }
}
