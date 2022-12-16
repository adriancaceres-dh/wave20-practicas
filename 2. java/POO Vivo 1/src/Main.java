import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Persona PersonaSinDatos = new Persona();
        Persona PersonaSinPesoNiAltura = new Persona("5.999.232-2", "Juan", 17);
        Persona PersonaConPesoYAltura = new Persona("3.939.232-2", "Ana", 32, 63.5, 173);

        System.out.println(PersonaConPesoYAltura.toString());

    }
}