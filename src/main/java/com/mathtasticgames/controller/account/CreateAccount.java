package com.mathtasticgames.controller.account;

import com.mathtasticgames.entity.Account;
import com.mathtasticgames.entity.Role;
import com.mathtasticgames.entity.User;
import com.mathtasticgames.persistence.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(
        urlPatterns = {"/createAccount"}
)
@SuppressWarnings("unchecked")
public class CreateAccount extends HttpServlet {

    private final Dao accountDao = new Dao(Account.class);
    private final Dao roleDao = new Dao(Role.class);
    private final Dao userDao = new Dao(User.class);
    private static final String FAMILY_NAME = "lastName";
    private static final String PARENT_FIRST_NAME = "parentFirstName";
    private static final String PARENT_EMAIL = "parentEmail";
    private static final String PARENT_BIRTH_DATE = "parentBirthDate";
    private static final String PARENT_PASSWORD = "parentPassword";
    private static final String PARENT_ROLE_NAME = "parentRole";
    private static final String CHILD_FIRST_NAME = "firstNameChild";
    private static final String CHILD_EMAIL = "emailChild";
    private static final String CHILD_BIRTH_DATE = "birthDateChild";
    private static final String CHILD_PASSWORD = "passwordChild";
    private static final String CHILD_ROLE_NAME = "roleChild";

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Account account = insertAccount(request, FAMILY_NAME);
        User user = insertUser(request, PARENT_EMAIL, PARENT_FIRST_NAME, PARENT_BIRTH_DATE, PARENT_PASSWORD, account);
        insertRole(request, PARENT_ROLE_NAME, user);

        int count = 0;

        while (true) {
            count += 1;
            if (request.getParameter(CHILD_FIRST_NAME + count) == null) {
                break;
            }
            user = insertUser(request, CHILD_EMAIL + count, CHILD_FIRST_NAME + count,
                    CHILD_BIRTH_DATE + count, CHILD_PASSWORD + count, account);
            insertRole(request, CHILD_ROLE_NAME + count, user);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private Account insertAccount(HttpServletRequest request, String familyName) {

        Account account = new Account(request.getParameter(familyName));
        int accountId = accountDao.insert(account);
        account.setId(accountId);
        return account;
    }

    private void insertRole(HttpServletRequest request, String roleName, User user) {
        Role role = new Role(request.getParameter(roleName), user);
        roleDao.insert(role);
    }

    private User insertUser(HttpServletRequest request, String email, String firstName, String birthDate, String password,
            Account account) {
        String emailInput = request.getParameter(email);
        String firstNameInput = request.getParameter(firstName);
        LocalDate birthDateInput = LocalDate.parse(request.getParameter(birthDate));
        String passwordInput = request.getParameter(password);

        User user = new User(emailInput, firstNameInput, birthDateInput, passwordInput, account);
        int id = userDao.insert(user);
        user.setId(id);
        return user;
    }
}
