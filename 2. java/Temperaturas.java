public class Temperaturas {
    public static void main(String[] args) {

        //datos
        String[] ciudades = {"Londres","Madrid","Nueva York", "Buenos Aires", "asuncion","sao pablo", "lima", "Santiago de chile","Lisboa", "Tokio"};

        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        //parametros iniciales
        int indexMayorTemperatura = 0;
        int indexMenorTemperatura = 0;

        //busqueda
        for (int i = 1; i < temperaturas.length; i++){

            if(temperaturas[i][0] < temperaturas[indexMenorTemperatura][0]) {
                indexMenorTemperatura = i;
            }
            if(temperaturas[i][1] > temperaturas[indexMenorTemperatura][0] ){
                indexMayorTemperatura = i;
            }
        }


        System.out.println("La menor temperatura la tuvo: " + ciudades[indexMenorTemperatura] + ",con " + temperaturas[indexMenorTemperatura][0] + " grados");
        System.out.println("La mayor temperatura la tuvo: " + ciudades[indexMayorTemperatura] + ",con " + temperaturas[indexMayorTemperatura][1] + " grados");
    }
}
