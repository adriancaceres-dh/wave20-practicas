public class Main {
    public static void main(String[] args) {

        String[] ciudades= {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8, 27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int temperaturaMaxima=-275, temperaturaMinima=1000, ciudadMasCaliente=0, ciudadMasFria=0; //A la temperatura minima y maxima le asigno un valor ilogico para asegurarme de que cualquier comparacion posterior funcione bien.

        for (int i=0;i < temperaturas.length ;i++){
            if(temperaturas[i][1]>temperaturaMaxima){
                temperaturaMaxima=temperaturas[i][1];
                ciudadMasCaliente=i;
            };
            if(temperaturas[i][0]<temperaturaMinima){
                temperaturaMinima=temperaturas[i][0];
                ciudadMasFria=i;
            };
        };

        System.out.println("La menor tempertatura la tuvo " + ciudades[ciudadMasFria] + " con " + temperaturaMinima + "ºC.");
        System.out.println("La mayor tempertatura la tuvo " + ciudades[ciudadMasCaliente] + " con " + temperaturaMaxima + "ºC.");


    }
}


