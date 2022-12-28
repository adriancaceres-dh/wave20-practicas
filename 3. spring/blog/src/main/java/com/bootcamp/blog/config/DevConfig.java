package com.bootcamp.blog.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevConfig {
    @PostConstruct
    public void iniciarDev(){
        System.out.println("________estoy en dev_____");
    }
}
