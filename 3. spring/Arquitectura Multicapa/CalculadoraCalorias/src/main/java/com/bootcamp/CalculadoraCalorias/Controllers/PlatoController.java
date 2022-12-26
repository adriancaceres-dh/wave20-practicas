package com.bootcamp.CalculadoraCalorias.Controllers;

import com.bootcamp.CalculadoraCalorias.DTO.IngredienteDto;
import com.bootcamp.CalculadoraCalorias.Services.IServiciePlatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {

    @Autowired
    IServiciePlatos servicioPlato;
    @GetMapping("CaloriasPorPlato/{nombrePlato}")
    public ResponseEntity<Integer> calcularCaloriasPlato(@PathVariable String nombrePlato){
        return new ResponseEntity<>(servicioPlato.devolverCaloriasDelPlato(nombrePlato), HttpStatus.OK);
    }

    @GetMapping("IngredientesCaloriasPorPlato/{nombrePlato}")
    public ResponseEntity<String> devolverIngredientesPlato(@PathVariable String nombrePlato){
        return new ResponseEntity<>(servicioPlato.devolverCaloriasEIngredientesDelPlato(nombrePlato), HttpStatus.OK);
    }

    @GetMapping("IngredientesMayorCaloria/{nombrePlato}")
    public ResponseEntity<IngredienteDto> devolverIngredientesMayorCaloria(@PathVariable String nombrePlato){
        return new ResponseEntity<>(servicioPlato.ingredienteMayorCaloria(nombrePlato), HttpStatus.OK);
    }


}
