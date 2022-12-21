import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cobrador cobradorBancario = new Cobrador();
        Ejecutivo ejecutivoComercial = new Ejecutivo();
        Basic basic = new Basic();

        Scanner scanner= new Scanner(System.in);
        String sOption = "0";

        do {
            System.out.println("Ingresar al sistema como:");
            System.out.println("--------------------------");
            System.out.println("1. Ejecutivo");
            System.out.println("2. Basic");
            System.out.println("3. Cobrador");
            System.out.println("0. SALIR");

            sOption =scanner.next();
            if(Integer.parseInt(sOption)== 1){
                do {
                    ImprimirOpcionesGenerales();
                    sOption = scanner.next();
                    if (Integer.parseInt(sOption) == 2) {
                        System.out.println(ejecutivoComercial.depositar());
                        System.out.println(ejecutivoComercial.transaccionOk());
                    } else if (Integer.parseInt(sOption) == 5) {
                        System.out.println(ejecutivoComercial.transferir());
                        System.out.println(ejecutivoComercial.transaccionOk());
                    }else if(Integer.parseInt(sOption)==6){
                        break;
                    } else {
                        System.out.println(ejecutivoComercial.transaccionNoOk());
                    }
                }while(Integer.parseInt(sOption) != 6);
            }else if(Integer.parseInt(sOption)==2){
                do {
                    ImprimirOpcionesGenerales();
                    sOption = scanner.next();
                    if (Integer.parseInt(sOption) == 1) {
                        System.out.println(basic.consultarSaldo());
                        System.out.println(basic.transaccionOk());
                    } else if (Integer.parseInt(sOption) == 3) {
                        System.out.println(basic.pagarServicios());
                        System.out.println(basic.transaccionOk());
                    } else if (Integer.parseInt(sOption) == 4) {
                        System.out.println(basic.retirarEfectivo());
                        System.out.println(basic.transaccionOk());
                    } else if (Integer.parseInt(sOption) == 6) {
                        break;
                    } else {
                        System.out.println(basic.transaccionNoOk());
                    }
                }while(Integer.parseInt(sOption)!=6);
                //faltan whiles internos
            }else if(Integer.parseInt(sOption)==3){
                do {
                    ImprimirOpcionesGenerales();
                    sOption = scanner.next();
                    if (Integer.parseInt(sOption) == 1) {
                        System.out.println(cobradorBancario.consultarSaldo());
                        System.out.println(cobradorBancario.transaccionOk());
                    } else if (Integer.parseInt(sOption) == 4) {
                        System.out.println(cobradorBancario.retirarEfectivo());
                        System.out.println(cobradorBancario.transaccionOk());
                    } else if (Integer.parseInt(sOption) == 6) {
                        break;
                    } else {
                        System.out.println(cobradorBancario.transaccionNoOk());
                    }
                }while(Integer.parseInt(sOption) !=6);
            }else if(Integer.parseInt(sOption)==0){
                break;
            }else{
                System.out.println("Ingrese una opcion valida.");
            }
        }while(Integer.parseInt(sOption)!=0);
    }

    public static void ImprimirOpcionesGenerales(){
        System.out.println("------------------------");
        System.out.println("1. Consultar Saldo");
        System.out.println("2. Depositar");
        System.out.println("3. Pagar Servicios");
        System.out.println("4. Retirar efectivo");
        System.out.println("5. Transferir");
        System.out.println("6. VOLVER.");
    }
}