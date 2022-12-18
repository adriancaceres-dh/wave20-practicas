public class Persona {
    public String nombre;
    public int edad;
    public int dni;
    public double peso;
    public double altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, int dni){
        this.nombre=nombre;
        this.edad=edad;
        this.dni=dni;
    }

    public Persona(String nombre, int edad, int dni, double peso, double altura){
        this.nombre=nombre;
        this.edad=edad;
        this.dni=dni;
        this.peso=peso;
        this.altura=altura;
    }

    public int calcularIMC(){
        double resultadoIMC;
        int retorno=0;

        resultadoIMC=peso/(altura*altura);

        if(resultadoIMC<20){
            retorno=-1;
        }else if(resultadoIMC>=20 && resultadoIMC<=25){
            retorno=0;
        }else{
            retorno=1;
        }

        return retorno;
    }

    public boolean esMayorDeEdad(){
        boolean retorno=true;

        if(edad>=18){
            retorno=true;
        }else{
            retorno=false;
        }

        return retorno;

    }
    @Override
    public String toString() {
        return "Nombre:  " + nombre + " Edad: " + edad + " DNI: " + dni + " Peso: " + peso + "kg Altura: " +
                altura + " metros.";
    }

}
