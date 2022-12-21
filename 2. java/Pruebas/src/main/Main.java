package main;

import java.util.Arrays;

public class Main {
    public static int[] burbuja(int[] array) {
        int n = array.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(array[j-1] > array[j]){
                    //swap elements
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }

            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] numeros = {2,3,1};
        Main.burbuja(numeros);
    }
}
