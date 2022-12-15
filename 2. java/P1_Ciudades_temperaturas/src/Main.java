public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,47},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int tempMinima = Integer.MAX_VALUE;
        String ciudadTempMinima = "";
        int tempMaxima = Integer.MIN_VALUE;
        String ciudadTempMaxima = "";

        for(int i = 0; i < ciudades.length; i++){
            int tempMinimaCiudadActual = temperaturas[i][0];
            if(tempMinima > tempMinimaCiudadActual){
                tempMinima = tempMinimaCiudadActual;
                ciudadTempMinima = ciudades[i];
            }

            int tempMaximaCiudadActual = temperaturas[i][1];
            if(tempMaxima < tempMaximaCiudadActual){
                tempMaxima = tempMaximaCiudadActual;
                ciudadTempMaxima = ciudades[i];
            }
        }

        System.out.println("Ciudad con temperatura minima: " + ciudadTempMinima + " con la temperatura: " + tempMinima);
        System.out.println("Ciudad con temperatura máxima: " + ciudadTempMaxima + " con la temperatura: " + tempMaxima);
    }
}