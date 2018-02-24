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
        Account account = new Account("this@email.com", "McFamily");
        account.setAccountPassword("account");
        account.setParentPassword("parent");
        int id = dao.insert(account);

        assertNotEquals(0, id);
        Account insertedAccount = (Account) dao.getById(id);
        assertEquals(insertedAccount.getEmail(), account.getEmail());
        assertEquals(insertedAccount.getFamilyName(), account.getFamilyName());
        assertEquals(insertedAccount.getAccountPassword(), account.getAccountPassword());
        assertEquals(insertedAccount.getParentPassword(), account.getParentPassword());
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
        account.setFamilyName("Yahnke");
        dao.saveOrUpdate(account);
        Account updatedAccount = (Account) dao.getById(1);
        assertEquals(account.getFamilyName(), updatedAccount.getFamilyName());
    }

    @Test
    void getAccountByIdSuccess() {
        Account account = (Account) dao.getById(1);
        assertEquals("Niesen", account.getFamilyName());
        assertEquals("holli.niesen@gmail.com", account.getEmail());
        assertEquals("family", account.getAccountPassword());
        assertEquals("parent", account.getParentPassword());
    }

    @Test
    void getAccountByEmailSuccess() {
        ArrayList<Account> accounts = (ArrayList<Account>) dao.getByProperty("holli.niesen@gmail.com", "email");
        assertEquals(1, accounts.size());
        assertEquals("Niesen", accounts.get(0).getFamilyName());
    }

    @Test
    void getAllAccountsSuccess() {
        ArrayList<Account> accounts = (ArrayList<Account>) dao.getAll();
        assertEquals(2, accounts.size());
    }
}
