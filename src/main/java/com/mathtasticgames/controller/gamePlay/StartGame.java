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

@WebServlet(
        urlPatterns = {"/startGame"}
)
@SuppressWarnings("unchecked")
public class StartGame extends HttpServlet {

    private final PlayGame playGame = new PlayGame();
    private static final String DIFFICULT = "hardQuestions";
    private static final String URL = "game/askQuestion.jsp";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Game game = playGame.startGame(request.getRemoteUser(), request.getParameter(DIFFICULT) != null);
        HttpSession session = request.getSession();
        session.setAttribute("game", game);
        RequestDispatcher dispatcher = request.getRequestDispatcher(URL);
        dispatcher.forward(request, response);
    }
}
