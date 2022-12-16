package montoServicios;

import java.util.Scanner;

public class calcularMontos {
	public static void main(String[] args) {
		for (int i = 0; i < 7; i++) {
			Scanner teclado = new Scanner(System.in);
			System.out.println("Ingrese 1 si el cliente cposee el primer servicio, 2 en caso de que posea el segundo.");
			int servicio = teclado.nextInt();
			if (servicio == 1) {
				System.out.println("El cliente debe abonar 1500 pesos.");
			} else if (servicio == 2) {
				int servicio2 = 1500 + 700;
				System.out.println("El cliente debe abonar " + servicio2 + " pesos.");
			}
		}
	}
}
