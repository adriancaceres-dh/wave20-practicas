public class Main {

    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "New york", "Buenos aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int minTemperatura = temperaturas[0][0];
        int maxTemperatura = temperaturas[0][1];

        String ciudadMinTemperatura = new String();
        String ciudadMaxTemperatura = new String();

        for (int i = 1; i < ciudades.length; i++) {
            if(minTemperatura > temperaturas[i][0]){
                minTemperatura= temperaturas[i][0];
                ciudadMinTemperatura= ciudades[i];
            }

            if(maxTemperatura < temperaturas[i][1]){
                maxTemperatura= temperaturas[i][1];
                ciudadMaxTemperatura= ciudades[i];
            }
        }

        System.out.print("Ciudad con temperatura mas baja: " + ciudadMinTemperatura + " con " + minTemperatura);
        System.out.println();
        System.out.print("Ciudad con temperatura mas alta: " + ciudadMaxTemperatura + " con " + maxTemperatura);
    }
}