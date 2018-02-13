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

    @ManyToOne
    private Account account;

    @ManyToOne
    private Role role;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName   the first name
     * @param dateOfBirth the date of birth
     * @param account     the account
     * @param role        the role
     */
    public User(String firstName, LocalDate dateOfBirth, Account account, Role role) {
        this();
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.account = account;
        this.role = role;
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user id.
     *
     * @param id the user id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the user first name.
     *
     * @return the user first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user first name.
     *
     * @param firstName the user first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the user date of birth.
     *
     * @return the user date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the user date of birth.
     *
     * @param dateOfBirth the user date of birth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets account.
     *
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets account.
     *
     * @param account the account
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Gets the user age in years.
     *
     * @return the user age in years
     */
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
