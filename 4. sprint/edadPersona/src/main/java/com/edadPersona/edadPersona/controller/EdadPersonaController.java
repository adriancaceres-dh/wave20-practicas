package com.edadPersona.edadPersona.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadPersonaController {
@GetMapping("/{dia}/{mes}/{anio}")
public int calcularEdad (@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
	LocalDate ahora = LocalDate.now();
	int edadDeLaPersona = ahora.getYear() -anio;
	return edadDeLaPersona;
}
}
