package com.mathtasticgames.controller.gamePlay;

import com.mathtasticgames.entity.Game;
import com.mathtasticgames.entity.GameQuestion;
import com.mathtasticgames.gameLogic.PlayGame;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(
        urlPatterns = {"/endGame"}
)
@SuppressWarnings("unchecked")
public class EndGame extends HttpServlet {

    private static final String URL = "game/endGame.jsp";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PlayGame playGame = new PlayGame();
        HttpSession session = request.getSession();

        ArrayList<GameQuestion> gameQuestions = (ArrayList<GameQuestion>) session.getAttribute("originalGameQuestions");
        request.setAttribute("numberRight", playGame.getNumberRight(gameQuestions));

        RequestDispatcher dispatcher = request.getRequestDispatcher(URL);
        dispatcher.forward(request, response);
    }
}
