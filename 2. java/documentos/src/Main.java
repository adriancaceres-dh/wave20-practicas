import com.bootcamp.documentos.Curriculum;
import com.bootcamp.documentos.Informe;
import com.bootcamp.documentos.PDF;
import com.bootcamp.personas.Persona;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona per1 = new Persona("Coob o nap", "11", "F");
        Curriculum c1 = new Curriculum(per1);
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Regalonear");
        habilidades.add("Esponjear");
        habilidades.add("Hacer mocadillo");
        habilidades.add("Hacer tutin");
        c1.setHabilidades(habilidades);
        PDF p1 = new PDF(2, "Nap", "How to nap",  "Esponjoso");
        Informe i1 = new Informe("lorem ipsum y vos ya sabes...", 10, "Snoop-e", "Coob o nap");

        c1.imprimir();
        p1.imprimir();
        i1.imprimir();

    }
}