package com.example.pruebaSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PruebaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaSpringApplication.class, args);
	}

	@GetMapping("/{name}")
	public String sayHello(@PathVariable String name){
		return "Hello World " + name;
	}

}
