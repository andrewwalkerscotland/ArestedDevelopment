package com.andrewwalkerscotland.ArestedDevelopment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.andrewwalkerscotland.ArestedDevelopment.UsersActions;

@Configuration
public class ApplicationConfig {

    @Bean
    UsersActions usersActions() {
        return new UsersActions();
    }
}
