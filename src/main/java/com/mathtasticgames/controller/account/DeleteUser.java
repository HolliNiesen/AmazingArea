package com.mathtasticgames.controller.account;

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
        urlPatterns = {"/deleteUser"}
)
@SuppressWarnings("unchecked")
public class DeleteUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao userDao = new Dao(User.class);
        User user = (User) userDao.getById(Integer.parseInt(request.getParameter("delete")));

        userDao.delete(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
