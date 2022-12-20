public class Perecedero extends Producto {
    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cancantidadDeProductostidad){
        switch (diasPorCaducar){
            case 1:
                return super.calcular(cancantidadDeProductostidad)/4;
            case 2:
                return super.calcular(cancantidadDeProductostidad)/3;
            case 3:
                return super.calcular(cancantidadDeProductostidad)/2;
            default:
                return super.calcular(cancantidadDeProductostidad);
        }
    }

}
