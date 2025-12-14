package org.dailycodework.bankingsystem.service;

import org.dailycodework.bankingsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    // Сервис для управления пользователями. Содержит методы для создания пользователя,
    //поиска пользователя по ID и получения списка всех пользователей.
    private final Map<Integer, User> users = new HashMap<>();
    private int userId = 1;
    public User createUser(String login) {
        User user = new User();
        user.setLogin(login);
        user.setId(userId++);
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
