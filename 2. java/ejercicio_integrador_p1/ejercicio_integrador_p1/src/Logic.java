public class Logic {
    public static double calcularTotal(Reserva reserva, Client client){

    }

    public static double calcularDescuento(Reserva reserva, Client client){
        if (ClientRepository.clients.contains(client)) return 0.05;
        return 0;
    }
}
