package com.mathtasticgames.controller.gamePlay;

import com.mathtasticgames.entity.GameQuestion;

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
        urlPatterns = {"/askQuestion"}
)
@SuppressWarnings("unchecked")
public class AskQuestion extends HttpServlet {

    private static final String NEXT_QUESTION_URL = "game/askQuestion.jsp";
    private static final String END_GAME_URL = "/endGame";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList<GameQuestion> currentGameQuestions = (ArrayList<GameQuestion>) session.getAttribute("currentGameQuestions");

        RequestDispatcher dispatcher;

        if (!currentGameQuestions.isEmpty()) {
            session.setAttribute("currentGameQuestion", currentGameQuestions.get(0));
            dispatcher = request.getRequestDispatcher(NEXT_QUESTION_URL);
            dispatcher.forward(request, response);
        }

        dispatcher = request.getRequestDispatcher(END_GAME_URL);
        dispatcher.forward(request, response);
    }
}
