public class Cliente implements Transaccion {

    private String transaccion;

    public Cliente(){

    }

    public Cliente(String transaccion){
        this.transaccion = transaccion;
    }

    public void ejecutarTransaccion(){
        System.out.println("realizando " + transaccion + "...");
    }

    public void transaccionOk(){
        System.out.println( transaccion + " finalizo correctamente");
    }

    public void transaccionNotOk(){
        System.out.println("No se pudo realizar "+ transaccion);
    }
}
