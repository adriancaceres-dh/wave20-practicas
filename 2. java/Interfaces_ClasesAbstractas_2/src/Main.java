import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //curriculum
        System.out.println("CV--------------");
        Persona estudiante = new Persona(26, "Francisco Marquez");
        List<String> habilidades = new ArrayList<String>();
        habilidades.add("cortar el pasto");
        habilidades.add("hablar portugues");
        Curriculum cv = new Curriculum(estudiante, habilidades);
        System.out.println(cv.imprimir(cv));

        //informe
        System.out.println("Informe--------------");
        Persona autor = new Persona(40, "Stephen King");
        Informe informe = new Informe("Informe de salubridad", 10, autor, estudiante );
        System.out.println(informe.imprimir(informe));

        //Libro
        System.out.println("Libro--------------");
        LibroPDF libro = new LibroPDF(400, autor, "el fantasma de canterville", "drama");
        System.out.println(libro.imprimir(libro));
    }
}