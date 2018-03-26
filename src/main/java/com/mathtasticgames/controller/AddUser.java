package com.mathtasticgames.controller;



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
        urlPatterns = {"/addUser"}
)
@SuppressWarnings("unchecked")
public class AddUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Dao accountDao = new Dao(Account.class);
        Dao roleDao = new Dao(Role.class);
        Dao userDao = new Dao(User.class);

        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
        String password = request.getParameter("password");
        String roleName = request.getParameter("role");

        Account account = (Account) accountDao.getById(Integer.parseInt(request.getParameter("account")));

        User user = new User(email, firstName, dateOfBirth, password, account);
        int id = userDao.insert(user);
        user.setId(id);

        Role role = new Role(roleName, user);
        roleDao.insert(role);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
