public class Temperatura {
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
