package org.dailycodework.bankingsystem;

import org.dailycodework.bankingsystem.model.User;
import org.dailycodework.bankingsystem.service.OperationsConsoleListener;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankingSystemApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        OperationsConsoleListener console = context.getBean(OperationsConsoleListener.class);
        console.start();

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        User user = new User();
        session.getTransaction().commit();

        session.close();
    }
}
