package Ejercicio1;

import Ejercicio1.Clases.Basic;
import Ejercicio1.Clases.Cobradores;
import Ejercicio1.Clases.Ejecutivos;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n Metodos del cliente Basic");
        Basic basic1 = new Basic("Basic 1");
        basic1.consultaSaldo("122332", true);
        basic1.pagarServicios("Servicio 1" , true);
        basic1.retiroEfectivo("124324", 1000, true);

        System.out.println("\n Métodos del cliente Cobrador");
        Cobradores cobrador1 = new Cobradores("Cobrador 1");
        cobrador1.consultaSaldo("123123",true);
        cobrador1.retiroEfectivo("4234",34,true);

        System.out.println("\n Métodos del cliente Ejecutivo");
        Ejecutivos ejecutivos1 = new Ejecutivos("Ejecutivo 1");
        ejecutivos1.depositar("4325345",3444,true);
        ejecutivos1.transferencia("3443", 3434,true);
        
    }
}