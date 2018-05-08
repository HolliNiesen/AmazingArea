package com.mathtasticgames.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Game question.
 */
@Entity(name = "GameQuestion")
@Table(name = "game_question")
public class GameQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private boolean correct;

    @ManyToOne
    private Game game;

    @ManyToOne
    private Question question;

    /**
     * Instantiates a new Game question.
     */
    public GameQuestion() {
    }

    /**
     * Instantiates a new Game question.
     *
     * @param game     the game
     * @param question the question
     */
    public GameQuestion(Game game, Question question) {
        this();
        this.game = game;
        this.question = question;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Is correct boolean.
     *
     * @return the boolean
     */
    public boolean isCorrect() {
        return correct;
    }

    /**
     * Sets correct.
     *
     * @param correct the correct
     */
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Sets game.
     *
     * @param game the game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Gets question.
     *
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Sets question.
     *
     * @param question the question
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "GameQuestion{" +
                "id=" + id +
                ", correct=" + correct +
                ", game=" + game +
                ", question=" + question +
                '}';
    }
}
