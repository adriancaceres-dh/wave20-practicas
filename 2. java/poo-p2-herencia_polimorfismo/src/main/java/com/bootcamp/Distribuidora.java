package com.bootcamp;

import jdk.jfr.Percentage;

public class Distribuidora {
    public static void main(String[] args) {
        String[] nombresPerecederos = {"Arroz", "Galletas"};
        double[] precioPerecederos = {79.99, 120.00};
        int[] diasPorCadudar = {12, 2};

        String[] nombresNoPerecederos = {"Desodorante", "Destornillador"};
        double[] precioNoPerecederos = {180.00, 39.99};
        String[] tipos = {"Perfumería", "Ferretería"};

        Perecedero[] perecederos = new Perecedero[2];
        NoPerecedero[] noPerecederos = new NoPerecedero[2];

        for (int i = 0; i < perecederos.length; i++) {
            Perecedero p = new Perecedero(nombresPerecederos[i], precioPerecederos[i], diasPorCadudar[i]);
            System.out.println(p.toString());
            System.out.println(String.format("Precio 5 artículos: %.2f", p.calcular(5)));
        }

        for (int i = 0; i < noPerecederos.length; i++) {
            NoPerecedero p = new NoPerecedero(nombresNoPerecederos[i], precioNoPerecederos[i], tipos[i]);
            System.out.println(p.toString());
            System.out.println(String.format("Precio 5 artículos: %.2f", p.calcular(5)));
        }
    }
}