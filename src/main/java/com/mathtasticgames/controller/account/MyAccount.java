package com.mathtasticgames.controller.account;

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
import java.util.ArrayList;

@WebServlet(
        urlPatterns = {"/myAccount"}
)
@SuppressWarnings("unchecked")
public class MyAccount extends HttpServlet {

    private final Dao userDao = new Dao(User.class);
    private static final String PARENT_ROLE = "parent";
    private static final String URL = "account/myAccount.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) userDao.getByProperty(request.getRemoteUser(), "email").get(0);
        ArrayList<User> users = new ArrayList<User>();

        for (Role role : user.getRoles()) {
            if (role.getRoleName().equals(PARENT_ROLE)) {
                users = getUsersByAccount(user.getAccount().getId());
                break;
            }
        }

        if (users.isEmpty()) {
            users.add(user);
        }

        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher(URL);
        dispatcher.forward(request, response);
    }

    private ArrayList<User> getUsersByAccount(int accountId) {
        ArrayList<User> users = (ArrayList<User>) userDao.getAll();
        for (User user : users) {
            if (user.getAccount().getId() != accountId) {
                users.remove(user);
            }
        }
        return users;
    }
}
