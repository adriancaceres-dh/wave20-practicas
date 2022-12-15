import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("########################################## INTRODUCCION A JAVA P1 ##########################################");
        //------------------------CARGAMOS LOS DATOS------------------------
        String[] vectorCiudades = {"Londes", "Madrid","Nuev York", "Bueno Aires", "Asuncion", "Sao Pablo", "Lima", "Santiago de Chile","Lisboa", "Tokio"};
        int[][] vectorTemperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        //------------------------------------------------------------------

        // Llamamos a la función para poder obtener lo que nos pide la letra.
        Temperatura.temperaturasGlobales(vectorCiudades, vectorTemperaturas);
        System.out.println("############################################################################################################");

        System.out.println("########################################## INTRODUCCION A JAVA P2 ##########################################");
        // -------------- PARTE A --------------
        Participante nuevoParticipante = new Participante(12345678,"Emanuel","Fonseca",22,123123123,123123123,"o+");
        Carrera_de_la_Selva nuevaCarrera = new Carrera_de_la_Selva();
        nuevaCarrera.agregarCompetidorCategoriaChica(nuevoParticipante);
        // -------------------------------------

        // -------------- PARTE B --------------
        nuevaCarrera.mostrarParticipantesCategoriaChico();
        // -------------------------------------

        // -------------- PARTE C --------------
        nuevaCarrera.desincribirParticipante(nuevoParticipante);
        // -------------------------------------

        // -------------- PARTE D --------------
        // Ya se hace automáticamente cuando se agrega a la competición. En la letra no dice: "Imprimir en consola".
        System.out.println("Monto a pagar por el participante: " + nuevoParticipante.getMontoPagar());
        // -------------------------------------
        System.out.println("############################################################################################################");
    }

}
