public class App {
    public static void main(String[] args) {
        String[] cities = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion",
                "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"
        };
        int[][] temperatures = {
                {-2, 33}, {-3, 32}, {-8, 27}, {-4, 37}, {6, 42},
                {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}
        };
        int minTemperature = temperatures[0][0];
        int maxTemperature = temperatures[0][0];
        int cityMinTemperatureIndex = 0;
        int cityMaxTemperatureIndex = 0;

        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < temperatures[i].length; j++) {
                if (minTemperature > temperatures[i][j]) {
                    minTemperature = temperatures[i][j];
                    cityMinTemperatureIndex = i;
                } else if (maxTemperature < temperatures[i][j]) {
                    maxTemperature = temperatures[i][j];
                    cityMaxTemperatureIndex = i;
                }
            }
        }

        System.out.println("La ciudad más fría es " + cities[cityMinTemperatureIndex] + " con una T° de: " + minTemperature + "°C");
        System.out.println("La ciudad más caliente es " + cities[cityMaxTemperatureIndex] + " con una T° de: " + maxTemperature + "°C");

    }
}