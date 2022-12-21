package modelo;

public abstract class Usuario  implements ITransaccion{

    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String depósito() {
        return "Deposito realizado por ";
    }
    public String Transferencia(){
            return "Transferencia realizado por ";
    }
    public String Retiro(){
            return "Retiro realizado por ";
    }
    public String Efectivo(){
            return "Efectivo realizado por ";
    }
    public String consultaDeSaldo(){
            return "Consulta de saldo realizado por ";
    }
    public String pagoDeServicios(){
            return "Pago de Servicios realizado por ";
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion realizada correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion fallida");
    }
}
