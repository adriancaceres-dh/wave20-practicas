package com.bootcamp.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import jakarta.annotation.PostConstruct;

@Profile("dev")
@Configuration
public class ConfigDev {
    
    @PostConstruct
    public void initialize(){
        System.out.println("Iniciando ambiente de dev");
    }
}
