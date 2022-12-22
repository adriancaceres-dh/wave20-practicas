public class Persona {

    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC(){
        double imc = 0;
        double variable_retorno = 0;
        imc += peso/(altura*altura);
        System.out.println("Su Índice de masa corporal (IMC) es de: " + imc);
        if(imc<20){
            variable_retorno=-1;
            System.out.println("Tienes bajo peso!");
        } else if (imc >= 20 && imc <= 25) {
            System.out.println("Tienes un peso saludable!!");
        } else if (imc>25) {
            variable_retorno=1;
            System.out.println("Tienes Sobrepeso");
        }
        return variable_retorno;
    }

    public Boolean esMayorDeEdad(){
        boolean mayoriaDeEdad = false;
        if (this.edad>18){
            mayoriaDeEdad = true;
            System.out.println("Eres mayor de edad :))");
        }
        else{
            System.out.println("No eres mayor de edad :/");
        }
        return mayoriaDeEdad;
    }

    @Override
    public String toString() {
        return  "\nnombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                "kg , altura=" + altura +"cm";
    }
}
