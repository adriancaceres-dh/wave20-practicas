public class Main {
    public static void main(String[] args) {
        Persona personaConstructorSinParametros = new Persona();
        Persona personaConParametrosIncompletos = new Persona("Diego", 23, "1019146999");
        Persona personaConParametrosCompletos = new Persona("Diego", 23, "1019146999", 70,1.85);

        int imc =personaConParametrosCompletos.calcularIMC();
        boolean mayorDeEdad = personaConParametrosCompletos.esMayorDeEdad();

        if(imc==-1)
            System.out.println(personaConParametrosCompletos.nombre + " tienes bajo peso");
        else if (imc==0) {
            System.out.println(personaConParametrosCompletos.nombre + " tienes un peso ideal");
        }else{
            System.out.println(personaConParametrosCompletos.nombre + " tienes sobrepeso");
        }

        if(mayorDeEdad){
            System.out.println(personaConParametrosCompletos.nombre + " eres mayor de edad");
        }else{
            System.out.println(personaConParametrosCompletos.nombre + " eres menor de edad");
        }

        System.out.println(personaConParametrosCompletos.toString());
    }
}