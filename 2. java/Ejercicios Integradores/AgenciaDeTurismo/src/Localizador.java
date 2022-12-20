import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double totalPrecio;
    private boolean esPaquete;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        aplicarDescuentoAReservas();
        esPaquete = esPaquete();
        totalPrecio = calcularTotalPrecioReservas();
    }

    private void aplicarDescuentoAReservas() {

    }

    private boolean esPaquete() {
        boolean reservaHotel = false;
        boolean reservaTransporte = false;
        boolean reservaComida = false;
        boolean reservaBoleto = false;
        for(Reserva reserva : reservas){
            if(reserva.getClass().isInstance(new Hotel())){
                reservaHotel = true;
            }
            if(reserva.getClass().isInstance(new Transporte())){
                reservaTransporte = true;
            }
            if(reserva.getClass().isInstance(new Comida())){
                reservaComida = true;
            }
            if(reserva.getClass().isInstance(new BoletoViaje())) {
                reservaBoleto = true;
            }
        }
        return reservaHotel && reservaBoleto && reservaComida && reservaTransporte;
    }

    private double calcularTotalPrecioReservas() {
        return reservas.stream().mapToDouble(reserva -> reserva.getPrecio()).sum() * obtenerDescuento();
    }
    public double obtenerDescuento(){
        double totalDescuento = 0;
        if(esPaquete)
            totalDescuento += 0.1d;
        if(cliente.getLocalizadores().size() >= 2)
            totalDescuento += 0.05;


        return 1 - totalDescuento;
    }
}
