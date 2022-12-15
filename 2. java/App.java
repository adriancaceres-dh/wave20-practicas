import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        int[][] temperaturas = {
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35}

        };
        String[] ciudades = {"Londres","Madrid","NY","Buenos Aires","Asuncion","Sao Paulo", "Lima","Santiago", "Lisboa","Tokio"};
        int max = -10000;
        int id_max = 0;
        int min = 10000;
        int id_min = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            if(temperaturas[i][1]>max){
                max = temperaturas[i][1];
                id_max = i;
            }
            if (temperaturas[i][0]<min){
                min = temperaturas[i][0];
                id_min = i;
            }

        }

        System.out.println("Temperatura maxima "+ciudades[id_max]+" "+max );
        System.out.println("Temperatura minima "+ciudades[id_min]+" "+min );


    }
}
