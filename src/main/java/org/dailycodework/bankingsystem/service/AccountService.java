package org.dailycodework.bankingsystem.service;
import org.dailycodework.bankingsystem.model.Account;
import org.dailycodework.bankingsystem.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class AccountService {
    //Сервис для управления счетами. Содержит методы для создания счета, пополнения и
    //снятия средств, перевода средств между счетами и закрытия счета.
    @Value("${account.default-amount}")
    private int accountCounter;
    private final Map<Integer, Account> accounts = new HashMap<>();
    public Account createAccount(User user) {
        Account account = new Account();
        account.setId(accountCounter++);
        account.setUserId(user.getId());
        account.setBalance(0);
        user.getAccountList().add(account);
        accounts.put(account.getId(), account);
        return account;
    }
    public void closeAccount(int accountId) {
        Account closingAccount = accounts.get(accountId);
        if (closingAccount == null) {
            throw new RuntimeException("Account with id " + accountId + " not found");
        }
        int userId = closingAccount.getUserId();
        List<Account> userAccounts = new ArrayList<>();
        for (Account account : accounts.values()) {
            if (account.getUserId() == userId) {
                userAccounts.add(account);
            }
        }
        if (userAccounts.size() == 1) {
            throw new RuntimeException("User has only one account");
        }
        Account targetAccount = userAccounts.stream()
                .filter(a -> a.getId() != accountId)
                .min(Comparator.comparingInt(Account::getId))
                .orElseThrow();
        int balance = closingAccount.getBalance();
        if (balance > 0) {
            closingAccount.withdraw(balance);
            targetAccount.deposit(balance);
        }
        accounts.remove(accountId);
    }
    public void deposit(int accountId, int amount) {
        if (amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        Account account = accounts.get(accountId);
        if (account == null) {
            throw new RuntimeException("Account with id " + accountId + " not found");
        }
        account.deposit(amount);
    }
    public void transfer(int fromAccountId, int toAccountId, int amount) {
        if (fromAccountId == toAccountId) {
            throw new IllegalArgumentException("Source and target accounts must be different");
        }
        if (amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);
        if (fromAccount == null){
            throw new IllegalArgumentException("Account with id " + fromAccountId + " not found");
        }
        if (toAccount == null){
            throw new IllegalArgumentException("Account with id " + toAccountId + " not found");
        }
        if (fromAccount.getBalance() < amount){
            throw new IllegalArgumentException("Insufficient funds");
        }
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
    public void withdraw(int accountId, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        Account account = accounts.get(accountId);
        if (account == null) {
            throw new IllegalArgumentException("Account with id " + accountId + " not found");
        }
        account.withdraw(amount);
    }
}
