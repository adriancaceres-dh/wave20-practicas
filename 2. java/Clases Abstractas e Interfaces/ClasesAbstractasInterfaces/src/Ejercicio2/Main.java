package Ejercicio2;

import Ejercicio2.Clases.Curriculum;
import Ejercicio2.Clases.Informe;
import Ejercicio2.Clases.LibrosPdf;
import Ejercicio2.Clases.Persona;
import Ejercicio2.Interfaces.Imprimible;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Caminar");
        habilidades.add("Correr");
        Persona persona1 = new Persona("Persona 1", habilidades);
        Curriculum curriculumPersona1 = new Curriculum(persona1);
        Imprimible.imprimir(curriculumPersona1);

        LibrosPdf libro1 = new LibrosPdf(100, "Autor 1", "Titulo 1", "Genero 1");
        Imprimible.imprimir(libro1);

        Informe informe1 = new Informe(50, 25, "Autor 2", "Revisor 1");
        Imprimible.imprimir(informe1);

    }
}
