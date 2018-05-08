package com.mathtasticgames.controller.gamePlay;

import com.mathtasticgames.entity.Game;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/askQuestion"}
)
@SuppressWarnings("unchecked")
public class AskQuestion extends HttpServlet {

    private static final String NEXT_QUESTION_URL = "game/askQuestion.jsp";
    private static final String END_GAME_URL = "endGame";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Game game = (Game) session.getAttribute("game");
        RequestDispatcher dispatcher;

        if (!game.getGameQuestions().isEmpty()) {
            dispatcher = request.getRequestDispatcher(NEXT_QUESTION_URL);
            dispatcher.forward(request, response);
        }

        dispatcher = request.getRequestDispatcher(END_GAME_URL);
        dispatcher.forward(request, response);
    }
}
