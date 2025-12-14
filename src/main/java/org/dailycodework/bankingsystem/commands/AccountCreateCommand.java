package org.dailycodework.bankingsystem.commands;
import org.dailycodework.bankingsystem.model.User;
import org.dailycodework.bankingsystem.service.AccountService;
import org.dailycodework.bankingsystem.service.UserService;
import org.springframework.stereotype.Component;
import java.util.Scanner;
@Component
public class AccountCreateCommand implements OperationCommand {
        private final AccountService accountService;
        private final UserService userService;
    public AccountCreateCommand(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }
    @Override
    public String getName(){
        return "ACCOUNT_CREATE";
    }
    @Override
    public void execute(Scanner scanner) {
        System.out.println("Select a user by ID to create an account:");
        for (User user : userService.getUsers()) {
            System.out.println(user.getId() + ": " + user.getLogin());
        }
        System.out.println("Enter user ID:");
        int userId;
        try {
            userId = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Invalid user ID, Must be an integer");
            return;
        }
        User user = userService.getUser(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        accountService.createAccount(user);
        System.out.println("Account created for " + user.getLogin());
    }
}
