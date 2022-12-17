public class Main {
    public static void main(String[] args) {
        //ejercicio 4
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Lautaro Walsh", 27, "39106633");
        Persona persona3 = new Persona("Mariano Rodriguez", 56, "42567884", 70.0, 1.8);
        //No se puede crear una instancia de la clase 'Persona' pasando como parametros del constructor
        // solo la edad y el nombre, ya que no existe un constructor con dicha cantidad y tipo de parametros

        System.out.println(persona3.toString());

        if(persona3.esMayorDeEdad()){
            System.out.println("Es mayor.");
        }else{
            System.out.println("Es menor.");
        }

        int MC=persona3.calcularMC();
        if(MC ==0){
            System.out.println("IMC: bajo peso");
        }else if(MC==1){
            System.out.println("IMC: peso saludable");
        }else if(MC==2){
            System.out.println("IMC: sobrepeso");
        }
    }
}