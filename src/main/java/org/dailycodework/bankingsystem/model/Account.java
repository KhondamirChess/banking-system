package org.dailycodework.bankingsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name="Accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user-id")
    private int userId;
    @Column(name="balance")
    private int balance;
    public Account(int userId, int balance) {
        if (balance < 0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.userId = userId;
        this.balance = balance;
    }
    public Account() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }
    public void deposit(int amount) {
        if (amount <= 0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.balance += amount;
    }
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (balance < amount) {
            throw new IllegalStateException("Balance cannot be negative");
        }
        balance -= amount;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", balance=" + balance +
                '}';
    }

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
}

