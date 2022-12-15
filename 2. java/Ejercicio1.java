package Bootcamp;
public class Ejercicio1 {
    public static void main(String[] args){
        String ciudades[] = {"Londres","Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int temperaturas[][] = {{-2,33}, {-3,32}, {-8,27}, {4,37}, {6,42}, {5,43}, {0,39}, {-7,26}, {-1,31}, {-10,35}};

        int tempMin = 0;
        int tempMax = 0;

        for(int i=0; i<ciudades.length; i++){
            if (temperaturas[i][0] < temperaturas[tempMin][0]) {
                tempMin = i;
            }

            if (temperaturas[i][1] > temperaturas[tempMax][1]) {
                tempMax = i;
            }
        }

        System.out.println("La menor temperatura la obtuvo " + ciudades[tempMin] + " con, " + temperaturas[tempMin][0]);

    }
}
