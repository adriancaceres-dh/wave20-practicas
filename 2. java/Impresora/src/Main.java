import modelo.Impresora;
import modelo.Informe;
import modelo.Libro;
import modelo.Persona;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Persona p = new Persona("Armando", new ArrayList<>(Arrays.asList("codear", "Aprender", "tener sueño")));
        Informe in = new Informe(10,90,"anonimo", "El revisador");
        Libro l = new Libro("El libro", "Lo que el viento dejo","no binario XD", 80000);

        Impresora i = new Impresora();
        i.imprimirCurriculum(p);
        i.imprimirInformes(in);
        i.imprimirLibrosPDF(l);
    }
}