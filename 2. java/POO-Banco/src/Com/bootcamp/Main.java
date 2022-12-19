package Com.bootcamp;

import Com.bootcamp.Entidad.Basic;
import Com.bootcamp.Entidad.Cobradores;
import Com.bootcamp.Entidad.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basic b = new Basic(5000);
        Ejecutivo e = new Ejecutivo(500);
        Cobradores c = new Cobradores();

        b.consultarSaldo();
        b.retitoEfectivo(500);
        c.consultarSaldo();
        c.retitoEfectivo(300);
        e.Tranferir(100);
        e.depositar(500);
        b.consultarSaldo();
    }
}