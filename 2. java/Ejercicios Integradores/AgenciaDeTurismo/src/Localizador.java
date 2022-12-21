import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double descuento;
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
        boolean aplicarDescuentoPorReservas = false;
        for(Reserva reserva : reservas){
            int cantReservasHotel = 0;
            int cantReservasBoleto = 0;
            if(reserva.getClass().isInstance(new Hotel())){
                cantReservasHotel++;
            }
            if(reserva.getClass().isInstance(new BoletoViaje())) {
                cantReservasBoleto++;
            }
            if(cantReservasHotel >= 2) {
                aplicarDescuentoPorReservas = true;
                break;
            }

            if(cantReservasBoleto >= 2) {
                aplicarDescuentoPorReservas = true;
                break;
            }
        }
        if(aplicarDescuentoPorReservas) {
            for (Reserva reserva : reservas) {
                if (reserva.getClass().isInstance(new Hotel())) {
                    reserva.setPrecio(reserva.getPrecio() * 0.95);
                }
                if (reserva.getClass().isInstance(new BoletoViaje())) {
                    reserva.setPrecio(reserva.getPrecio() * 0.95);
                }
            }
        }
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

        descuento =  1 - totalDescuento;
        return descuento;
    }
}
