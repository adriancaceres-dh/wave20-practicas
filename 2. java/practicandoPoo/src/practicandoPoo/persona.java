package practicandoPoo;

public class persona {
	public String nombre;
	public String apellido;
	public String dni;
	public Short edad;
	public Double peso;
	public double altura;

	public persona() {

	}

	public persona(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public persona(String nombre, String apellido, String dni, Short edad, double peso, double altura) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
	}

	public Short calcular_IMC() {
		// calculamos el índice de masa corporal de la persona.
		double imc = 0;
		try
		{
			imc = peso / (altura * altura);
		}catch (ArithmeticException ex) {
			return -5;
		}

		if (imc < 20) {
			return -1;
		} else if (imc >= 20 && imc < 26) {
			return 0;
		} else {
			return 1;
		}
	}

	public boolean esMayordeEdad() {
		if (edad >= 18) {
			System.out.println("Nombre de la persona: " + nombre + " Apellido: " + apellido + " dni: " + dni + " edad: "
					+ edad + " altura: " + altura + " peso: " + peso);
			return true;
		} else {
			System.out.println("Nombre de la persona: " + nombre + " Apellido: " + apellido + " dni: " + dni + " edad: "
					+ edad + " altura: " + altura + " peso: " + peso);
			return false;
		}

	}

}
