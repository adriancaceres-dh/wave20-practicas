public class Main {
    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "New york", "Buenos aires", "Asuncion", "Sao Paulo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int indexMin = 0;
        int indexMax = 0;

        for(int i = 0; i < ciudades.length; i++) {
            indexMin = temperaturas[indexMin][0] < temperaturas[i][0] ? indexMin : i;
            indexMax = temperaturas[indexMax][1] > temperaturas[i][1] ? indexMax: i;
        }

        System.out.println("Maxima: " + temperaturas[indexMax][1] + " en ciudad: " + ciudades[indexMax]);
        System.out.println("Minima: " + temperaturas[indexMin][0] + " en ciudad: " + ciudades[indexMin]);
    }
}