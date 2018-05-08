package com.mathtasticgames.gameLogic;

import com.mathtasticgames.entity.Game;
import com.mathtasticgames.entity.GameQuestion;
import com.mathtasticgames.entity.Question;
import com.mathtasticgames.entity.User;
import com.mathtasticgames.persistence.Dao;
import com.mathtasticgames.persistence.QuestionDao;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The type Play game.
 */
@SuppressWarnings("unchecked")
public class PlayGame {

    private final QuestionDao questionDao = new QuestionDao();
    private final Dao gameQuestionDao = new Dao(GameQuestion.class);
    private final Dao gameDao = new Dao(Game.class);
    private final Dao userDao = new Dao(User.class);
    private static final int QUESTION_LIMIT = 10;
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
        WebTarget target = client.target(URL_BASE + number + URL_END);

        return target.request(MediaType.APPLICATION_JSON).get(String.class);
    }

    /**
     * Start the game.
     *
     * @param email     the email
     * @param difficult the difficult
     * @return the game
     */
    public Game startGame(String email, boolean difficult) {

        Game game = insertGame((User) userDao.getByProperty(email, "email").get(0));

        String maxAnswer = "25";
        if (difficult) {
            maxAnswer = "100";
        }
        ArrayList<Question> questions = (ArrayList<Question>) questionDao.getRandomQuestions(maxAnswer, QUESTION_LIMIT);
        for (Question question : questions) {
            GameQuestion gameQuestion = new GameQuestion(game, question);
            game.getGameQuestions().add(gameQuestion);
        }
        return game;
    }

    /**
     * Gets next question.
     *
     * @param game         the game
     * @param gameQuestion the game question
     * @param answerGiven  the answer given
     * @return the next question
     */
    public Game getNextQuestion(Game game, GameQuestion gameQuestion, int answerGiven) {
        gameQuestion.setCorrect(checkAnswer(gameQuestion.getQuestion().getSolution(), answerGiven));
        insertGameQuestion(gameQuestion);
        game.getGameQuestions().remove(gameQuestion);
        return game;
    }

    public Game getGame(int id) {
        return (Game) gameDao.getById(id);
    }

    /**
     * Gets number right.
     *
     * @param game the game
     * @return the number right
     */
    public int getNumberRight(Game game) {
        int count = 0;

        for (GameQuestion gameQuestion : game.getGameQuestions()) {
            if (gameQuestion.isCorrect()) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * Check answer boolean.
     *
     * @param answer      the answer
     * @param answerGiven the answer given
     * @return the boolean
     */
    private boolean checkAnswer(int answer, int answerGiven) {
        return answer == answerGiven;
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
