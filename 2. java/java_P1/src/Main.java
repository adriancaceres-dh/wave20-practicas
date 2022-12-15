public class Main {
    public static void main(String[] args) {


        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "San Pablo", "Lima", "Santiago de chile", "Lisboa", "Tokio"};

        int temp[] = new int[2];
        int indMin = 0;
        int indMax = 0;

        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        for (int i = 0; i < 10; i++) {
            if (temperaturas[i][0] < temp[0]) {
                temp[0] = temperaturas[i][0];
                indMin++;
            }
            if (temperaturas[i][1] > temp[1]) {
                temp[1] = temperaturas[i][1];
                indMax++;
            }
        }
        System.out.println("ciudad con minima " + ciudades[indMin] + " temperatura: " + temp[0] + "Cº");
        System.out.println("ciudad con maxima " + ciudades[indMax] + " temperatura: " + temp[1] + "Cº");
    }
}