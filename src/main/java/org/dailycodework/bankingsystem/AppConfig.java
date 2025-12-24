package org.dailycodework.bankingsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.dailycodework.bankingsystem")
@PropertySource("classpath:application.properties")
public class AppConfig {
}
