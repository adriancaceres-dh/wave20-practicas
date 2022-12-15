package com.bootcamp;

public class App {
public static void main(String[] args) {

    //Ejercicio1 JAVA
    String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
    int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

    //parametros de inicialización
    String ciudadMayor = "";
    String ciudadMenor = "";

    //la temp mayor y menor empieza en fila 0 columna 0 y 1 pero al comenzar a iterar quedará la verdadera
    int tempMayor = temperaturas[0][0];
    int tempMenor = temperaturas[0][1];

    for(int i=0; i<temperaturas.length; i++) {
        if(temperaturas[i][0] < tempMenor) {
            tempMenor = temperaturas[i][0];
            ciudadMenor = ciudades[i];
        } else if(temperaturas[i][1] > tempMayor){
            tempMayor = temperaturas[i][1];
            ciudadMayor = ciudades[i];
        }
    }

    System.out.println("La menor temperatura es de " + tempMenor + " " + "en la ciudad de " + ciudadMenor);
    System.out.println("La mayor temperatura es de " + tempMayor + " " +"en la ciudad de " + ciudadMayor);
    //Recorrer una matriz
  /*  int [][] numeros = new int[4][3];

    numeros[0][1] = 10;

    for (int i = 0; i<4;i++) {
        for (int j=0; j<3; j++) {
            System.out.println(numeros[i][j] + " ");
        }
        System.out.println(" ");
    }
+/
    /*
    int numeros[] = {3,-1,12,-6,8,10};
    int contador[] = {0,0};
    int contadorPositivos = 0;
    int contadorNegativos = 0;

    //contar positivos y negativos

    for(int i=0; i < numeros.length; i++) {
        if(numeros[i] >=0) {
            contadorPositivos++;
        } else {
            contadorNegativos++;
        }
    }
    System.out.println(contadorPositivos);
    System.out.println(contadorNegativos);
*/
    /*
    for (int i = 0; i < 4; i++) {
        System.out.println("Linea" + (i + 1) );
    }

    int i = 0;
    while(i < 4 ) {
        System.out.println("Línea " + (i + 1) );
        i++;
    }

    int j=0;
    do {
        System.out.println("Linea " + (j + 1) );
        j++;
    } while(j < 4);
    */
}
}
