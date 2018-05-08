package com.mathtasticgames.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * The type Game.
 */
@Entity(name = "Game")
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private LocalDate date;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "game", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<GameQuestion> gameQuestions;

    /**
     * Instantiates a new Game.
     *
     * @param date          the date
     * @param user          the user
     */
    public Game(LocalDate date, User user) {
        this();
        this.date = date;
        this.user = user;
    }

    /**
     * Instantiates a new Game.
     */
    public Game() {
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
     * Gets date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets game questions.
     *
     * @return the game questions
     */
    public Set<GameQuestion> getGameQuestions() {
        return gameQuestions;
    }

    /**
     * Sets game questions.
     *
     * @param gameQuestions the game questions
     */
    public void setGameQuestions(Set<GameQuestion> gameQuestions) {
        this.gameQuestions = gameQuestions;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", date=" + date +
                ", user=" + user +
                ", gameQuestions=" + gameQuestions +
                '}';
    }
}
