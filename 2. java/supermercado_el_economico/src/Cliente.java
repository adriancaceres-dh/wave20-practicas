public class Cliente {

    private String nombre;
    private long dni;
    private String apellido;

    public Cliente(String nombre, long dni, String apellido) {
        this.nombre = nombre;
        this.dni = dni;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
