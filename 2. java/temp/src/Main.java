import java.security.Signature;
import java.sql.Array;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = new String[10];
        int[][] temperaturas = new int[10][10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "NY";
        ciudades[3] = "BSAS";
        ciudades[4] = "AS";
        ciudades[5] = "SP";
        ciudades[6] = "LM";
        ciudades[7] = "SC";
        ciudades[8] = "LB";
        ciudades[9] = "TK";

        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        int tempMin = 0;
        String ciudadMin = "";
        int tempMax = 0;
        String ciudadMax = "";

        int minimoAbsoluto = 0;
        String ciudadMinimaAb = "";
        String ciudadMaxAb = "";
        int maximoAbsoluto = 0;

        for(int i = 0; i < ciudades.length; i++){
            int tempMinimaActual = temperaturas[i][0];
            int temMaximaActual = temperaturas[i][1];
            if(tempMinimaActual < tempMin){
                tempMin = tempMinimaActual;
                if(tempMinimaActual < minimoAbsoluto){
                    minimoAbsoluto = tempMinimaActual;
                    ciudadMinimaAb = ciudades[i];
                }
            }
            if(temMaximaActual > tempMax){
                tempMax = temMaximaActual;
            }
            System.out.println("La temp minima es: "+ tempMin + " para la cuidad de "+ ciudades[i]);
            System.out.println("La temp maxima es: "+ tempMax + " para la cuidad de "+ ciudades[i]);
        }
        System.out.println("La ciudad mas fria es: "+ ciudadMinimaAb +" con una temp de: " +minimoAbsoluto);

    }
}