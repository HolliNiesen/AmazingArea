package com.mathtasticgames.controller.gamePlay;

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
        urlPatterns = {"/answerQuestion"}
)
@SuppressWarnings("unchecked")
public class AnswerQuestion extends HttpServlet {

    private static final String URL = "game/answerQuestion.jsp";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        int answerGiven = Integer.parseInt(request.getParameter("answer"));
        PlayGame playGame = new PlayGame();

        ArrayList<GameQuestion> currentGameQuestions = (ArrayList<GameQuestion>) session.getAttribute("currentGameQuestions");
        GameQuestion gameQuestion = (GameQuestion) session.getAttribute("currentGameQuestion");
        playGame.checkAnswer(gameQuestion, answerGiven);

        currentGameQuestions.remove(gameQuestion);
        session.setAttribute("currentGameQuestions", currentGameQuestions);

        request.setAttribute("numberFact", playGame.getNumberFact(gameQuestion.getQuestion().getSolution()));

        RequestDispatcher dispatcher = request.getRequestDispatcher(URL);
        dispatcher.forward(request, response);
    }
}
