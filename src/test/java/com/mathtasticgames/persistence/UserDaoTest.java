package com.mathtasticgames.persistence;

import com.mathtasticgames.entity.User;
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
        User user = userDao.getById("1");
        assertNotNull(user);
        assertEquals("Holli", user.getFirstName());
        assertEquals(LocalDate.parse("1993-02-16"), user.getDateOfBirth());
    }
}