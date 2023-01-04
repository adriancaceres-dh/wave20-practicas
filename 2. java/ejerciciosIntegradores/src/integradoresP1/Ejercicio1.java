package integradoresP1;

import java.util.Arrays;

public class Ejercicio1 {
    public static int[] burbuja(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = i + 1; j < arreglo.length; j++) {
                int tmp = 0;
                if (arreglo[i] > arreglo[j]) {
                    tmp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }
        return arreglo;
    }   
}
