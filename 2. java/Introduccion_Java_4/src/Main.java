import com.bootcamp.Curriculum;
import com.bootcamp.Imprimir;
import com.bootcamp.Informe;
import com.bootcamp.LibroPDF;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {

        List<String> estudios1 = new ArrayList<>();
        estudios1.add("Primario");
        estudios1.add("Secundario");
        Curriculum curriculum = new Curriculum("Lio", "Messi", estudios1);
        Imprimir.imprimir(curriculum);

        LibroPDF libroPDF = new LibroPDF("Campeones mundiales", "Lio Messi", "Historia", 10);
        Imprimir.imprimir(libroPDF);

        Informe informe = new Informe("Largo", 100, "Lio", "Messi");
        Imprimir.imprimir(informe);






    }
}