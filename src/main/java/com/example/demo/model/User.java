package com.example.demo.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @Column(name = "userid")
    private String userid;

    @Column(name = "username",unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "cretaedOn")
    private Date date;

    @Column(name = "roles")
    private String roles;

    @Column(name = "active")
    private boolean active;

    public User() {
    }

    public User(String username, String password, String email, Date date, String roles, boolean active) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.date = date;
        this.roles = roles;
        this.active = active;
    }

    public String getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Date getDate() {
        return date;
    }

    public String getRoles() {
        return roles;
    }

    public boolean getActive() {
        return active;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
