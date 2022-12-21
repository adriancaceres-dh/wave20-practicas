package Ejercicio1;

public class ConsultaSaldo implements ITransacciones {
    // El valor de 1 significa cuenta valida y 0 cuenta invalida
    public void realizarConsultaSaldo() {
        /* Este valor siempre será posible. Suponiendo que el usuario posee una cuenta para poder ingresar
        al sistema, y por lo tanto posee una cuenta bancaria. Además, se supone que el usuario puede consultar
        el estado de cuenta sin importar si la cuenta está bloqueada o no. (a menos que el usuario no exista).*/
        transaccionOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("Su operación está siendo procesada.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La cuenta seleccionada no existe.");
    }
}
