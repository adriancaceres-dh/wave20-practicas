import com.sun.source.tree.ReturnTree;

public class Persona {

    private String nombre;
    private String dni;
    private Integer edad;
    private Double peso;
    private Double altura;

    public Persona(){

    }

    public Persona(String nombre, String dni, Integer edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, Integer edad, Double peso, Double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double IMC = peso/(altura*altura);

        if(IMC < 20){
            return -1;
        } else if (IMC > 25) {
            return 1;
        }else {
            return 0;
        }
    }

    public boolean esMyorDeEdad(){
        if(edad >= 18){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
