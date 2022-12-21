package banco.clases;

public class Main {
    public static void main(String[] args) {
        System.out.println("ENTIDAD BANCARIA DE LA ARGENTINA");
        System.out.println("-------------------------------------------------------");
        System.out.println("\nOPERACIONES BASICAS");
        System.out.println("-------------------------------------------------------");
        Basic basico = new Basic();
        basico.consultarSaldo();
        basico.pagarServicio("Seguro Auto");
        basico.retirarEfectivo(3000);
        System.out.println("\nOPERACIONES DE COBRADOR");
        System.out.println("-------------------------------------------------------");
        Cobrador cobrador = new Cobrador();
        cobrador.consultarSaldo();
        cobrador.retirarEfectivo(15000);
        System.out.println("\nOPERACIONES EJECUTIVAS");
        System.out.println("-------------------------------------------------------");
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.hacerDeposito();
        ejecutivo.hacerTransferencia(499.99);
    }
}
