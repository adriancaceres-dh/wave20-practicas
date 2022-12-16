public class Main
{
    public static void main(String[] args)
    {
        Persona persona_uno = new Persona();
        Persona persona_dos = new Persona("Fede",22,"42383966");
        Persona persona_tres = new Persona("Roberto",33,"41123452",113.12255,1.75151);
        //Si se quiere construir con dos atributos da error de compilación


        System.out.println("Información de "+persona_tres.getNombre());
        switch ((int) persona_tres.calcularIMC()){
            case -1 :
                System.out.println("Bajo peso");break;
            case 0:
                System.out.println("Peso saludable");break;
            case 1:
                System.out.println("SobrePeso");
        }

        if(persona_tres.esMayorDeEdad()){
            System.out.println(persona_tres.getNombre() + "es mayor de edad");
        }else{
            System.out.println(persona_tres.getNombre() + "no es mayor de edad");

        }

    }
}
