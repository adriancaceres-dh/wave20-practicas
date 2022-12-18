import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaCarreraDeLaSelva {

    Map<Integer, Participantes> carrera;
    int consecutivo=0;

    public ListaCarreraDeLaSelva(){
        carrera=new HashMap<>();
    }
    public  void agregarCompetidor(Participantes participante) {
        if (participante.categoria == 0) {
            System.out.println("Lo sentimos, no puedes inscribirte en la carrera");
        } else {
            consecutivo++;
            carrera.put(consecutivo, participante);
        }
    }
    public void infoCarrera(){
        for(Map.Entry<Integer,Participantes> participante : carrera.entrySet()){
            System.out.println(participante.getKey());
            System.out.println(participante.getValue().toString());
        }

    }
    public void obtenerInscritosPorCategoria(int categoria){
        for(Map.Entry<Integer,Participantes> participante : carrera.entrySet()){
            if(participante.getValue().categoria==categoria){
                System.out.println(participante.getKey());
                System.out.println(participante.getValue().toString());

            }
        }
    }

    public void retirarParticipante(int consecutivo){

        carrera.remove(consecutivo);
    }

}
