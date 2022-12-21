package ejerClaseAbstractas;

public abstract class Cliente {
   protected String nombre;

    public Cliente() {
    }
    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public void consultaDeSaldo() {}

    public void realizarDeposito(){}

    public  void pagosDeServicio(){}

    public void retiroDeEfectivo(){}
    public  void tranferencias(){}


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
