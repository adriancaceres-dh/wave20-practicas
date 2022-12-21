package com.bootcamp.imprenta;

import com.bootcamp.imprenta.modelo.*;

public class EjemploImprenta {
    public static void main(String[] args) {
        Carrera carreraTrabajador = new Carrera("Ing de sistemas");
        Curriculum cv = new Curriculum( new Persona("Camilo","Arango"),carreraTrabajador,"Curriculum vitae");
        Persona autorCV = cv.getPersona();
        autorCV.setRol("Ingeniero de sistemas");
        cv.setPersona(autorCV);

        cv.addExperiencia("Java")
                .addExperiencia("Oracle Dba")
                .addExperiencia("Spring Framework")
                .addExperiencia("Fullstack")
                .addExperiencia("Angular");

        Persona autorLibro = new Persona("Andrés","Guzmán","Programador");
        Libro libro = new Libro(autorLibro,"Curso de Java","Programacion");

        libro.addPagina(new Pagina("POO"))
                .addPagina(new Pagina("Microservicios"))
                .addPagina(new Pagina("Herencia"))
                .addPagina(new Pagina("Interfaces"))
                .addPagina(new Pagina("Multi threads"));

        Persona autor = new Persona("Santiago","Villa","Investigador");
        Persona revisor = new Persona("Carlos","Castro","Profesor");

        String contenido = "Lorem Ipsum is simply dummy text of the printing and " +
                "typesetting industry. Lorem Ipsum has been the industry's " +
                "standard dummy text ever since the 1500s, when an unknown printer " +
                "took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic " +
                "typesetting, remaining essentially unchanged. It was popularised in the 1960s.";
        Informe informe = new Informe(autor,revisor,contenido);

        imprimir(cv);
        imprimir(informe);
        imprimir(libro);
    }

    public static void imprimir(IImprimible imprimible){
        System.out.println(imprimible.imprimir());
    }
}
