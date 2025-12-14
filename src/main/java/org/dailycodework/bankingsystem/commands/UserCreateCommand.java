package org.dailycodework.bankingsystem.commands;
import org.dailycodework.bankingsystem.service.UserService;
import org.springframework.stereotype.Component;
import java.util.Scanner;
@Component
public class UserCreateCommand implements OperationCommand {
    private final UserService userService;
    public UserCreateCommand(UserService userService) {
        this.userService = userService;
    }
    @Override
    public String getName(){
        return "USER_CREATE";
    }
    @Override
    public void execute(Scanner scanner) {
        System.out.println("Please enter your login: ");
        String login = scanner.nextLine();
        userService.createUser(login);
    }
}
