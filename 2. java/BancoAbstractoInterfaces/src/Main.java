import modelo.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo("Armando", "Sub-Gerente");
        System.out.println(ejecutivo.Transferencia());
        ejecutivo.transaccionNoOk();
    }
}