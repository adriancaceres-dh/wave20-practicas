public class Cliente {
    private String Nombre;
    private String Apellido;
    private String DNI;
    private int Edad;

    public Cliente(String nombre, String apellido, String DNI, int edad) {
        Nombre = nombre;
        Apellido = apellido;
        this.DNI = DNI;
        Edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente { " +
                "Nombre: "+Nombre+", " +
                "Apellido: "+Apellido+", " +
                "DNI: "+DNI+", " +
                "Edad: "+Edad+" }";
    }
}

