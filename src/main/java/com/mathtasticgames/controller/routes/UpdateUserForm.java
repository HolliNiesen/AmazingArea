package com.mathtasticgames.controller.routes;

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
@SuppressWarnings("unchecked")
public class UpdateUserForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Dao accountDao = new Dao(Account.class);
        Dao roleDao = new Dao(Role.class);
        Dao userDao = new Dao(User.class);

        request.setAttribute("accounts", accountDao.getAll());
        request.setAttribute("roles", roleDao.getAll());

        int id = Integer.parseInt(request.getParameter("update"));
        request.setAttribute("user", userDao.getById(id));

        RequestDispatcher dispatcher = request.getRequestDispatcher("account/updateUser.jsp");
        dispatcher.forward(request, response);
    }
}
