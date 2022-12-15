import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Carrera_de_la_Selva {
    Map<Integer, Participante> categoriaChico;
    Map<Integer, Participante> categoriaMedio;
    Map<Integer, Participante> categoriaAvanzada;

    private int numeroDeInscripción;

    public Carrera_de_la_Selva() {
        this.categoriaChico = new HashMap<Integer, Participante>();
        this.categoriaMedio = new HashMap<Integer, Participante>();
        this.categoriaAvanzada = new HashMap<Integer, Participante>();
        numeroDeInscripción = 1;
    }

    public void agregarCompetidorCategoriaChica(Participante nuevoParticipante) {
        categoriaChico.put(numeroDeInscripción, nuevoParticipante);
        if (nuevoParticipante.getEdad() < 18) {
            nuevoParticipante.setMontoPagar(1300);
        } else {
            nuevoParticipante.setMontoPagar(1500);
        }
        numeroDeInscripción++;
    }

    public int getNumeroDeInscripción() {
        return numeroDeInscripción;
    }

    public void mostrarParticipantesCategoriaChico() {
        for (Map.Entry<Integer, Participante> participante : categoriaChico.entrySet()) {
            System.out.println("----" + " Numero de inscripción: " + participante.getKey() + " ---------------");
            System.out.println("Participante: " + participante.getValue().getDatosParticipante());
            System.out.println("--------------------------");
        }
    }

    public void desincribirParticipante(Participante eliminar) {
        int dniEliminar = eliminar.getDni();
        for (Map.Entry<Integer, Participante> participante : categoriaChico.entrySet()) {
            if (participante.getValue().getDni() == dniEliminar) {
                categoriaChico.remove(participante.getKey());
                System.out.println("Participante eliminado con exito");
                return;
            }
        }
        System.out.println("Persona no existe en categoria");
    }
}
