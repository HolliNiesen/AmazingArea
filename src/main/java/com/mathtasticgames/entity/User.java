package com.mathtasticgames.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

/**
 * Class representation of a user.
 *
 * @author hniesen
 */
@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "role_id")
    private int roleId;

    public User() {
    }

    public User(String firstName, LocalDate dateOfBirth, int accountId, int roleId) {
        this();
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.accountId = accountId;
        this.roleId = roleId;
    }

    /**
     * Gets the user id.
     * @return the user id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user id.
     * @param id the user id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the user first name.
     * @return the user first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user first name.
     * @param firstName the user first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the user date of birth.
     * @return the user date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the user date of birth.
     * @param dateOfBirth the user date of birth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the user account id.
     * @return the user account id
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Gets the user role id.
     * @return the user role id
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Gets the user age in years.
     * @return the user age in years
     */
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
