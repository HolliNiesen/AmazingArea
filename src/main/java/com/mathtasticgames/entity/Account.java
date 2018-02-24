package com.mathtasticgames.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Account.
 */
@Entity(name = "Account")
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String email;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "account_password")
    private String accountPassword;

    @Column(name = "parent_password")
    private String parentPassword;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    /**
     * Instantiates a new Account.
     */
    public Account() { }

    /**
     * Instantiates a new Account.
     *
     * @param email      the email
     * @param familyName the family name
     */
    public Account(String email, String familyName) {
        this();
        this.email = email;
        this.familyName = familyName;
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
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets family name.
     *
     * @return the family name
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Sets family name.
     *
     * @param familyName the family name
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * Gets account password.
     *
     * @return the account password
     */
    public String getAccountPassword() {
        return accountPassword;
    }

    /**
     * Sets account password.
     *
     * @param accountPassword the account password
     */
    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    /**
     * Gets parent password.
     *
     * @return the parent password
     */
    public String getParentPassword() {
        return parentPassword;
    }

    /**
     * Sets parent password.
     *
     * @param parentPassword the parent password
     */
    public void setParentPassword(String parentPassword) {
        this.parentPassword = parentPassword;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
