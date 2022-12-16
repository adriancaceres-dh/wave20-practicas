package java_1;

public class TemperaturaCiudade {
    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("Ejercicio Temperaturas y Ciudades");
        String ciudades[] = {"londres", "madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        double[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        double temperaturaMinima = temperaturas[0][0];
        double temperaturaMaxima = temperaturas[0][0];
        String ciudadMinima = ciudades[0];
        String ciudadMaxima = ciudades[0];

        for (int f = 0; f < temperaturas.length; f++) {
            for (int c = 0; c < temperaturas[f].length; c++) {
                if (temperaturas[f][c]<temperaturaMinima){
                    temperaturaMinima=temperaturas[f][c];
                    ciudadMinima=ciudades[f];
                }
                if (temperaturas[f][c]>temperaturaMaxima){
                    temperaturaMaxima=temperaturas[f][c];
                    ciudadMaxima=ciudades[f];
                }
            }

        }
        System.out.println("La ciudad de " + ciudadMinima + " es la ciudad con la temperatura mínima de: " + temperaturaMinima);
        System.out.println("La ciudad de " + ciudadMaxima + " es la ciudad con la temperatura máxima de: " + temperaturaMaxima);
    }
}
