package com.bootcamp.DtoResponseEntity;

import com.bootcamp.DtoResponseEntity.model.Sintoma;
import com.bootcamp.DtoResponseEntity.repository.SintomaRepository;
import com.bootcamp.DtoResponseEntity.service.SintomaService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DtoResponseEntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DtoResponseEntityApplication.class, args);
	}

}
