package com.mathtasticgames.controller;

import com.mathtasticgames.entity.*;
import com.mathtasticgames.persistence.*;

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
public class AddUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AccountDao accountDao = new AccountDao();
        RoleDao roleDao = new RoleDao();
        UserDao userDao = new UserDao();

        String firstName = request.getParameter("firstName");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));

        Role role = roleDao.getById(Integer.parseInt(request.getParameter("role")));
        Account account = accountDao.getById(Integer.parseInt(request.getParameter("account")));

        User user = new User(firstName, dateOfBirth, account, role);
        userDao.insert(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
