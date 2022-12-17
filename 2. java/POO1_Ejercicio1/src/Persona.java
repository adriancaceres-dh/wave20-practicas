public class Persona {
    String nombre;
    int edad;
    String dni;
    int pesoKG;
    double alturaM;
//declaracion de constructores
    public Persona() {}

    public Persona ( String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona ( String nombre, int edad, String dni, int pesoKG, double alturaM){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.pesoKG = pesoKG;
        this.alturaM = alturaM;
    }
// fin de declaracion de constructores

// declaracion de metodos

    public int calcularIMC () {
        double imc = this.pesoKG/(Math.pow(this.alturaM, 2));
        System.out.println(Math.pow(this.alturaM, 2));
        if (imc < 20) return -1;
        else if (imc <= 25) return 0;
        return 1;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    public String toString(){
        return "Nombre: " + this.nombre
                + ", Edad: " + this.edad
                + ", DNI: " + this.dni
                + ", Peso en KG: " + this.pesoKG
                + ", Altura en CM: " + this.alturaM;
    }
}
