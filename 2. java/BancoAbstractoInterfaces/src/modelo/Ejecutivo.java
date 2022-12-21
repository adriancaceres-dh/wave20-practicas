package modelo;

public class Ejecutivo extends Usuario {

    private String cargo;

    public Ejecutivo(String nombre, String cargo) {
        super(nombre);
        this.cargo = cargo;
    }

    @Override
    public String depósito() {
        return super.depósito()+" Ejecutivo";
    }

    @Override
    public String Transferencia() {
        return super.Transferencia()+" Ejecutivo";
    }

    @Override
    public void transaccionOk() {
        super.transaccionOk();
    }

    @Override
    public void transaccionNoOk() {
        super.transaccionNoOk();
    }
}
