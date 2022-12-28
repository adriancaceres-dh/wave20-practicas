package com.Springprofiles.P2Pgexample.Config;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevConfig {

    @PostConstruct
    public void inicializar()
    {
        System.out.println("PERFIL DEV ------------------------- PERFIL DEV-------------- asdasdas");
    }
}
