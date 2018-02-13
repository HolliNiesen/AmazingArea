package com.mathtasticgames.controller;

import com.mathtasticgames.persistence.AccountDao;
import com.mathtasticgames.persistence.RoleDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/addUserForm"}
)
public class AddUserForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AccountDao accountDao = new AccountDao();
        RoleDao roleDao = new RoleDao();

        request.setAttribute("accounts", accountDao.getAll());
        request.setAttribute("roles", roleDao.getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("addUser.jsp");
        dispatcher.forward(request, response);
    }
}
