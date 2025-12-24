package org.dailycodework.bankingsystem.commands;
import org.dailycodework.bankingsystem.model.User;
import org.dailycodework.bankingsystem.service.UserService;
import org.springframework.stereotype.Component;
import java.util.Scanner;
@Component
public class ShowAllUsersCommand implements OperationCommand{
    private final UserService userService;
    public ShowAllUsersCommand(UserService userService) {
        this.userService = userService;
    }
    @Override
    public String getName(){
        return "SHOW_ALL_USERS";
    }
    @Override
    public void execute(Scanner scanner) {
        var users = userService.getUsers();
        if(users.isEmpty()){
            System.out.println("No users found");
            return;
        }
        System.out.println("USERS LIST");
        for (User user : userService.getUsers()) {
            System.out.println(user.getId() + ": " + user.getLogin());
        }
    }
}
