package com.example.autos;

import com.example.autos.dto.request.CarRequestToCarModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;


@SpringBootApplication
public class ConcesionariaAutosApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public CarRequestToCarModel carRequestToCarModel() {
		return new CarRequestToCarModel();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConcesionariaAutosApplication.class, args);
	}

}
