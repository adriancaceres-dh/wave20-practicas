package intro_java;

public class Temperaturas {

    public static void main(String[] args) {

        String[] cities = {"Londres", "Madrid", "New York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatures = {
                { -2, 33 },
                { -3, 32 },
                { -8, 27 },
                { 4, 37 },
                { 6, 42 },
                { 5, 43 },
                { 0, 39 },
                { -7, 26 },
                { -1, 31 },
                { -10, 35}
        };

        int minIdx = 0;
        int maxIdx = 0;

        for ( int i = 0; i < cities.length; i++) {
            if ( temperatures[i][0] < temperatures[minIdx][0] ) {
                minIdx = i;
            }

            if ( temperatures[i][1] > temperatures[maxIdx][1] ) {
                maxIdx = i;
            }
        }

        System.out.println("La menor temperatura es de " + temperatures[minIdx][0] + "º en " + cities[minIdx]);
        System.out.println("La mayor temperatura es de " + temperatures[maxIdx][1] + "º en " + cities[maxIdx]);
    }
}
