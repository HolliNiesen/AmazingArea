package com.mathtasticgames.persistence;

import com.mathtasticgames.entity.User;
import com.mathtasticgames.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDaoTest {

    UserDao userDao;

    /**
     * Sets up.
     * Instantiates a new UserDao.
     */
    @BeforeEach
    void setUp() {
        Database.getInstance().runSQL("resetDb.sql");
        userDao = new UserDao();
    }

    /**
     * Tests getting all users.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = userDao.getAll();
        assertEquals(2, users.size());
    }

    /**
     * Tests getting users by first name with a single letter.
     */
    @Test
    void getUsersByFirstNameWithSingleLetterSuccess() {
        List<User> users = userDao.getByFirstName("o");
        assertEquals(2, users.size());
    }

    /**
     * Tests getting users by first name with a whole name.
     */
    @Test
    void getUsersByFirstNameWithWholeNameSuccess() {
        List<User> users = userDao.getByFirstName("Holli");
        assertEquals(1, users.size());
    }

    @Test
    void getUserByIdSuccess() {
        User user = userDao.getById(1);
        assertNotNull(user);
        assertEquals("Holli", user.getFirstName());
        assertEquals(LocalDate.parse("1993-02-16"), user.getDateOfBirth());
    }

    @Test
    void insertUserSuccess() {
        User user = new User("Luna", LocalDate.parse("2011-12-08"), 1, 2);
        int id = userDao.insert(user);
        assertNotEquals(0, id);
        User insertedUser = userDao.getById(id);
        assertEquals(user.getFirstName(), insertedUser.getFirstName());
        assertEquals(user.getDateOfBirth(), insertedUser.getDateOfBirth());
        assertEquals(user.getAccountId(), insertedUser.getAccountId());
        assertEquals(user.getRoleId(), user.getRoleId());
    }
}