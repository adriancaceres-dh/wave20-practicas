package ejerClaseAbstractas;

public class App {
    public static void main(String[] args) {
        Cliente basic = new Basic("Ricadardo");
        Cliente ejecutivo = new Ejecutivo("Franco");
        Cliente cobradores = new Cobradores("Perez");
        System.out.println("---------------basic-----------");
        System.out.println("CLiente: " + basic.getNombre());
        basic.consultaDeSaldo();
        basic.pagosDeServicio();
        basic.retiroDeEfectivo();
        System.out.println("-------------ejecutivo---------");
        System.out.println("CLiente: " + ejecutivo.getNombre());
        ejecutivo.realizarDeposito();
        ejecutivo.tranferencias();
        System.out.println("-----------cobradores-------------");
        System.out.println("CLiente: " + cobradores.getNombre());
        cobradores.retiroDeEfectivo();
        cobradores.consultaDeSaldo();

    }
}
