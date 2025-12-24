package org.dailycodework.bankingsystem.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="login")
    private String login;
    @Column(name="account-list")
    private List<Account> accountList = new ArrayList<>();
    public User( String login, List<Account> accountList) {
        this.login = login;
        this.accountList = accountList;
    }
    public User() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public List<Account> getAccountList() {
        return accountList;
    }
    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
