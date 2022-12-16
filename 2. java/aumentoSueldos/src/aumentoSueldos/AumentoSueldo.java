package aumentoSueldos;

import java.util.Scanner;

public class AumentoSueldo {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int sueldo;
		System.out.println("Ingrese el DNI del empleado.");
		String dni = teclado.next();
		teclado = new Scanner(System.in);
		System.out.println("Ingrese el sueldo del empleado.");
		sueldo = teclado.nextInt();
		if (sueldo <= 20000) {
			System.out.println("Le corresponde un 20% de aumento.");
			double sueldoaumentado = (sueldo * 0.20) + sueldo;
			System.out.println("Su nuevo sueldo sería de " + sueldoaumentado);
		} else if (sueldo > 20000 && sueldo <= 45000) {
			System.out.println("Le corresponde un 10% de aumento.");
			double sueldoaumentado = (sueldo * 0.10) + sueldo;
			System.out.println("Su nuevo sueldo sería de " + sueldoaumentado);
		} else if (sueldo > 45000) {
			System.out.println("Le corresponde un 5% de aumento.");
			double sueldoaumentado = (sueldo * 0.05) + sueldo;
			System.out.println("El nuevo sueldo sería de " + sueldoaumentado);
		}
	}
}
