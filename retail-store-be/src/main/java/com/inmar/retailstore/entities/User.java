package com.inmar.retailstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(name = "uk_user", columnNames = {"username"})})
public class User extends AbstractEntity {

    private String username;

    private String password;

    @Column(name = "username", length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Column(name = "password", length = 1023)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
