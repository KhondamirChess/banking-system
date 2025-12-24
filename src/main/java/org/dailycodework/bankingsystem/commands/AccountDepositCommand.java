package org.dailycodework.bankingsystem.commands;
import org.dailycodework.bankingsystem.service.AccountService;
import org.springframework.stereotype.Component;
import java.util.Scanner;
@Component
public class AccountDepositCommand implements OperationCommand{
    private final AccountService accountService;
    public AccountDepositCommand(AccountService accountService) {
        this.accountService = accountService;
    }
    @Override
    public String getName(){
        return "ACCOUNT_DEPOSIT";
    }
    @Override
    public void execute(Scanner scanner){
        try {
            System.out.print("Enter account ID: ");
            int accountId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter amount: ");
            int amount = Integer.parseInt(scanner.nextLine());
            accountService.deposit(accountId, amount);
            System.out.println("Money successfully deposited");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
