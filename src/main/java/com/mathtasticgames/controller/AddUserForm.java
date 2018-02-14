package com.mathtasticgames.controller;

import com.mathtasticgames.entity.Account;
import com.mathtasticgames.entity.Role;
import com.mathtasticgames.persistence.Dao;

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
@SuppressWarnings("unchecked")
public class AddUserForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Dao accountDao = new Dao(Account.class);
        Dao roleDao = new Dao(Role.class);

        request.setAttribute("accounts", accountDao.getAll());
        request.setAttribute("roles", roleDao.getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("addUser.jsp");
        dispatcher.forward(request, response);
    }
}
