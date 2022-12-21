public class Cliente {
    String dni;
    String nombre;
    String apellido;
    boolean obtieneDescuento;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String apellido, boolean obtieneDescuento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.obtieneDescuento = false;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isObtieneDescuento() {
        return obtieneDescuento;
    }

    public void setObtieneDescuento(boolean obtieneDescuento) {
        this.obtieneDescuento = obtieneDescuento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", obtieneDescuento=" + obtieneDescuento +
                '}';
    }

}
