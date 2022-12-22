import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Mundial {

    List<Partido> partidos;

    public Mundial(){
        partidos = new ArrayList<>();
    }

    public Mundial(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public int cantidadPartidos(){
        return partidos.size();
    }

    public void agregarPartido(Partido partido){
        partidos.add(partido);
    }

    public int cantidadDeGolesTotales(){
        int cantidad = 0;
        for(Partido partido: partidos){
            cantidad += partido.golesLocal + partido.golesVisitante;
        }
        return cantidad;
    }

}
