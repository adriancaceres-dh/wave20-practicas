import java.util.Map;
import java.lang.Math. *;

public class Persona {
    String nombre;
    Integer edad;

    String dni;
    double peso;
    double altura;

    public Persona()
    {
    }
    public Persona(String nombre, Integer edad, String dni)
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

    /*
    cacularIMC(), la fórmula para calcularlo es: peso/(altura^2) - (peso expresado en kg y altura en mts),
    si este cálculo devuelve un valor menor que 20, la función debe retornar -1, si devuelve un número
    entre 20 y 25 inclusive para los dos valores, el método debe retornar un 0, por último, si devuelve un
    número mayor que 25 debe retornar un 1
    */

    public int calcularImc(Persona p)
    {
        //pre: altura y peso deben ser mayor a cero.
        double Imc = p.peso / Math.pow(p.altura, 2);

        if(Imc < 20)
        {
             return -1;
        }
        else if (Imc >= 20 && Imc <= 25)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    public boolean esMayorDeEdad(Persona p)
    {
        //pre: la persona debe tener seteada la edad.
        return p.edad > 18;
    }

    public String toString(Persona p)
    {
        return "{ Nombre: " + p.nombre + ", Edad: " + p.edad + ", Dni: " + p.dni + ", Peso: " + p.peso + " }";
    }

}
