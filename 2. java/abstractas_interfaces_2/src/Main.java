import documento.Curriculum;
import documento.Imprimible;
import documento.Informe;
import documento.LibroPDF;

import java.util.List;

// En un caso un poco más serio consideraría hacer de Autor y Genero clases,
// ya que lo más probable es que se repitan en diferentes instancias
// y no queremos que haya que tocar código para agregarlos ni que un typo deje inconsistencias
public class Main {
    public static void main(String[] args) {
        List<Imprimible> imprimibles = List.of(
                new Curriculum("Un re CV"),
                new Informe("John Doe", "Johannes Dou", "Un re informe"),
                new LibroPDF(123, "John Doe", "Un re libro", "Un re genero")
        );

        imprimibles.forEach(Impresora::imprimirDocumento);
    }
}