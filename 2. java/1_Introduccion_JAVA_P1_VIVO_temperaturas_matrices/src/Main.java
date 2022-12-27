public class Main {
    public static void main(String[] args) {
/*
        //Variables

        String mi_variable = "algo";
        boolean flag  = false;

        //Condicionales

        if(flag) {
            System.out.println("La flag es true");
        } else {
            System.out.println("La flag es falso");
        }

        //Ciclos

        for (int i = 1; i < 5; i++){
            System.out.println("Linea " + i);
        }

        int i= 0;
        while(i <= 3){
            System.out.println("Linea " + (i + 1));
            i++;
        }

        i = 0;
        do  {
            System.out.println("Linea " + (i + 1));
            i++;
        } while(i <= 3);

        int numeros[] = {3,-1,12,-6,8,10};
        int contadorNegativos = 0;
        int contadorPositivos = 0;

        for(int j = 0; j < numeros.length;j++){
            if(numeros[j] < 0) contadorNegativos++;
            else contadorPositivos++;
        }

        System.out.println("Numeros positivos =  " + contadorPositivos);
        System.out.println("Numeros negativos =  " + contadorNegativos);*/

        // Matriz

        /*int[][] matrizNumeros = new int[4][3];

        matrizNumeros[0][1] = 10;

        for(int i = 0; i < 0;i++){

        }*/

        //Ejercicio Practico

        String ciudades[] = {"Londres", "Madrid", "New york", "Buenos aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int indiceMenorTemp = 0;
        int indiceMayorTemp = 0;

        for(int i = 0; i < ciudades.length ; i++){
            if(temperaturas[indiceMenorTemp][0] > temperaturas[i][0]) indiceMenorTemp = i;
            if(temperaturas[indiceMayorTemp][1] < temperaturas[i][1]) indiceMayorTemp = i;
        }
        System.out.println("La menor temperatura es " + temperaturas[indiceMenorTemp][0] + " en la ciudad de " + ciudades[indiceMenorTemp]);
        System.out.println("La mayor temperatura es " + temperaturas[indiceMayorTemp][1] + " en la ciudad de " + ciudades[indiceMayorTemp]);
    }
}