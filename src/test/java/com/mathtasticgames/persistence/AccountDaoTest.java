package com.mathtasticgames.persistence;

import com.mathtasticgames.entity.Account;
import com.mathtasticgames.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unchecked")
public class AccountDaoTest {

    private Dao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("resetDb.sql");
        dao = new Dao(Account.class);
    }

    @Test
    void createAccountSuccess() {
        Account account = new Account("McFamily");
        int id = dao.insert(account);

        assertNotEquals(0, id);
        Account insertedAccount = (Account) dao.getById(id);
        assertEquals(insertedAccount.getLastName(), account.getLastName());
    }

    @Test
    void deleteAccountSuccess() {
        Account account = (Account) dao.getById(2);
        dao.delete(account);
        assertNull(dao.getById(2));
    }

    @Test
    void updateAccountSuccess() {
        Account account = (Account) dao.getById(1);
        account.setLastName("Yahnke");
        dao.saveOrUpdate(account);
        Account updatedAccount = (Account) dao.getById(1);
        assertEquals(account.getLastName(), updatedAccount.getLastName());
    }

    @Test
    void getAccountByIdSuccess() {
        Account account = (Account) dao.getById(1);
        assertEquals("Niesen", account.getLastName());
    }

    @Test
    void getAccountByEmailSuccess() {
        ArrayList<Account> accounts = (ArrayList<Account>) dao.getByProperty("Niesen", "lastName");
        assertEquals(1, accounts.size());
        assertEquals(1, accounts.get(0).getId());
    }

    @Test
    void getAllAccountsSuccess() {
        ArrayList<Account> accounts = (ArrayList<Account>) dao.getAll();
        assertEquals(2, accounts.size());
    }
}
