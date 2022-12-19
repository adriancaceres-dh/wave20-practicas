public class Main {
    public static void main(String[] args) {

        //Se instancia a el objeto persona. Se "Crea".
        Persona personaCreada = new Persona();

        //La persona está rellenando un formulario y los datos obligatorios son Nombre, edad y dni.
        Persona personaRegistrada = new Persona("Pepe", 24, "1234");

        //La persona ya ingreso en el sistema y ahora que quiere realizar una accion se necesita más datos sobre ella.
        Persona personaFull = new Persona("Santiago", 23, "5010", 80, 1.80);

        System.out.println("Datos completos: ");
        System.out.println(" -> " + personaFull.toString(personaFull));

        if (personaFull.altura > 0 && personaFull.peso > 0) {
            System.out.println("IMC: ");

            int Imc = personaFull.calcularImc(personaFull);

            if(Imc == -1)
            {
                System.out.println(" * Bajo Peso. ");
            }
            else if (Imc == 0)
            {
                System.out.println(" * Peso Saludable. ");
            }
            else if (Imc == 1)
            {
                System.out.println(" * Sobrepeso. ");
            }
        }

        System.out.println(" Es mayor de edad? ");
        System.out.println(" -> " + personaFull.esMayorDeEdad(personaFull));

    }
}