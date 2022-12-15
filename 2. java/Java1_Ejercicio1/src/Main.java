public class Main {
    public static void main(String[] args) {
         // Java 1 Estructuras de control y Arreglos
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenas Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temps = {{-2,33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5,43}, {0, 39}, {-7,26}, {-1,31}, {-10,35}};

        int tempMin = temps[0][0];
        int tempMax = temps[0][1];
        String ciudadMin = ciudades[0];
        String ciudadMax = ciudades[0];

        for(int i = 0; i<ciudades.length; i++){
            if(tempMin > temps[i][0] ) {
                tempMin = temps[i][0];
                ciudadMin = ciudades[i];
            }
            if(tempMax < temps[i][1] ) {
                tempMax = temps[i][1];
                ciudadMax = ciudades[i];
            }
        }
        System.out.println("La temperatura máxima fue "+ tempMax + " en la ciudad de " + ciudadMax);
        System.out.println("La temperatura mínima fue "+ tempMin + " en la ciudad de " + ciudadMin);

    }
}