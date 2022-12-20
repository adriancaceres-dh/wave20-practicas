public class Main {
    public static void main(String[] args)
    {
        System.out.println(" ");
        System.out.println("- EJECUTIVO INICIO SESION EN EL SISTEMA.");
        // El ejecutivo hace un deposito
        Ejecutivos ejecutivo = new Ejecutivos();
        ejecutivo.HacerDeposito();
        ejecutivo.HacerTransferencia();

        System.out.println(" ");
        System.out.println("- BASIC INICIO SESION EN EL SISTEMA. ");
        Basic basic = new Basic();
        basic.ConsultaDeSaldo();
        basic.PagoDeServicios();
        basic.RetiroDeEfectivo();

        System.out.println(" ");
        System.out.println("- COBRADOR INICIO SESION EN EL SISTEMA. ");
        Cobradores cobrador = new Cobradores();
        cobrador.ConsultaDeSaldo();
        cobrador.RetiroDeEfectivo();


    }
}