import java.util.ArrayList;
import java.util.List;

public class Persona {
    private int edad;
    private String nombreCompleto;

    public Persona(int edad, String nombreCompleto) {
        this.edad = edad;
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

}
