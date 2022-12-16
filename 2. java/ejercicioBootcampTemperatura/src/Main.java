public class Main {
    public static void main(String[] args) {
        String ciudades [] = new String [10];
        int temperatura [][] = new int [10][2];
        int tempeMin = temperatura[0][0];
        int tempeMax = temperatura[0][1];
        String ciudadMin = ciudades[0];
        String ciudadMax = ciudades[0];

        ciudades[0]="Londres";
        ciudades[1]="Madrid";
        ciudades[2]="Nueva York";
        ciudades[3]="Buenos Aires";
        ciudades[4]="Asuncion";
        ciudades[5]="Sáo Paulo";
        ciudades[6]="Lima";
        ciudades[7]="Santiago de Chile";
        ciudades[8]="Lisboa";
        ciudades[9]="Tokio";

        temperatura[0][0] = -2;
        temperatura[0][1] = 33;
        temperatura[1][0] = -3;
        temperatura[1][1] = 32;
        temperatura[2][0] = -8;
        temperatura[2][1] = 27;
        temperatura[3][0] = 4;
        temperatura[3][1] = 37;
        temperatura[4][0] = 6;
        temperatura[4][1] = 42;
        temperatura[5][0] = 5;
        temperatura[5][1] = 43;
        temperatura[6][0] = 0;
        temperatura[6][1] = 39;
        temperatura[7][0] = -7;
        temperatura[7][1] = 26;
        temperatura[8][0] = -1;
        temperatura[8][1] = 31;
        temperatura[9][0] = -10;
        temperatura[9][1] = 35;

        for (int i=0; i < ciudades.length; i++){
            if(tempeMin > temperatura[i][0]) {
                tempeMin = temperatura[i][0];
                ciudadMin = ciudades[i];
            }
            if (tempeMax < temperatura[i][1]){
                tempeMax = temperatura[i][1];
                ciudadMax = ciudades[i];
            }
        }
        System.out.println( ciudadMin + " con la temperatura mas baja fue de " + tempeMin );
        System.out.println( ciudadMax + " con la temperatura mas alta fue de " + tempeMax);
    }
}