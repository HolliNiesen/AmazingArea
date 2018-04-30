package com.mathtasticgames.controller.form;

import com.mathtasticgames.entity.Account;
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

        request.setAttribute("accounts", accountDao.getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("account/addUser.jsp");
        dispatcher.forward(request, response);
    }
}
