import java.util.Scanner;

public class Cliente {
    String dni;
    String nombre;
    String apellido;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    public Cliente clienteNuevo(){
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Ingresar DNI:");
        String dni = scannerObj.nextLine();
        System.out.println("Ingresar nombres:");
        String name = scannerObj.nextLine();
        System.out.println("Ingresar apellidos:");
        String lastName = scannerObj.nextLine();

        return new Cliente(dni,name,lastName);
    }


}
