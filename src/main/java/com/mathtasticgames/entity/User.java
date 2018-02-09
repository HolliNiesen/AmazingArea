package com.mathtasticgames.entity;

import java.time.LocalDate;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String accountId;
    private String roleId;

    public User() {

    }

    public User(String id, String roleId, String accountId) {
        this.id = id;
        this.accountId = accountId;
        this.roleId = roleId;
    }

    /**
     * Gets the user id.
     * @return the user id
     */
    public String getId() {
        return id;
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
     * Gets the user last name.
     * @return the user last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user last name.
     * @param lastName the user last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public String getAccountId() {
        return accountId;
    }

    /**
     * Gets the user role id.
     * @return the user role id
     */
    public String getRoleId() {
        return roleId;
    }
}
