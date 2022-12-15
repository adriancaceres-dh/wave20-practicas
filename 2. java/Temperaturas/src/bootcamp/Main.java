package bootcamp;

public class Main {
    public static void main(String[] args) {
    String[] ciudades = {"Londres","Madrid","Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima",
            "Santiago de Chile", "Lisboa", "Tokio"};
    int[][] temperaturas ={{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43}, {0,39}, {-7,26},{-1,31},{-10,35}};
    int menor = temperaturas[0][0];
    int mayor = temperaturas[0][1];
    int indiceMenor = 0;
    int indiceMayor = 0;

    for (int i = 0; i < temperaturas.length; i++) {
        if(menor > temperaturas[i][0]) {
            menor = temperaturas[i][0];
            indiceMenor = i;
        }
        if(mayor < temperaturas[i][1]) {
            mayor = temperaturas[i][1];
            indiceMayor = i;
        }
    }
        System.out.println("La ciudad con la menor temperatura fue: " + ciudades[indiceMenor] + " Su temperatura fue: "
                + temperaturas[indiceMenor][0]);
        System.out.println("La ciudad con la mayor temperatura fue: " + ciudades[indiceMayor] + " Su temperatura fue: "
                + temperaturas[indiceMayor][1]);
    }
}