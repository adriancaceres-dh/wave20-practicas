public class Cliente {
    String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Reserva HacerReserva(int id, String tipo)
    {
        Reserva nuevaReserva = new Reserva(id, tipo);
        return nuevaReserva;
    }
}
