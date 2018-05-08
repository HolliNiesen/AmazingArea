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
        urlPatterns = {"/answerQuestion"}
)
@SuppressWarnings("unchecked")
public class AnswerQuestion extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int answer = Integer.parseInt(request.getParameter("answer"));
        PlayGame playGame = new PlayGame();
        Game game = (Game) session.getAttribute("game");
        session.setAttribute("game", playGame.getNextQuestion(game, (GameQuestion) game.getGameQuestions().toArray()[0], answer));
        request.setAttribute("numberFact", playGame.getNumberFact(answer));

        RequestDispatcher dispatcher = request.getRequestDispatcher("game/answerQuestion.jsp");
        dispatcher.forward(request, response);
    }
}
