import com.bootcamp.clases.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();


        String matematica = "Matematica";
        String ingles = "Inglés";
        String fisica = "Física";
        String quimica = "Química";

        Estudiante estudiante = new Estudiante("Pedro", "Perez", 22);
        estudiante.addMateria(matematica);
        estudiante.addMateria(ingles);

        EstudianteTecnico estudianteTécnico = new EstudianteTecnico("José", "Ruiz", 23, "Campus");
        estudianteTécnico.addMateria(fisica);
        estudianteTécnico.addMateria(quimica);

        PersonaMantenimiento personaMantenimiento = new PersonaMantenimiento("Eric", "Lawn", 35, "Jardín");

        PersonaSoporteTecnico personaSoporteTecnico = new PersonaSoporteTecnico("Luz", "Gomez", 24, "IT");

        Profesor profesor = new Profesor("Juan", "Totti", 39);
        profesor.addCurso(quimica);
        profesor.addCurso(fisica);

        Tutor tutor = new Tutor("Juana", "Lacroix", 21);
        tutor.addMateria(matematica);
        tutor.addMateria(fisica);
        tutor.addMateriaAEnseniar(quimica);

        personas.add(estudiante);
        personas.add(estudianteTécnico);
        personas.add(personaMantenimiento);
        personas.add(personaSoporteTecnico);
        personas.add(profesor);
        personas.add(tutor);

        personas.forEach(Persona::indicarResponsabilidades);

    }
}