public class Persona {
    //nombre, edad, dni (en este caso vamos a representarlo como una cadena de caracteres), peso y altura
    String nombre;
    int edad;
    String dni;
    double peso;
    int alturaCm;

    //Constructor sin parámetros
    public Persona() {
    }

    //Constructor con parámetros nombre, edad, dni
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    //Constructor con todas las variables de instancia como parámetro


    public Persona(String nombre, int edad, String dni, double peso, int alturaCm) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.alturaCm = alturaCm;
    }

    public String calcularIMC(){
        double alturaEnMetros = alturaCm/100;
        double imc = (peso)/(alturaEnMetros * alturaEnMetros);
        int resultado = 0;
        String mensaje = null;

        if(imc < 20) {
            resultado = -1;
            mensaje = "Según su índice de IMC usted tiene bajo peso";
        } else if(imc >=20 && imc <=25) {
            resultado = 0;
            mensaje = "Según su índice de IMC usted tiene peso saludable";
        } else if(imc > 25){
            resultado = 1;
            mensaje = "Según su índice de IMC usted tiene sobrepeso";
        }

        return mensaje;
    }

    public String esMayorDeEdad(){
        boolean esMayor = false;
        String mensaje;

        if (edad > 18) {
            esMayor = true;
            mensaje = "La persona es mayor de edad";
        } else {
            mensaje = "La persona es menor de edad";
        }
        return mensaje;
    }

    public String toStringMethod(){
        String informacion = nombre + " tiene " + edad + " años, con dni " + dni + " peso " + peso + " y altura " + alturaCm;
        return informacion;
    }
}
