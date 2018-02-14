package com.mathtasticgames.controller;

import com.mathtasticgames.entity.User;
import com.mathtasticgames.persistence.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet to get users.
 * @author hniesen
 */

@WebServlet(
        urlPatterns = {"/getUsers"}
)
@SuppressWarnings("unchecked")
public class GetUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao userDao = new Dao(User.class);

        String searchType = request.getParameter("submit");

        if (searchType.equals("all")) {
            request.setAttribute("users", userDao.getAll());
        } else {
            request.setAttribute("users", userDao.getByProperty(request.getParameter("term"), "firstName"));
        }



        RequestDispatcher dispatcher = request.getRequestDispatcher("/users.jsp");
        dispatcher.forward(request, response);
    }
}
