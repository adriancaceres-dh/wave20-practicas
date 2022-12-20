import com.bootcamp.clases.Curriculum;
import com.bootcamp.clases.Informe;
import com.bootcamp.clases.LibroPDF;
import com.bootcamp.clases.Persona;

import java.util.*;

public class Main{
    public static void main(String[] args)  {
        Persona persona = new Persona("Franco","Alvarez",192502632);
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Responsable");
        habilidades.add("metódico");
        Curriculum curr = new Curriculum(persona,habilidades);

        curr.imprimir(); //acá me salta duda con que el objeto llame al método para sí mismo

        Informe informe = new Informe("Hola mundo que tal","Franco Alvarez","Adrian Caceres",18,1);
        informe.imprimir();

        LibroPDF libro = new LibroPDF(10,"Franco Alvarez","Memorias de un bootcamper","Suspenso");
        libro.imprimir();
    }

}