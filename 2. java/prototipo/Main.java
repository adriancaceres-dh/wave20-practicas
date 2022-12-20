package prototipo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SusesionUnoGenValor susesion = new SusesionUnoGenValor(0,2,1);
        Integer valorSerie = susesion.getValorSerie();
        boolean siguienteSerie = true;
        int leer;
        int valorInicialSerie;
        while(siguienteSerie){
            System.out.println("Quiere ver el siguiente de la serie?");
            System.out.println("1-siguiente numero de la serie");
            System.out.println("2-reiniciar la serie");
            System.out.println("3- Establecer valor inicial de la serie");
            System.out.println("4- Salir");
            Scanner nom = new Scanner(System.in);
            leer = nom.nextInt();
            if(leer == 1){
                System.out.println("Este es el siguiente de la serie: ");
                System.out.println(susesion.valorSiguienteDeLaSerie());
            }if(leer == 4){
                siguienteSerie = false;
            }if(leer == 2){
                susesion.reiniciarSerie();
            }if(leer == 3){
                System.out.println("ingrese el valor inicial para la serie");
                valorSerie = nom.nextInt();
                susesion.establecerValorInicialSerie(valorSerie);
            }

        }

    }
}
