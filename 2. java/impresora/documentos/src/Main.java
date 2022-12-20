import com.bootcamp.Curriculums;
import com.bootcamp.Informes;
import com.bootcamp.LibroPDF;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Curriculums curriculum1 = new Curriculums();
        curriculum1.setNombre("Julian");
        curriculum1.setProfesion("Ingeniero");
        curriculum1.setHabilidades(List.of(new String[]{"programador", "responsable"}));
        curriculum1.mostrar();

        LibroPDF libro = new LibroPDF();
        libro.setTitulo("Java");
        libro.setCantidadPaginas(100);
        libro.setNombreAutor("Julian");
        libro.mostrar();

        Informes informe = new Informes();
        informe.setAutor("Julian");
        informe.setLongitud(900);
        informe.setRevisor("Luis");
        informe.setTexto("Este es un informe de prueba");
        informe.mostrar();
    }
}