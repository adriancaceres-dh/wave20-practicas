public class Main {
    public static void main(String[] args) {

        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int tempMinima = temperaturas[0][0];
        int tempMaxima = temperaturas[0][1];
        int posicionTempMin = 0;
        int posicionTempMax = 0;

        for (int i = 1; i < 10; i++) {
            if (temperaturas[i][0] < tempMinima) {
                tempMinima = temperaturas[i][0];
                posicionTempMin = i;
            }

            if (temperaturas[i][1] > tempMaxima) {
                tempMaxima = temperaturas[i][1];
                posicionTempMax = i;
            }

        }

        System.out.println("La menor temperatura la tuvo " + ciudades[posicionTempMin] + " con " + tempMinima);
        System.out.println("La mayor temperatura la tuvo " + ciudades[posicionTempMax] + " con " + tempMaxima);
    }
}
