public class App {
    public static void main(String[] args) throws Exception {
        //------------------------CARGAMOS LOS DATOS------------------------
        String[] vectorCiudades = {"Londes", "Madrid","Nuev York", "Bueno Aires", "Asuncion", "Sao Pablo", "Lima", "Santiago de Chile","Lisboa", "Tokio"};
        int[][] vectorTemperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        //------------------------------------------------------------------

        // Llamamos a la función para poder obtener lo que nos pide la letra.
        temperaturasGlobales(vectorCiudades, vectorTemperaturas);
    }

    // Metodo encargado de encontrar las temperaturas globales a través de una matriz temperaturas y su respectivo vector de ciudades.
    public static void temperaturasGlobales(String[] vectorCiudades, int[][] vectorTemperaturas) {

        // Controlamos que no sean vacias. También se prodría hacer una guarda con try-catch por si son nulas.
        if (vectorCiudades.length != 0 && vectorTemperaturas.length != 0) {
            
            int mayorTemperatura = vectorTemperaturas[0][1];
            String ciudadMayorTemp = "";
            
            int menorTemperatura = vectorTemperaturas[0][0];
            String ciudadMenorTemp = "";

            // Recorreremos la matriz para encontrar las temperaturas.
            for (int i = 0; i < vectorCiudades.length; i++) {
                int actualMayor = vectorTemperaturas[i][1];
                int actualMenor = vectorTemperaturas[i][0];
                
                // Si encontramos una temperatura mayor a la que tenemos guardada, la cambiamos por la nueva.
                if (mayorTemperatura < actualMayor) {
                    mayorTemperatura = actualMayor;
                    ciudadMayorTemp = vectorCiudades[i];
                }

                // Si encontramos una temperatura menor a la que tenemos guardada, la cambiamos por la nueva.
                if (menorTemperatura > actualMenor) {
                    menorTemperatura = actualMenor;
                    ciudadMenorTemp = vectorCiudades[i];
                }
            }
            System.out.println("La menor temperatura la tuvo " + ciudadMenorTemp + ", con " + menorTemperatura + "grados C");
            System.out.println("La mayor temperatura la tuvo " + ciudadMayorTemp + ", con " + mayorTemperatura + "grados C");
        }
    }
}
