public class Main {
    public static void main(String[] args) {
        // Lista Ciudades
        String ciudades[] = {"Londres", "Madrid", "New York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        /*ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "New York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "São Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";*/

        // Matriz Temperaturas
        int temperaturas[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        /*temperaturas[0][0] = -2;
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
        temperaturas[9][1] = 35;*/

        // Variables utilizadas
        int menorTemperatura = temperaturas[0][0];
        int mayorTemperatura = temperaturas[0][1];
        int[]indices = new int[2];

        // Logica
        for (int i = 0; i < temperaturas.length; i++) {
            if(temperaturas[i][0] < menorTemperatura) {
                menorTemperatura = temperaturas[i][0];
                indices[0]= i;
            }
            if(temperaturas[i][1] > mayorTemperatura) {
                mayorTemperatura = temperaturas[i][1];
                indices[1] = i;
            }
        }
        System.out.println("Menor Temperatura: " + ciudades[indices[0]] + " con " + temperaturas[indices[0]][0] + " grados");
        System.out.println("Mayor Temperatura: " + ciudades[indices[1]] + " con " + temperaturas[indices[1]][1] + " grados");

    }
}