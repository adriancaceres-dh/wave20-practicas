public class Main {
    public static void main(String[] args) {
        Persona personaSinParametros = new Persona();
        Persona personaTresParametros = new Persona("Persona Tres Parametros", 19,"12345");
        Persona personaTodosLosParametros = new Persona("Persona Todos Los Parametros", 20,"123",26.0f, 1.00f);

        System.out.println("Impresiones para la persona con todos los parametros");
        System.out.println(personaTodosLosParametros.toString());
        System.out.println(personaTodosLosParametros.esMayorDeEdad() ? "Es mayor de edad": "Es menor de edad");
        switch (personaTodosLosParametros.calcularIMC()){
            case -1:
                System.out.println("Peso bajo");
                break;
            case 0:
                System.out.println("Peso ideal");
                break;
            case 1:
                System.out.println("Sobre peso");
                break;

        }



    }
}