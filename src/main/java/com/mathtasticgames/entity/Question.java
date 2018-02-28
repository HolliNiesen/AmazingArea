package com.mathtasticgames.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Question.
 */
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "left_number")
    private int leftNumber;

    @Column(name = "right_number")
    private int rightNumber;

    private int solution;

    /**
     * Instantiates a new Question.
     */
    public Question() {
    }

    /**
     * Instantiates a new Question.
     *
     * @param leftNumber  the left number
     * @param rightNumber the right number
     * @param solution    the solution
     */
    public Question(int leftNumber, int rightNumber, int solution) {
        this.leftNumber = leftNumber;
        this.rightNumber = rightNumber;
        this.solution = solution;
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
     * Gets left number.
     *
     * @return the left number
     */
    public int getLeftNumber() {
        return leftNumber;
    }

    /**
     * Sets left number.
     *
     * @param leftNumber the left number
     */
    public void setLeftNumber(int leftNumber) {
        this.leftNumber = leftNumber;
    }

    /**
     * Gets right number.
     *
     * @return the right number
     */
    public int getRightNumber() {
        return rightNumber;
    }

    /**
     * Sets right number.
     *
     * @param rightNumber the right number
     */
    public void setRightNumber(int rightNumber) {
        this.rightNumber = rightNumber;
    }

    /**
     * Gets solution.
     *
     * @return the solution
     */
    public int getSolution() {
        return solution;
    }

    /**
     * Sets solution.
     *
     * @param solution the solution
     */
    public void setSolution(int solution) {
        this.solution = solution;
    }
}