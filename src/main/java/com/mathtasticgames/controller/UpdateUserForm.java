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

@WebServlet(
        urlPatterns = {"/updateUserForm"}
)
public class UpdateUserForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Dao accountDao = new Dao(new Account().getClass());
        Dao roleDao = new Dao(new Role().getClass());
        Dao userDao = new Dao(new User().getClass());

        request.setAttribute("accounts", accountDao.getAll());
        request.setAttribute("roles", roleDao.getAll());

        int id = Integer.parseInt(request.getParameter("update"));
        request.setAttribute("user", userDao.getById(id));

        RequestDispatcher dispatcher = request.getRequestDispatcher("updateUser.jsp");
        dispatcher.forward(request, response);
    }
}
