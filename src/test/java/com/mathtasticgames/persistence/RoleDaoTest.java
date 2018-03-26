package com.mathtasticgames.persistence;

import com.mathtasticgames.entity.Role;
import com.mathtasticgames.entity.User;
import com.mathtasticgames.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unchecked")
public class RoleDaoTest {

    private Dao dao;

    @BeforeEach
    void SetUp() {
        Database database = Database.getInstance();
        database.runSQL("resetDb.sql");
        dao = new Dao(Role.class);
    }

    @Test
    void createRoleSuccess() {
        Dao userDao = new Dao(User.class);
        User user = (User) userDao.getById(2);
        Role role = new Role("child", user);
        int id = dao.insert(role);
        assertNotEquals(0, id);
        Role insertedRole = (Role) dao.getById(id);
        assertEquals(role.getRoleName(), insertedRole.getRoleName());
    }

    @Test
    void deleteRoleSuccess() {
        Role role = (Role) dao.getById(1);
        dao.delete(role);
        assertNull(dao.getById(1));
    }

    @Test
    void updateRoleSuccess() {
        Role role = (Role) dao.getById(1);
        role.setRoleName("new");
        dao.saveOrUpdate(role);
        Role updatedRole = (Role) dao.getById(1);
        assertEquals(role.getRoleName(), updatedRole.getRoleName());
    }

    @Test
    void getRoleByNameSuccess() {
        ArrayList<Role> roles = (ArrayList<Role>) dao.getByProperty("parent", "roleName");
        assertEquals(1, roles.size());
        assertEquals("parent", roles.get(0).getRoleName());
    }

    @Test
    void getAllRolesSuccess() {
        ArrayList<Role> roles = (ArrayList<Role>) dao.getAll();
        assertEquals(1, roles.size());
    }
}
