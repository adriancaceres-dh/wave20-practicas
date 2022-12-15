package com.bootcamp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Carga arreglos de ciudades y temperaturas.

        String ciudades[] = new String[10];
        double temperaturas[][] = new double[10][2];
        double tempMin, tempMax;
        String ciudadMin, ciudadMax;

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);


        System.out.println("INGRESO DE TEMPERATURAS MINIMAS Y MAXIMAS EN CIUDADES.");
        System.out.println();
        for (int i=0; i<ciudades.length; i++){
            System.out.println("CIUDAD "+(i+1)+" DE "+ciudades.length+": ");
            System.out.println();
            System.out.println("Ingrese nombre ciudad: ");
            ciudades[i]=sc1.nextLine();
            System.out.println("Ingrese temperatura minima: ");
            temperaturas[i][0]=sc2.nextInt();
            System.out.println("Ingrese temperatura maxima: ");
            temperaturas[i][1]=sc2.nextInt();
            System.out.println();

        }

        //Calculo temperaturas maximas y minimas.

        tempMin=Integer.MAX_VALUE;
        tempMax=Integer.MIN_VALUE;
        ciudadMin="None";
        ciudadMax="None";

        for (int i=0; i<temperaturas.length;i++){
            if(temperaturas[i][0]<tempMin){
                tempMin=temperaturas[i][0];
                ciudadMin=ciudades[i];
            }
            if(temperaturas[i][1]>tempMax){
                tempMax=temperaturas[i][1];
                ciudadMax=ciudades[i];
            }
        }

        //Informe temperatura maxima y minima con ciudad correspondiente.

        System.out.println("La menor temperatura la tuvo "+ciudadMin+" con "+tempMin+"ºC.");
        System.out.println("La mayor temperatura la tuvo "+ciudadMax+" con "+tempMax+"ºC.");



    }
}
