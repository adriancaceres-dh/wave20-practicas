import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarreraDeLaSelva {
    static public HashMap<String, List> circuitos = new HashMap<>();
    static List<HashMap> circuitoChico = new ArrayList<>();
    static List<HashMap> circuitoMediano = new ArrayList<>();
    static List<HashMap> circuitoGrande = new ArrayList<>();


    public static void main(String[] args) {
        circuitos.put("chico", circuitoChico);
        circuitos.put("medio", circuitoMediano);
        circuitos.put("avanzado", circuitoGrande);
        inscribirParticipante(1,"1","1",1,1,1,"1","chico");
        inscribirParticipante(2,"2","2",2,2,2,"2","chico");
        mostrarParticipantes("chico");

    }
    public static void mostrarParticipantes(String circuito){

        List<HashMap> c = circuitos.get(circuito);
        for(HashMap<String,Object> participante: c){
            if (participante == null){
                continue;
            }
            for(Map.Entry<String, Object> dato : participante.entrySet()){
                System.out.println(dato.getKey()+" "+dato.getValue());
            }
            System.out.println();
        }

    }
    public static void inscribirParticipante(Integer dni,
                                             String nombre,
                                             String apellido,
                                             Integer edad,
                                             Integer celular,
                                             Integer numeroEmergencia,
                                             String grupoSanguineo,
                                             String circuito){
        HashMap<String,Object> participante = new HashMap<>();
        participante.put("dni",dni);
        participante.put("apellido",apellido);
        participante.put("nombre",nombre);
        participante.put("edad",edad);
        participante.put("celular",celular);
        participante.put("numeroEmergencia",numeroEmergencia);
        participante.put("grupoSanguineo",grupoSanguineo);
        participante.put("numero",circuitos.get(circuito).size()+1);

        switch (circuito){
            case "chico":
                participante.put("pago", edad<18 ? 1300:1500);
                circuitos.get("chico").add(participante);
                break;
            case "mediano":
                participante.put("pago", edad<18 ? 2000:2300);
                circuitos.get("medio").add(participante);
                break;
            default:
                if(edad<18){
                    System.out.println("el participante es menor de edad y no se puede inscribir");
                    break;
                }
                participante.put("pago",2800);
                circuitos.get("avanzado").add(participante);
                break;
        }
    }
    public  static void removerParticipante(String circuito, Integer numero){
        circuitos.get(circuito).set(numero,null);
    }

}

