package com.mathtasticgames.controller;

import com.mathtasticgames.persistence.AccountDao;
import com.mathtasticgames.persistence.RoleDao;
import com.mathtasticgames.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/updateUserForm"}
)
public class UpdateUserForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AccountDao accountDao = new AccountDao();
        RoleDao roleDao = new RoleDao();
        UserDao userDao = new UserDao();

        request.setAttribute("accounts", accountDao.getAll());
        request.setAttribute("roles", roleDao.getAll());

        int id = Integer.parseInt(request.getParameter("update"));
        request.setAttribute("user", userDao.getById(id));

        RequestDispatcher dispatcher = request.getRequestDispatcher("updateUser.jsp");
        dispatcher.forward(request, response);
    }
}
