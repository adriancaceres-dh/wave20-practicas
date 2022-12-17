public class Main {
    public static void main(String[] args) {

        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio"};

        int temperaturas[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {-6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int temMin = temperaturas[0][0], temMax = temperaturas[0][1];
        String ciudadMin = "", ciudadMax = "";

        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                if (temperaturas[i][j] < temMin) {
                    temMin = temperaturas[i][j];
                    ciudadMin = ciudades[i];
                }
                if (temperaturas[i][j] > temMax) {
                    temMax = temperaturas[i][j];
                    ciudadMax = ciudades[i];
                }
            }
        }
        System.out.println("La ciudad con la temperatura minima es: " + ciudadMin + " " + temMin + "°");
        System.out.println("La ciudad con la temperatura maxima es: " + ciudadMax + " " + temMax + "°");
    }
}