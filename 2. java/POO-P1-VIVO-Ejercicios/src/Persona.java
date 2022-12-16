import java.util.Map;

public class Persona {
    String nombre;
    Integer edad;

    String dni;
    double peso;
    double altura;

    public Persona()
    {
    }

    public void Persona(String nombre, Integer edad, String dni)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, Integer edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

}
