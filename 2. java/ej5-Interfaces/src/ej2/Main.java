package ej2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        Curriculum cv = new Curriculum(
                new Persona("juan",20),
                new ArrayList<String>(
                        Arrays.asList("Autodidacta", "Constante")
                )
        );
        IImprimible.imprimir(cv);

        Informe informe = new Informe(
                100,
                "Pedro",
                "HarryPotterre",
                "Drama"
        );
        IImprimible.imprimir(informe);

        LibroPDF pdf = new LibroPDF(
                "Loremipsum",
                new Persona("Carlos",24),
                new Persona("Martin",30)
        );
        IImprimible.imprimir(pdf);
    }
}
