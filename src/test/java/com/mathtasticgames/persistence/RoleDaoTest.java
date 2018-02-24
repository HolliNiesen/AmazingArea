package com.mathtasticgames.persistence;

import com.mathtasticgames.entity.Role;
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
        Role role = new Role("role");
        int id = dao.insert(role);
        assertNotEquals(0, id);
        Role insertedRole = (Role) dao.getById(id);
        assertEquals(role.getName(), insertedRole.getName());
    }

    @Test
    void deleteRoleSuccess() {
        Role role = (Role) dao.getById(3);
        dao.delete(role);
        assertNull(dao.getById(3));
    }

    @Test
    void updateRoleSuccess() {
        Role role = (Role) dao.getById(1);
        role.setName("new");
        dao.saveOrUpdate(role);
        Role updatedRole = (Role) dao.getById(1);
        assertEquals(role.getName(), updatedRole.getName());
    }

    @Test
    void getRoleByNameSuccess() {
        ArrayList<Role> roles = (ArrayList<Role>) dao.getByProperty("parent", "name");
        assertEquals(1, roles.size());
        assertEquals("parent", roles.get(0).getName());
    }

    @Test
    void getAllRolesSuccess() {
        ArrayList<Role> roles = (ArrayList<Role>) dao.getAll();
        assertEquals(3, roles.size());
    }
}
