package com.mathtasticgames.persistence;

import com.mathtasticgames.entity.Account;
import com.mathtasticgames.entity.Role;
import com.mathtasticgames.entity.User;
import com.mathtasticgames.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DAO tests for users.
 */
@SuppressWarnings("unchecked")
class UserDaoTest {

    private Dao accountDao;
    private Dao roleDao;
    private Dao userDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("resetDb.sql");
        accountDao = new Dao(Account.class);
        roleDao = new Dao(Role.class);
        userDao = new Dao(User.class);

    }

    /**
     * Get all users should be successful.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = userDao.getAll();
        assertEquals(2, users.size());
    }

    /**
     * Get users by first name with single letter should be successful.
     */
    @Test
    void getUsersByFirstNameWithSingleLetterSuccess() {
        List<User> users = userDao.getByProperty("o", "firstName");
        assertEquals(2, users.size());
    }

    /**
     * Get users by first name with whole name is successful.
     */
    @Test
    void getUsersByFirstNameWithWholeNameSuccess() {
        List<User> users = userDao.getByProperty("Holli", "firstName");
        assertEquals(1, users.size());
    }

    /**
     * Get user by id should be successful.
     */
    @Test
    void getUserByIdSuccess() {
        User user = (User) userDao.getById(1);
        assertNotNull(user);
        assertEquals("Holli", user.getFirstName());
        assertEquals(LocalDate.parse("1993-02-16").toString(), user.getDateOfBirth());
    }

    /**
     * Insert user should be successful.
     */
    @Test
    void insertUserSuccess() {
        User user = new User("Luna", LocalDate.parse("2011-12-08"), (Account) accountDao.getById(1), (Role) roleDao.getById(2));
        int id = userDao.insert(user);
        assertNotEquals(0, id);
        User insertedUser = (User) userDao.getById(id);
        assertEquals(user.getFirstName(), insertedUser.getFirstName());
        assertEquals(user.getDateOfBirth(), insertedUser.getDateOfBirth());
        assertEquals(user.getAccount().getId(), insertedUser.getAccount().getId());
        assertEquals(user.getRole().getId(), user.getRole().getId());
    }

    /**
     * Delete user should be successful.
     */
    @Test
    void deleteUserSuccess() {
        User user = (User) userDao.getById(2);
        userDao.delete(user);
        assertNull(userDao.getById(2));
    }

    /**
     * Update user should be successful.
     */
    @Test
    void updateUserSuccess() {
        String newFirstName = "Odyssey";
        User cosmo = (User) userDao.getById(2);
        cosmo.setFirstName(newFirstName);
        userDao.saveOrUpdate(cosmo);
        User odyssey = (User) userDao.getById(2);
        assertEquals(newFirstName, odyssey.getFirstName());
    }
}
