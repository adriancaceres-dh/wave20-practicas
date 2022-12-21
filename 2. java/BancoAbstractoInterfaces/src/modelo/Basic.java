package modelo;

public class Basic extends Usuario  {

   private String nombre;

    public Basic(String nombre, String nombre1) {
        super(nombre);
        this.nombre = nombre1;
    }

    @Override
    public String depósito() {
        return super.depósito()+"Basic";
    }

    @Override
    public String Transferencia() {
        return super.Transferencia()+"Basic";
    }

    @Override
    public String Retiro() {
        return super.Retiro()+"Basic";
    }

    @Override
    public String consultaDeSaldo() {
        return super.consultaDeSaldo()+"Basic";
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
