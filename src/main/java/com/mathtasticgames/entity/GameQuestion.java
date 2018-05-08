package com.mathtasticgames.entity;

import javax.persistence.OneToMany;

public class GameQuestion {

    private int id;

    private boolean correct;

    @OneToMany
    private Game game;

    @OneToMany
    private Question question;

    public GameQuestion(Game game, Question question) {
        this();
        this.game = game;
        this.question = question;
    }

    public GameQuestion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Question getQuestion() {
        return question;
    }

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
