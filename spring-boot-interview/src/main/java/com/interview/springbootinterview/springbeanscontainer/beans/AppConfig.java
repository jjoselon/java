package com.interview.springbootinterview.springbeanscontainer.beans;

import com.interview.springbootinterview.springbeanscontainer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Autowired
    private RepositoryDTO repositoryDTO;

    @Bean
    @Qualifier(value = "1")
    public User user() {
        return new User(repositoryDTO.create() + "!");
    }

    @Bean
    @Primary
    public User user2() {
        return new User(repositoryDTO.create() + "?");
    }
}
