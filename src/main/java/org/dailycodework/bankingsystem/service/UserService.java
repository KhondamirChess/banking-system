package org.dailycodework.bankingsystem.service;

import org.dailycodework.bankingsystem.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    // Сервис для управления пользователями. Содержит методы для создания пользователя,
    //поиска пользователя по ID и получения списка всех пользователей.

    private final Map<Integer, User> users = new HashMap<>();
    private int userCounter = 1;

    public User createUser(String login) {
        User user = new User();
        user.setLogin(login);
        user.setId(userCounter++);
        users.put(user.getId(), user);
        System.out.println("User created: " + user);
        return user;
    }

    public User getUser(int id) {
        return users.get(id);
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }
}
