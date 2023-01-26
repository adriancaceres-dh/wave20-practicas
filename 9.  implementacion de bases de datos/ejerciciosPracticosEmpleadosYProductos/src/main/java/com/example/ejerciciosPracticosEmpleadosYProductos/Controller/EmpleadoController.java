package com.example.ejerciciosPracticosEmpleadosYProductos.Controller;

import com.example.ejerciciosPracticosEmpleadosYProductos.Service.IServiceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private IServiceEmpleado serviceEmpleado;

}
