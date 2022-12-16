package objetos;

//Clase persona
public class Persona {
    private String nombre;
    private String edad;
    private String dni;
    private double peso;
    private double altura;

    //Constructores
    public Persona(){}

    public Persona (String nombre,String edad,String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre,String edad,String dni,double peso,double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso=peso;
        this.altura=altura;
    }

    public int calcularIMC(){
        double calculo = this.peso/Math.pow(this.altura,2);
        int retornarValor= 0;
        if(calculo < 20){
            retornarValor = -1;
        }
        if(calculo >= 20 && calculo <= 25 ){
            retornarValor = 0;
        }
        if(calculo > 25){
            retornarValor = 1;
        }
        return retornarValor;
    }
    public boolean esMayorDeEdad(){
        boolean esMayor =false;
        int number = Integer.parseInt(this.edad);
        if(number > 18){
            esMayor = true;
        }
        return esMayor;
    }

    public String toString() {
        return "Nombre:" + this.nombre + "- Edad:" + this.edad + "- dni:" + this.dni + "- Peso:" + this.peso + "- Altura:" + this.altura;
    }



}


