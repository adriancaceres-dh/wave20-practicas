import com.bootcamp.clases.Curriculum;
import com.bootcamp.clases.Informe;
import com.bootcamp.clases.LibroPDF;
import com.bootcamp.clases.Persona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Pedro", 18,75000,"Universitario","Desarrollador de Software", "ATOS");
        List<String> habilidades = new ArrayList<>();
        habilidades.add("JAVA");
        habilidades.add("C#");
        habilidades.add("PHP");
        Curriculum curriculum = new Curriculum(persona,habilidades);
        curriculum.imprimir();
        LibroPDF libroPDF = new LibroPDF(50, "Luis", "El inspector", "Novela");
        libroPDF.imprimir();
    }
}