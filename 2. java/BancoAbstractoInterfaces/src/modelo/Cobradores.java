package modelo;

public class Cobradores extends  Usuario{

    private String tipo;

    public Cobradores(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }


    @Override
    public String Efectivo() {
        return super.Efectivo()+"Cobrador";
    }

    @Override
    public String consultaDeSaldo() {
        return super.consultaDeSaldo()+"Cobrador";
    }

    @Override
    public String pagoDeServicios() {
        return super.pagoDeServicios()+"Cobrador";
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
