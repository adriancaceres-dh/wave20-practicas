public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion",
                "Sao Paulo", "Lima",  "Santiago", "Lisboa", "Tokio"};
        double[][] temperaturas = {{-2,33},{-3,32},{-8,23},{4,37},{6,42},{5,43},{0,39},{-7,26},
                {-1,31},{-10,35}};


        int tempMinIndex = 0;
        int tempMaxIndex = 0;

        for(int i = 1; i < temperaturas.length; i++){
            if (temperaturas[i][0] < temperaturas[tempMinIndex][0]) tempMinIndex = i;
            if (temperaturas[i][1] > temperaturas[tempMaxIndex][1]) tempMaxIndex = i;
        }

        System.out.println("La ciudad más fría es " + ciudades[tempMinIndex]
                + " y la más cálida es " + ciudades[tempMaxIndex] + ".");

    }
}