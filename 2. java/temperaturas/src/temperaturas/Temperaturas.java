package temperaturas;

public class Temperaturas {
	public static void main(String[] args) {
		String[] ciudades = new String[10];
		ciudades[0] = "Londres";
		ciudades[1] = "Madrid";
		ciudades[2] = "Nueva York";
		ciudades[3] = "Buenos Aires";
		ciudades[4] = "Asunción";
		ciudades[5] = "Sao Paulo";
		ciudades[6] = "Lima";
		ciudades[7] = "Santiago de Chile";
		ciudades[8] = "Lisboa";
		ciudades[9] = "Tokio";
		int[] grados = new int[10];
		grados[0] = -2;
		grados[1] = -3;
		grados[2] = -8;
		grados[3] = 4;
		grados[4] = 6;
		grados[5] = 5;
		grados[6] = 0;
		grados[7] = -7;
		grados[8] = -1;
		grados[9] = -10;
		int temperaturamenor = 0;
		int temperaturamayor = 0;
		String ciudadConMenor = "";
		String ciudadConMayor = "";
		for (int i = 0; i < ciudades.length; i++) {
			int actual = grados[i];
			if (temperaturamenor > actual) {
				temperaturamenor = grados[i];
				ciudadConMenor = ciudades[i];
			}
			if (temperaturamayor < actual) {
				temperaturamayor = grados[i];
				ciudadConMayor = ciudades[i];
			}
		}
		// Mostramos los resultados.
		System.out.println(
				"La ciudad con menor temperatura fue " + ciudadConMenor + ", con " + temperaturamenor + " grados.");
		System.out.println(
				"La ciudad con más temperatura fue " + ciudadConMayor + ", con " + temperaturamayor + " grados.");
	}
}
