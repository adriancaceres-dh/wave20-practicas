public class Persona {
    String nombre;
    Integer edad;
    String dni;
    Double peso;
    Double altura;
    public Persona (){

    }
    public Persona(String nombre, Integer edad, String dni){
        this.edad = edad;
        this.nombre = nombre;
        this.dni = dni;
    }
    public Persona(String nombre, Integer edad, String dni, Double peso, Double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
    public int calcularIMC(){
        Double IMC = peso/Math.pow(altura,2);
        if (IMC<20 ){
            return -1;
        }else if(IMC>=20 && IMC<=25){
            return 0;
        }
        else {
            return 1;
        }
    }
    public Boolean esMayorDeEdad(){
        return edad>=18;
    }
    public String toString(){
        return "nombre: "+nombre+"\n"+"edad: "+edad+"\n"+"dni: "+dni+"\n"+"altura: "+altura+"\n"+"peso: "+peso+"\n";
    }
}
