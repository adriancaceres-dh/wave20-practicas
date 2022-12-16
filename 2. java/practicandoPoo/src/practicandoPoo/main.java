package practicandoPoo;

public class main {

	public static void main(String[] args) {
		persona persona1 = new persona();
		Short ed = 19;
		persona persona2 = new persona("Agustín", "Iglesias", "13101567");
		persona persona3 = new persona("Agustín", "Iglesias", "13567222", ed, 100.0, 1.99);
		Short imcdelapersona = persona3.calcular_IMC();
		boolean esMayor = persona3.esMayordeEdad();
		if (imcdelapersona == -1) {
			System.out.println("¡Tienes bajo peso! deberías ir a un médico.");
		} else if (imcdelapersona == 0) {
			System.out.println("¡Felicidades! estás en tu peso ideal. Sigue así.");
		} else if (imcdelapersona == -5) {
			System.out.println("No se pudo obtener el IMC.");
		} else {
			System.out.println(
					"Tienes sobrepeso u obesidad. Deberías hacer algo de ejercicio, ir al nutricionista y comer más sano.");
		}
		if (esMayor) {
			System.out.println(
					"¡Felicidades! ya eres mayor de edad. ¿Vamos por unas servecitas, " + persona3.nombre + "?");
		} else {
			System.out.println(
					"Todavía no eres mayor de edad. Ánimo, pronto lo serás y podrás conducir tu propio coche.");
		}
	}
}
