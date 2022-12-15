public class Main {
    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "New york", "Buenos aires", "Asuncion", "Sao Paulo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        
        int min = 0;
        int max = 0;
        String ciudadMin = "";
        String ciudadMax = "";

        for(int i = 0; i < ciudades.length; i++) {
            boolean noEsMenor = min < temperaturas[i][0];
            boolean noEsMayor = max > temperaturas[i][1];
            min = noEsMenor ? min : temperaturas[i][0];
            ciudadMin = noEsMenor ? ciudadMin : ciudades[i];
            max = noEsMayor ? max : temperaturas[i][1];
            ciudadMax = noEsMayor ? ciudadMax : ciudades[i];
        }

        System.out.println("Maxima: " + max + " en ciudad: " + ciudadMax);
        System.out.println("Minima: " + min + " en ciudad: " + ciudadMin);
    }
}