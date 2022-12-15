public class Main {
    public static void main(String[] args) {

        /*Un portal de noticias tiene registrados datos de las diferentes temperaturas que obtuvieron algunas
         ciudades del mundo durante el año pasado; a partir de estos registros, pudieron determinar la más baja
          y la más alta para cada una de las ciudades. Por ejemplo, se determinó que para Londres,
          la mínima fue de -2º C y la máxima de 33º C. Sin embargo, actualmente necesitan armar una noticia
           en donde especifiquen cuál es la temperatura máxima que hubo entre todas las ciudades registradas y
           cuál fue la mínima. Para ello cuentan con un vector con los nombres de cada una de las ciudades y una
           matriz de dos columnas que especifican su temperatura máxima y mínima, los cuales se especifican a
           continuación:
         */

        String ciudades[] = new String [] {"Londres", "Madrid", "New York", "Buenos Aires", "Asuncion",
                "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokyo"};
        int temperaturas [][] = new int [10][2];
        String ciudadMasCalida="";
        String ciudadMasFria="";
        int temperaturaMasBaja=0;
        int temperaturaMasAlta=0;

        temperaturas[0][0]=-2;
        temperaturas[1][0]=-3;
        temperaturas[2][0]=-8;
        temperaturas[3][0]=4;
        temperaturas[4][0]=6;
        temperaturas[5][0]=5;
        temperaturas[6][0]=0;
        temperaturas[7][0]=-7;
        temperaturas[8][0]=-1;
        temperaturas[9][0]=-10;
        temperaturas[0][1]=33;
        temperaturas[1][1]=32;
        temperaturas[2][1]=27;
        temperaturas[3][1]=37;
        temperaturas[4][1]=42;
        temperaturas[5][1]=43;
        temperaturas[6][1]=39;
        temperaturas[7][1]=26;
        temperaturas[8][1]=31;
        temperaturas[9][1]=35;

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 1; j++) {

                if (temperaturas[i][j]<temperaturaMasBaja){
                    temperaturaMasBaja=temperaturas[i][j];
                    ciudadMasFria=ciudades[i];
                }
                if (temperaturas[i][j]>temperaturaMasAlta){
                    temperaturaMasAlta=temperaturas[i][j];
                    ciudadMasCalida=ciudades[i];
                }

            }

        }

        System.out.println("La ciudad mas calida fue " +ciudadMasCalida+ "" +
                " con una temperatura de " +temperaturaMasAlta+ ".");
        System.out.println("La ciudad mas fria fue " +ciudadMasFria+ "" +
                " con una temperatura de " +temperaturaMasBaja+ ".");
    }
}