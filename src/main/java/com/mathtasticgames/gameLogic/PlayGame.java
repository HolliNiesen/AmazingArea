package com.mathtasticgames.gameLogic;

import com.mathtasticgames.entity.Game;
import com.mathtasticgames.entity.GameQuestion;
import com.mathtasticgames.entity.Question;
import com.mathtasticgames.entity.User;
import com.mathtasticgames.persistence.Dao;
import com.mathtasticgames.persistence.QuestionDao;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The type Play game.
 */
@SuppressWarnings("unchecked")
public class PlayGame {

    private ArrayList<GameQuestion> gameQuestions = new ArrayList<GameQuestion>();
    private final QuestionDao questionDao = new QuestionDao();
    private final Dao gameQuestionDao = new Dao(GameQuestion.class);
    private final Dao gameDao = new Dao(Game.class);
    private final Dao userDao = new Dao(User.class);
    private static final int QUESTION_LIMIT = 10;

    /**
     * Instantiates a new Play game.
     */
    public PlayGame() {
    }

    /**
     * Instantiates a new Play game.
     *
     * @param gameQuestions the game questions
     */
    public PlayGame(ArrayList<GameQuestion> gameQuestions) {
        this();
        this.gameQuestions = gameQuestions;
    }

    /**
     * Start the game.
     *
     * @param email     the email
     * @param difficult the difficult
     * @return the game
     */
    public ArrayList<GameQuestion> startGame(String email, boolean difficult) {

        Game game = insertGame((User) userDao.getByProperty(email, "email").get(0));

        String maxAnswer = "25";
        if (difficult) {
            maxAnswer = "100";
        }
        ArrayList<Question> questions = (ArrayList<Question>) questionDao.getRandomQuestions(maxAnswer, QUESTION_LIMIT);
        for (Question question : questions) {
            GameQuestion gameQuestion = new GameQuestion(game, question);
            gameQuestions.add(gameQuestion);
        }
        return gameQuestions;
    }

    public ArrayList<GameQuestion> getNextQuestion(GameQuestion gameQuestion, int answerGiven) {
        gameQuestion.setCorrect(checkAnswer(gameQuestion.getQuestion().getSolution(), answerGiven));
        insertGameQuestion(gameQuestion);
        gameQuestions.remove(gameQuestion);
        return gameQuestions;
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
