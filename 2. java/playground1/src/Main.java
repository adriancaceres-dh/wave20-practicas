public class Main {
    public static void main(String[] args) {
        String ciudades[] = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int temperaturas[][] = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35},
        };

        int indexes[] = {0, 0};

        for (int i = 0; i< temperaturas.length; i++){
            if(temperaturas[i][0] < temperaturas[indexes[0]][0]) indexes[0] = i;
            if(temperaturas[i][1] > temperaturas[indexes[1]][1]) indexes[1] = i;
        }

        System.out.println(ciudades[indexes[0]] + " " + temperaturas[indexes[0]][0]);
        System.out.println(ciudades[indexes[1]] + " " + temperaturas[indexes[1]][1]);
    }
}
