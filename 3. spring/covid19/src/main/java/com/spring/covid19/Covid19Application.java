package com.spring.covid19;

import com.spring.covid19.repository.SintomaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Covid19Application {

	public static void main(String[] args) {
		SpringApplication.run(Covid19Application.class, args);
		SintomaRepository.cargarSintomas();
	}

}
