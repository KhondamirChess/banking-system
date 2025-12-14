package org.dailycodework.bankingsystem;

import org.dailycodework.bankingsystem.service.OperationsConsoleListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankingSystemApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        // Получаем listener — все зависимости будут внедрены автоматически
        OperationsConsoleListener console = context.getBean(OperationsConsoleListener.class);
        console.start();
    }
}
