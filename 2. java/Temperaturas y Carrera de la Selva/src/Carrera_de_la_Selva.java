import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**

 * Esta clase define las listas de categorias que existen en la carrera como algunas funciones básicas de agregación y eliminación
 * de participantes.

 * @author: Emanuel Fonseca
 */
public class Carrera_de_la_Selva {

    // Lista que contiene los participantes de la categoria Chico.
    Map<Integer, Participante> categoriaChico;

    // Lista que contiene los participantes de la categoria Medio.
    Map<Integer, Participante> categoriaMedio;

    // Lista que contiene los participantes de la categoria Avanzada.
    Map<Integer, Participante> categoriaAvanzada;

    // Numero de inscripto del participante. Cabe destacar que es único para cada participante e incremental luego de una
    // nueva inscripción.
    private int numeroDeInscripción;

    public Carrera_de_la_Selva() {
        this.categoriaChico = new HashMap<Integer, Participante>();
        this.categoriaMedio = new HashMap<Integer, Participante>();
        this.categoriaAvanzada = new HashMap<Integer, Participante>();
        numeroDeInscripción = 1;
    }

    /**
     * Constructor para la serie de números aleatorios
     * @param nuevoParticipante El parámetro nuevoParticipamente define el nuevo participante a agregar en la categoria chica.

     */
    public void agregarCompetidorCategoriaChica(Participante nuevoParticipante) {
        categoriaChico.put(numeroDeInscripción, nuevoParticipante);

        // Al momento de agregar al participante ya se calcula el monto que debe pagar según su edad.
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

    /**

     * Muestra solo los participantes de la categoria chica.

     * @param
     */
    public void mostrarParticipantesCategoriaChico() {
        for (Map.Entry<Integer, Participante> participante : categoriaChico.entrySet()) {
            System.out.println("----" + " Numero de inscripción: " + participante.getKey() + " ---------------");
            System.out.println("Participante: " + participante.getValue().getDatosParticipante());
            System.out.println("--------------------------");
        }
    }

    /**

     * Elimina un usuario, pasado por parámetro, de la categoria chica.

     * @param eliminar es el participante que será eliminado de la competencia categoria chica.
     */
    public void desincribirParticipante(Participante eliminar) {
        int dniEliminar = eliminar.getDni();
        for (Map.Entry<Integer, Participante> participante : categoriaChico.entrySet()) {
            // Comparamos que el DNI de la persona a eliminar sea igual a alguno de la lista de competidores en esta categoria.
            if (participante.getValue().getDni() == dniEliminar) {
                categoriaChico.remove(participante.getKey());
                System.out.println("Participante eliminado con exito");
                return;
            }
        }
        // No se encontró el usuario pasado por parámetro.
        System.out.println("Persona no existe en categoria");
    }
}
