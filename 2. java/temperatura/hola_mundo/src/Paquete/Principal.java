package Paquete;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        //Aqui va el hola mundo
        //System.out.print("Hello World");

        /*
        Comentario de varias lineas
         */

        /*
        Scanner sp = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        String nombre = sp.nextLine();
        int numero = 32;
        System.out.println(numero);

         */

        /*Condicional

         */
        /*
        boolean flag =true;
        if (flag==true){
            System.out.println("Verdad");
        }

         */


        /* for
        for (int i=0; i<3;i++){
        System.out.println("Linea"+ (i+1));
        }
         */


        /*
        while

        int i = 0;
        while( i<=3 ){
            System.out.println("Linea" + (i+1));
            i++;
        }
         */

        /* ejercicio de positivos y negativos
        int numeros[] = {1,2,-3,-6,4};
        int pos=0;
        int neg=0;
        for (int i=0; i< numeros.length;i++){
            if (numeros[i]>=0) {
                pos++;
            }
            else {
                neg++;
            }

        }
        System.out.println("positivos " + pos);
        System.out.println("negativos" + neg);
         */

        String ciudad[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo","Lima",
                "Santiago de Chile","Lisboa","Tokio"};
        int matriz[][] = {{-2,-3,-8,4,6,5,0,-7,-1,-10},{33,32,27,37,42,43,39,26,31,35}};
        int menor, mayor;
        mayor=matriz[0][0];
        menor=matriz[0][0];
        int pos_menor = 0;
        int pos_mayor = 0;
        for (int i=0; i < ciudad.length; i++){

            if( matriz[0][i]<menor ){
                menor=matriz[0][i];
                pos_menor = i;
            }
            if( matriz[1][i]> mayor ){
                mayor=matriz[1][i];
                pos_mayor = i;
            }
        }
        System.out.println("Ciudad con menor temperatura es "+ciudad[pos_menor]+" con "+menor);
        System.out.println("Ciudad con mayor temperatura es "+ciudad[pos_mayor]+" con "+mayor);
    }
}
