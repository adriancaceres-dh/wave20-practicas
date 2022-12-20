public class Main {
    public static void main(String[] args) {

        String[] cities = {"Lodres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temps = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int maxTem = 00;
        int minTem = 00;
        int index_i = 0;
        int index_j = 0;
        String city_min = "";
        String city_max = "";
        for (int i = 0; i < temps.length; i++) {

            for (int j = 0; j < temps[i].length; j++) {

                if (temps[i][j] < minTem) {
                    minTem = temps[i][j];
                    index_i = i;
                }
                if (temps[i][j] > maxTem) {
                    maxTem = temps[i][j];
                    index_j = i;
                }
            }
        }

        city_min = cities[index_i];
        city_max = cities[index_j];

        System.out.println(" La menor temperatura fue de " + minTem + " grados en la ciudad de " + city_min);
        System.out.println(" La mayor temperatura fue de " + maxTem + " grados en la ciudadc de " + city_max);
    }
}