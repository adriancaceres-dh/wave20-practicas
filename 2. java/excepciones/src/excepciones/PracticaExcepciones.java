package excepciones;

public class PracticaExcepciones {
	public PracticaExcepciones() {
		// En el constructor haremos que el programa lance una excepción.
		int a = 0;
		int b = 300;
		try {
			int resultado = b / a;
		} catch (ArithmeticException e) {
//Lanzamos otra excepción explicando que no se puede dividir por 0.
			throw new IllegalArgumentException("No se puede dividir por 0.");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Programa finalizado.");
		}
	}
}
