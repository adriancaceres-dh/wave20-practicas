public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Pedro",15,"45886987");
        Persona p3 = new Persona("Juan",25,"89766543",87.9,1.8);


        System.out.println(mostrarIMC(p1));
        System.out.println(mostrarMayoriaDeEdad(p1));
    }

    public static String mostrarIMC(Persona persona) {
        String texto = "El IMC DE" + persona.nombre + " ES: ";
        switch (persona.calcularIMC()) {
            case -1:
                texto += "Bajo peso";
                break;
            case 0:
                texto += "Peso saludable";
                break;
            case 1:
                texto += "Sobrepeso";
                break;
            default:
                texto += "INVÁLIDO";
                break;
        }

        return texto;
    }

    public static String mostrarMayoriaDeEdad(Persona persona) {
        String texto = persona.nombre + " es ";
        return persona.esMayorDeEdad() ? texto + "mayor de edad" : texto + "menor de edad";
    }

}