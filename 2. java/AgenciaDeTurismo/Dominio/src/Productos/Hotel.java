package Productos;
public class Hotel extends Producto {
    private int CantidadNoches;
    public Hotel(double precio, String descripcion, int cantidadNoches) {
        super(precio,descripcion);
        CantidadNoches = cantidadNoches ;
    }

    @Override
    public double getPrecio(){
        return  super.PrecioBase*CantidadNoches;
    }

    @Override
    public String toString() {
        return "ReservaHotel{ Descripcion: "+super.Descripcion+
                ", Precio por noche: "+super.PrecioBase+
                ", CantNoches: "+CantidadNoches+
                ", Precio total" +this.getPrecio() +"}";
    }
}
