package com.bootcamp.covid;

import com.bootcamp.covid.repository.Helper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidApplication {

    public static void main(String[] args) {
        Helper.fillWithTestData();
        SpringApplication.run(CovidApplication.class, args);
    }

}
