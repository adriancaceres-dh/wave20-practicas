public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){}

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    //ejercicio 5
    public int calcularMC(){
        double MC = this.peso/(Math.pow(altura, 2));
        if(MC<20){
            return -1;
        }
        else if(MC >= 20 && MC<= 25){
            return 0;
        }

        return 1;

    }

    public Boolean esMayorDeEdad(){
        if(this.edad>=18){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "datos de persona: \n" + this.nombre + "\nDNI: " + this.dni + "\nedad: " + this.edad + "\npeso: " + this.peso + "Kg\naltura: " + this.altura +"Mts";
    }
}

