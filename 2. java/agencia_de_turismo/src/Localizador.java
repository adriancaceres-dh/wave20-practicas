public class Localizador {

    private double preciosUnitarios;
    private int reservasDeHotel;
    private int comidas;
    private int boletosDeViaje;
    private int trasnporte;

    public Localizador(int reservasDeHotel, int comidas, int boletosDeViaje, int trasnporte) {
        this.reservasDeHotel = reservasDeHotel;
        this.comidas = comidas;
        this.boletosDeViaje = boletosDeViaje;
        this.trasnporte = trasnporte;
        preciosUnitarios = 1000;
    }

    public double calcularTotal(){
        return (reservasDeHotel + comidas + boletosDeViaje +trasnporte)*preciosUnitarios;
    }

    public int getReservasDeHotel() {
        return reservasDeHotel;
    }

    public void setReservasDeHotel(int reservasDeHotel) {
        this.reservasDeHotel = reservasDeHotel;
    }

    public int getComidas() {
        return comidas;
    }

    public void setComidas(int comidas) {
        this.comidas = comidas;
    }

    public int getBoletosDeViaje() {
        return boletosDeViaje;
    }

    public void setBoletosDeViaje(int boletosDeViaje) {
        this.boletosDeViaje = boletosDeViaje;
    }

    public int getTrasnporte() {
        return trasnporte;
    }

    public void setTrasnporte(int trasnporte) {
        this.trasnporte = trasnporte;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservasDeHotel=" + reservasDeHotel +
                ", comidas=" + comidas +
                ", boletosDeViaje=" + boletosDeViaje +
                ", trasnporte=" + trasnporte +
                '}';
    }
}
