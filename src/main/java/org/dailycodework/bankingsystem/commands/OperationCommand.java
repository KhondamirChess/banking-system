package org.dailycodework.bankingsystem.commands;
import java.util.Scanner;
public interface OperationCommand {
    String getName();
    void execute(Scanner scanner);
}
