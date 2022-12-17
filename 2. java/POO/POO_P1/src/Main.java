import com.bootcamp.Persona;
public class Main {
    public static void main(String[] args) {

        Persona persona_completo = new Persona("Franco", "19.250.263-2",26,90,1.80f);
        Persona persona_parcial = new Persona ("Ricardo", "19.868.421-K",23);
        Persona persona_sin_datos = new Persona();

        System.out.println(persona_completo.toString());

        int imc = persona_completo.cacularIMC();
        System.out.print("Nivel de peso");
        if (imc == -1) System.out.print(" bajo peso");
        if (imc == 0) System.out.print(" normal");
        if (imc == 1) System.out.print(" sobre peso");
        System.out.println();
        System.out.println((persona_completo.esMayorDeEdad())?"Es mayor de edad":"No es mayor de edad");
    }
}