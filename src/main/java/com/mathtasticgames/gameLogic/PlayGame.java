package com.mathtasticgames.gameLogic;

import com.mathtasticgames.entity.Game;
import com.mathtasticgames.entity.GameQuestion;
import com.mathtasticgames.entity.Question;
import com.mathtasticgames.entity.User;
import com.mathtasticgames.persistence.Dao;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The type Play game.
 */
@SuppressWarnings("unchecked")
public class PlayGame {

    private final Dao questionDao = new Dao(Question.class);
    private final Dao gameQuestionDao = new Dao(GameQuestion.class);
    private final Dao gameDao = new Dao(Game.class);
    private final Dao userDao = new Dao(User.class);
    private static final int QUESTION_LIMIT = 5;
    private static final String URL_BASE = "http://numbersapi.com/";
    private static final String URL_END = "/trivia";

    /**
     * Instantiates a new Play game.
     */
    public PlayGame() {
    }

    /**
     * Gets number fact.
     *
     * @param number the number
     * @return the number fact
     */
    public String getNumberFact(int number) {
        Client client = ClientBuilder.newClient();
        try {
            WebTarget target = client.target(URL_BASE + number + URL_END);
            return target.request(MediaType.APPLICATION_JSON).get(String.class);
        } catch (Exception e) {
            return "Could not get number fact :(";
        }
    }

    /**
     * Start the game.
     *
     * @param email     the email
     * @param difficult the difficult
     * @return the game
     */
    public Game startGame(String email, boolean difficult) {

        Game game = new Game(LocalDate.now(), (User) userDao.getByProperty(email, "email").get(0));

        String maxAnswer = "25";
        if (difficult) {
            maxAnswer = "100";
        }
        ArrayList<Question> questions = (ArrayList<Question>) questionDao.getByPropertyLessEqualThan(maxAnswer, "solution");
        for (int x = 0; x < QUESTION_LIMIT; x += 1) {
            int index = (int) (Math.random() * questions.size());
            Question question = questions.get(index);
            GameQuestion gameQuestion = new GameQuestion(game, question);
            game.getGameQuestions().add(gameQuestion);
            questions.remove(question);
        }
        return game;
    }

    public Game getGame(int id) {
        return (Game) gameDao.getById(id);
    }

    /**
     * Gets number right.
     *
     * @param gameQuestions the game questions
     * @return the number right
     */
    public int getNumberRight(ArrayList<GameQuestion> gameQuestions) {
        int count = 0;

        for (GameQuestion gameQuestion : gameQuestions) {
            if (gameQuestion.isCorrect()) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * Check answer boolean.
     *
     * @param gameQuestion  the game question
     * @param answerGiven   the answer given
     */
    public void checkAnswer(GameQuestion gameQuestion, int answerGiven) {
        gameQuestion.setCorrect(gameQuestion.getQuestion().getSolution() == answerGiven);
    }

    /**
     * Gets results.
     *
     * @param gameId the game id
     */
    public void getResults(int gameId) {
        gameDao.getById(gameId);
    }

    private Game insertGame(User user) {
        Game game = new Game(LocalDate.now(), user);
        int id = gameDao.insert(game);
        return (Game) gameDao.getById(id);
    }

    private void insertGameQuestion(GameQuestion gameQuestion) {
        gameQuestionDao.insert(gameQuestion);
    }
}
